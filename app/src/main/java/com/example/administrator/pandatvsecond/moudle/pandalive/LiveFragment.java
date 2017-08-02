package com.example.administrator.pandatvsecond.moudle.pandalive;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.Toast;

import com.example.administrator.pandatvsecond.R;
import com.example.administrator.pandatvsecond.app.App;
import com.example.administrator.pandatvsecond.base.BaseFragment;
import com.example.administrator.pandatvsecond.model.bean.live.AllLiveFragmentBean;
import com.example.administrator.pandatvsecond.model.bean.live.LiveCommonBean;
import com.example.administrator.pandatvsecond.model.bean.live.LiveFragmentBean;
import com.example.administrator.pandatvsecond.model.bean.live.MoreEyeBean;
import com.example.administrator.pandatvsecond.model.bean.live.WatchTalkBean;
import com.example.administrator.pandatvsecond.moudle.pandalive.adapter.LiveFragmentAdapter;
import com.example.administrator.pandatvsecond.moudle.pandalive.fragment.LiveCommonFragment;
import com.example.administrator.pandatvsecond.moudle.pandalive.fragment.SmallLiveFragment;
import com.example.administrator.pandatvsecond.widget.manager.LoadingDialog;
import com.example.administrator.pandatvsecond.widget.manager.NonSwipeableViewPager;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/7/28.
 */

public class LiveFragment extends BaseFragment implements LiveContract.View{
    private LiveContract.Presenter presenter;
    private TabLayout livefragment_tablayout;
    private NonSwipeableViewPager livefragment_noviewpager;
    public static AllLiveFragmentBean allLiveFragmentBean = null;



    @Override
    protected int getLayoutId() {
        return R.layout.live_fragment;
    }

    @Override
    protected void initView(View view) {
        new LivePresenter(this);
        livefragment_tablayout = (TabLayout) view.findViewById(R.id.livefragment_tablayout);
        livefragment_noviewpager = (NonSwipeableViewPager) view.findViewById(R.id.livefragment_noviewpager);
    }

    @Override
    protected void loadData() {
        presenter.requestLiveFragmentData();
    }

    @Override
    public void LiveFragmentDataResult(AllLiveFragmentBean allLiveFragmentBean) {
        this.allLiveFragmentBean = allLiveFragmentBean;
        if (this.allLiveFragmentBean!=null) {
            ArrayList<Fragment> liveBaseFragments = new ArrayList<>();
            for (int i = 0; i < LiveFragmentAdapter.PAGE_COUNT; i++){
                if (i==0) {
                    SmallLiveFragment smallLiveFragment = new SmallLiveFragment();
                    new LivePresenter(smallLiveFragment);
                    liveBaseFragments.add(smallLiveFragment);
                }else{
                    Bundle bundle = new Bundle();
                    bundle.putInt("index",i);
                    LiveCommonFragment liveCommonFragment = new LiveCommonFragment();
                    liveCommonFragment.setArguments(bundle);
                    new LivePresenter(liveCommonFragment);
                    liveBaseFragments.add(liveCommonFragment);
                }
            }
            livefragment_noviewpager.setAdapter(new LiveFragmentAdapter(getChildFragmentManager(),liveBaseFragments));
            livefragment_tablayout.setupWithViewPager(livefragment_noviewpager);
        }

    }

    @Override
    public void SmallLiveFragmentResult(LiveFragmentBean liveBean) {

    }
    @Override
    public void showProgress() {
        LoadingDialog.show(App.context);
    }
    @Override
    public void dismissProgress() {
        LoadingDialog.dimiss();
    }
    @Override
    public void setPresenter(LiveContract.Presenter presenter) {
        this.presenter = presenter;
    }
    @Override
    public void showMessage(String msg) {
        Toast.makeText(getActivity(), msg, Toast.LENGTH_SHORT).show();
    }
    @Override
    public void onRefresh() {}
    @Override
    public void MoreEyeResult(List<MoreEyeBean.ListBean> listBean) {

    }
    @Override
    public void WatchTalkResult(List<WatchTalkBean.DataBean.ContentBean> content) {

    }
    @Override
    public void LiveCommonDataResult(LiveCommonBean liveCommonBean) {

    }
}
