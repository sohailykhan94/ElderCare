package ge.eldercare.adapters;


import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import ge.eldercare.ChatFragment;
import ge.eldercare.LogsFragment;
import ge.eldercare.ProfileFragment;

/**
 * Created by sohailyarkhan on 18/04/16.
 */


public class TabsPagerAdapter extends FragmentPagerAdapter {

    public TabsPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int index) {

        switch (index) {
            case 0:
                // Top Rated fragment activity
                return new ChatFragment();
            case 1:
                // Games fragment activity
                return new LogsFragment();
            case 2:
                // Movies fragment activity
                return new ProfileFragment();
        }

        return null;
    }

    @Override
    public int getCount() {
        // get item count - equal to number of tabs
        return 3;
    }

}