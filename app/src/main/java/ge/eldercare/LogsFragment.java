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

/**
 * Created by sohailyarkhan on 18/04/16.
 */
public class LogsFragment extends Fragment{

    private List<LogEntry> entries;
    private LogDBHelper mDbHelper;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.logs_fragment, container, false);

        return rootView;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState){
        super.onViewCreated(view,savedInstanceState);
        mDbHelper=new LogDBHelper(getContext());
        RecyclerView rv = (RecyclerView)getView().findViewById(R.id.rv);
        LinearLayoutManager llm = new LinearLayoutManager(getContext());
        rv.setLayoutManager(llm);
        initializeData();
        LogAdapter adapter = new LogAdapter(entries);
        rv.setAdapter(adapter);
    }

    private void initializeData(){
        entries = new ArrayList<>();
/*
        SQLiteDatabase db = mDbHelper.getReadableDatabase();

// Define a projection that specifies which columns from the database
// you will actually use after this query.
        String[] projection = {
                FeedEntry._ID,
                FeedEntry.COLUMN_NAME_TITLE,
                FeedEntry.COLUMN_NAME_UPDATED,
        ...
        };

// How you want the results sorted in the resulting Cursor
        String sortOrder =
                FeedEntry.COLUMN_NAME_UPDATED + " DESC";

        Cursor c = db.query(
                FeedEntry.TABLE_NAME,  // The table to query
                projection,                               // The columns to return
                selection,                                // The columns for the WHERE clause
                selectionArgs,                            // The values for the WHERE clause
                null,                                     // don't group the rows
                null,                                     // don't filter by row groups
                sortOrder                                 // The sort order
        );
*/
        entries.add(new LogEntry("Emma Wilson", "23 years old"));
        entries.add(new LogEntry("Lavery Maiss", "25 years old"));
        entries.add(new LogEntry("Lillie Watts", "35 years old"));
    }



}
