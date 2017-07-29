package com.example.administrator.pandatvsecond.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.administrator.pandatvsecond.R;
import com.example.administrator.pandatvsecond.activity.adapter.FragmentAdapter;
import com.example.administrator.pandatvsecond.base.BaseActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/6/14.
 */

public class SplashActivity extends BaseActivity {
    ViewPager viewPager;
    private List<ImageView> list = new ArrayList<>();
    private FragmentAdapter adapter;
    private int[] imgs = {R.drawable.guide_one,R.drawable.guide_two,R.drawable.guide_three};
    private SharedPreferences mShared;

    @Override
    protected void initView() {
        viewPager = (ViewPager) findViewById(R.id.viewPager);

        addViewPager();
        adapter = new FragmentAdapter(list);
        viewPager.setAdapter(adapter);
    }

    @Override
    protected int getLauoutId() {
        return R.layout.activity_splash;
    }

    @Override
    protected void loadData() {

    }

    public void addViewPager(){
        mShared = getSharedPreferences("data", MODE_PRIVATE);
        final SharedPreferences.Editor editor = mShared.edit();
        ViewGroup.LayoutParams params = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.MATCH_PARENT);
        ImageView img1 = new ImageView(this);
        img1.setLayoutParams(params);
        img1.setImageResource(R.drawable.guide_one);
        ImageView img2 = new ImageView(this);
        img2.setLayoutParams(params);
        img2.setImageResource(R.drawable.guide_two);
        ImageView img3 = new ImageView(this);
        img3.setLayoutParams(params);
        img3.setImageResource(R.drawable.guide_three);
        img3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editor.putString("uid", "1");
                editor.commit();
                Intent intent = new Intent(SplashActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });


        list.add(img1);
        list.add(img2);
        list.add(img3);

    }

}
