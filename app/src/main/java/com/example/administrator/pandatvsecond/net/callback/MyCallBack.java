package com.example.administrator.pandatvsecond.net.callback;

/**
 * Created by Administrator on 2017/7/27.
 */

public interface MyCallBack<T> {
    void onSusses(T t);
    void onError(String msg);
}
