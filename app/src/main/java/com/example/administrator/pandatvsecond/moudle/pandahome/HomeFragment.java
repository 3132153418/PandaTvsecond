package com.example.administrator.pandatvsecond.moudle.pandahome;

import android.support.v7.widget.LinearLayoutManager;
import android.view.View;

import com.example.administrator.pandatvsecond.R;
import com.example.administrator.pandatvsecond.app.App;
import com.example.administrator.pandatvsecond.base.BaseFragment;
import com.example.administrator.pandatvsecond.model.bean.HomeBean;
import com.example.administrator.pandatvsecond.moudle.pandahome.adapter.HomeRecycleviewAdapter;
import com.example.administrator.pandatvsecond.util.MineLog;
import com.example.administrator.pandatvsecond.widget.manager.LoadingDialog;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.ArrayList;

/**
 * Created by Administrator on 2017/7/28.
 */

public class HomeFragment extends BaseFragment implements HomeContract.View{
    private HomePresenter presenter;
    private XRecyclerView home_recyclerview;
    private ArrayList<Object> home_datas = new ArrayList<>();
    private HomeRecycleviewAdapter homeRecycleviewAdapter;

    @Override
    protected int getLayoutId() {
        return R.layout.home_fragment;
    }

    @Override
    protected void initView(View view) {
        home_recyclerview = (XRecyclerView) view.findViewById(R.id.home_recyclerview);
        LinearLayoutManager manager = new LinearLayoutManager(getContext());
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        home_recyclerview.setLayoutManager(manager);
        home_recyclerview.setPullRefreshEnabled(true);
        home_recyclerview.setLoadingMoreEnabled(false);
        home_recyclerview.setLoadingListener(new XRecyclerView.LoadingListener() {
            @Override
            public void onRefresh() {

            }

            @Override
            public void onLoadMore() {

            }
        });
        homeRecycleviewAdapter = new HomeRecycleviewAdapter(getActivity(),home_datas);
        home_recyclerview.setAdapter(homeRecycleviewAdapter);
    }


    @Override
    protected void loadData() {
        LoadingDialog.show(getActivity());
        presenter.start();
    }

    @Override
    public void setResult(HomeBean homeBean) {
        home_datas.add(homeBean.getData().getBigImg());
        home_datas.add(homeBean.getData().getPandaeye());
        home_datas.add(homeBean.getData().getPandalive());
        MineLog.d("TAG","home_datas"+home_datas.size());
        homeRecycleviewAdapter.notifyDataSetChanged();
        LoadingDialog.dimiss();
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
    public void setPresenter(HomeContract.Presenter presenter) {
        this.presenter = (HomePresenter) presenter;

    }

    @Override
    public void showMessage(String msg) {

    }

    @Override
    public void onRefresh() {

    }


}
