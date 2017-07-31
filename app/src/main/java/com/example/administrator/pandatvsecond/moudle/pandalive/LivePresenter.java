package com.example.administrator.pandatvsecond.moudle.pandalive;

import android.graphics.drawable.Drawable;

import com.example.administrator.pandatvsecond.model.bean.GoodTimeBean;
import com.example.administrator.pandatvsecond.model.bean.LiveFragmentBean;
import com.example.administrator.pandatvsecond.model.bean.MoreEyeBean;
import com.example.administrator.pandatvsecond.model.bean.WatchTalkBean;
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

    @Override
    public void requestSmallLiveFragmentData() {
        liveView.showProgress();
        liveMoudle.loadLiveData(new MyCallBack<LiveFragmentBean>() {
            @Override
            public void onSuccess(Drawable drawable) {

            }

            @Override
            public void onSusses(LiveFragmentBean liveFragmentBean) {
                liveView.SmallLiveFragmentResult(liveFragmentBean.getLive().get(0));
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

    @Override
    public void requestGoodTimeFragmentData() {
        liveView.showProgress();
            liveMoudle.loadGoodTimeBeanData(new MyCallBack<GoodTimeBean>() {
                @Override
                public void onSuccess(Drawable drawable) {

                }

                @Override
                public void onSusses(GoodTimeBean goodTimeBean) {
                        liveView.GoodTimeBeanResult(goodTimeBean);
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

    @Override
    public void requestNobeerFragmentData() {

    }

    @Override
    public void requestGGShowFragmentData() {

    }

    @Override
    public void requestPandaFileFragmentData() {

    }

    @Override
    public void requestPandaTopFragmentData() {

    }

    @Override
    public void requestPandaThingsFragmentData() {

    }

    @Override
    public void requestEspeciallyShowFragmentData() {

    }

    @Override
    public void requestOriginalNewsFragmentData() {

    }
}
