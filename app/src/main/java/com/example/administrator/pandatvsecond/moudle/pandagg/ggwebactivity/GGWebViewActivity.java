package com.example.administrator.pandatvsecond.moudle.pandagg.ggwebactivity;

import android.support.v7.widget.LinearLayoutManager;
import android.view.View;

import com.example.administrator.pandatvsecond.R;
import com.example.administrator.pandatvsecond.base.BaseActivity;
import com.example.administrator.pandatvsecond.model.bean.PandaTebieBean;
import com.example.administrator.pandatvsecond.model.bean.VideoJingCaiBean;
import com.example.administrator.pandatvsecond.moudle.pandagg.adapter.GGWebAdapter;
import com.example.administrator.pandatvsecond.util.MineLog;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.ArrayList;
import java.util.List;

import fm.jiecao.jcvideoplayer_lib.JCVideoPlayer;
import fm.jiecao.jcvideoplayer_lib.JCVideoPlayerStandard;

/**
 * Created by Administrator on 2017/8/1.
 * 测试一下
 */

public class GGWebViewActivity extends BaseActivity implements GGWebContract.View {
    private GGWebContract.Presenter presenter;
    private XRecyclerView xRecyclerView;
    private GGWebAdapter ggWebAdapter;
    private List<PandaTebieBean.VideoBean> list = new ArrayList<>();
    private String pid = "d2a828ca5cd0400f82c2adee5581fc17",title,url;
    private JCVideoPlayerStandard jcVideoPlayerStandard;

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

        xRecyclerView = (XRecyclerView) findViewById(R.id.ggWeb_Xrecycler);
        LinearLayoutManager manager = new LinearLayoutManager(this);
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        xRecyclerView.setLayoutManager(manager);
        ggWebAdapter = new GGWebAdapter(list, GGWebViewActivity.this);
        xRecyclerView.setAdapter(ggWebAdapter);
        ggWebAdapter.notifyDataSetChanged();

        /*Intent intent = getIntent();
        pid = intent.getStringExtra("pid");
        title = intent.getStringExtra("title");*/

    }

    @Override
    public void onPause() {
        super.onPause();
        JCVideoPlayer.releaseAllVideos();
    }

    @Override
    public void showProgress() {

    }

    @Override
    public void dismissProgress() {

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
        jcVideoPlayerStandard.setUp(url,JCVideoPlayerStandard.SCREEN_LAYOUT_NORMAL,"asdas");
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
}
