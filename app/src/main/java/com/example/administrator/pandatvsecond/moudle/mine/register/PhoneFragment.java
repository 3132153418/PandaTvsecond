package com.example.administrator.pandatvsecond.moudle.mine.register;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.administrator.pandatvsecond.R;
import com.example.administrator.pandatvsecond.base.BaseFragment;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import okhttp3.OkHttpClient;

/**
 * Created by lenovo on 2017/7/31.
 */
public class PhoneFragment extends BaseFragment implements View.OnClickListener, PhoneContract.View {
    @BindView(R.id.phone_Edit)
    EditText phoneEdit;
    @BindView(R.id.phone_TextView)
    TextView phoneTextView;
    @BindView(R.id.image_Edit)
    EditText imageEdit;
    @BindView(R.id.yanzheng_TextView)
    TextView yanzhengTextView;
    @BindView(R.id.phone_ImageView)
    ImageView phoneImageView;
    @BindView(R.id.yanzhengma_Edit)
    EditText yanzhengmaEdit;
    @BindView(R.id.yanzhengma_Btn)
    Button yanzhengmaBtn;
    @BindView(R.id.pwd_Edit)
    EditText pwdEdit;
    @BindView(R.id.login_CheckBox)
    CheckBox loginCheckBox;
    @BindView(R.id.phone_agree)
    LinearLayout phoneAgree;
    @BindView(R.id.login_Button)
    Button loginButton;
    Unbinder unbinder;
    private ImageView phone_ImageView;
    private EditText phone_Edit, image_Edit, yanzhengma_Edit, pwd_Edit;
    private CheckBox login_CheckBox;
    private Button yanzhengma_Btn, login_Button;
    private TextView textView, yanzhnegma_Text;
    private int a = 60;
    byte[] bytes;
    private OkHttpClient client = new OkHttpClient();
    private String jsonId;
    private PhonePresenter presenter;


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.phone_Edit:
                if (phone_Edit.getText().toString().equals("")) {
                    textView.setVisibility(View.VISIBLE);
                    textView.setText("手机号码不能为空");
                } else {
                    textView.setVisibility(View.GONE);
                }
                break;
            case R.id.image_Edit:
                break;
            case R.id.phone_ImageView:
                presenter.start();
                break;
            case R.id.login_CheckBox:
                break;
            case R.id.yanzhengma_Btn:
                presenter.getPhoneYz(phone_Edit.getText().toString(), image_Edit.getText().toString());
                break;
            case R.id.login_Button:
                presenter.getStrPhone(phone_Edit.getText().toString(), yanzhengma_Edit.getText().toString(), pwd_Edit.getText().toString());
                if (phone_Edit.getText().toString().equals("")
                        || yanzhengma_Edit.getText().toString().equals("")
                        || pwd_Edit.getText().toString().equals("")) {
                    Toast.makeText(getContext(), "注册失败", Toast.LENGTH_SHORT).show();
                } else {
                    getActivity().finish();
                }

                break;
        }
    }

    @Override
    public void setPhoneReg(Drawable drawable) {
        phone_ImageView.setImageDrawable(drawable);

    }

    @Override
    public void setStrPhone(String strPhone) {

    }

    @Override
    public void setRegsPhone(String string) {

    }

    @Override
    public void showProgress() {

    }

    @Override
    public void dismissProgress() {

    }

    @Override
    public void setPresenter(PhoneContract.Presenter presenter) {

        this.presenter = (PhonePresenter) presenter;
    }

    @Override
    public void showMessage(String msg) {

    }

    @Override
    public void onRefresh() {

    }

    @Override
    protected int getLayoutId() {
        return R.layout.register_phone_fragment;

    }

    @Override
    protected void initView(View view) {
        new PhonePresenter(this);
        phone_Edit = (EditText) view.findViewById(R.id.phone_Edit);
        image_Edit = (EditText) view.findViewById(R.id.image_Edit);
        yanzhengma_Edit = (EditText) view.findViewById(R.id.yanzhengma_Edit);
        pwd_Edit = (EditText) view.findViewById(R.id.pwd_Edit);
        login_Button = (Button) view.findViewById(R.id.login_Button);
        login_Button.setOnClickListener(this);
        login_CheckBox = (CheckBox) view.findViewById(R.id.login_CheckBox);
        yanzhengma_Btn = (Button) view.findViewById(R.id.yanzhengma_Btn);
        yanzhengma_Btn.setOnClickListener(this);
        phone_ImageView = (ImageView) view.findViewById(R.id.phone_ImageView);
        phone_ImageView.setOnClickListener(this);
        textView = (TextView) view.findViewById(R.id.phone_TextView);
        yanzhnegma_Text = (TextView) view.findViewById(R.id.yanzheng_TextView);

    }

    @Override
    protected void loadData() {
        presenter.start();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        unbinder = ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick(R.id.phone_agree)
    public void onViewClicked() {
//        Intent intent = new Intent(this, .class);
//        startActivity(intent);
    }
}
