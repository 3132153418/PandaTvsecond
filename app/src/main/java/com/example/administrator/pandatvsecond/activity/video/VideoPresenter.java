package com.example.administrator.pandatvsecond.activity.video;

import com.example.administrator.pandatvsecond.model.bean.VideoJingCaiBean;
import com.example.administrator.pandatvsecond.model.biz.VideoMoudle;
import com.example.administrator.pandatvsecond.model.biz.VideoMoudleImpl;
import com.example.administrator.pandatvsecond.net.callback.MyCallBack;

/**
 * Created by Administrator on 2017/7/29.
 */

public class VideoPresenter implements VideoContract.Presenter {
    private VideoContract.View videoView;
    private VideoMoudle videoMoudle;
    public VideoPresenter(VideoContract.View videoView){
        this.videoView = videoView;
        videoView.setPresenter(this);
        videoMoudle = new VideoMoudleImpl();
    }
    @Override
    public void start() {

    }

    @Override
    public void setJcVideo(String pid) {
        videoMoudle.setVideoJc(pid, new MyCallBack<VideoJingCaiBean>() {
            @Override
            public void onSusses(VideoJingCaiBean videoJingCaiBean) {
                videoView.setResult(videoJingCaiBean);
            }

            @Override
            public void onError(String msg) {

            }
        });
    }
}
