package com.example.administrator.pandatvsecond.activity;


import com.example.administrator.pandatvsecond.base.BasePresenter;
import com.example.administrator.pandatvsecond.base.BaseView;
import com.example.administrator.pandatvsecond.model.bean.OriginalBean;

/**
 * Created by Administrator on 2017/7/15.
 */

public interface OriginalContract {
//    挂号费结核杆菌
    interface View extends BaseView<Presenter> {
        void setResoust(OriginalBean originalBean);
    }
    interface Presenter extends BasePresenter {




    }
}
