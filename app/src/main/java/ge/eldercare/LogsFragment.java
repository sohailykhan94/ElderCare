package ge.eldercare;


import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import ge.eldercare.R;
import ge.eldercare.adapters.LogAdapter;
import ge.eldercare.dbhelperclasses.LogDBHelper;
import ge.eldercare.dbhelperclasses.LogHelperConstructor;

/**
 * Created by sohailyarkhan on 18/04/16.
 */
public class LogsFragment extends Fragment{

    public static final String TAG="LogsFragment";
    private static List<LogEntry> entries;
    private static LogDBHelper mDbHelper;
    public static LogAdapter adapter;
    private static RecyclerView rv;
    private static LinearLayoutManager llm;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.logs_fragment, container, false);

        return rootView;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState){
        super.onViewCreated(view,savedInstanceState);
        entries=new ArrayList<>();
        mDbHelper=new LogDBHelper(getContext());
        rv = (RecyclerView)getView().findViewById(R.id.rv);
        llm = new LinearLayoutManager(getContext());
        llm.setReverseLayout(true);
        llm.setStackFromEnd(true);
        rv.setLayoutManager(llm);
        initializeData();
        adapter= new LogAdapter(entries);
        rv.setAdapter(adapter);
    }

    private static void initializeData(){
        //entries = new ArrayList<>();
        SQLiteDatabase db = mDbHelper.getReadableDatabase();

        String[] projection = {LogHelperConstructor.LogHelperEntry.COLUMN_NAME_TYPE, LogHelperConstructor.LogHelperEntry.COLUMN_NAME_MESSAGE};


        Cursor c = db.query(
                LogHelperConstructor.LogHelperEntry.TABLE_NAME,  // The table to query
                projection,                               // The columns to return
                null,                                // The columns for the WHERE clause
                null,                            // The values for the WHERE clause
                null,                                     // don't group the rows
                null,                                     // don't filter by row groups
                null                                 // The sort order
        );
        Log.i(TAG,"Queried DB");
        c.moveToFirst();
        while(!c.isAfterLast())
        {
            String type=c.getString(c.getColumnIndex(LogHelperConstructor.LogHelperEntry.COLUMN_NAME_TYPE));
            String content=c.getString(c.getColumnIndex(LogHelperConstructor.LogHelperEntry.COLUMN_NAME_MESSAGE));
            entries.add(new LogEntry(type, content));
            c.moveToNext();
        }
    }


    public static void notifyDatasetChange() {
        if(entries!=null)
        entries.clear();
        initializeData();
        if(adapter!=null)
        adapter.notifyDataSetChanged();
    }
}
