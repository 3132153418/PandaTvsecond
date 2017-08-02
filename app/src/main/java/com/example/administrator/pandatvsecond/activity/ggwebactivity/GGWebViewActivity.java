package com.example.administrator.pandatvsecond.activity.ggwebactivity;

import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

import com.example.administrator.pandatvsecond.R;
import com.example.administrator.pandatvsecond.base.BaseActivity;
import com.example.administrator.pandatvsecond.model.bean.PandaTebieBean;
import com.example.administrator.pandatvsecond.model.bean.VideoJingCaiBean;
import com.example.administrator.pandatvsecond.moudle.pandagg.adapter.GGWebAdapter;
import com.example.administrator.pandatvsecond.util.MineLog;
import com.example.administrator.pandatvsecond.widget.manager.LoadingDialog;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.ArrayList;
import java.util.List;

import fm.jiecao.jcvideoplayer_lib.JCVideoPlayer;
import fm.jiecao.jcvideoplayer_lib.JCVideoPlayerStandard;

/**
 * Created by Administrator on 2017/8/1.
 * 测试一下
 */

public class GGWebViewActivity extends BaseActivity implements GGWebContract.View,View.OnClickListener{
    private GGWebContract.Presenter presenter;
    private XRecyclerView xRecyclerView;
    private GGWebAdapter ggWebAdapter;
    private List<PandaTebieBean.VideoBean> list = new ArrayList<>();
    private String pid ,title,url;
    private JCVideoPlayerStandard jcVideoPlayerStandard;
    private CheckBox checkbox_Image_Btn;
    private TextView ggWeb_TextView;
    private Boolean isCheck = false;

    @Override
    protected int getLauoutId() {
        return R.layout.activity_ggwebview;
    }

    @Override
    protected void loadData() {

        presenter.start();
        presenter.setJcVideo(pid);

    }

    @Override
    protected void initView() {

        new GGWebPresenter(this);

        jcVideoPlayerStandard = (JCVideoPlayerStandard) findViewById(R.id.jcVideoPlayerStandard);

        checkbox_Image_Btn = (CheckBox) findViewById(R.id.checkbox_Image_Btn);
        checkbox_Image_Btn.setOnClickListener(this);
        ggWeb_TextView = (TextView) findViewById(R.id.ggWeb_TextView);
        xRecyclerView = (XRecyclerView) findViewById(R.id.ggWeb_Xrecycler);
        LinearLayoutManager manager = new LinearLayoutManager(this);
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        xRecyclerView.setLayoutManager(manager);
        ggWebAdapter = new GGWebAdapter(list, GGWebViewActivity.this);
        xRecyclerView.setAdapter(ggWebAdapter);

        Intent intent = getIntent();
        pid = intent.getStringExtra("pid");
        title = intent.getStringExtra("title");

    }

    @Override
    public void onPause() {
        super.onPause();
        JCVideoPlayer.releaseAllVideos();
    }

    @Override
    public void showProgress() {
        LoadingDialog.show(this);
    }

    @Override
    public void dismissProgress() {
        LoadingDialog.dimiss();
    }

    @Override
    public void setPresenter(GGWebContract.Presenter presenter) {

        this.presenter = presenter;
    }

    @Override
    public void showMessage(String msg) {

    }

    @Override
    public void onRefresh() {

    }

    @Override
    public void setVideoResult(final VideoJingCaiBean videoJingCaiBean) {
        final List<VideoJingCaiBean.VideoBean.ChaptersBean> chapters = videoJingCaiBean.getVideo().getChapters();

        url = chapters.get(0).getUrl();
        jcVideoPlayerStandard.setUp(url,JCVideoPlayerStandard.SCREEN_LAYOUT_NORMAL,title);
        jcVideoPlayerStandard.startVideo();

    }

    @Override
    public void setGGXrecy(final PandaTebieBean pandaTebieBean) {

        List<PandaTebieBean.VideoBean> video = pandaTebieBean.getVideo();
        list.addAll(video);
        xRecyclerView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String vid = pandaTebieBean.getVideo().get(0).getVid();
                MineLog.d("vidsadasdasd",vid);
                presenter.setJcVideo(vid);
            }
        });

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.checkbox_Image_Btn:
                if (isCheck == false) {
                    ggWeb_TextView.setVisibility(View.VISIBLE);
                    isCheck = true;
                    return;
                } else {
                    ggWeb_TextView.setVisibility(View.GONE);
                    isCheck = false;
                    return;

                }
        }
    }
}
