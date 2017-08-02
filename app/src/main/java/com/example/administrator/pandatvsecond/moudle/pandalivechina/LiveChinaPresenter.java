package com.example.administrator.pandatvsecond.moudle.pandalivechina;

import android.graphics.drawable.Drawable;

import com.example.administrator.pandatvsecond.app.App;
import com.example.administrator.pandatvsecond.model.bean.PopupBean;
import com.example.administrator.pandatvsecond.model.biz.LiveChinaMoudle;
import com.example.administrator.pandatvsecond.model.biz.LiveChinaMoudleIpl;
import com.example.administrator.pandatvsecond.net.callback.MyCallBack;
import com.example.administrator.pandatvsecond.util.ACache;
import com.example.administrator.pandatvsecond.util.MineLog;

/**
 * Created by lenovo on 2017/7/28.
 */

public class LiveChinaPresenter implements LiveChinaContract.livechinaPresenter {
    //持有View层对象
    private LiveChinaContract.View livechinaview;
    //持有Moudle层对象
    private LiveChinaMoudle liveChinaMoudle;
    private ACache aCache = ACache.get(App.context);

    //持有Moudle层对象
    public LiveChinaPresenter(LiveChinaContract.View livechinaview) {
        this.livechinaview = livechinaview;
        livechinaview.setPresenter(this);
        liveChinaMoudle = new LiveChinaMoudleIpl();
    }

    @Override
    public void start() {
        livechinaview.showProgress();
        PopupBean popupbean = (PopupBean) aCache.getAsObject("PopupBean");
        if (popupbean == null) {
            liveChinaMoudle.getLiveChinaTab(new MyCallBack<PopupBean>() {
                @Override
                public void onSuccess(Drawable drawable) {

                }

                @Override
                public void onSusses(PopupBean popupBean) {
                    livechinaview.getChinaLiveTab(popupBean);
                    livechinaview.dismissProgress();
                    MineLog.d("直播中国bean", popupBean.getAlllist().get(0).getTitle());
                }

                @Override
                public void onsusses(String string) {

                }

                @Override
                public void onError(String msg) {

                }
            });
        } else{
            livechinaview.getChinaLiveTab(popupbean);
            livechinaview.dismissProgress();
        }

    }
}
