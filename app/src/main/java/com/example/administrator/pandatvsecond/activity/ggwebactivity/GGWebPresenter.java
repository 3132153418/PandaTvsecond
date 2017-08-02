package com.example.administrator.pandatvsecond.activity.ggwebactivity;

import android.graphics.drawable.Drawable;

import com.example.administrator.pandatvsecond.model.bean.PandaTebieBean;
import com.example.administrator.pandatvsecond.model.bean.VideoJingCaiBean;
import com.example.administrator.pandatvsecond.model.biz.GGVideoMoudle;
import com.example.administrator.pandatvsecond.model.biz.GGVideoMoudleImpl;
import com.example.administrator.pandatvsecond.net.callback.MyCallBack;
import com.example.administrator.pandatvsecond.util.MineLog;

/**
 * Created by Administrator on 2017/8/1.
 */

public class GGWebPresenter implements GGWebContract.Presenter {
    private GGWebContract.View ggWebView;
    private GGVideoMoudle ggVideoMoudle;
    public GGWebPresenter(GGWebContract.View ggWebView){
        this.ggWebView = ggWebView;
        this.ggWebView.setPresenter(this);
        ggVideoMoudle = new GGVideoMoudleImpl();
    }

    @Override
    public void setJcVideo(String pid) {
        ggVideoMoudle.setVideoJc(pid, new MyCallBack<VideoJingCaiBean>() {
            @Override
            public void onSuccess(Drawable drawable) {

            }

            @Override
            public void onSusses(VideoJingCaiBean videoJingCaiBean) {

                MineLog.d("video",videoJingCaiBean.toString());
                ggWebView.setVideoResult(videoJingCaiBean);
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
    public void start() {
        ggVideoMoudle.setGGWebMoudle(new MyCallBack<PandaTebieBean>() {
            @Override
            public void onSuccess(Drawable drawable) {

            }

            @Override
            public void onSusses(PandaTebieBean pandaTebieBean) {

                ggWebView.setGGXrecy(pandaTebieBean);
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
