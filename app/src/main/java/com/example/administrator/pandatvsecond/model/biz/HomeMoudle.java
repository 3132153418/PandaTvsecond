package com.example.administrator.pandatvsecond.model.biz;

import com.example.administrator.pandatvsecond.base.BaseModel;
import com.example.administrator.pandatvsecond.model.bean.HomeBean;
import com.example.administrator.pandatvsecond.model.bean.UpdateBean;
import com.example.administrator.pandatvsecond.net.callback.MyCallBack;

/**
 * Created by Administrator on 2017/7/28.
 */

public interface HomeMoudle extends BaseModel {

    void loadHomeData(MyCallBack<HomeBean> callBack);

    void requestVersion(MyCallBack<UpdateBean> callBack);
}
