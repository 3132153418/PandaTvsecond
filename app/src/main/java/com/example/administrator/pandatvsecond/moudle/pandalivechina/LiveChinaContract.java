package com.example.administrator.pandatvsecond.moudle.pandalivechina;

import com.example.administrator.pandatvsecond.base.BasePresenter;
import com.example.administrator.pandatvsecond.base.BaseView;
import com.example.administrator.pandatvsecond.model.bean.PopupBean;

/**
 * Created by lenovo on 2017/7/28.
 */

public class LiveChinaContract {
    interface View extends BaseView<livechinaPresenter> {
        void getChinaLiveTab(PopupBean popupBean);
    }
    interface livechinaPresenter extends BasePresenter {

    }
}
