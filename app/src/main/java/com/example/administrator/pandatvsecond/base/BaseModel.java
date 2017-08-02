package com.example.administrator.pandatvsecond.base;

import com.example.administrator.pandatvsecond.net.Ihttp;
import com.example.administrator.pandatvsecond.net.OkHttpFactroy;

/**
 * Created by Administrator on 2017/7/28.
 */

public interface BaseModel {
    public static Ihttp ihttp = OkHttpFactroy.onCreate();


}
