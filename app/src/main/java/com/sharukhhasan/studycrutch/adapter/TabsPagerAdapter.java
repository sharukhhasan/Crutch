package com.sharukhhasan.studycrutch.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.sharukhhasan.studycrutch.R;
import com.sharukhhasan.studycrutch.fragments.CourseFilesFragment;
import com.sharukhhasan.studycrutch.fragments.CourseStudyFragment;
import com.sharukhhasan.studycrutch.fragments.CourseWallFragment;

/**
 * Created by sharukhhasan on 6/7/16.
 */
public class TabsPagerAdapter extends FragmentPagerAdapter {

    public TabsPagerAdapter(FragmentManager fm)
    {
        super(fm);
    }

    @Override
    public Fragment getItem(int position)
    {
        switch (position) {
            case 0:
                return new CourseWallFragment();
            case 1:
                return new CourseFilesFragment();
            case 2:
                return new CourseStudyFragment();
        }

        return null;
    }

    @Override
    public int getCount()
    {
        return 3;
    }

}
