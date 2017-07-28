package com.example.administrator.pandatvsecond.model.biz;

import com.example.administrator.pandatvsecond.config.Urls;
import com.example.administrator.pandatvsecond.model.bean.HomeBean;
import com.example.administrator.pandatvsecond.net.callback.MyCallBack;

/**
 * Created by Administrator on 2017/7/28.
 */

public class HomeMoudleImpl implements HomeMoudle{
    @Override
    public void setShow(MyCallBack<HomeBean> callBack) {

        ihttp.get(Urls.PANDAHOME,callBack);
    }
}
