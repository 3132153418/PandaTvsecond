package com.example.administrator.pandatvsecond.moudle.mine.register;

import android.content.Intent;
import android.graphics.Bitmap;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.administrator.pandatvsecond.R;
import com.example.administrator.pandatvsecond.base.BaseFragment;
import com.example.administrator.pandatvsecond.moudle.mine.login.LoginActivity;
import com.example.administrator.pandatvsecond.widget.manager.ToastManager;

import butterknife.BindView;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * 注册界面
 */

public class EmileFragment extends BaseFragment implements EmileContract.View {
    @BindView(R.id.et_email)
    EditText etEmail;
    @BindView(R.id.et_emailpsw)
    EditText etEmailpsw;
    @BindView(R.id.et_emailquerenpsw)
    EditText etEmailquerenpsw;
    @BindView(R.id.et_emailpictureyanzheng)
    EditText etEmailpictureyanzheng;
    @BindView(R.id.email_image)
    ImageView emailImage;
    @BindView(R.id.bt_emailregister)
    Button btEmailregister;
    Unbinder unbinder;
    @BindView(R.id.et_email_gone)
    TextView etEmailGone;
    @BindView(R.id.et_emailpsw_gone)
    TextView etEmailpswGone;
    @BindView(R.id.et_emailquerenpsw_gone)
    TextView etEmailquerenpswGone;
    @BindView(R.id.gou_agree)
    LinearLayout gouAgree;

    private EmileContract.Presenter presenter;

    @Override
    public void showProgress() {


    }

    @Override
    public void dismissProgress() {

    }


    @Override
    public void showMessage(String msg) {
        ToastManager.show(msg);
    }

    @Override
    public void onRefresh() {

    }

    @Override
    public void setPresenter(EmileContract.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void showEmailTips(String msg) {

        etEmailGone.setVisibility(View.VISIBLE);
        etEmailGone.setText(msg);

    }

    @Override
    public void hideEmailTips() {
        etEmailGone.setVisibility(View.GONE);
    }

    @Override
    public void showPwdTips(String msg) {
        etEmailpswGone.setVisibility(View.VISIBLE);
        etEmailpswGone.setText(msg);

    }

    @Override
    public void hidePwdTips() {
        etEmailpswGone.setVisibility(View.GONE);
    }

    @Override
    public void showImgCode(Bitmap bitmap) {
        emailImage.setImageBitmap(bitmap);

    }

    @Override
    public void toLogin() {

        Intent intent = new Intent(getContext(), LoginActivity.class);
        startActivity(intent);

    }




    @Override
    protected int getLayoutId() {
        return R.layout.register_email_fragment;
    }

    @Override
    protected void initView(View view) {
        new EmilePresenter(this);
    }

    @Override
    protected void loadData() {

        presenter.start();
    }





    @OnClick({R.id.email_image, R.id.bt_emailregister, R.id.et_email, R.id.et_emailpsw, R.id.et_emailquerenpsw})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.email_image:
                presenter.start();
                break;
            case R.id.bt_emailregister:
                presenter.register(etEmail.getText().toString().trim(),
                        etEmailpsw.getText().toString().trim(),
                        etEmailpictureyanzheng.getText().toString().trim());
                break;
            case R.id.et_email:

                break;
            case R.id.et_emailpsw:
//                if(etEmail.equals("")) {
//                    etEmailGone.setVisibility(View.VISIBLE);
//                }
                break;
            case R.id.et_emailquerenpsw:
                break;
        }

    }

    @OnClick(R.id.gou_agree)
    public void onViewClicked() {
//        Intent intent = new Intent(EmileFragment.this, PersonAgreeActivity.class);
//        startActivity(intent);
    }

}
