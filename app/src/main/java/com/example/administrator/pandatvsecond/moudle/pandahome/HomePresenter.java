package com.example.administrator.pandatvsecond.moudle.pandahome;

import android.graphics.drawable.Drawable;

import com.example.administrator.pandatvsecond.app.App;
import com.example.administrator.pandatvsecond.model.bean.HomeBean;
import com.example.administrator.pandatvsecond.model.biz.HomeMoudle;
import com.example.administrator.pandatvsecond.model.biz.HomeMoudleImpl;
import com.example.administrator.pandatvsecond.net.callback.MyCallBack;
import com.example.administrator.pandatvsecond.util.ACache;
import com.example.administrator.pandatvsecond.util.MineLog;

/**
 * Created by Administrator on 2017/7/28.
 */

public class HomePresenter implements HomeContract.Presenter {
    private HomeContract.View homeView;
    private HomeMoudle homeMoudle;
    public HomePresenter(HomeContract.View homeView){
        this.homeView = homeView;
        homeView.setPresenter(this);
        this.homeMoudle = new HomeMoudleImpl();
    }

    @Override
    public void start() {
        homeView.showProgress();
        HomeBean homeBean = (HomeBean) ACache.get(App.context).getAsObject("HomeBean");
        if (homeBean ==null) {
            homeMoudle.loadHomeData(new MyCallBack<HomeBean>() {
                @Override
                public void onSuccess(Drawable drawable) {

                }

                @Override
                public void onSusses(HomeBean homeBean) {
                    MineLog.d("Home", "网络请求回调成功");
                    homeView.setResult(homeBean);
                    homeView.dismissProgress();
                }

                @Override
                public void onsusses(String string) {

                }

                @Override
                public void onError(String msg) {
                    MineLog.d("Home", "网络请求回调失败"+msg);
                }
            });
        }else {
            homeView.setResult(homeBean);
            homeView.dismissProgress();
        }

    }
}
