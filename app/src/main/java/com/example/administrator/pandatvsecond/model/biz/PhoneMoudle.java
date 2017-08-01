package com.example.administrator.pandatvsecond.model.biz;

import com.example.administrator.pandatvsecond.base.BaseModel;
import com.example.administrator.pandatvsecond.net.callback.MyCallBack;

/**
 * Created by Administrator on 2017/7/22.
 */

public interface PhoneMoudle extends BaseModel{
    void getPhone(MyCallBack callBack);
    void setPhone(String number, String yanzm, MyCallBack callBack);

    void phoneRegister(String number, String yanzm, String pwd, MyCallBack callBack);
}
