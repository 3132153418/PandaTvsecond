package com.example.administrator.pandatvsecond.app;

import android.app.Application;
import android.content.Context;

import com.example.administrator.pandatvsecond.base.BaseActivity;
import com.example.administrator.pandatvsecond.util.MineLog;
import com.umeng.message.IUmengRegisterCallback;
import com.umeng.message.PushAgent;

/**
 * Created by Administrator on 2017/7/27.
 */

public class App extends Application {
    public static BaseActivity context = null;
    @Override
    public void onCreate() {
        super.onCreate();


        PushAgent mPushAgent = PushAgent.getInstance(this);
//注册推送服务，每次调用register方法都会回调该接口
        mPushAgent.register(new IUmengRegisterCallback() {

            @Override
            public void onSuccess(String deviceToken) {
                //注册成功会返回device token
                MineLog.d("deviceToken",deviceToken);
            }

            @Override
            public void onFailure(String s, String s1) {

            }
        });


    }
}
