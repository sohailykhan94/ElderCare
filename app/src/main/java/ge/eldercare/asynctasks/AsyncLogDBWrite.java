package ge.eldercare.asynctasks;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.AsyncTask;
import android.util.Log;

import ge.eldercare.LogsFragment;
import ge.eldercare.dbhelperclasses.LogDBHelper;
import ge.eldercare.dbhelperclasses.LogHelperConstructor;

/**
 * Created by Tejas on 20-Apr-16.
 */
public class AsyncLogDBWrite extends AsyncTask<Void,Void,Void>{

    public static final String TAG="AsyncLogWriter";
    LogDBHelper mDbHelper;
    String type;
    String message;

    public AsyncLogDBWrite(LogDBHelper mDbHelper,String type,String message)
    {
        this.type=type;
        this.message=message;
        this.mDbHelper=mDbHelper;
    }

    @Override
    protected Void doInBackground(Void... params) {
        // Gets the data repository in write mode
        SQLiteDatabase db = mDbHelper.getWritableDatabase();

        // Create a new map of values, where column names are the keys
        ContentValues values = new ContentValues();
        values.put(LogHelperConstructor.LogHelperEntry.COLUMN_NAME_TYPE, type);
        values.put(LogHelperConstructor.LogHelperEntry.COLUMN_NAME_MESSAGE, message);
        Log.i(TAG,"Log Inserted"+message);
        // Insert the new row, returning the primary key value of the new row
        long newRowId = db.insert(LogHelperConstructor.LogHelperEntry.TABLE_NAME, null, values);
        return null;
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);
        LogsFragment.notifyDatasetChange();
    }
}
