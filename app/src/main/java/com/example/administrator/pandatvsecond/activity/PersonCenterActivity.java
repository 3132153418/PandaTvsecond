package com.example.administrator.pandatvsecond.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.administrator.pandatvsecond.R;
import com.example.administrator.pandatvsecond.moudle.mine.login.LoginActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by lenovo on 2017/7/31.
 */

public class PersonCenterActivity extends Activity {


    @BindView(R.id.backImg)
    ImageView backImg;
    @BindView(R.id.titleTv)
    TextView titleTv;
    @BindView(R.id.name_TextView)
    TextView nameTextView;
    @BindView(R.id.click_Login_LinearLayout)
    LinearLayout clickLoginLinearLayout;
    @BindView(R.id.gunakanLiShi)
    LinearLayout gunakanLiShi;
    @BindView(R.id.myShouCang)
    LinearLayout myShouCang;
    @BindView(R.id.shezhi)
    LinearLayout shezhi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.personal_center);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.backImg, R.id.click_Login_LinearLayout, R.id.gunakanLiShi, R.id.myShouCang, R.id.shezhi})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.backImg:
                finish();
                break;
            case R.id.click_Login_LinearLayout:
                Intent intent = new Intent(PersonCenterActivity.this, LoginActivity.class);
                startActivity(intent);
                break;
            case R.id.gunakanLiShi:
                break;
            case R.id.myShouCang:
                break;
            case R.id.shezhi:
                break;
        }
    }
}
