package com.example.administrator.pandatvsecond.moudle.pandahome;

import android.view.View;

import com.example.administrator.pandatvsecond.R;
import com.example.administrator.pandatvsecond.base.BaseFragment;
import com.example.administrator.pandatvsecond.model.bean.HomeBean;

/**
 * Created by Administrator on 2017/7/28.
 */

public class HomeFragment extends BaseFragment implements HomeContract.View {
    private HomePresenter presenter;
    @Override
    protected int getLayoutId() {
        return R.layout.home_fragment;
    }

    @Override
    protected void initView(View view) {
        presenter.start();
    }



    @Override
    protected void loadData() {

        new HomePresenter(this);
    }

    @Override
    public void setResult(HomeBean homeBean) {

    }

    @Override
    public void showProgress() {

    }

    @Override
    public void dismissProgress() {

    }

    @Override
    public void setPresenter(HomeContract.Presenter presenter) {
        this.presenter = (HomePresenter) presenter;

    }

    @Override
    public void showMessage(String msg) {

    }

    @Override
    public void onRefresh() {

    }
}
