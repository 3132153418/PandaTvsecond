package com.example.administrator.pandatvsecond.moudle.pandalive;

import android.graphics.drawable.Drawable;

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
        liveView.showProgress();
        liveMoudle.loadNoBeerBeanData(new MyCallBack<NoBearBean>() {
            @Override
            public void onSuccess(Drawable drawable) {

            }

            @Override
            public void onSusses(NoBearBean noBearBean) {
                liveView.NoBeerBeanResult(noBearBean);
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
    public void requestGGShowFragmentData() {
        liveView.showProgress();
        liveMoudle.loadGGShowBeanData(new MyCallBack<GGShowBean>() {
            @Override
            public void onSuccess(Drawable drawable) {

            }

            @Override
            public void onSusses(GGShowBean ggShowBean) {
                liveView.GGShowBeanResult(ggShowBean);
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
    public void requestPandaFileFragmentData() {
        liveView.showProgress();
        liveMoudle.loadPandaFileData(new MyCallBack<PandaFileBean>() {
            @Override
            public void onSuccess(Drawable drawable) {

            }

            @Override
            public void onSusses(PandaFileBean pandaFileBean) {
                liveView.PandaFileResult(pandaFileBean);
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
    public void requestPandaTopFragmentData() {
        liveView.showProgress();
        liveMoudle.loadPandaTopBeanData(new MyCallBack<PandaTopBean>() {
            @Override
            public void onSuccess(Drawable drawable) {

            }

            @Override
            public void onSusses(PandaTopBean pandaTopBean) {
                liveView.PandaTopBeanResult(pandaTopBean);
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
    public void requestPandaThingsFragmentData() {
        liveView.showProgress();
        liveMoudle.loadPandaThingsBeanData(new MyCallBack<NoBearBean>() {
            @Override
            public void onSuccess(Drawable drawable) {

            }

            @Override
            public void onSusses(NoBearBean noBearBean) {
                liveView.PandaThingsBeanResult(noBearBean);
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
    public void requestEspeciallyShowFragmentData() {
        liveView.showProgress();
        liveMoudle.loadEspeciallyShowBeanData(new MyCallBack<EspeciallyShowBean>() {
            @Override
            public void onSuccess(Drawable drawable) {

            }

            @Override
            public void onSusses(EspeciallyShowBean especiallyShowBean) {
                liveView.EspeciallyShowBeanResult(especiallyShowBean);
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
    public void requestOriginalNewsFragmentData() {
        liveView.showProgress();
        liveMoudle.loadOriginalNewsBeanData(new MyCallBack<OriginalNewsBean>() {
            @Override
            public void onSuccess(Drawable drawable) {

            }

            @Override
            public void onSusses(OriginalNewsBean originalNewsBean) {
                liveView.OriginalNewsBeanResult(originalNewsBean);
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
