package com.example.administrator.pandatvsecond.activity.video;

import com.example.administrator.pandatvsecond.base.BasePresenter;
import com.example.administrator.pandatvsecond.base.BaseView;
import com.example.administrator.pandatvsecond.model.bean.VideoJingCaiBean;

/**
 * Created by Administrator on 2017/7/29.
 */

public interface VideoContract {
    interface View extends BaseView<Presenter>{

        void setResult(VideoJingCaiBean videoJingCaiBean);
    }
    interface Presenter extends BasePresenter{
        void setJcVideo(String pid);
    }
}
