package com.example.smdojt.manilafame.Attendees;

/**
 * Created by smdojt on 2/27/2017.
 */
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

public class PagerAdapter_Attendees extends FragmentStatePagerAdapter {
    int mNumOfTabs;

    public PagerAdapter_Attendees(FragmentManager fm, int NumOfTabs) {
        super(fm);
        this.mNumOfTabs = NumOfTabs;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                TabAttendeesAllFragment tab1 = new TabAttendeesAllFragment();
                return tab1;
            case 1:
                TabAttendeesVIPFragment tab2 = new TabAttendeesVIPFragment();
                return tab2;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return mNumOfTabs;
    }
}