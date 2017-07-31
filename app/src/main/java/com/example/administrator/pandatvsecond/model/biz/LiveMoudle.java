package com.example.administrator.pandatvsecond.model.biz;

import com.example.administrator.pandatvsecond.base.BaseModel;
import com.example.administrator.pandatvsecond.model.bean.LiveFragmentBean;
import com.example.administrator.pandatvsecond.model.bean.MoreEyeBean;
import com.example.administrator.pandatvsecond.model.bean.WatchTalkBean;
import com.example.administrator.pandatvsecond.net.callback.MyCallBack;

/**
 * Created by Administrator on 2017/7/29.
 */

public interface LiveMoudle extends BaseModel{
    void loadLiveData(MyCallBack<LiveFragmentBean> callBack);
    void loadLiveMoreEyeData(String moreurl,MyCallBack<MoreEyeBean> callBack);
    void loadLiveWatchTalkData(String watchtalkurl,MyCallBack<WatchTalkBean> callBack);

}
