package com.example.administrator.pandatvsecond.moudle.mine.register;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.os.Bundle;

import com.example.administrator.pandatvsecond.model.bean.PersonRegister;
import com.example.administrator.pandatvsecond.model.biz.IMineModel;
import com.example.administrator.pandatvsecond.model.biz.MineModeImpl;
import com.example.administrator.pandatvsecond.net.callback.MyCallBack;
import com.example.administrator.pandatvsecond.config.Keys;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by xingge on 2017/7/27.
 */

public class EmilePresenter implements EmileContract.Presenter {

    private EmileContract.View mineView;
    private IMineModel mineModel;
    private String jsessionid;
    public EmilePresenter(EmileContract.View mineView){
        this.mineView = mineView;
        this.mineView.setPresenter(this);
        this.mineModel = new MineModeImpl();
    }

    @Override
    public void start() {
        mineModel.loadImgCode(new MyCallBack<Bundle>() {
            @Override
            public void onSuccess(Drawable drawable) {

            }

            @Override
            public void onSusses(Bundle bundle) {
                jsessionid = bundle.getString(Keys.JSESSIONID);
                byte[] byteArray = bundle.getByteArray(Keys.IMGCODE);
                Bitmap bitmap = BitmapFactory.decodeByteArray(byteArray, 0, byteArray.length);
                mineView.showImgCode(bitmap);
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
    public boolean checkEmail(String emailAddress) {

        if(emailAddress == null || "".equals(emailAddress)){
            mineView.showEmailTips("邮箱不能为空");
            return false;
        }else
            mineView.hideEmailTips();

        String regEx = "/^[a-zA-Z0-9_-]+@[a-zA-Z0-9_-]+(\\.[a-zA-Z0-9_-]+)+$/";
        Pattern pattern = Pattern.compile(regEx);
        // 忽略大小写的写法
        // Pattern pat = Pattern.compile(regEx, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(emailAddress);
        // 字符串是否与正则表达式相匹配
        boolean matches = matcher.matches();
        if(!matches){
            mineView.showEmailTips("邮箱格式不正确");
            return false;
        }

        return true;

    }

    @Override
    public boolean checkPwd(String pwd) {
        if(pwd == null || "".equals(pwd)){
            mineView.showEmailTips("密码不能为空");
            return false;
        }else
            mineView.hidePwdTips();
        return true;
    }

    @Override
    public boolean checkImgCode(String imgCode) {
        return true;
    }


    @Override
    public void register(String mailAdd, String passWd, String verificationCode) {

//        if(!checkEmail(mailAdd))
//            return;
        if(!checkPwd(passWd))
            return;
        if(!checkImgCode(verificationCode))
            return;
        mineModel.register(mailAdd, passWd, verificationCode, jsessionid, new MyCallBack<PersonRegister>() {
            @Override
            public void onSuccess(Drawable drawable) {

            }

            @Override
            public void onSusses(PersonRegister personRegister) {
                String msg = personRegister.getMsg();
                if("success".equals(msg)){
                    mineView.toLogin();
                }
                mineView.showMessage(msg);
            }

            @Override
            public void onsusses(String string) {

            }

            @Override
            public void onError(String msg) {
                mineView.showMessage(msg);
            }

        });
    }
}
