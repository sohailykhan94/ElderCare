package ge.eldercare;

import android.app.Activity;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import ge.eldercare.adapters.ChatAdapter;

public class ChatActivity extends AppCompatActivity {

    private RecyclerView rv;
    LinearLayoutManager llm;
    Context context;
    private int count = 0;
    private List<Chat> bubbles;
    private List<Chat> temp;
    ChatAdapter adapter;
    private static final ScheduledExecutorService worker =
            Executors.newSingleThreadScheduledExecutor();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);
        context = getApplicationContext();
        rv = (RecyclerView)findViewById(R.id.rv);
        llm = new LinearLayoutManager(context);
        rv.setLayoutManager(llm);
        initializeData();

        adapter = new ChatAdapter(bubbles, context);
        rv.setAdapter(adapter);
    }

    private void initializeData(){
        bubbles = new ArrayList<>();
        temp = new ArrayList<>();
        temp.add(new Chat("Mrs. XYZ Khan", "Hi! I'm Okay, feeling better.", R.drawable.profile2, false));
        temp.add(new Chat("Mrs. XYZ Khan", "He's fine as well", R.drawable.profile2, false));
        temp.add(new Chat("Mrs. XYZ Khan", "When are you coming over?", R.drawable.profile2, false));
        temp.add(new Chat("Mrs. XYZ Khan", "Great", R.drawable.profile2, false));
        temp.add(new Chat("Mrs. XYZ Khan", "We went out today. You?", R.drawable.profile2, false));
    }

    public void back(View v){
        this.onBackPressed();
    }

    public void sendMessage(View v){
        EditText message = (EditText) findViewById(R.id.sendMessage);
        bubbles.add(new Chat("Mr. Sohail Yar Khan", message.getText().toString(), R.drawable.profile, true));
        message.setText("");
        adapter.notifyDataSetChanged();
        Runnable task = new Runnable() {
            public void run() {

                try{
                    bubbles.add(temp.get(count));
                    count++;
                    adapter.notifyDataSetChanged();
                }catch (Exception e){

                }

            }
        };
        worker.schedule(task, 3, TimeUnit.SECONDS);
    }
}
