package com.example.administrator.pandatvsecond.model.biz;

import com.example.administrator.pandatvsecond.config.Urls;
import com.example.administrator.pandatvsecond.model.bean.LiveBean;
import com.example.administrator.pandatvsecond.net.callback.MyCallBack;

/**
 * Created by Administrator on 2017/7/28.
 */

public class LiveMoudleImpl implements LiveMoudle {

    @Override
    public void setLive(MyCallBack<LiveBean> callBack) {
        ihttp.get(Urls.PANDAJCYK,callBack);
    }
}
