package com.example.administrator.pandatvsecond.moudle.pandalivechina.fragment;


import android.graphics.drawable.Drawable;

import com.example.administrator.pandatvsecond.app.App;
import com.example.administrator.pandatvsecond.model.bean.ChangchengBean;
import com.example.administrator.pandatvsecond.model.biz.LiveChinaMoudle;
import com.example.administrator.pandatvsecond.model.biz.LiveChinaMoudleIpl;
import com.example.administrator.pandatvsecond.net.callback.MyCallBack;
import com.example.administrator.pandatvsecond.util.ACache;
import com.example.administrator.pandatvsecond.util.MineLog;

/**
 * Created by Administrator on 2017/7/22.
 */

public class LivePresenter implements LiveContract.Presenter {

    private LiveChinaMoudle liveChinaMoudle;
    private ACache aCache = ACache.get(App.context);

    private LiveContract.View view;

    public LivePresenter(LiveContract.View view) {

        this.view = view;
        this.view.setPresenter(this);
        liveChinaMoudle = new LiveChinaMoudleIpl();

    }

    @Override
    public void setUrl(String url) {
        ChangchengBean changchengbean = (ChangchengBean) aCache.getAsObject("ChangchengBean");
        if (changchengbean == null) {
            liveChinaMoudle.getLiveChinaUrl(url, new MyCallBack<ChangchengBean>() {
                @Override
                public void onSuccess(Drawable drawable) {

                }

                @Override
                public void onSusses(ChangchengBean changchengBean) {
                    view.getManager(changchengBean);
                    MineLog.d("LivePresenter直播中国数据", changchengBean.getLive().get(0).getBrief());
                }

                @Override
                public void onsusses(String string) {

                }

                @Override
                public void onError(String msg) {

                }
            });
        } else
            view.getManager(changchengbean);


    }

    @Override
    public void start() {

    }
}
