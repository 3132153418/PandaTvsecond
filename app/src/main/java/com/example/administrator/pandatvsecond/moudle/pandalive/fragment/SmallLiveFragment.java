package com.example.administrator.pandatvsecond.moudle.pandalive.fragment;

import android.support.design.widget.TabLayout;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.administrator.pandatvsecond.R;
import com.example.administrator.pandatvsecond.app.App;
import com.example.administrator.pandatvsecond.base.BaseFragment;
import com.example.administrator.pandatvsecond.model.bean.EspeciallyShowBean;
import com.example.administrator.pandatvsecond.model.bean.GGShowBean;
import com.example.administrator.pandatvsecond.model.bean.GoodTimeBean;
import com.example.administrator.pandatvsecond.model.bean.LiveFragmentBean;
import com.example.administrator.pandatvsecond.model.bean.MoreEyeBean;
import com.example.administrator.pandatvsecond.model.bean.NoBearBean;
import com.example.administrator.pandatvsecond.model.bean.OriginalNewsBean;
import com.example.administrator.pandatvsecond.model.bean.PandaFileBean;
import com.example.administrator.pandatvsecond.model.bean.PandaTopBean;
import com.example.administrator.pandatvsecond.model.bean.WatchTalkBean;
import com.example.administrator.pandatvsecond.moudle.pandalive.LiveContract;
import com.example.administrator.pandatvsecond.moudle.pandalive.LivePresenter;
import com.example.administrator.pandatvsecond.moudle.pandalive.adapter.SmallLiveFragmentAdapter;
import com.example.administrator.pandatvsecond.moudle.pandalive.common.LiveBaseFragment;
import com.example.administrator.pandatvsecond.util.MineLog;
import com.example.administrator.pandatvsecond.widget.manager.LoadingDialog;
import com.example.administrator.pandatvsecond.widget.manager.NonSwipeableViewPager;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lenovo on 2017/7/31.
 */

public class SmallLiveFragment extends LiveBaseFragment implements LiveContract.View, View.OnClickListener {
    private LiveContract.Presenter presenter;
    private ImageView iv_smalllivefragment;
    private TextView tv_smalllivefragment_title;
    private TextView tv_smalllivefragment_content;
    private Button btn_smalllivefragment_hs;
    private TextView tv_smalllivefragment_brief;
    private TabLayout tab_smalllivefragment;
    private NonSwipeableViewPager nopager_smalllivefragment;
    private boolean ischeck = false;
    private ArrayList<BaseFragment> baseFragments = new ArrayList<>();
    private SmallLiveFragmentAdapter smallLiveFragmentAdapter;

    @Override
    protected int getLayoutId() {
        return R.layout.live_smalllivefragment;
    }

    @Override
    protected void initView(View view) {
        new LivePresenter(this);
        iv_smalllivefragment = (ImageView) view.findViewById(R.id.iv_smalllivefragment);
        tv_smalllivefragment_title = (TextView) view.findViewById(R.id.tv_smalllivefragment_title);
        tv_smalllivefragment_content = (TextView) view.findViewById(R.id.tv_smalllivefragment_content);
        btn_smalllivefragment_hs = (Button) view.findViewById(R.id.btn_smalllivefragment_hs);
        btn_smalllivefragment_hs.setOnClickListener(this);
        tv_smalllivefragment_brief = (TextView) view.findViewById(R.id.tv_smalllivefragment_brief);
        tab_smalllivefragment = (TabLayout) view.findViewById(R.id.tab_smalllivefragment);
        nopager_smalllivefragment = (NonSwipeableViewPager) view.findViewById(R.id.nopager_smalllivefragment);
    }

    @Override
    protected void loadData() {
        presenter.requestSmallLiveFragmentData();
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


    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.btn_smalllivefragment_hs:
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
                break;
        }
    }

    @Override
    public void SmallLiveFragmentResult(LiveFragmentBean.LiveBean liveBean) {
        MineLog.d("SmallLiveFragment",liveBean.toString());
        Glide.with(getActivity()).load(liveBean.getImage()).into(iv_smalllivefragment);
        tv_smalllivefragment_title.setText(liveBean.getTitle());
        tv_smalllivefragment_content.setText("简介");
        tv_smalllivefragment_brief.setText(liveBean.getBrief());
    }

    @Override
    public void MoreEyeResult(List<MoreEyeBean.ListBean> listBean) {
        baseFragments.add(new SmallLiveMoreEyeFragment(listBean));
    }


    @Override
    public void WatchTalkResult(List<WatchTalkBean.DataBean.ContentBean> content) {
        MineLog.d("SmallLiveFragment",content.toString());
        baseFragments.add(new SmallLiveWatchTalkFragment(content));
        smallLiveFragmentAdapter = new SmallLiveFragmentAdapter(getChildFragmentManager(), baseFragments);
        MineLog.d("SmallLiveFragment",baseFragments.size()+"");
        nopager_smalllivefragment.setAdapter(smallLiveFragmentAdapter);
        tab_smalllivefragment.setupWithViewPager(nopager_smalllivefragment);
//        smallLiveFragmentAdapter.notifyDataSetChanged();
    }

    @Override
    public void GoodTimeBeanResult(GoodTimeBean goodTimeBean) {

    }

    @Override
    public void NoBeerBeanResult(NoBearBean noBearBean) {

    }

    @Override
    public void GGShowBeanResult(GGShowBean ggShowBean) {

    }

    @Override
    public void PandaFileResult(PandaFileBean pandaFileBean) {

    }

    @Override
    public void PandaTopBeanResult(PandaTopBean pandaTopBean) {

    }

    @Override
    public void PandaThingsBeanResult(NoBearBean noBearBean) {

    }

    @Override
    public void EspeciallyShowBeanResult(EspeciallyShowBean especiallyShowBean) {

    }

    @Override
    public void OriginalNewsBeanResult(OriginalNewsBean originalNewsBean) {

    }
}
