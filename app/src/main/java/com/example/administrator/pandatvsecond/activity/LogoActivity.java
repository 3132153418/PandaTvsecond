package com.example.administrator.pandatvsecond.activity;

import android.content.Intent;
import android.content.SharedPreferences;

import com.example.administrator.pandatvsecond.R;
import com.example.administrator.pandatvsecond.base.BaseActivity;
import com.example.administrator.pandatvsecond.util.MineLog;

/**
 * Created by Administrator on 2017/7/27.
 */

public class LogoActivity extends BaseActivity {
    private SharedPreferences mShared;
    private String uid;
    @Override
    protected int getLauoutId() {
        return R.layout.logo;
    }

    @Override
    protected void loadData() {

    }

    @Override
    protected void initView() {
        mShared = getSharedPreferences("data", MODE_PRIVATE);
        uid = mShared.getString("uid", "");

        if(uid.equals("")) {
            MineLog.d("LogoActivity:::::::::::id",uid.toString());
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
