package com.example.administrator.pandatvsecond.model.biz;

import com.example.administrator.pandatvsecond.base.BaseModel;
import com.example.administrator.pandatvsecond.model.bean.PandaTebieBean;
import com.example.administrator.pandatvsecond.model.bean.VideoJingCaiBean;
import com.example.administrator.pandatvsecond.net.callback.MyCallBack;

/**
 * Created by Administrator on 2017/7/29.
 */

public interface GGVideoMoudle extends BaseModel{
    void setVideoJc(String pid, MyCallBack<VideoJingCaiBean> callBack);
    void setGGWebMoudle(MyCallBack<PandaTebieBean> callBack);
}
