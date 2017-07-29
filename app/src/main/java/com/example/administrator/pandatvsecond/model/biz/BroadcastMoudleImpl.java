package com.example.administrator.pandatvsecond.model.biz;

import com.example.administrator.pandatvsecond.config.Urls;
import com.example.administrator.pandatvsecond.model.bean.BroadcastBean;
import com.example.administrator.pandatvsecond.net.callback.MyCallBack;

/**
 * Created by Administrator on 2017/7/28.
 */

public class BroadcastMoudleImpl implements BroadcastMoudle {
    @Override
    public void setBroadcast(MyCallBack<BroadcastBean> callBack) {
        ihttp.get(Urls.PAPERLDATA,null,callBack);
    }
}
