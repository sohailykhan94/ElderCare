package ge.eldercare.adapters;

import android.app.Activity;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;
import ge.eldercare.Chat;
import ge.eldercare.R;

/**
 * Created by sohailyarkhan on 19/04/16.
 */
public class ChatAdapter extends RecyclerView.Adapter<ChatAdapter.ChatViewHolder>{

    List<Chat> bubbles;
    Context context;
    public ChatAdapter(List<Chat> bubbles, Context context){
        this.bubbles = bubbles;
        this.context = context;
    }

    @Override
    public int getItemCount() {
        return bubbles.size();
    }

    @Override
    public ChatViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.chat_bubble, viewGroup, false);
        ChatViewHolder cvh = new ChatViewHolder(v);
        return cvh;
    }

    @Override
    public void onBindViewHolder(ChatViewHolder chatViewHolder, int i) {
        chatViewHolder.personName.setText(bubbles.get(i).name);
        chatViewHolder.personAge.setText(bubbles.get(i).message);
        chatViewHolder.personPhoto.setImageResource(bubbles.get(i).photoId);
        if(bubbles.get(i).isSender){
            chatViewHolder.rl.setBackground(context.getResources().getDrawable(R.drawable.border_left));
        }else{
            chatViewHolder.rl.setBackground(context.getResources().getDrawable(R.drawable.border_left2));
        }
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    public static class ChatViewHolder extends RecyclerView.ViewHolder {
        RelativeLayout rl;
        TextView personName;
        TextView personAge;
        CircleImageView personPhoto;
        boolean isSender;


        ChatViewHolder(View itemView) {
            super(itemView);
            rl = (RelativeLayout)itemView.findViewById(R.id.mainHolder);
            personName = (TextView)itemView.findViewById(R.id.senderName);
            personAge = (TextView)itemView.findViewById(R.id.senderMessage);
            personPhoto = (CircleImageView)itemView.findViewById(R.id.senderImage);
        }
    }

}