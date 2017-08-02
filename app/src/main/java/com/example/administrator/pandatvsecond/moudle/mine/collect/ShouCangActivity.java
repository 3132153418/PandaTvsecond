package com.example.administrator.pandatvsecond.moudle.mine.collect;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.administrator.pandatvsecond.R;
import com.example.administrator.pandatvsecond.base.BaseActivity;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.OnClick;


public class ShouCangActivity extends BaseActivity {
    @BindView(R.id.shoucang_image)
    ImageView shoucangImage;
    @BindView(R.id.shoucang_tab)
    TabLayout shoucangTab;
    @BindView(R.id.shoucang_viewpager)
    ViewPager shoucangViewpager;
    @BindView(R.id.bj)
    TextView bj;

    private ShouCangTabAdapter adapter;
    private Live_Tab_Fragment liveTabFragment;
    private Highlights_Tab_Fragment highlightsTabFragment;
    private ArrayList<Fragment> list = new ArrayList<>();

    @Override
    protected void initView() {

        liveTabFragment = new Live_Tab_Fragment();
        highlightsTabFragment = new Highlights_Tab_Fragment(bj);

        list.add(liveTabFragment);
        list.add(highlightsTabFragment);

        adapter = new ShouCangTabAdapter(getSupportFragmentManager(), list);
        shoucangViewpager.setAdapter(adapter);

        shoucangTab.setupWithViewPager(shoucangViewpager);
        shoucangTab.setTabMode(TabLayout.MODE_FIXED);


       /* bj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(bj.getText().toString().trim().equals("编辑")){

                    bj.setText("完成");
                }else if(bj.getText().toString().trim().equals("完成")){

                    bj.setText("编辑");
                }
            }
        });*/
    }

    @Override
    protected int getLauoutId() {
        return R.layout.activity_shoucang;

    }

    @Override
    protected void loadData() {

    }




    @OnClick(R.id.shoucang_image)
    public void onViewClicked() {
        finish();
    }


}
