package com.example.administrator.pandatvsecond.activity;

import android.content.Intent;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import com.example.administrator.pandatvsecond.R;
import com.example.administrator.pandatvsecond.base.BaseActivity;


/**
 * Created by Administrator on 2017/7/24.
 */

public class XiuGaiNameActivity extends BaseActivity implements View.OnClickListener{
    private ImageView geRenXinXi_Back_Image;
    private EditText xiuGai_EditText;


    @Override
    protected void initView() {

        geRenXinXi_Back_Image = (ImageView) findViewById(R.id.geRenXinXi_Back_Image);
        geRenXinXi_Back_Image.setOnClickListener(this);
        xiuGai_EditText = (EditText) findViewById(R.id.xiuGai_EditText);
        Intent intent = getIntent();
        String user = intent.getStringExtra("user");
        xiuGai_EditText.setText(user);
    }

    @Override
    protected int getLauoutId() {
        return R.layout.person_xiugai_name;

    }

    @Override
    protected void loadData() {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.geRenXinXi_Back_Image:
                finish();
                break;
        }
    }
}
