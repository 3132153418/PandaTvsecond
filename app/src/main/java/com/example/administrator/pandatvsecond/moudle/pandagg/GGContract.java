package com.example.administrator.pandatvsecond.moudle.pandagg;

import com.example.administrator.pandatvsecond.base.BasePresenter;
import com.example.administrator.pandatvsecond.base.BaseView;
import com.example.administrator.pandatvsecond.model.bean.GGbean;

/**
 * Created by lenovo on 2017/7/28.
 */

public interface GGContract {
    interface View extends BaseView<ggPresenter> {
    void showGGdata(GGbean gGbean);
    }
    interface ggPresenter extends BasePresenter{

    }
}
