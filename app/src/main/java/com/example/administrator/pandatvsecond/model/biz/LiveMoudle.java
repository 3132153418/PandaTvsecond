package com.example.administrator.pandatvsecond.model.biz;

import com.example.administrator.pandatvsecond.base.BaseModel;
import com.example.administrator.pandatvsecond.model.bean.EspeciallyShowBean;
import com.example.administrator.pandatvsecond.model.bean.GGShowBean;
import com.example.administrator.pandatvsecond.model.bean.GoodTimeBean;
import com.example.administrator.pandatvsecond.model.bean.LiveFragmentBean;
import com.example.administrator.pandatvsecond.model.bean.MoreEyeBean;
import com.example.administrator.pandatvsecond.model.bean.NoBearBean;
import com.example.administrator.pandatvsecond.model.bean.OriginalNewsBean;
import com.example.administrator.pandatvsecond.model.bean.PandaFileBean;
import com.example.administrator.pandatvsecond.model.bean.PandaTopBean;
import com.example.administrator.pandatvsecond.model.bean.WatchTalkBean;
import com.example.administrator.pandatvsecond.net.callback.MyCallBack;

/**
 * Created by Administrator on 2017/7/29.
 */

public interface LiveMoudle extends BaseModel{
    void loadLiveData(MyCallBack<LiveFragmentBean> callBack);
    void loadLiveMoreEyeData(String moreurl,MyCallBack<MoreEyeBean> callBack);
    void loadLiveWatchTalkData(String watchtalkurl,MyCallBack<WatchTalkBean> callBack);

    void loadGoodTimeBeanData(MyCallBack<GoodTimeBean> callBack);

    void loadNoBeerBeanData(MyCallBack<NoBearBean> callBack);

    void loadGGShowBeanData(MyCallBack<GGShowBean> callBack);

    void loadPandaFileData(MyCallBack<PandaFileBean> callBack);

    void loadPandaTopBeanData(MyCallBack<PandaTopBean> callBack);

    void loadPandaThingsBeanData(MyCallBack<NoBearBean> callBack);//用当熊不让的数据请求

    void loadEspeciallyShowBeanData(MyCallBack<EspeciallyShowBean> callBack);

    void loadOriginalNewsBeanData (MyCallBack<OriginalNewsBean> callBack);
}
