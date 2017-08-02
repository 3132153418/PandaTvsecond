package com.example.administrator.pandatvsecond.model.biz;

import com.example.administrator.pandatvsecond.base.BaseModel;
import com.example.administrator.pandatvsecond.model.bean.live.AllLiveFragmentBean;
import com.example.administrator.pandatvsecond.model.bean.live.LiveCommonBean;
import com.example.administrator.pandatvsecond.model.bean.live.LiveFragmentBean;
import com.example.administrator.pandatvsecond.model.bean.live.MoreEyeBean;
import com.example.administrator.pandatvsecond.model.bean.live.WatchTalkBean;
import com.example.administrator.pandatvsecond.net.callback.MyCallBack;

/**
 * Created by Administrator on 2017/7/29.
 */

public interface LiveMoudle extends BaseModel{
    void loadLiveData(MyCallBack<AllLiveFragmentBean> callBack);
    void loadSmallLiveFragmentData(String url, MyCallBack<LiveFragmentBean> callBack);
    void loadLiveMoreEyeData(String moreurl,MyCallBack<MoreEyeBean> callBack);
    void loadLiveWatchTalkData(String watchtalkurl,MyCallBack<WatchTalkBean> callBack);
    void loadLiveCommonBeanData(String vsid, int page,MyCallBack<LiveCommonBean> callBack);

}
