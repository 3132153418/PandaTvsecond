package com.example.administrator.pandatvsecond.moudle.pandagg;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.androidkun.PullToRefreshRecyclerView;
import com.androidkun.callback.PullToRefreshListener;
import com.example.administrator.pandatvsecond.R;
import com.example.administrator.pandatvsecond.base.BaseFragment;
import com.example.administrator.pandatvsecond.model.bean.GGbean;
import com.example.administrator.pandatvsecond.moudle.pandagg.adapter.GGAdapter;
import com.example.administrator.pandatvsecond.moudle.pandagg.adapter.GlideImageLoader;
import com.example.administrator.pandatvsecond.activity.ggwebactivity.GGWebViewActivity;
import com.example.administrator.pandatvsecond.util.MineLog;
import com.example.administrator.pandatvsecond.widget.manager.LoadingDialog;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 滚滚视频 */

public class GGFragment extends BaseFragment implements GGContract.View{

    @BindView(R.id.gg_pull)
    PullToRefreshRecyclerView ggPull;
    private GGContract.ggPresenter ggPresenter;
    private GGAdapter ggAdapter;
    private List<GGbean.ListBean> gglist = new ArrayList<>();
    private List<GGbean.BigImgBean> ggbigimagelist= new ArrayList<>();
    private Banner bannerheader;

    @Override
    protected int getLayoutId() {
        return R.layout.gg_fragment;
    }

    @Override
    protected void initView(View view) {
        LinearLayoutManager manager = new LinearLayoutManager(getActivity());
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        ggPull.setLayoutManager(manager);
        ggPull.setPullRefreshEnabled(true);
        ggPull.setLoadingMoreEnabled(true);
        ggPull.setPullToRefreshListener(new PullToRefreshListener() {
            @Override
            public void onRefresh() {
                ggPull.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        ggPull.setRefreshComplete();
                    }
                }, 2000);
            }

            @Override
            public void onLoadMore() {
                ggPull.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        ggPull.setLoadMoreComplete();
                    }
                }, 2000);
            }
        });
        View inflate = View.inflate(getActivity(), R.layout.gg_header, null);
        bannerheader = (Banner) inflate.findViewById(R.id.gg_banner);
        ggPull.addHeaderView(inflate);

    }

    

    @Override
    protected void loadData() {
        new GGPresenter(this);
        ggPresenter.start();



    }

    @Override
    public void showGGdata(GGbean gGbean) {
        ggbigimagelist.addAll(gGbean.getBigImg());
        final List<String> list=new ArrayList<>();
        for(int i = 0; i < ggbigimagelist.size(); i++) {
            GGbean.BigImgBean bigImgBean = ggbigimagelist.get(i);
            MineLog.d("法国红酒考虑吧你们，",bigImgBean.toString());
            list.add(bigImgBean.getImage());
        }

        //设置图片加载器
        bannerheader.setImageLoader(new GlideImageLoader());
        MineLog.d("GGFragmentbannerid",bannerheader.toString());
        //设置自动轮播，默认为true
        bannerheader.isAutoPlay(true);
        //设置轮播时间
        bannerheader.setDelayTime(2000);
        //设置图片集合
        bannerheader.setImages(list);
        MineLog.d("更换即可了个复活技能吗",list.toString());
        //设置点的位置
        bannerheader.setIndicatorGravity(BannerConfig.RIGHT);
        //banner设置方法全部调用完毕时最后调用
        bannerheader.start();

        gglist.addAll(gGbean.getList());
        ggAdapter = new GGAdapter(getActivity(), gglist);

        MineLog.d("ggadapter", gglist.toString());
        ggPull.setAdapter(ggAdapter);
        ggAdapter.notifyDataSetChanged();

        ggAdapter.setonClickListener(new GGAdapter.SetOnItemListener() {
            @Override
            public void setOnItemListener(GGbean.ListBean listBean) {
                String url = listBean.getUrl();
                String title = listBean.getTitle();
                String brief = listBean.getBrief();
                String image = listBean.getImage();
                Intent in = new Intent(getActivity(),GGWebViewActivity.class);
                in.putExtra("url",url);
                in.putExtra("title",title);
                in.putExtra("brief",brief);
                in.putExtra("pid","84f27011346547c595d78b47a48eb6de");
                in.putExtra("image",image);
                startActivity(in);


            }
        });

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
    public void setPresenter(GGContract.ggPresenter ggPresenter) {
        this.ggPresenter = ggPresenter;
    }

    @Override
    public void showMessage(String msg) {

    }

    @Override
    public void onRefresh() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        unbinder = ButterKnife.bind(this, rootView);
        return rootView;
    }

//    @Override
//    public void onDestroyView() {
//        super.onDestroyView();
//        unbinder.unbind();
//    }
}
