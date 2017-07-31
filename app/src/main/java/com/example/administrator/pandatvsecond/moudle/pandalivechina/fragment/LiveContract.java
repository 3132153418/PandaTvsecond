package com.example.administrator.pandatvsecond.moudle.pandalivechina.fragment;

import com.example.administrator.pandatvsecond.base.BasePresenter;
import com.example.administrator.pandatvsecond.base.BaseView;
import com.example.administrator.pandatvsecond.model.bean.ChangchengBean;

/**
 * Created by Administrator on 2017/7/22.
 */

public interface LiveContract {
    interface  View extends BaseView<Presenter> {
        void getManager(ChangchengBean changchengBean);
        void showMessage(String msg);



    }
    interface Presenter extends BasePresenter {
        void setUrl(String url);
    }
}
