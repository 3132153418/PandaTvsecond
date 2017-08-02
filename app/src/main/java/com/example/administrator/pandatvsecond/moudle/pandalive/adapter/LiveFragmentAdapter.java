package com.example.administrator.pandatvsecond.moudle.pandalive.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

/**
 * Created by lenovo on 2017/7/31.
 */

public class LiveFragmentAdapter extends FragmentPagerAdapter {
    public static final int PAGE_COUNT = 9;
    private ArrayList<Fragment> liveBaseFragments;

    public LiveFragmentAdapter(FragmentManager fm,ArrayList<Fragment> liveBaseFragments) {
        super(fm);
        this.liveBaseFragments = liveBaseFragments;
    }

    @Override
    public Fragment getItem(int position) {
        return liveBaseFragments.get(position);
    }

    @Override
    public int getCount() {
        return PAGE_COUNT;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return "直播";
            case 1:
                return "精彩一刻";
            case 2:
                return "当熊不让";
            case 3:
                return "超萌滚滚秀";
            case 4:
                return "熊猫档案";
            case 5:
                return "熊猫Top榜";
            case 6:
                return "熊猫那些事儿";
            case 7:
                return "特别节目";
            case 8:
                return "原创新闻";
        }
        return null;
    }
}
