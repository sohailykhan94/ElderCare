package ge.eldercare;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import ge.eldercare.R;

/**
 * Created by sohailyarkhan on 18/04/16.
 */
public class ChatFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.chat_fragment, container, false);

        return rootView;
    }
}
