package com.example.administrator.pandatvsecond.moudle.pandagg;

import android.graphics.drawable.Drawable;
import android.util.Log;

import com.example.administrator.pandatvsecond.app.App;
import com.example.administrator.pandatvsecond.model.bean.GGbean;
import com.example.administrator.pandatvsecond.model.biz.GGMoudleImpl;
import com.example.administrator.pandatvsecond.model.biz.GGmoudle;
import com.example.administrator.pandatvsecond.net.callback.MyCallBack;
import com.example.administrator.pandatvsecond.util.ACache;
import com.example.administrator.pandatvsecond.util.MineLog;

/**
 * Created by lenovo on 2017/7/28.
 */

public class GGPresenter implements GGContract.ggPresenter {
    private GGContract.View ggview;
    private GGmoudle gGmoudle;
    private ACache aCache = ACache.get(App.context);

    public GGPresenter(GGContract.View ggview) {
        this.ggview = ggview;
        ggview.setPresenter(this);
        this.gGmoudle = new GGMoudleImpl();
    }
    @Override
    public void start() {
        GGbean ggbean = (GGbean) aCache.getAsObject("GGbean");
        if (ggbean == null) {

            gGmoudle.setGGmodel(new MyCallBack<GGbean>() {
                @Override
                public void onSuccess(Drawable drawable) {
                }
                @Override
                public void onSusses(GGbean gGbean) {
                    ggview.showGGdata(gGbean);
                    Log.d("GGPresenter", "gGbean:" + gGbean);
                    MineLog.d("滚滚视频网络请求成功", gGbean.getList().get(0).getBrief().toString());
                }
                @Override
                public void onsusses(String string) {
                }
                @Override
                public void onError(String msg) {
                    MineLog.d("滚滚视频网络请求失败", msg.toString());
                }
            });
        } else
            ggview.showGGdata(ggbean);
    }
}
