package com.example.administrator.pandatvsecond.model.biz;

import com.example.administrator.pandatvsecond.base.BaseModel;
import com.example.administrator.pandatvsecond.model.bean.ChangchengBean;
import com.example.administrator.pandatvsecond.model.bean.PopupBean;
import com.example.administrator.pandatvsecond.net.callback.MyCallBack;

/**
 * Created by lenovo on 2017/7/28.
 */
public interface LiveChinaMoudle extends BaseModel {
    void getLiveChinaUrl(String url,MyCallBack<ChangchengBean> callback);
    void getLiveChinaTab(MyCallBack<PopupBean> callback);
}
