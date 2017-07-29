package com.example.administrator.pandatvsecond.moudle.pandabroadcast;

import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.androidkun.PullToRefreshRecyclerView;
import com.bumptech.glide.Glide;
import com.example.administrator.pandatvsecond.R;
import com.example.administrator.pandatvsecond.base.BaseFragment;
import com.example.administrator.pandatvsecond.model.bean.BroadcastBean;
import com.example.administrator.pandatvsecond.moudle.pandabroadcast.adapter.BroadcastAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/7/28.
 */

public class BroadcastFragment extends BaseFragment implements BroadcastContract.View {

    private BroadcastContract.Presenter presenter;
    private List<BroadcastBean.ListBean> list = new ArrayList<>();
    private PullToRefreshRecyclerView pullToRefreshRecyclerView;
    private BroadcastAdapter adapter;
    private ImageView imageView;
    private TextView textView;
    private View inflat;

    @Override
    protected int getLayoutId() {
        return R.layout.broadcast_fragment;
    }

    @Override
    protected void initView(View view) {

        new BroadcastPresenter(this);

        inflat = LayoutInflater.from(getContext()).inflate(R.layout.broadcast_img_item, null);
        imageView = (ImageView) inflat.findViewById(R.id.broadcast_ImageView);
        textView = (TextView) inflat.findViewById(R.id.broadcast_Image_title);
        pullToRefreshRecyclerView = (PullToRefreshRecyclerView) view.findViewById(R.id.broadcast_PullRecy);
        LinearLayoutManager managers = new LinearLayoutManager(getContext());
        managers.setOrientation(LinearLayoutManager.VERTICAL);

        pullToRefreshRecyclerView.setLayoutManager(managers);
        pullToRefreshRecyclerView.addHeaderView(inflat);
        pullToRefreshRecyclerView.setPullRefreshEnabled(true);

    }

    @Override
    protected void loadData() {
        presenter.start();

    }

    @Override
    public void showProgress() {

    }

    @Override
    public void dismissProgress() {

    }

    @Override
    public void setPresenter(BroadcastContract.Presenter presenter) {

        this.presenter =  presenter;
    }

    @Override
    public void showMessage(String msg) {

    }

    @Override
    public void onRefresh() {

    }

    @Override
    public void setResult(BroadcastBean broadcastBean) {

        Glide.with(getContext()).load(broadcastBean.getBigImg().get(0).getImage()).into(imageView);
        textView.setText(broadcastBean.getBigImg().get(0).getTitle());
        List<BroadcastBean.ListBean> listBean = broadcastBean.getList();
        list.addAll(listBean);
        adapter = new BroadcastAdapter(list, getContext());
        pullToRefreshRecyclerView.setAdapter(adapter);
    }

}
