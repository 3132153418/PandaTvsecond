package com.example.administrator.pandatvsecond.widget.manager;

import android.widget.Toast;

import com.example.administrator.pandatvsecond.app.App;



public class ToastManager {

    public static void show(String msg){
        Toast.makeText(App.context,msg,Toast.LENGTH_LONG).show();
    }
}
