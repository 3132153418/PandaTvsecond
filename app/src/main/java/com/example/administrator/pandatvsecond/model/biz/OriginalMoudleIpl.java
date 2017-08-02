package com.example.administrator.pandatvsecond.model.biz;


import com.example.administrator.pandatvsecond.config.Urls;
import com.example.administrator.pandatvsecond.model.bean.OriginalBean;
import com.example.administrator.pandatvsecond.net.callback.MyCallBack;

/**
 * Created by Administrator on 2017/7/15.
 */

public class OriginalMoudleIpl implements OriginaMoudle {

    @Override
    public void getOriginaCallBack(MyCallBack<OriginalBean> callBack) {
        ihttp.get(Urls.PANDAORIGINAL,null,callBack);
    }
}
