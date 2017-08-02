package com.example.administrator.pandatvsecond.moudle.pandalive.fragment;

import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.widget.Toast;

import com.example.administrator.pandatvsecond.R;
import com.example.administrator.pandatvsecond.activity.video.VideoActivity;
import com.example.administrator.pandatvsecond.base.BaseFragment;
import com.example.administrator.pandatvsecond.model.bean.live.AllLiveFragmentBean;
import com.example.administrator.pandatvsecond.model.bean.live.LiveCommonBean;
import com.example.administrator.pandatvsecond.model.bean.live.LiveFragmentBean;
import com.example.administrator.pandatvsecond.model.bean.live.MoreEyeBean;
import com.example.administrator.pandatvsecond.model.bean.live.WatchTalkBean;
import com.example.administrator.pandatvsecond.moudle.pandalive.LiveContract;
import com.example.administrator.pandatvsecond.moudle.pandalive.LiveFragment;
import com.example.administrator.pandatvsecond.moudle.pandalive.adapter.LiveCommonAdapter;
import com.example.administrator.pandatvsecond.widget.manager.LoadingDialog;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lenovo on 2017/8/1.
 */

public class LiveCommonFragment extends BaseFragment implements LiveContract.View {
    private XRecyclerView common_recyclerview;
    private boolean isCreatView = false;
    private boolean isLoadMore  = false;
    private List<LiveCommonBean.VideoBean> video = new ArrayList<>();
    private int page = 1;
    private String id;
    private LiveCommonAdapter liveCommonAdapter;

    @Override
    protected int getLayoutId() {
        return R.layout.live_commonfragment;
    }

    @Override
    protected void initView(View view) {
        common_recyclerview = (XRecyclerView) view.findViewById(R.id.common_recyclerview);
        LinearLayoutManager manager = new LinearLayoutManager(getActivity());
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        common_recyclerview.setLayoutManager(manager);
        common_recyclerview.setPullRefreshEnabled(true);
        common_recyclerview.setLoadingMoreEnabled(true);
        common_recyclerview.setLoadingListener(new XRecyclerView.LoadingListener() {
            @Override
            public void onRefresh() {
                isLoadMore = false;
                presenter.requestLiveCommonFragmentData(id,1);
            }

            @Override
            public void onLoadMore() {
                isLoadMore = true;
                presenter.requestLiveCommonFragmentData(id,++page);
            }
        });
        isCreatView = true;
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser){
        super.setUserVisibleHint(isVisibleToUser);
        if (isVisibleToUser) {
            int index = getArguments().getInt("index");
            id = LiveFragment.allLiveFragmentBean.getTablist().get(index).getId();
            presenter.requestLiveCommonFragmentData(id,page);
        }
    }

    @Override
    protected void loadData() {
        
    }

    @Override
    public void LiveCommonDataResult(LiveCommonBean liveCommonBean) {
        if (isCreatView) {
            if (isLoadMore) {
                video.addAll(liveCommonBean.getVideo());
                liveCommonAdapter.notifyDataSetChanged();
                common_recyclerview.loadMoreComplete();
            }else{
                video.clear();
                video.addAll(liveCommonBean.getVideo());
                liveCommonAdapter = new LiveCommonAdapter(getActivity(), video);
                common_recyclerview.setAdapter(liveCommonAdapter);
                common_recyclerview.refreshComplete();
            }
            liveCommonAdapter.setonClickListener(new LiveCommonAdapter.SetOnItemListener() {
                @Override
                public void setOnItemListener(int postion) {
                    String pid = video.get(postion).getVid();
                    String title = video.get(postion).getT();
                    Intent intent = new Intent(getActivity(), VideoActivity.class);
                    intent.putExtra("pid",pid);
                    intent.putExtra("title",title);
                    startActivity(intent);
                }
            });


//            isCreatView = false;
        }
    }

    @Override
    public void showProgress() {
        LoadingDialog.show(getActivity());
    }

    @Override
    public void dismissProgress() {
        LoadingDialog.dimiss();
    }


    private LiveContract.Presenter presenter;
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
    public void SmallLiveFragmentResult(LiveFragmentBean liveBean) {

    }

    @Override
    public void MoreEyeResult(List<MoreEyeBean.ListBean> listBean) {

    }

    @Override
    public void WatchTalkResult(List<WatchTalkBean.DataBean.ContentBean> content) {

    }

    @Override
    public void LiveFragmentDataResult(AllLiveFragmentBean allLiveFragmentBean) {

    }
}
