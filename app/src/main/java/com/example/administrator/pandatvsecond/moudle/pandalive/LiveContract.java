package com.example.administrator.pandatvsecond.moudle.pandalive;

import com.example.administrator.pandatvsecond.base.BasePresenter;
import com.example.administrator.pandatvsecond.base.BaseView;
import com.example.administrator.pandatvsecond.model.bean.LiveFragmentBean;
import com.example.administrator.pandatvsecond.model.bean.MoreEyeBean;
import com.example.administrator.pandatvsecond.model.bean.WatchTalkBean;

import java.util.List;

/**
 * Created by Administrator on 2017/7/28.
 */

public interface LiveContract {
    interface View extends BaseView<Presenter>{

        void SmallLiveFragmentResult(LiveFragmentBean.LiveBean liveBean);
        void MoreEyeResult(List<MoreEyeBean.ListBean> listBean);
        void WatchTalkResult(List<WatchTalkBean.DataBean.ContentBean> content);
    }
    interface Presenter extends BasePresenter{
        void requestSmallLiveFragmentData();

        void requestSmallLiveFragmentMoreEyeData(String moreeyeurl);

        void requestSmallLiveFragmentWatchTalkData();
    }
}
