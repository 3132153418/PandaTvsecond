package com.example.administrator.pandatvsecond.moudle.pandalive;

import com.example.administrator.pandatvsecond.base.BasePresenter;
import com.example.administrator.pandatvsecond.base.BaseView;
import com.example.administrator.pandatvsecond.model.bean.live.AllLiveFragmentBean;
import com.example.administrator.pandatvsecond.model.bean.live.LiveCommonBean;
import com.example.administrator.pandatvsecond.model.bean.live.LiveFragmentBean;
import com.example.administrator.pandatvsecond.model.bean.live.MoreEyeBean;
import com.example.administrator.pandatvsecond.model.bean.live.WatchTalkBean;

import java.util.List;

/**
 * Created by Administrator on 2017/7/28.
 */

public interface LiveContract {
    interface View extends BaseView<Presenter>{
        void LiveFragmentDataResult(AllLiveFragmentBean allLiveFragmentBean);
        void SmallLiveFragmentResult(LiveFragmentBean liveBean);
        void MoreEyeResult(List<MoreEyeBean.ListBean> listBean);
        void WatchTalkResult(List<WatchTalkBean.DataBean.ContentBean> content);
        void LiveCommonDataResult(LiveCommonBean liveCommonBean);

    }
    interface Presenter extends BasePresenter{
        void requestLiveFragmentData();
        void requestSmallLiveFragmentData(String url);
        void requestSmallLiveFragmentMoreEyeData(String moreeyeurl);
        void requestSmallLiveFragmentWatchTalkData();
        void requestLiveCommonFragmentData(String vsid,int page);

    }
}
