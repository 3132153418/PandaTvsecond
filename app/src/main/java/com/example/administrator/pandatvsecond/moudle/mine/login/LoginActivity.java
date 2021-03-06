package com.example.administrator.pandatvsecond.moudle.mine.login;

import android.app.ProgressDialog;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.administrator.pandatvsecond.R;
import com.example.administrator.pandatvsecond.activity.RegisterActivity;
import com.example.administrator.pandatvsecond.base.BaseActivity;
import com.example.administrator.pandatvsecond.model.bean.LoginEntity;
import com.example.administrator.pandatvsecond.moudle.mine.pwd.PassWordActivity;
import com.example.administrator.pandatvsecond.util.MineLog;

/**
 * 登录界面
 */

public class LoginActivity extends BaseActivity  implements View.OnClickListener,LoginContract.View {
    private ImageView loginBack,weibo_Login,qqLogin;
    private ProgressDialog dialog;
    private TextView register;
    private EditText editUserName,editUserPassword;
    private Button loginBtn;
    private LoginPresenter presenter;
    private TextView forget_password;




    @Override
    protected void initView() {

        dialog = new ProgressDialog(this);
        new LoginPresenter(this);
        register = (TextView) findViewById(R.id.register_Text);
        register.setOnClickListener(this);

        loginBack = (ImageView) findViewById(R.id.loginBacks);
        loginBack.setOnClickListener(this);
        qqLogin = (ImageView) findViewById(R.id.qqLogin);
        qqLogin.setOnClickListener(this);
        weibo_Login = (ImageView) findViewById(R.id.weibo_Login);
        weibo_Login.setOnClickListener(this);
        editUserName = (EditText) findViewById(R.id.editUserName);
        editUserPassword = (EditText) findViewById(R.id.editUserPassword);
        loginBtn = (Button) findViewById(R.id.loginBtn);
        loginBtn.setOnClickListener(this);
        forget_password = (TextView) findViewById(R.id.forget_password);
        forget_password.setOnClickListener(this);

    }

    @Override
    protected int getLauoutId() {
        return R.layout.person_login;
    }

    @Override
    protected void loadData() {

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
//        UMShareAPI.get(this).onActivityResult(requestCode, resultCode, data);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.loginBacks:
                finish();
                break;
            case R.id.qqLogin:
//                UMShareAPI.get(this).doOauthVerify(this, SHARE_MEDIA.QQ, authListener);
                break;
            case R.id.weibo_Login:
//                UMShareAPI.get(this).doOauthVerify(this, SHARE_MEDIA.SINA, authListener);
                break;
            case R.id.register_Text:
                Intent intent = new Intent(this,RegisterActivity.class);
                startActivity(intent);
                break;
            case R.id.loginBtn:

                if (editUserName.getText().toString().equals("") && editUserPassword.getText().toString().equals("")){
                    Toast.makeText(this, "登录失败", Toast.LENGTH_SHORT).show();
                }else {
                    presenter.loge(editUserName.getText().toString(),editUserPassword.getText().toString());
                    Toast.makeText(this, "登录成功", Toast.LENGTH_SHORT).show();
                }

                break;
            case R.id.forget_password:
                Intent intent1 = new Intent(LoginActivity.this,PassWordActivity.class);
                startActivity(intent1);
                finish();
                break;
        }
    }

    @Override
    public void setLogin(LoginEntity login) {
        String errMsg = login.getErrMsg();
        String user_seq_id= login.getUser_seq_id();
        MineLog.d("susses",errMsg.toString());
        if (errMsg.equals("成功")) {
            Intent intent = getIntent();
            intent.putExtra("name", "央视" + user_seq_id);
//            intent.putExtra("personimage",R.mipmap.ic_launcher);
            setResult(0, intent);
            finish();
        }else {
            Toast.makeText(this, "登录失败", Toast.LENGTH_SHORT).show();
        }

    }

    @Override
    public void showProgress() {

    }

    @Override
    public void dismissProgress() {

    }

    @Override
    public void setPresenter(LoginContract.Presenter presenter) {

        this.presenter= (LoginPresenter) presenter;
    }

    @Override
    public void showMessage(String msg) {
    }

    @Override
    public void onRefresh() {
    }
}
