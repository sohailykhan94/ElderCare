package ge.eldercare;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import ge.eldercare.R;

/**
 * Created by sohailyarkhan on 18/04/16.
 */
public class ChatFragment extends Fragment {

    String TAG = "Chat Activity";
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.chat_fragment, container, false);

        final RelativeLayout launchChat = (RelativeLayout) rootView.findViewById(R.id.rl1);
        launchChat.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Log.d(TAG, "Chat launched");
                Intent myIntent = new Intent(getActivity(), ChatActivity.class);
                myIntent.putExtra("display_picture", R.drawable.profile);
                myIntent.putExtra("name", "Mr. Sohail Yar Khan");
                ChatFragment.this.startActivity(myIntent);
            }
        });

        return rootView;
    }

}
