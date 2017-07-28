package com.example.administrator.pandatvsecond.base;

/**
 * Created by Administrator on 2017/7/27.
 */

public interface BaseView <T>{
    void showProgress();
    void dismissProgress();
    void setPresenter(T t);
    void showMessage(String msg);
    void onRefresh();
}
