package com.example.administrator.pandatvsecond.net;

import android.widget.ImageView;

import com.example.administrator.pandatvsecond.net.callback.MyCallBack;

import java.util.Map;

/**
 * Created by Administrator on 2017/7/27.
 */

public interface Ihttp {

    <T>void get(String url, MyCallBack<T> callBack);
    <T>void get(String url,Map<String,String> params, MyCallBack<T> callBack);
    <T>void get(String url,Map<String,String> params, Map<String,String> heards,MyCallBack<T> callBack);
    <T>void loginPost(String url,Map<String,String> params, Map<String,String> heards,MyCallBack<T> callBack);
    <T>void registerPost(String url,Map<String,String> params, Map<String,String> heards,MyCallBack<T> callBack);
    <T>void post(String url,MyCallBack<T> callBack);
    <T>void post(String url,Map<String,String> params, MyCallBack<T> callBack);
    <T>void post(String url,Map<String,String> params, Map<String,String> heards,MyCallBack<T> callBack);
    void loadImage(String url, ImageView imageView);

}
