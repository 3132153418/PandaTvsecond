package com.example.administrator.pandatvsecond.activity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.example.administrator.pandatvsecond.R;
import com.example.administrator.pandatvsecond.base.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by lenovo on 2017/7/31.
 */
public class PersonAgreeActivity extends BaseActivity {
    @BindView(R.id.agree_post_back)
    Button agreePostBack;
    @BindView(R.id.agree_post_text)
    TextView agreePostText;

    @Override
    protected int getLauoutId() {
        return R.layout.person_agree;
    }

    @Override
    protected void loadData() {

    }

    @Override
    protected void initView() {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @OnClick(R.id.agree_post_back)
    public void onViewClicked() {
        finish();
    }
}
