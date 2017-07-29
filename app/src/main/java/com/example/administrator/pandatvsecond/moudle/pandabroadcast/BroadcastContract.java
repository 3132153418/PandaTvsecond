package com.example.administrator.pandatvsecond.moudle.pandabroadcast;

import com.example.administrator.pandatvsecond.base.BasePresenter;
import com.example.administrator.pandatvsecond.base.BaseView;
import com.example.administrator.pandatvsecond.model.bean.BroadcastBean;

/**
 * Created by Administrator on 2017/7/28.
 */

public interface BroadcastContract {
    interface View extends BaseView<Presenter>{
       void setResult(BroadcastBean broadcastBean);

    }
    interface Presenter extends BasePresenter{

    }
}
