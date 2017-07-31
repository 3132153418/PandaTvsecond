package com.example.administrator.pandatvsecond.model.biz;

import com.example.administrator.pandatvsecond.config.Urls;
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

public class LiveMoudleImpl implements LiveMoudle {

    @Override
    public void loadLiveData(MyCallBack<LiveFragmentBean> callBack) {
            ihttp.get(Urls.PANDALIVE,null,callBack);
    }

    @Override
    public void loadLiveMoreEyeData(String moreurl,MyCallBack<MoreEyeBean> callBack) {
        ihttp.get(moreurl,null,callBack);
    }

    @Override
    public void loadLiveWatchTalkData(String watchtalkurl,MyCallBack<WatchTalkBean> callBack) {
        ihttp.get(watchtalkurl,null,callBack);
    }

    @Override
    public void loadGoodTimeBeanData(MyCallBack<GoodTimeBean> callBack) {
        ihttp.get(Urls.GOODTIME,null,callBack);
    }

    @Override
    public void loadNoBeerBeanData( MyCallBack<NoBearBean> callBack) {
        ihttp.get(Urls.DXBR,null,callBack);
    }

    @Override
    public void loadGGShowBeanData( MyCallBack<GGShowBean> callBack) {
        ihttp.get(Urls.CMGGSHOW,null,callBack);
    }

    @Override
    public void loadPandaFileData( MyCallBack<PandaFileBean> callBack) {
        ihttp.get(Urls.XMDA,null,callBack);
    }

    @Override
    public void loadPandaTopBeanData(MyCallBack<PandaTopBean> callBack) {
        ihttp.get(Urls.XMTOPBANG,null,callBack);
    }

    @Override
    public void loadPandaThingsBeanData( MyCallBack<NoBearBean> callBack) {
        //熊猫那些事使用当熊不让的数据
        ihttp.get(Urls.DXBR,null,callBack);
    }

    @Override
    public void loadEspeciallyShowBeanData(MyCallBack<EspeciallyShowBean> callBack) {
        ihttp.get(Urls.TBJM,null,callBack);
    }

    @Override
    public void loadOriginalNewsBeanData( MyCallBack<OriginalNewsBean> callBack) {
        ihttp.get(Urls.YCXW,null,callBack);
    }

}
