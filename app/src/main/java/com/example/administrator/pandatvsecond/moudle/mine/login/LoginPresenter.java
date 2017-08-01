package com.example.administrator.pandatvsecond.moudle.mine.login;

import android.graphics.drawable.Drawable;

import com.example.administrator.pandatvsecond.model.bean.LoginEntity;
import com.example.administrator.pandatvsecond.model.biz.LoginMoudle;
import com.example.administrator.pandatvsecond.model.biz.LoginMoudleIpl;
import com.example.administrator.pandatvsecond.net.callback.MyCallBack;

/**
 * Created by lenovo on 2017/7/31.
 */

public class LoginPresenter implements LoginContract.Presenter {
    private LoginContract.View loginView;
    private LoginMoudle loginMoudle;
    public LoginPresenter(LoginContract.View loginView){
        this.loginView = loginView;
        loginView.setPresenter(this);
        loginMoudle = new LoginMoudleIpl();
    }

    @Override
    public void start() {

    }

    @Override
    public void loge(String name, String pwd) {
        loginMoudle.getLogin(name, pwd, new MyCallBack<LoginEntity>() {
            @Override
            public void onSuccess(Drawable drawable) {

            }

            @Override
            public void onSusses(LoginEntity loginEntity) {
                loginView.setLogin(loginEntity);

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
