package com.example.administrator.pandatvsecond.model.biz;


import com.example.administrator.pandatvsecond.base.BaseModel;
import com.example.administrator.pandatvsecond.model.bean.LoginEntity;
import com.example.administrator.pandatvsecond.net.callback.MyCallBack;

/**
 * Created by Administrator on 2017/7/21.
 */

public interface LoginMoudle extends BaseModel{
    void getLogin(String name, String pwd, MyCallBack<LoginEntity> callBack);
}
