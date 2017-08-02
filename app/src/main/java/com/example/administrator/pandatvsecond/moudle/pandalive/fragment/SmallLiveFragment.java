package com.example.administrator.pandatvsecond.moudle.pandalive.fragment;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.administrator.pandatvsecond.R;
import com.example.administrator.pandatvsecond.app.App;
import com.example.administrator.pandatvsecond.base.BaseFragment;
import com.example.administrator.pandatvsecond.model.bean.live.AllLiveFragmentBean;
import com.example.administrator.pandatvsecond.model.bean.live.LiveCommonBean;
import com.example.administrator.pandatvsecond.model.bean.live.LiveFragmentBean;
import com.example.administrator.pandatvsecond.model.bean.live.MoreEyeBean;
import com.example.administrator.pandatvsecond.model.bean.live.WatchTalkBean;
import com.example.administrator.pandatvsecond.moudle.pandalive.LiveContract;
import com.example.administrator.pandatvsecond.moudle.pandalive.LiveFragment;
import com.example.administrator.pandatvsecond.moudle.pandalive.adapter.SmallLiveFragmentAdapter;
import com.example.administrator.pandatvsecond.widget.manager.LoadingDialog;
import com.example.administrator.pandatvsecond.widget.manager.NonSwipeableViewPager;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lenovo on 2017/7/31.
 */

public class SmallLiveFragment extends Fragment implements LiveContract.View{
    private LiveContract.Presenter presenter;
    private ImageView iv_smalllivefragment;
    private TextView tv_smalllivefragment_title;
    private TextView tv_smalllivefragment_content;
    private Button btn_smalllivefragment_hs;
    private TextView tv_smalllivefragment_brief;
    private TabLayout tab_smalllivefragment;
    private NonSwipeableViewPager nopager_smalllivefragment;



    private static ArrayList<BaseFragment> baseFragments = new ArrayList<>();
    private SmallLiveFragmentAdapter smallLiveFragmentAdapter;


    private boolean isCreatView = false;
    private boolean ischeck = false;


    @Override
    public View onCreateView(final LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            View smalllivefragment = inflater.inflate(R.layout.live_smalllivefragment, null);
            iv_smalllivefragment = (ImageView) smalllivefragment.findViewById(R.id.iv_smalllivefragment);
            tv_smalllivefragment_title = (TextView) smalllivefragment.findViewById(R.id.tv_smalllivefragment_title);
            tv_smalllivefragment_content = (TextView) smalllivefragment.findViewById(R.id.tv_smalllivefragment_content);
            btn_smalllivefragment_hs = (Button) smalllivefragment.findViewById(R.id.btn_smalllivefragment_hs);
            btn_smalllivefragment_hs.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (ischeck) {
                        //如果点击了以后要收回
                        ischeck = false;
                        btn_smalllivefragment_hs.setBackgroundResource(R.drawable.live_china_detail_up);
                        tv_smalllivefragment_brief.setVisibility(View.GONE);
                    } else {
                        ischeck = true;
                        btn_smalllivefragment_hs.setBackgroundResource(R.drawable.live_china_detail_down);
                        tv_smalllivefragment_brief.setVisibility(View.VISIBLE);
                    }
                }
            });
            tv_smalllivefragment_brief = (TextView) smalllivefragment.findViewById(R.id.tv_smalllivefragment_brief);
            tab_smalllivefragment = (TabLayout) smalllivefragment.findViewById(R.id.tab_smalllivefragment);
            nopager_smalllivefragment = (NonSwipeableViewPager) smalllivefragment.findViewById(R.id.nopager_smalllivefragment);
            isCreatView = true;
            return smalllivefragment;

    }


    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (isVisibleToUser) {
            AllLiveFragmentBean.TablistBean tablistBean = LiveFragment.allLiveFragmentBean.getTablist().get(0);
            presenter.requestSmallLiveFragmentData(tablistBean.getUrl());
        }
    }


    @Override
    public void SmallLiveFragmentResult(LiveFragmentBean liveBean) {
        if (isCreatView) {
            LiveFragmentBean.LiveBean liveBean1 = liveBean.getLive().get(0);
            Glide.with(getActivity()).load(liveBean1.getImage()).into(iv_smalllivefragment);
            tv_smalllivefragment_title.setText(liveBean1.getTitle());
            tv_smalllivefragment_content.setText("简介");
            tv_smalllivefragment_brief.setText(liveBean1.getBrief());
        }
    }
    @Override
    public void MoreEyeResult(List<MoreEyeBean.ListBean> listBean) {
        if (isCreatView) {
            baseFragments.add(new SmallLiveMoreEyeFragment(listBean));
        }
    }
    @Override
    public void WatchTalkResult(List<WatchTalkBean.DataBean.ContentBean> content) {
        if (isCreatView) {
            baseFragments.add(new SmallLiveWatchTalkFragment(content));
            smallLiveFragmentAdapter = new SmallLiveFragmentAdapter(getChildFragmentManager(), baseFragments);
            nopager_smalllivefragment.setAdapter(smallLiveFragmentAdapter);
            tab_smalllivefragment.setupWithViewPager(nopager_smalllivefragment);
        }
    }



    @Override
    public void LiveFragmentDataResult(AllLiveFragmentBean allLiveFragmentBean) {

    }
    @Override
    public void LiveCommonDataResult(LiveCommonBean liveCommonBean) {
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
    public void onRefresh() {

    }


}
