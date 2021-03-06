package com.example.administrator.pandatvsecond.activity;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.administrator.pandatvsecond.R;
import com.example.administrator.pandatvsecond.base.BaseActivity;
import com.example.administrator.pandatvsecond.model.bean.HomeBean;
import com.example.administrator.pandatvsecond.moudle.pandahome.HomeContract;
import com.example.administrator.pandatvsecond.util.DataCleanManager;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 设置主界面
 */

public class SettingActivity extends BaseActivity implements HomeContract.View {

    @BindView(R.id.isPush)
    CheckBox isPush;
    @BindView(R.id.isPlay)
    CheckBox isPlay;
    @BindView(R.id.personal_delete_img)
    ImageView personalDeleteImg;
    @BindView(R.id.number)
    TextView number;
    @BindView(R.id.clean)
    RelativeLayout clean;
    @BindView(R.id.panda_setting_help)
    RelativeLayout pandaSettingHelp;
    @BindView(R.id.isShengji)
    ImageView isShengji;
    @BindView(R.id.panda_setting_shengji)
    RelativeLayout pandaSettingShengji;
    @BindView(R.id.isGood)
    ImageView isGood;
    @BindView(R.id.panda_setting_haoping)
    RelativeLayout pandaSettingHaoping;
    @BindView(R.id.isAbout)
    ImageView isAbout;
    @BindView(R.id.panda_setting_about)
    RelativeLayout pandaSettingAbout;
    @BindView(R.id.settingBack)
    ImageView settingBack;
    //版本更新
    private static int versionCode;
    private String versionsUrl;
    private AlertDialog alertDialog;
    int total = 0;
    private int versionsInt;
    //持有P层对象
    private HomeContract.Presenter presenter;
    private Context context;


    @Override
    protected void initView() {
        context = SettingActivity.this;

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
        return R.layout.person_setting;

    }


    @OnClick({R.id.panda_setting_help, R.id.panda_setting_shengji, R.id.panda_setting_haoping, R.id.panda_setting_about, R.id.clean})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.panda_setting_help:
                Intent intent = new Intent(context, PersonhelpActivity.class);
                startActivity(intent);
                break;
            case R.id.panda_setting_shengji:
                break;
            case R.id.panda_setting_haoping:
                Uri uri = Uri.parse("market://details?id=cn.cntv.app.ipanda");
                Intent goToMarket = new Intent(Intent.ACTION_VIEW, uri);
                try {
                    startActivity(goToMarket);
                } catch (Exception e) {
                    Toast.makeText(SettingActivity.this, "没有找到可用的应用市场",
                            Toast.LENGTH_LONG).show();
                }
                break;
            case R.id.panda_setting_about:
                Intent intent2 = new Intent(SettingActivity.this, AboutActivity.class);
                startActivity(intent2);
                break;
            case R.id.clean:
                final AlertDialog.Builder builder = new AlertDialog.Builder(SettingActivity.this);
                builder.setTitle("确认清楚缓存吗?");
                builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
                builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        DataCleanManager.clearAllCache(SettingActivity.this);
                        try {
                            String totalCacheSize = DataCleanManager.getTotalCacheSize(SettingActivity.this);
                            number.setText(totalCacheSize);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }

//                    AlertDialog dialog = builder.create();

                });
                break;
        }
    }


    @Override
    public void showProgress() {

    }

    @Override
    public void dismissProgress() {

    }

    @Override
    public void setPresenter(HomeContract.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void showMessage(String msg) {

    }

    @Override
    public void onRefresh() {

    }


    @Override
    public void setResult(HomeBean homeBean) {

    }


    @OnClick(R.id.settingBack)
    public void onViewClicked() {
        finish();
    }


}
