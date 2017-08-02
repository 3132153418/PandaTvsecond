package com.example.administrator.pandatvsecond.app;

import android.app.Application;

import com.example.administrator.pandatvsecond.base.BaseActivity;
import com.example.administrator.pandatvsecond.util.MineLog;
import com.umeng.message.IUmengRegisterCallback;
import com.umeng.message.PushAgent;
import com.umeng.socialize.PlatformConfig;
import com.umeng.socialize.UMShareAPI;

/**
 * Created by Administrator on 2017/7/27.
 */

public class App extends Application {
    public static BaseActivity context = null;
    {
        PlatformConfig.setSinaWeibo("2778718705", "62da4926518ba3dab1529eb578fd28ca","https://sns.whalecloud.com/sina2/callback");
        PlatformConfig.setQQZone("100424468","c7394704798a158208a74ab60104f0ba");
    }
    @Override
    public void onCreate() {
        super.onCreate();


        UMShareAPI.get(this);
        PushAgent mPushAgent = PushAgent.getInstance(this);
//注册推送服务，每次调用register方法都会回调该接口
        mPushAgent.register(new IUmengRegisterCallback() {

            @Override
            public void onSuccess(String deviceToken) {
                //注册成功会返回device token
                MineLog.d("deviceToken", deviceToken);
            }

            @Override
            public void onFailure(String s, String s1) {

            }
        });


    }

}
