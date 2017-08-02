package com.example.administrator.pandatvsecond.model.biz;


import com.example.administrator.pandatvsecond.base.BaseModel;
import com.example.administrator.pandatvsecond.model.bean.OriginalBean;
import com.example.administrator.pandatvsecond.net.callback.MyCallBack;

/**
 * Created by Administrator on 2017/7/15.
 */

public interface OriginaMoudle extends BaseModel{

    void getOriginaCallBack(MyCallBack<OriginalBean> callBack);
}
