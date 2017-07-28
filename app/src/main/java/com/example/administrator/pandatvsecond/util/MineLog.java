package com.example.administrator.pandatvsecond.util;

import android.util.Log;

/**
 * Created by Administrator on 2017/7/28.
 */

public class MineLog {
    private static boolean isOpen = true;
    public static void d(String tag,String msg){
        if(isOpen)
            Log.d(tag,msg);
    }
}
