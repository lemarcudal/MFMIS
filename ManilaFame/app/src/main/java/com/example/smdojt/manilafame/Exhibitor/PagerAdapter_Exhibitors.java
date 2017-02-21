package com.example.smdojt.manilafame.Exhibitor;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

/**
 * Created by smdojt on 2/21/2017.
 */

public class PagerAdapter_Exhibitors extends FragmentStatePagerAdapter{
    int mNumOfTabs;
    public PagerAdapter_Exhibitors(FragmentManager fm, int NumOfTabs)
    {
        super(fm);
        this.mNumOfTabs = NumOfTabs;
    }
    @Override
    public Fragment getItem(int position)
    {
        switch (position)
        {
            case 0:
                TabInternationalFragment tab1 = new TabInternationalFragment();
                return tab1;
            case 1:
                TabLocalFragment tab2 = new TabLocalFragment();
                return tab2;
            default:
                return null;
        }

    }
    //-----------------------------------
    @Override
    public int getCount()
    {
        return mNumOfTabs;
    }
}
