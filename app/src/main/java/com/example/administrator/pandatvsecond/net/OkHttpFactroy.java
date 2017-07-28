package com.example.administrator.pandatvsecond.net;

/**
 * Created by Administrator on 2017/7/27.
 */

public class OkHttpFactroy {
    public static Ihttp onCreate() {
        return OkHttpUtils.getInstance();
    }
}
