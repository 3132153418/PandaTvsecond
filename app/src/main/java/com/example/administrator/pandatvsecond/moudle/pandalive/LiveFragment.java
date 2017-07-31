package com.example.administrator.pandatvsecond.moudle.pandalive;

import android.support.design.widget.TabLayout;
import android.view.View;
import android.widget.Toast;

import com.example.administrator.pandatvsecond.R;
import com.example.administrator.pandatvsecond.app.App;
import com.example.administrator.pandatvsecond.base.BaseFragment;
import com.example.administrator.pandatvsecond.model.bean.LiveFragmentBean;
import com.example.administrator.pandatvsecond.model.bean.MoreEyeBean;
import com.example.administrator.pandatvsecond.model.bean.WatchTalkBean;
import com.example.administrator.pandatvsecond.moudle.pandalive.adapter.LiveFragmentAdapter;
import com.example.administrator.pandatvsecond.moudle.pandalive.common.LiveBaseFragment;
import com.example.administrator.pandatvsecond.moudle.pandalive.fragment.LiveEspeciallyShowFragment;
import com.example.administrator.pandatvsecond.moudle.pandalive.fragment.LiveGGShowFragment;
import com.example.administrator.pandatvsecond.moudle.pandalive.fragment.LiveGoodTimeFragment;
import com.example.administrator.pandatvsecond.moudle.pandalive.fragment.LiveNoBeerFragment;
import com.example.administrator.pandatvsecond.moudle.pandalive.fragment.LiveOriginalNewsFragment;
import com.example.administrator.pandatvsecond.moudle.pandalive.fragment.LivePandaFileFragment;
import com.example.administrator.pandatvsecond.moudle.pandalive.fragment.LivePandaThingsFragment;
import com.example.administrator.pandatvsecond.moudle.pandalive.fragment.LivePandaTopFragment;
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

    @Override
    protected int getLayoutId() {
        return R.layout.live_fragment;
    }

    @Override
    protected void initView(View view) {
        livefragment_tablayout = (TabLayout) view.findViewById(R.id.livefragment_tablayout);
        livefragment_noviewpager = (NonSwipeableViewPager) view.findViewById(R.id.livefragment_noviewpager);
        ArrayList<LiveBaseFragment> liveBaseFragments = new ArrayList<>();
        liveBaseFragments.add(new SmallLiveFragment());
        liveBaseFragments.add(new LiveGoodTimeFragment());
        liveBaseFragments.add(new LiveNoBeerFragment());
        liveBaseFragments.add(new LiveGGShowFragment());
        liveBaseFragments.add(new LivePandaFileFragment());
        liveBaseFragments.add(new LivePandaTopFragment());
        liveBaseFragments.add(new LivePandaThingsFragment());
        liveBaseFragments.add(new LiveEspeciallyShowFragment());
        liveBaseFragments.add(new LiveOriginalNewsFragment());
        //这里是用childfragmentmanager、还是这个
        livefragment_noviewpager.setAdapter(new LiveFragmentAdapter(getChildFragmentManager(),liveBaseFragments));
        livefragment_tablayout.setupWithViewPager(livefragment_noviewpager);
    }



    @Override
    protected void loadData() {}



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
    public void SmallLiveFragmentResult(LiveFragmentBean.LiveBean liveBean) {

    }

    @Override
    public void MoreEyeResult(List<MoreEyeBean.ListBean> listBean) {

    }

    @Override
    public void WatchTalkResult(List<WatchTalkBean.DataBean.ContentBean> content) {

    }
}
