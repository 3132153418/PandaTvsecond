package com.example.administrator.pandatvsecond.activity;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;

import com.example.administrator.pandatvsecond.R;
import com.example.administrator.pandatvsecond.activity.adapter.Original_Adapter;
import com.example.administrator.pandatvsecond.app.App;
import com.example.administrator.pandatvsecond.base.BaseActivity;
import com.example.administrator.pandatvsecond.model.bean.OriginalBean;
import com.example.administrator.pandatvsecond.widget.manager.LoadingDialog;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/7/15.
 */

public class OriginalActivity extends BaseActivity implements OriginalContract.View ,View.OnClickListener{
    private List<OriginalBean.InteractiveBean> list = new ArrayList<>();
    private ListView listView;
    private Original_Adapter adapter;
    private OriginalContract.Presenter presenter;
    private ImageView original_Back_Image;

    @Override
    protected int getLauoutId() {
        return R.layout.activity_original;
    }

    @Override
    protected void initView() {
        new OriginalPresenter(this);
        listView = (ListView) findViewById(R.id.activity_original_ListView);
        original_Back_Image = (ImageView) findViewById(R.id.original_Back_Imagetwo);
        original_Back_Image.setOnClickListener(this);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(OriginalActivity.this, OriginalWebViewAcTivity.class);
                intent.putExtra("url",list.get(position).getUrl());
                intent.putExtra("title",list.get(position).getTitle());
                intent.putExtra("image",list.get(position).getImage());
                startActivity(intent);
            }
        });

    }


    @Override
    protected void loadData() {
        presenter.start();
    }

    @Override
    public void showProgress() {
        LoadingDialog.show(App.context);

    }

    @Override
    public void dismissProgress() {
        LoadingDialog.dimiss();
    }

    @Override
    public void setPresenter(OriginalContract.Presenter presenter) {

        this.presenter = presenter;

    }

    @Override
    public void showMessage(String msg) {

    }

    @Override
    public void onRefresh() {

    }

    @Override
    public void setResoust(OriginalBean originalBean) {

        List<OriginalBean.InteractiveBean> interactive = originalBean.getInteractive();

        list.addAll(interactive);

        adapter = new Original_Adapter(this, list);
        listView.setAdapter(adapter);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.original_Back_Imagetwo:
                finish();
                break;
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        App.context = this;
    }
}
