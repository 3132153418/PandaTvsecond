package com.example.administrator.pandatvsecond.moudle.mine.register;

import android.graphics.drawable.Drawable;

import com.example.administrator.pandatvsecond.base.BasePresenter;
import com.example.administrator.pandatvsecond.base.BaseView;

/**
 * Created by Administrator on 2017/7/22.
 */

public interface PhoneContract {
    interface View extends BaseView<Presenter> {
        void setPhoneReg(Drawable drawable);

        void setStrPhone(String strPhone);

        void setRegsPhone(String string);
    }
    interface Presenter extends BasePresenter{
        void getPhoneYz(String num, String yz);

        void getStrPhone(String num, String yz, String pwd);
    }
}
