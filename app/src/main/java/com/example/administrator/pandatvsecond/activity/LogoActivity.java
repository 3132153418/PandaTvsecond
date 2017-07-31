package com.example.administrator.pandatvsecond.activity;

import android.content.Intent;

import com.example.administrator.pandatvsecond.R;
import com.example.administrator.pandatvsecond.base.BaseActivity;
import com.example.administrator.pandatvsecond.widget.manager.SharedPreferencesManager;

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

        String userInfo = SharedPreferencesManager.getUserInfo();
        if(userInfo.equals("")) {
            Intent intent = new Intent(LogoActivity.this, SplashActivity.class);
            startActivity(intent);
            finish();
        }else {
            Intent intentTwo = new Intent(LogoActivity.this, MainActivity.class);
            startActivity(intentTwo);
            finish();
        }

    }
}
