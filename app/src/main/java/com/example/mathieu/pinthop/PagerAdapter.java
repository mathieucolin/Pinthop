package com.example.mathieu.pinthop;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

/**
 * Created by Mathieu on 11/02/2016.
 */
public class PagerAdapter extends FragmentStatePagerAdapter{

    int mNumOfTabs;

    public PagerAdapter(FragmentManager fm, int NumOfTabs) {
        super(fm);
        this.mNumOfTabs = NumOfTabs;
    }

    @Override
    public Fragment getItem(int position) {

        switch (position) {
            case 0:
                TabRecherche tab1 = new TabRecherche();
                return tab1;
            case 1:
                TabBaseDeDonnees tab2 = new TabBaseDeDonnees();
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
