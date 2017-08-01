package com.example.administrator.pandatvsecond.moudle.mine.login;

import com.example.administrator.pandatvsecond.base.BasePresenter;
import com.example.administrator.pandatvsecond.base.BaseView;
import com.example.administrator.pandatvsecond.model.bean.LoginEntity;

/**
 * Created by lenovo on 2017/7/31.
 */

public class LoginContract {
    interface View extends BaseView<Presenter>{
        void setLogin(LoginEntity login);
    }
    interface Presenter extends BasePresenter{
        void loge(String name,String pwd);
    }
}
