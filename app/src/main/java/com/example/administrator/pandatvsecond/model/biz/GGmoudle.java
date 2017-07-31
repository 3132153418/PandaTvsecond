package com.example.administrator.pandatvsecond.model.biz;

import com.example.administrator.pandatvsecond.base.BaseModel;
import com.example.administrator.pandatvsecond.model.bean.GGbean;
import com.example.administrator.pandatvsecond.net.callback.MyCallBack;

/**
 * Created by lenovo on 2017/7/28.
 */

public  interface GGmoudle extends BaseModel {
   void setGGmodel(MyCallBack<GGbean> callBack);

}
