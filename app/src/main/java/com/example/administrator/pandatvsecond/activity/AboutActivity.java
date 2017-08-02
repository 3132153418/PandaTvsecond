package com.example.administrator.pandatvsecond.activity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.administrator.pandatvsecond.R;
import com.example.administrator.pandatvsecond.base.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by lenovo on 2017/7/24.
 */
public class AboutActivity extends BaseActivity {
    @BindView(R.id.about_web_back)
    ImageView aboutWebBack;
    @BindView(R.id.about_version)
    TextView aboutVersion;



    @Override
    protected void initView() {

    }

    @Override
    protected void loadData() {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @Override
    protected int getLauoutId() {
        return R.layout.personal_about;

    }

    @OnClick(R.id.about_web_back)
    public void onViewClicked() {
        finish();
    }
}
