package com.example.administrator.pandatvsecond.widget.manager;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.administrator.pandatvsecond.app.App;


public class SharedPreferencesManager {
    private static SharedPreferences preferences = App.context.getSharedPreferences("user",Context.MODE_PRIVATE);
    private static SharedPreferences.Editor editor = preferences.edit();
    public static void saveUserInfo(String userInfo){
        editor.putString("userInfo",userInfo);
        editor.commit();
    }
public static  String  getUserInfo(){
    String userInfo = preferences.getString("userInfo", "");
    return userInfo;
}
}
