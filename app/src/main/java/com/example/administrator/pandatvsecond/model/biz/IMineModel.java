package com.example.administrator.pandatvsecond.model.biz;

import android.os.Bundle;

import com.example.administrator.pandatvsecond.base.BaseModel;
import com.example.administrator.pandatvsecond.model.bean.PersonRegister;
import com.example.administrator.pandatvsecond.net.callback.MyCallBack;

/**
 * Created by xingge on 2017/7/27.
 */

public interface IMineModel extends BaseModel {

    void loadImgCode(MyCallBack<Bundle> callback);
    void register(String mailAdd, String passWd, String verificationCode, String cookie, MyCallBack<PersonRegister> callback);
}
