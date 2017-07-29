package com.example.administrator.pandatvsecond.moudle.pandalive;

import android.view.View;

import com.example.administrator.pandatvsecond.R;
import com.example.administrator.pandatvsecond.base.BaseFragment;
import com.example.administrator.pandatvsecond.model.bean.LiveBean;

/**
 * Created by Administrator on 2017/7/28.
 */

public class LiveFragment extends BaseFragment implements LiveContract.View{

    private LivePresenter presenter;
    @Override
    protected int getLayoutId() {
        return R.layout.live_fragment;
    }

    @Override
    protected void initView(View view) {

        presenter.start();
    }

    @Override
    protected void loadData() {

        new LivePresenter(this);
    }

    @Override
    public void setResult(LiveBean liveBean) {

    }

    @Override
    public void showProgress() {

    }

    @Override
    public void dismissProgress() {

    }

    @Override
    public void setPresenter(LiveContract.Presenter presenter) {

        this.presenter = (LivePresenter) presenter;
    }

    @Override
    public void showMessage(String msg) {

    }

    @Override
    public void onRefresh() {

    }
}
