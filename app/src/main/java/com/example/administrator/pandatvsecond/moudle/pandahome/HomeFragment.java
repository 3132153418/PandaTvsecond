package com.example.administrator.pandatvsecond.moudle.pandahome;

import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.widget.Toast;

import com.example.administrator.pandatvsecond.R;
import com.example.administrator.pandatvsecond.activity.video.VideoActivity;
import com.example.administrator.pandatvsecond.app.App;
import com.example.administrator.pandatvsecond.base.BaseFragment;
import com.example.administrator.pandatvsecond.model.bean.HomeBean;
import com.example.administrator.pandatvsecond.moudle.pandahome.adapter.HomeRecycleviewAdapter;
import com.example.administrator.pandatvsecond.util.MineLog;
import com.example.administrator.pandatvsecond.util.VersionUpdateUtils;
import com.example.administrator.pandatvsecond.widget.manager.LoadingDialog;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.ArrayList;
import java.util.List;

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
        LinearLayoutManager manager = new LinearLayoutManager(getActivity());
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        home_recyclerview.setLayoutManager(manager);
        home_recyclerview.setPullRefreshEnabled(true);
        home_recyclerview.setLoadingMoreEnabled(false);
        home_recyclerview.setLoadingListener(new XRecyclerView.LoadingListener() {
            @Override
            public void onRefresh() {
                presenter.start();
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
        presenter.requestVersionAndUpdate();
        presenter.start();
        homeRecycleviewAdapter.setOnClick(new HomeRecycleviewAdapter.OnClick() {
            @Override
            public void setTypeBroadcastOne(View view, List<HomeBean.DataBean.PandaeyeBean.ItemsBean> items) {
                String pid = items.get(0).getPid();
                String title = items.get(0).getTitle();
                Intent intent = new Intent(getActivity(), VideoActivity.class);
                intent.putExtra("pid",pid);
                intent.putExtra("title",title);
                startActivity(intent);
            }

            @Override
            public void setTypeBroadcastTwo(View view, List<HomeBean.DataBean.PandaeyeBean.ItemsBean> items) {

                String pid = items.get(1).getPid();
                String title = items.get(1).getTitle();
                Intent intent = new Intent(getActivity(), VideoActivity.class);
                intent.putExtra("pid",pid);
                intent.putExtra("title",title);
                startActivity(intent);
            }

            @Override
            public void setTypeLive(HomeBean.DataBean.PandaliveBean.ListBean list) {
               /* String pid = list.getVid();
                String title = list.getTitle();
                Intent intent = new Intent(getActivity(),VideoActivity.class);
                intent.putExtra("pid",pid);
                startActivity(intent);*/
            }

            @Override
            public void setTypeSplendid(HomeBean.DataBean.AreaBean.ListscrollBean listscroll) {

                String pid = listscroll.getPid();
                String title = listscroll.getTitle();
                Intent intent = new Intent(getActivity(),VideoActivity.class);
                intent.putExtra("pid",pid);
                intent.putExtra("title",title);
                MineLog.d("pid",pid);
                startActivity(intent);
            }

            @Override
            public void setTypeGG(HomeBean.DataBean.WallliveBean.ListBeanX items) {

                String pid = items.getVid();
                String title = items.getTitle();
                Intent intent = new Intent(getActivity(),VideoActivity.class);
                intent.putExtra("pid",pid);
                intent.putExtra("title",title);
                startActivity(intent);
            }

            @Override
            public void setTypeLiveChina(HomeBean.DataBean.ChinaliveBean.ListBeanXX list2) {

              /*  String pid = list2.getVid();
                String title = list2.getTitle();
                Intent intent = new Intent(getActivity(),VideoActivity.class);
                intent.putExtra("pid",pid);
                intent.putExtra("title",title);
                startActivity(intent);*/
            }

            @Override
            public void setTypeLunBo(HomeBean.DataBean.BigImgBean imgBean) {
                String pid = imgBean.getPid();
                String title = imgBean.getTitle();
                Intent intent = new Intent(getActivity(),VideoActivity.class);
                intent.putExtra("pid",pid);
                intent.putExtra("title",title);
                startActivity(intent);
            }
        });
    }

    @Override
    public void setResult(HomeBean homeBean) {
        home_datas.clear();
        home_datas.add(homeBean.getData().getBigImg());
        home_datas.add(homeBean.getData().getPandaeye());
        home_datas.add(homeBean.getData().getPandalive());
        home_datas.add(homeBean.getData().getArea());
        home_datas.add(homeBean.getData().getWalllive());
        home_datas.add(homeBean.getData().getChinalive());
        homeRecycleviewAdapter.notifyDataSetChanged();
        home_recyclerview.refreshComplete();
    }

    @Override
    public void showUpdateDialog() {
        //显示以及下载新版本
        VersionUpdateUtils.showWarnUpdateDialog();
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
        Toast.makeText(getActivity(), msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onRefresh() {

    }


}
