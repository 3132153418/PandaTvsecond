package com.example.administrator.pandatvsecond.model.biz;

import com.example.administrator.pandatvsecond.config.Urls;
import com.example.administrator.pandatvsecond.model.bean.ChangchengBean;
import com.example.administrator.pandatvsecond.model.bean.PopupBean;
import com.example.administrator.pandatvsecond.net.callback.MyCallBack;

/**
 * Created by lenovo on 2017/7/28.
 */
public class LiveChinaMoudleIpl implements LiveChinaMoudle {
    @Override
    public void getLiveChinaUrl(String url, MyCallBack<ChangchengBean> callback) {
        ihttp.get(url,null,callback);
    }

    @Override
    public void getLiveChinaTab(MyCallBack<PopupBean> callback) {
        ihttp.get(Urls.PANDA_LIVE_CHINA_TAB,null,callback);

    }
}
