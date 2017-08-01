package com.example.administrator.pandatvsecond.moudle.mine.register;

import android.graphics.drawable.Drawable;

import com.example.administrator.pandatvsecond.model.biz.PhoneMoudle;
import com.example.administrator.pandatvsecond.model.biz.PhoneMoudleIpl;
import com.example.administrator.pandatvsecond.net.callback.MyCallBack;


/**
 * Created by Administrator on 2017/7/22.
 */

public class PhonePresenter implements PhoneContract.Presenter {
    private PhoneContract.View phoneView;
    private PhoneMoudle phoneMoudle;

    public PhonePresenter(PhoneContract.View phoneView) {
        phoneView.setPresenter(this);
        this.phoneView = phoneView;
        phoneMoudle = new PhoneMoudleIpl();

    }

    @Override
    public void start() {

        phoneMoudle.getPhone(new MyCallBack() {
            @Override
            public void onSuccess(Drawable drawable) {
                phoneView.setPhoneReg(drawable);
            }

            @Override
            public void onSusses(Object o) {

            }

            @Override
            public void onsusses(String string) {

            }

            @Override
            public void onError(String msg) {

            }


        });
    }

    @Override
    public void getPhoneYz(String num, String yz) {
        phoneMoudle.setPhone(num, yz, new MyCallBack() {


            @Override
            public void onSuccess(Drawable drawable) {

            }

            @Override
            public void onSusses(Object o) {
                phoneView.setStrPhone(o.toString());
            }

            @Override
            public void onsusses(String string) {

            }

            @Override
            public void onError(String msg) {

            }
        });
    }

    @Override
    public void getStrPhone(String num, String yz, String pwd) {
        phoneMoudle.phoneRegister(num, yz, pwd, new MyCallBack() {

            @Override
            public void onSuccess(Drawable drawable) {

            }

            @Override
            public void onSusses(Object o) {
                phoneView.setRegsPhone(o.toString());
            }

            @Override
            public void onsusses(String string) {

            }

            @Override
            public void onError(String msg) {

            }
        });
    }
}
