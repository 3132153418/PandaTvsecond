package com.example.administrator.pandatvsecond.model.biz;

import com.example.administrator.pandatvsecond.config.Urls;
import com.example.administrator.pandatvsecond.model.bean.live.AllLiveFragmentBean;
import com.example.administrator.pandatvsecond.model.bean.live.LiveCommonBean;
import com.example.administrator.pandatvsecond.model.bean.live.LiveFragmentBean;
import com.example.administrator.pandatvsecond.model.bean.live.MoreEyeBean;
import com.example.administrator.pandatvsecond.model.bean.live.WatchTalkBean;
import com.example.administrator.pandatvsecond.net.callback.MyCallBack;
import com.example.administrator.pandatvsecond.util.MineLog;

/**
 * Created by Administrator on 2017/7/29.
 */

public class LiveMoudleImpl implements LiveMoudle {

    @Override
    public void loadLiveData(MyCallBack<AllLiveFragmentBean> callBack) {
            ihttp.get(Urls.LIVEFRAGMENTDATA,null,callBack);
    }

    @Override
    public void loadSmallLiveFragmentData(String url, MyCallBack<LiveFragmentBean> callBack) {
            ihttp.get(url,null,callBack);
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
    public void loadLiveCommonBeanData(String vsid, int page, MyCallBack<LiveCommonBean> callBack) {
        String url = Urls.LIVE_COMMON_START + vsid + Urls.LIVE_COMMON_END + page;
        MineLog.d("bug",url);
        ihttp.get(url,null,callBack);
    }


}
