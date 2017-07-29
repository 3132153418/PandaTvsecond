package com.example.administrator.pandatvsecond.activity;

import android.content.Intent;
import android.support.v4.app.FragmentManager;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.example.administrator.pandatvsecond.R;

import com.example.administrator.pandatvsecond.activity.video.VideoActivity;
import com.example.administrator.pandatvsecond.base.BaseActivity;
import com.example.administrator.pandatvsecond.moudle.pandabroadcast.BroadcastFragment;
import com.example.administrator.pandatvsecond.moudle.pandagg.GGFragment;
import com.example.administrator.pandatvsecond.moudle.pandahome.HomeFragment;
import com.example.administrator.pandatvsecond.moudle.pandahome.HomePresenter;
import com.example.administrator.pandatvsecond.moudle.pandalive.LiveFragment;
import com.example.administrator.pandatvsecond.moudle.pandalivechina.LiveChinaFragment;
import com.example.administrator.pandatvsecond.widget.manager.ToastManager;


import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends BaseActivity{
    @BindView(R.id.iconImg)
    ImageView iconImg;
    @BindView(R.id.personImg)
    ImageView personImg;
    @BindView(R.id.titleTv)
    TextView titleTv;
    @BindView(R.id.hudongImg)
    ImageView hudongImg;
    @BindView(R.id.frameLayout)
    FrameLayout container;
    @BindView(R.id.shouye)
    RadioButton homePage;
    @BindView(R.id.pandalive_btn)
    RadioButton homePandaLive;
    @BindView(R.id.gg_btn)
    RadioButton homeRollVideo;
    @BindView(R.id.bobao_btn)
    RadioButton homePandaBroadcast;
    @BindView(R.id.live_China_Btn)
    RadioButton homeLiveChina;
    @BindView(R.id.radioGroup)
    RadioGroup homeBottomGroup;

    private long lastTime;
    public static final int HOMETYPE = 1;

    @Override
    protected int getLauoutId() {
        return R.layout.activity_main;
    }


    @Override
    protected void loadData() {

    }

    @Override
    protected void initView() {
        HomeFragment homeFragment = (HomeFragment) changeFragment(HomeFragment.class,R.id.frameLayout,true,null,false);
        new HomePresenter(homeFragment);

    }


    @Override
    public void onBackPressed() {
        if(System.currentTimeMillis() - lastTime < 2000){
            finish();
        }else {
            ToastManager.show("再按一次退出");
            lastTime = System.currentTimeMillis();
        }
    }
    @OnClick({R.id.personImg, R.id.hudongImg, R.id.shouye, R.id.pandalive_btn, R.id.gg_btn, R.id.bobao_btn, R.id.live_China_Btn})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.personImg:
                break;
            case R.id.hudongImg:
                break;
            case R.id.shouye:
                showTitle(null,HOMETYPE);
                changeFragment(HomeFragment.class,R.id.frameLayout,true,null,false);
                break;
            case R.id.pandalive_btn:
                showTitle("熊猫直播",0);
                changeFragment(LiveFragment.class,R.id.frameLayout,true,null,false);
                break;
            case R.id.gg_btn:
                showTitle("滚滚视频",0);
                changeFragment(GGFragment.class,R.id.frameLayout,true,null,false);
                break;
            case R.id.bobao_btn:
                showTitle("熊猫播报",0);
                changeFragment(BroadcastFragment.class,R.id.frameLayout,true,null,false);
                break;
            case R.id.live_China_Btn:
                showTitle("直播中国",0);
                changeFragment(LiveChinaFragment.class,R.id.frameLayout,true,null,false);
                break;
        }
    }

    /**
     * 显示标题的方法
     * @param title 显示的标题
     * @param type 1代表首页
     */
    private void showTitle(String title,int type){
        if(type == HOMETYPE){
            iconImg.setVisibility(View.VISIBLE);
            titleTv.setVisibility(View.GONE);
            hudongImg.setVisibility(View.VISIBLE);
        }else {
            titleTv.setText(title);
            iconImg.setVisibility(View.GONE);
            titleTv.setVisibility(View.VISIBLE);
            hudongImg.setVisibility(View.GONE);
        }

    }
}
