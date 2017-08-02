package com.example.administrator.pandatvsecond.widget.manager;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.administrator.pandatvsecond.app.App;


public class SharedPreferencesManager {
    public static final String USERINFO = "biubiubiu";
    private static SharedPreferences preferences = App.context.getSharedPreferences("user", Context.MODE_PRIVATE);
    private static SharedPreferences.Editor editor = preferences.edit();

    public static void saveSplashInfo(String userInfo) {
        editor.putString("splash", userInfo);
        editor.commit();
    }

    public static String getSplashInfo() {
        String splash = preferences.getString("splash", "");
        return splash;
    }

    public static void saveUserInfo(String userInfo) {
        editor.putString(USERINFO, userInfo);
        editor.commit();
    }
    public static String getUserInfo() {
        String userInfo = preferences.getString(USERINFO, "");
        return userInfo;
    }
}
