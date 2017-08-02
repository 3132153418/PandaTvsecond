package com.example.administrator.pandatvsecond.activity;


import android.graphics.drawable.Drawable;

import com.example.administrator.pandatvsecond.app.App;
import com.example.administrator.pandatvsecond.model.bean.OriginalBean;
import com.example.administrator.pandatvsecond.model.biz.OriginaMoudle;
import com.example.administrator.pandatvsecond.model.biz.OriginalMoudleIpl;
import com.example.administrator.pandatvsecond.net.callback.MyCallBack;
import com.example.administrator.pandatvsecond.util.ACache;

/**
 * Created by Administrator on 2017/7/15.
 */

public class OriginalPresenter implements OriginalContract.Presenter {
    OriginalContract.View view;
//烦得很规范化附近你
    OriginaMoudle originaMoudle;
    private ACache aCache= ACache.get(App.context);
    public OriginalPresenter(OriginalContract.View view){
        this.view=view;
        view.setPresenter(this);
        originaMoudle=new OriginalMoudleIpl();
    }
    @Override
    public void start() {
        view.showProgress();
        OriginalBean originalBean= (OriginalBean) aCache.getAsObject("OriginalBean");
        if(originalBean==null) {
            originaMoudle.getOriginaCallBack(new MyCallBack<OriginalBean>() {
                @Override
                public void onSuccess(Drawable drawable) {

                }

                @Override
                public void onSusses(OriginalBean originalBean) {
                    view.setResoust(originalBean);
                    view.dismissProgress();
                }

                @Override
                public void onsusses(String string) {

                }

                @Override
                public void onError(String msg) {

                }

            });
        }else
            view.setResoust(originalBean);


    }
}
