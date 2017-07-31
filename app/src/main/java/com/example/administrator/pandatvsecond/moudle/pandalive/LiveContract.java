package com.example.administrator.pandatvsecond.moudle.pandalive;

import com.example.administrator.pandatvsecond.base.BasePresenter;
import com.example.administrator.pandatvsecond.base.BaseView;
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

import java.util.List;

/**
 * Created by Administrator on 2017/7/28.
 */

public interface LiveContract {
    interface View extends BaseView<Presenter>{

        void SmallLiveFragmentResult(LiveFragmentBean.LiveBean liveBean);
        void MoreEyeResult(List<MoreEyeBean.ListBean> listBean);
        void WatchTalkResult(List<WatchTalkBean.DataBean.ContentBean> content);

        void GoodTimeBeanResult(GoodTimeBean goodTimeBean);

        void NoBeerBeanResult(NoBearBean noBearBean);

        void GGShowBeanResult(GGShowBean ggShowBean);

        void PandaFileResult(PandaFileBean pandaFileBean);

        void PandaTopBeanResult(PandaTopBean pandaTopBean);

        void PandaThingsBeanResult(NoBearBean noBearBean);//用当熊不让的数据请求

        void EspeciallyShowBeanResult(EspeciallyShowBean especiallyShowBean);

        void OriginalNewsBeanResult(OriginalNewsBean originalNewsBean);
    }
    interface Presenter extends BasePresenter{


        void requestSmallLiveFragmentData();

        void requestSmallLiveFragmentMoreEyeData(String moreeyeurl);

        void requestSmallLiveFragmentWatchTalkData();
        void requestGoodTimeFragmentData();
        void requestNobeerFragmentData();
        void requestGGShowFragmentData();
        void requestPandaFileFragmentData();
        void requestPandaTopFragmentData();
        void requestPandaThingsFragmentData();
        void requestEspeciallyShowFragmentData();
        void requestOriginalNewsFragmentData();

    }
}
