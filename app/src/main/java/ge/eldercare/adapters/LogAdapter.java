package ge.eldercare.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import ge.eldercare.LogEntry;
import ge.eldercare.R;

/**
 * Created by Tejas on 19-Apr-16.
 */
public class LogAdapter extends RecyclerView.Adapter<LogAdapter.LogViewHolder>{

    List<LogEntry> logs;

    public LogAdapter(List<LogEntry> logs){
        this.logs = logs;
    }

    @Override
    public LogViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.log_template, parent, false);
        LogViewHolder lvh = new LogViewHolder(v);
        return lvh;
    }

    @Override
    public void onBindViewHolder(LogViewHolder holder, int i) {
        holder.logTitle.setText(logs.get(i).getTitle());
        holder.logContent.setText(logs.get(i).getContent());
        holder.logIcon.setImageResource(R.drawable.ic_class_24dp);
    }

    @Override
    public int getItemCount() {
        return logs.size();
    }

    public static class LogViewHolder extends RecyclerView.ViewHolder {
        TextView logTitle;
        TextView logContent;
        ImageView logIcon;

        LogViewHolder(View itemView) {
            super(itemView);
            logTitle = (TextView)itemView.findViewById(R.id.card_title);
            logContent = (TextView)itemView.findViewById(R.id.card_text);
            logIcon = (ImageView)itemView.findViewById(R.id.card_photo);
        }
    }
}
