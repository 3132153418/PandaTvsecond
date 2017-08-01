package com.example.administrator.pandatvsecond.model.biz;

import com.example.administrator.pandatvsecond.config.Urls;
import com.example.administrator.pandatvsecond.model.bean.LiveFragmentBean;
import com.example.administrator.pandatvsecond.model.bean.MoreEyeBean;
import com.example.administrator.pandatvsecond.model.bean.WatchTalkBean;
import com.example.administrator.pandatvsecond.net.callback.MyCallBack;

/**
 * Created by Administrator on 2017/7/29.
 */

public class LiveMoudleImpl implements LiveMoudle {
//    @Override
//    public void setVideoJc(String pid,MyCallBack<VideoJingCaiBean> callBack) {
//        Map<String,String > map = new HashMap<>();
//        map.put("pid",pid);
//        ihttp.get(Urls.VADIOPATH,map,callBack);
//    }

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
}
