package com.example.administrator.pandatvsecond.moudle.pandagg.ggwebactivity;

import com.example.administrator.pandatvsecond.activity.video.VideoContract;
import com.example.administrator.pandatvsecond.base.BasePresenter;
import com.example.administrator.pandatvsecond.base.BaseView;
import com.example.administrator.pandatvsecond.model.bean.PandaTebieBean;
import com.example.administrator.pandatvsecond.model.bean.VideoJingCaiBean;

/**
 * Created by Administrator on 2017/8/1.
 */

public interface GGWebContract {
    interface View extends BaseView<Presenter>{
        void setVideoResult(VideoJingCaiBean videoJingCaiBean);
        void setGGXrecy(PandaTebieBean pandaTebieBean);
    }
    interface Presenter extends BasePresenter{
        void setJcVideo(String pid);
    }
}
