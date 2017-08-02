package com.example.administrator.pandatvsecond.activity;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;

import com.example.administrator.pandatvsecond.R;
import com.example.administrator.pandatvsecond.base.BaseActivity;
import com.example.administrator.pandatvsecond.widget.manager.SharedPreferencesManager;

import java.util.Timer;
import java.util.TimerTask;

/**
*每次进入app先看到的logo
 */

public class LogoActivity extends BaseActivity {

    @Override
    protected int getLauoutId() {
        return R.layout.logo;


    }

    @Override
    protected void loadData() {

    }

    @Override
    protected void initView() {
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                String userInfo = SharedPreferencesManager.getSplashInfo();
                if(userInfo.equals("")) {
                    handler.sendEmptyMessage(0);
                    finish();
                }else {
                    handler.sendEmptyMessage(1);
                    finish();
                }
            }
        },2000);


    }

    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case 0:
                    Intent intent = new Intent(LogoActivity.this, SplashActivity.class);
                    startActivity(intent);
                    break;
                case 1:
                    Intent intentTwo = new Intent(LogoActivity.this, MainActivity.class);
                    startActivity(intentTwo);
                    break;
            }
        }
    };
}
