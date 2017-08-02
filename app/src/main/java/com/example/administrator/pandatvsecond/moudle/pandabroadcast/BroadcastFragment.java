package com.example.administrator.pandatvsecond.moudle.pandabroadcast;

import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.androidkun.PullToRefreshRecyclerView;
import com.androidkun.callback.PullToRefreshListener;
import com.bumptech.glide.Glide;
import com.example.administrator.pandatvsecond.R;
import com.example.administrator.pandatvsecond.app.App;
import com.example.administrator.pandatvsecond.base.BaseFragment;
import com.example.administrator.pandatvsecond.model.bean.BroadcastBean;
import com.example.administrator.pandatvsecond.moudle.pandabroadcast.adapter.BroadcastAdapter;
import com.example.administrator.pandatvsecond.widget.manager.LoadingDialog;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/7/28.
 */

public class BroadcastFragment extends BaseFragment implements BroadcastContract.View{

    private List<BroadcastBean.ListBean> list = new ArrayList<>();
    private ImageView imageView;
    private TextView textView;
    private PullToRefreshRecyclerView pullToRefreshRecyclerView;
    private BroadcastContract.Presenter presenter;
    private View inflat;
    @Override
    protected int getLayoutId() {
        return R.layout.broadcast_fragment;
    }


    protected void initView(View view) {

        new BroadcastPresenter(this);

        inflat = LayoutInflater.from(getActivity()).inflate(R.layout.broadcast_img_item, null);
        imageView = (ImageView) inflat.findViewById(R.id.broadcast_ImageView);
        textView = (TextView) inflat.findViewById(R.id.broadcast_Image_title);
        pullToRefreshRecyclerView = (PullToRefreshRecyclerView) view.findViewById(R.id.broadcast_PullRecy);
        LinearLayoutManager managers = new LinearLayoutManager(getActivity());
        managers.setOrientation(LinearLayoutManager.VERTICAL);

        pullToRefreshRecyclerView.setLayoutManager(managers);
        pullToRefreshRecyclerView.addHeaderView(inflat);
        pullToRefreshRecyclerView.setPullRefreshEnabled(true);
        pullToRefreshRecyclerView.setPullToRefreshListener(new PullToRefreshListener() {
            @Override
            public void onRefresh() {
                pullToRefreshRecyclerView.postDelayed(new Runnable() {
                    @Override
                    public void run() {

                        list.clear();
                        presenter.start();
                        pullToRefreshRecyclerView.setRefreshComplete();
                    }
                },1000);

            }

            @Override
            public void onLoadMore() {

                pullToRefreshRecyclerView.postDelayed(new Runnable() {
                    @Override
                    public void run() {

                        pullToRefreshRecyclerView.setLoadMoreComplete();
                    }
                },2000);

            }
        });


    }

    @Override
    protected void loadData() {
        presenter.start();


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

        Glide.with(getActivity()).load(broadcastBean.getBigImg().get(0).getImage()).into(imageView);
        textView.setText(broadcastBean.getBigImg().get(0).getTitle());
        List<BroadcastBean.ListBean> listBean = broadcastBean.getList();
        list.addAll(listBean);
        BroadcastAdapter adapter = new BroadcastAdapter(list, getActivity());
        pullToRefreshRecyclerView.setAdapter(adapter);

    }
}
