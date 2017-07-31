package com.example.administrator.pandatvsecond.moudle.mine.pwd;

import android.graphics.drawable.Drawable;

import com.example.administrator.pandatvsecond.model.biz.PassWordMoudle;
import com.example.administrator.pandatvsecond.model.biz.PassWordMoudleIpl;
import com.example.administrator.pandatvsecond.net.callback.MyCallBack;


/**
 * Created by Administrator on 2017/7/22.
 */

public class PassWordPresenter implements PassWordContract.Presenter {
    private PassWordContract.View pwdView;
    private PassWordMoudle passWordMoudle;
    public PassWordPresenter(PassWordContract.View pwdView){
        pwdView.setPresenter(this);
        this.pwdView = pwdView;
        passWordMoudle = new PassWordMoudleIpl();


    }
    @Override
    public void start() {

        passWordMoudle.setPwd(new MyCallBack() {
            @Override
            public void onSuccess(Drawable drawable) {
                pwdView.setPwdYz(drawable);
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
    public void getPwdYz(String num, String yz) {

        passWordMoudle.setPwdYz(num, yz, new MyCallBack() {
            @Override
            public void onSuccess(Drawable drawable) {

            }

            @Override
            public void onSusses(Object o) {

            }

            @Override
            public void onsusses(String string) {
                pwdView.setStrPwd(string);
            }

            @Override
            public void onError(String msg) {

            }
        });

    }

    @Override
    public void getStrPwd(String num, String yz, String pwd) {

        passWordMoudle.findPwdBtn(num, yz, pwd, new MyCallBack() {
            @Override
            public void onSuccess(Drawable drawable) {

            }

            @Override
            public void onSusses(Object o) {

            }

            @Override
            public void onsusses(String string) {
                pwdView.setRegsPwd(string);
            }

            @Override
            public void onError(String msg) {

            }
        });
    }
}
