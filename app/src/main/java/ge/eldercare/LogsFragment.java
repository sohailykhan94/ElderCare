package ge.eldercare;


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

/**
 * Created by sohailyarkhan on 18/04/16.
 */
public class LogsFragment extends Fragment {

    private List<LogEntry> entries;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.logs_fragment, container, false);
        return rootView;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState){
        super.onViewCreated(view,savedInstanceState);
        RecyclerView rv = (RecyclerView)getView().findViewById(R.id.rv);
        LinearLayoutManager llm = new LinearLayoutManager(getContext());
        rv.setLayoutManager(llm);
        initializeData();
        LogAdapter adapter = new LogAdapter(entries);
        rv.setAdapter(adapter);
    }

    private void initializeData(){
        entries = new ArrayList<>();
        entries.add(new LogEntry("Emma Wilson", "23 years old"));
        entries.add(new LogEntry("Lavery Maiss", "25 years old"));
        entries.add(new LogEntry("Lillie Watts", "35 years old"));
    }


}
