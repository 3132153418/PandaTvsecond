package com.example.administrator.pandatvsecond.moudle.pandahome;

import com.example.administrator.pandatvsecond.base.BasePresenter;
import com.example.administrator.pandatvsecond.base.BaseView;
import com.example.administrator.pandatvsecond.model.bean.HomeBean;
import com.example.administrator.pandatvsecond.model.bean.Video_home_TuiJianBean;
import com.example.administrator.pandatvsecond.net.callback.MyCallBack;

/**
 * Created by Administrator on 2017/7/28.
 */

public interface HomeContract {
    interface View extends BaseView<Presenter>{
        void setResult(HomeBean homeBean);

    }
    interface Presenter extends BasePresenter{

    }
}
