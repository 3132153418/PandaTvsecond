package com.example.administrator.pandatvsecond.moudle.pandalive;

import com.example.administrator.pandatvsecond.base.BasePresenter;
import com.example.administrator.pandatvsecond.base.BaseView;
import com.example.administrator.pandatvsecond.model.bean.LiveBean;

/**
 * Created by Administrator on 2017/7/28.
 */

public interface LiveContract {
    interface View extends BaseView<Presenter>{
        void setResult(LiveBean liveBean);
    }
    interface Presenter extends BasePresenter{}
}
