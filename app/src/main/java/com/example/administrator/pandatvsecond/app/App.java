package com.example.administrator.pandatvsecond.app;

import android.app.Application;

import com.example.administrator.pandatvsecond.base.BaseActivity;

/**
 * Created by Administrator on 2017/7/27.
 */

public class App extends Application {
    public static BaseActivity context = null;
    @Override
    public void onCreate() {
        super.onCreate();

    }
}
