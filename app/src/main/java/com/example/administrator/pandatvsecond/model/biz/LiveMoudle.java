package com.example.administrator.pandatvsecond.model.biz;

import com.example.administrator.pandatvsecond.base.BaseModel;
import com.example.administrator.pandatvsecond.model.bean.LiveBean;
import com.example.administrator.pandatvsecond.net.callback.MyCallBack;

/**
 * Created by Administrator on 2017/7/28.
 */

public interface LiveMoudle extends BaseModel{
    void setLive(MyCallBack<LiveBean> callBack);
}
