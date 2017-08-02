package com.example.administrator.pandatvsecond.moudle.pandalive.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.administrator.pandatvsecond.base.BaseFragment;

import java.util.ArrayList;

/**
 * Created by lenovo on 2017/7/31.
 */

public class SmallLiveFragmentAdapter extends FragmentPagerAdapter{

    private ArrayList<BaseFragment> baseFragments;

    public SmallLiveFragmentAdapter(FragmentManager fm, ArrayList<BaseFragment> baseFragments) {
        super(fm);
        this.baseFragments = baseFragments;
    }

    @Override
    public Fragment getItem(int position) {
        return baseFragments.get(position);
    }

    @Override
    public int getCount() {
        return 2;
    }

    @Override
    public CharSequence getPageTitle(int position) {

        switch (position) {
            case 0:
                return "多视角直播";
            case 1:
                return "边看边聊";
        }
        return null;
    }
}
