package com.example.administrator.pandatvsecond.activity.video;

import android.content.Intent;
import android.view.View;

import com.example.administrator.pandatvsecond.R;
import com.example.administrator.pandatvsecond.base.BaseActivity;
import com.example.administrator.pandatvsecond.model.bean.VideoJingCaiBean;

import java.util.List;

import fm.jiecao.jcvideoplayer_lib.JCVideoPlayer;
import fm.jiecao.jcvideoplayer_lib.JCVideoPlayerStandard;

/**
 * Created by Administrator on 2017/7/29.
 */

public class VideoActivity extends BaseActivity implements VideoContract.View {
    private VideoContract.Presenter presenter;
    private String pid ,title;
    private String url;
    private JCVideoPlayerStandard jcVideoPlayerStandard;

    @Override
    protected int getLauoutId() {
        return R.layout.activity_video;
    }

    @Override
    protected void loadData() {

        presenter.setJcVideo(pid);
    }

    @Override
    protected void initView() {
        new VideoPresenter(this);
        jcVideoPlayerStandard = (JCVideoPlayerStandard) findViewById(R.id.jcVideoPlayerStandard);
        Intent intent = getIntent();
        pid= intent.getStringExtra("pid");
       title = intent.getStringExtra("title");
    }

    @Override
    public void onPause() {
        super.onPause();
        JCVideoPlayer.releaseAllVideos();
    }

    @Override
    public void setResult(final VideoJingCaiBean videoJingCaiBean) {

        final List<VideoJingCaiBean.VideoBean.ChaptersBean> chapters = videoJingCaiBean.getVideo().getChapters();

        url = chapters.get(0).getUrl();
        jcVideoPlayerStandard.setUp(url,JCVideoPlayerStandard.SCREEN_LAYOUT_NORMAL,title);
        jcVideoPlayerStandard.startVideo();
        jcVideoPlayerStandard.setMonitor(new JCVideoPlayerStandard.imgClickon() {
            @Override
            public void Monitor(View view) {

            }

            @Override
            public void Back(View view) {

            }

            @Override
            public void WatchthelistMonitor(View view) {

            }

            //视频切换   高清
            @Override
            public void PopupGao(View view) {

                List<VideoJingCaiBean.VideoBean.Chapters2Bean> chapters2 = videoJingCaiBean.getVideo().getChapters2();
                url = chapters2.get(0).getUrl();
                jcVideoPlayerStandard.setUp(url,JCVideoPlayerStandard.SCREEN_LAYOUT_NORMAL,title);
                jcVideoPlayerStandard.startVideo();

            }

            //视频切换   标清
            @Override
            public void PopupBiao(View view) {

                List<VideoJingCaiBean.VideoBean.Chapters4Bean> chapters4 = videoJingCaiBean.getVideo().getChapters4();
                url = chapters4.get(0).getUrl();
                jcVideoPlayerStandard.setUp(url,JCVideoPlayerStandard.SCREEN_LAYOUT_NORMAL,title);
                jcVideoPlayerStandard.startVideo();
            }
        });



    }

    @Override
    public void showProgress() {

    }

    @Override
    public void dismissProgress() {

    }

    @Override
    public void setPresenter(VideoContract.Presenter presenter) {

        this.presenter = presenter;
    }

    @Override
    public void showMessage(String msg) {

    }

    @Override
    public void onRefresh() {

    }
}
