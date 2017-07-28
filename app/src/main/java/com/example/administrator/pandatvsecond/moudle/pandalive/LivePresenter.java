package com.example.administrator.pandatvsecond.moudle.pandalive;

import com.example.administrator.pandatvsecond.model.bean.LiveBean;
import com.example.administrator.pandatvsecond.model.biz.LiveMoudle;
import com.example.administrator.pandatvsecond.model.biz.LiveMoudleImpl;
import com.example.administrator.pandatvsecond.net.callback.MyCallBack;

/**
 * Created by Administrator on 2017/7/28.
 */

public class LivePresenter implements LiveContract.Presenter {
    private LiveContract.View liveView;
    private LiveMoudle liveMoudle;
    public LivePresenter(LiveContract.View liveView){
        this.liveView = liveView;
        this.liveView.setPresenter(this);
        liveMoudle = new LiveMoudleImpl();
    }

    @Override
    public void start() {

        liveMoudle.setLive(new MyCallBack<LiveBean>() {
            @Override
            public void onSusses(LiveBean liveBean) {
                liveView.setResult(liveBean);
            }

            @Override
            public void onError(String msg) {

            }
        });
    }
}
