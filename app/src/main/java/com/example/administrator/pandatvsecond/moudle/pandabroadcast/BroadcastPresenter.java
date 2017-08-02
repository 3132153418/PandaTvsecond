package com.example.administrator.pandatvsecond.moudle.pandabroadcast;

import android.graphics.drawable.Drawable;

import com.example.administrator.pandatvsecond.model.bean.BroadcastBean;
import com.example.administrator.pandatvsecond.model.biz.BroadcastMoudle;
import com.example.administrator.pandatvsecond.model.biz.BroadcastMoudleImpl;
import com.example.administrator.pandatvsecond.net.callback.MyCallBack;

/**
 * Created by Administrator on 2017/7/28.
 */

public class BroadcastPresenter implements BroadcastContract.Presenter {
    private BroadcastContract.View broadcastView;
    private BroadcastMoudle broadcastMoudle;
    public BroadcastPresenter(BroadcastContract.View broadcastView){

        this.broadcastView = broadcastView;
        broadcastView.setPresenter(this);
        broadcastMoudle = new BroadcastMoudleImpl();
    }

    @Override
    public void start() {
        broadcastView.showProgress();
        broadcastMoudle.setBroadcast(new MyCallBack<BroadcastBean>() {
            @Override
            public void onSuccess(Drawable drawable) {

            }

            @Override
            public void onSusses(BroadcastBean broadcastBean) {
                broadcastView.setResult(broadcastBean);
                broadcastView.dismissProgress();
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
