package com.example.administrator.pandatvsecond.model.biz;

import com.example.administrator.pandatvsecond.config.Urls;
import com.example.administrator.pandatvsecond.model.bean.VideoJingCaiBean;
import com.example.administrator.pandatvsecond.net.callback.MyCallBack;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2017/7/29.
 */

public class VideoMoudleImpl implements VideoMoudle {
    @Override
    public void setVideoJc(String pid,MyCallBack<VideoJingCaiBean> callBack) {
        Map<String,String > map = new HashMap<>();
        map.put("pid",pid);
        ihttp.get(Urls.VADIOPATH,map,callBack);
    }
}
