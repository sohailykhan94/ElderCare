package ge.eldercare;

import android.app.Activity;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import ge.eldercare.adapters.ChatAdapter;

public class ChatActivity extends AppCompatActivity {

    private RecyclerView rv;
    LinearLayoutManager llm;
    Context context;
    private List<Chat> bubbles;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);

        context = getApplicationContext();
        rv = (RecyclerView)findViewById(R.id.rv);
        llm = new LinearLayoutManager(context);
        rv.setLayoutManager(llm);
        initializeData();

        ChatAdapter adapter = new ChatAdapter(bubbles, context);
        rv.setAdapter(adapter);
    }

    private void initializeData(){
        bubbles = new ArrayList<>();
        bubbles.add(new Chat("Mr. Sohail Yar Khan", "Hey! How are you? Missing you?", R.drawable.profile, true));
        bubbles.add(new Chat("Mrs. XYZ Khan", "Hi! I'm Okay, feeling better.", R.drawable.profile2, false));
        bubbles.add(new Chat("Mr. Sohail Yar Khan", "That's great. I'm coming over tomorrow okay. How's dad?", R.drawable.profile, true));
    }
}
