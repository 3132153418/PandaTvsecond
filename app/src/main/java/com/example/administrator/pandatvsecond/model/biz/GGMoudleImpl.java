package com.example.administrator.pandatvsecond.model.biz;

import com.example.administrator.pandatvsecond.config.Urls;
import com.example.administrator.pandatvsecond.model.bean.GGbean;
import com.example.administrator.pandatvsecond.net.callback.MyCallBack;

/**
 * Created by lenovo on 2017/7/28.
 */

public class GGMoudleImpl implements GGmoudle {

    @Override
    public void setGGmodel(MyCallBack<GGbean> callBack) {
        ihttp.get(Urls.GGLIVE,null,callBack);

    }
}
