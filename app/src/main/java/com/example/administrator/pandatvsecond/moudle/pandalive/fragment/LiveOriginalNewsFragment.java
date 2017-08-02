package com.example.administrator.pandatvsecond.moudle.pandalive.fragment;

import android.support.v7.widget.LinearLayoutManager;
import android.view.View;

import com.example.administrator.pandatvsecond.R;
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
import com.example.administrator.pandatvsecond.moudle.pandalive.adapter.OriginalNewsAdapter;
import com.example.administrator.pandatvsecond.moudle.pandalive.common.LiveBaseFragment;
import com.example.administrator.pandatvsecond.widget.manager.LoadingDialog;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.List;

/**
 * Created by lenovo on 2017/7/31.
 */

public class LiveOriginalNewsFragment extends LiveBaseFragment implements LiveContract.View{
    private LiveContract.Presenter presenter;
    private XRecyclerView originalnews_recyclerview;

    @Override
    protected int getLayoutId() {
        return R.layout.live_originalnewsfragment;
    }

    @Override
    protected void initView(View view) {
        new LivePresenter(this);//关联Presenter层对象
        originalnews_recyclerview = (XRecyclerView) view.findViewById(R.id.originalnews_recyclerview);
        LinearLayoutManager manager = new LinearLayoutManager(getActivity());
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        originalnews_recyclerview.setLayoutManager(manager);
        originalnews_recyclerview.setPullRefreshEnabled(true);
        originalnews_recyclerview.setLoadingMoreEnabled(false);
        originalnews_recyclerview.setLoadingListener(new XRecyclerView.LoadingListener() {
            @Override
            public void onRefresh() {
                presenter.start();
            }

            @Override
            public void onLoadMore() {

            }
        });

    }

    @Override
    protected void loadData() {
        presenter.requestOriginalNewsFragmentData();
    }

    @Override
    public void SmallLiveFragmentResult(LiveFragmentBean.LiveBean liveBean) {

    }

    @Override
    public void MoreEyeResult(List<MoreEyeBean.ListBean> listBean) {

    }

    @Override
    public void WatchTalkResult(List<WatchTalkBean.DataBean.ContentBean> content) {

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
        originalnews_recyclerview.setAdapter(new OriginalNewsAdapter(getActivity(),originalNewsBean));
    }

    @Override
    public void showProgress() {
        LoadingDialog.show(getActivity());
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

    }

    @Override
    public void onRefresh() {

    }
}
