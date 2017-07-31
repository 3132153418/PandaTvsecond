package com.example.administrator.pandatvsecond.model.biz;


import com.example.administrator.pandatvsecond.config.Urls;
import com.example.administrator.pandatvsecond.model.bean.LoginEntity;
import com.example.administrator.pandatvsecond.net.callback.MyCallBack;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2017/7/21.
 */

public class LoginMoudleIpl implements LoginMoudle {
    @Override
    public void getLogin(String name, String pwd, MyCallBack<LoginEntity> callBack) {
        Map<String,String> map = new HashMap<>();
        map.put("username",name);
        map.put("password",pwd);
        map.put("from","https://reg.cntv.cn/login/login.action");
        map.put("service","client_transaction");

        ihttp.get(Urls.LOGIN,map,callBack);
    }
}
