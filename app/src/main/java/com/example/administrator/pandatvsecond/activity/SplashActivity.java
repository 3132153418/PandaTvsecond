package com.example.administrator.pandatvsecond.activity;

import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.administrator.pandatvsecond.R;
import com.example.administrator.pandatvsecond.moudle.pandahome.adapter.FragmentAdapter;
import com.example.administrator.pandatvsecond.base.BaseActivity;
import com.example.administrator.pandatvsecond.widget.manager.SharedPreferencesManager;

import java.util.ArrayList;
import java.util.List;

/**
 * 引导页
 */

public class SplashActivity extends BaseActivity {
    ViewPager viewPager;
    private List<ImageView> list = new ArrayList<>();
    private FragmentAdapter adapter;
    private int[] imgs = {R.drawable.guide_one,R.drawable.guide_two,R.drawable.guide_three};

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

        ViewGroup.LayoutParams params = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.MATCH_PARENT);
        ImageView imgone = new ImageView(this);
        imgone.setLayoutParams(params);
        imgone.setImageResource(R.drawable.guide_one);
        ImageView imgtwo= new ImageView(this);
        imgtwo.setLayoutParams(params);
        imgtwo.setImageResource(R.drawable.guide_two);
        ImageView imgthree = new ImageView(this);
        imgthree.setLayoutParams(params);
        imgthree.setImageResource(R.drawable.guide_three);
        imgthree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferencesManager.saveSplashInfo("uid");
                Intent intent = new Intent(SplashActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });


        list.add(imgone);
        list.add(imgtwo);
        list.add(imgthree);

    }

}
