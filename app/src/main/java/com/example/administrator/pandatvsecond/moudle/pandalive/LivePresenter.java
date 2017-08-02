package com.example.administrator.pandatvsecond.moudle.pandalive;

import android.graphics.drawable.Drawable;

import com.example.administrator.pandatvsecond.model.bean.live.AllLiveFragmentBean;
import com.example.administrator.pandatvsecond.model.bean.live.LiveCommonBean;
import com.example.administrator.pandatvsecond.model.bean.live.LiveFragmentBean;
import com.example.administrator.pandatvsecond.model.bean.live.MoreEyeBean;
import com.example.administrator.pandatvsecond.model.bean.live.WatchTalkBean;
import com.example.administrator.pandatvsecond.model.biz.LiveMoudle;
import com.example.administrator.pandatvsecond.model.biz.LiveMoudleImpl;
import com.example.administrator.pandatvsecond.net.callback.MyCallBack;

import java.util.List;

/**
 * Created by Administrator on 2017/7/28.
 */

public class LivePresenter implements LiveContract.Presenter {
    private LiveContract.View liveView;
    private LiveMoudle liveMoudle;

    public LivePresenter(LiveContract.View liveView) {
        this.liveView = liveView;
        liveView.setPresenter(this);
        this.liveMoudle = new LiveMoudleImpl();
    }

    @Override
    public void start() {
    }
    //这个是大Fragment的请求方法
    @Override
    public void requestLiveFragmentData() {

        liveMoudle.loadLiveData(new MyCallBack<AllLiveFragmentBean>() {
            @Override
            public void onSuccess(Drawable drawable) {

            }

            @Override
            public void onSusses(AllLiveFragmentBean allLiveFragmentBean) {
                liveView.LiveFragmentDataResult(allLiveFragmentBean);
            }

            @Override
            public void onsusses(String string) {

            }

            @Override
            public void onError(String msg) {
                liveView.showMessage(msg);
            }
        });
    }
    //这个是第一个小Fragment的请求方法
    @Override
    public void requestSmallLiveFragmentData(String url) {
        liveView.showProgress();
        liveMoudle.loadSmallLiveFragmentData(url,new MyCallBack<LiveFragmentBean>() {
            @Override
            public void onSuccess(Drawable drawable) {

            }

            @Override
            public void onSusses(LiveFragmentBean liveFragmentBean) {
                liveView.SmallLiveFragmentResult(liveFragmentBean);
                requestSmallLiveFragmentMoreEyeData(liveFragmentBean.getBookmark().getMultiple().get(0).getUrl());
                requestSmallLiveFragmentWatchTalkData();
            }

            @Override
            public void onsusses(String string) {

            }

            @Override
            public void onError(String msg) {
                liveView.showMessage(msg);
            }
        });
    }


    //这个是第一个小Fragment中的多视角直播的请求方法
    @Override
    public void requestSmallLiveFragmentMoreEyeData(String moreeyeurl) {
        liveMoudle.loadLiveMoreEyeData(moreeyeurl, new MyCallBack<MoreEyeBean>() {
            @Override
            public void onSuccess(Drawable drawable) {

            }

            @Override
            public void onSusses(MoreEyeBean moreEyeBean) {
                List<MoreEyeBean.ListBean> list = moreEyeBean.getList();
                liveView.MoreEyeResult(list);
                liveView.dismissProgress();
            }

            @Override
            public void onsusses(String string) {

            }

            @Override
            public void onError(String msg) {
                liveView.showMessage(msg);
            }
        });


    }
    //这个是第一个小Fragment中的边看边聊的请求方法
    @Override
    public void requestSmallLiveFragmentWatchTalkData() {
        String watchtalkurl = "http://newcomment.cntv.cn/comment/list?app=ipandaApp&itemid=zhiboye_chat&nature=1&page=2";
            liveMoudle.loadLiveWatchTalkData(watchtalkurl, new MyCallBack<WatchTalkBean>() {
                @Override
                public void onSuccess(Drawable drawable) {

                }

                @Override
                public void onSusses(WatchTalkBean watchTalkBean) {
                    List<WatchTalkBean.DataBean.ContentBean> content = watchTalkBean.getData().getContent();
                    liveView.WatchTalkResult(content);
                }

                @Override
                public void onsusses(String string) {

                }

                @Override
                public void onError(String msg) {

                }
            });
    }
    //这个是小Fragment中可以复用的Fragment的请求方法
    @Override
    public void requestLiveCommonFragmentData(String vsid, int page) {
        liveView.showProgress();
        liveMoudle.loadLiveCommonBeanData(vsid,page, new MyCallBack<LiveCommonBean>() {
            @Override
            public void onSuccess(Drawable drawable) {

            }

            @Override
            public void onSusses(LiveCommonBean liveCommonBean) {
                liveView.LiveCommonDataResult(liveCommonBean);
                liveView.dismissProgress();
            }

            @Override
            public void onsusses(String string) {

            }

            @Override
            public void onError(String msg) {

            }
        });
    }

}
