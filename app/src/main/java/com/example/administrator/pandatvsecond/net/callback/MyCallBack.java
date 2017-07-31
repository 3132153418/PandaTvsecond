package com.example.administrator.pandatvsecond.net.callback;

import android.graphics.drawable.Drawable;

/**
 * Created by Administrator on 2017/7/27.
 */

public interface MyCallBack<T> {
    void onSuccess(Drawable drawable);
    void onSusses(T t);
    void onsusses(String string);

    void onError(String msg);
}
