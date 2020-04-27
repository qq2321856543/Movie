package com.bw.movie.activity;

import android.content.Intent;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bw.movie.R;
import com.bw.movie.base.BaseAcitvity;
import com.bw.movie.base.BasePresenter;
import com.bw.movie.bean.EmailCodeBean;
import com.bw.movie.bean.LoginBean;
import com.bw.movie.bean.RegisterBean;
import com.bw.movie.icoolor.ICoolor_LRE;
import com.bw.movie.presenter.Presenter_LRE;
import com.bw.movie.utils.EncryptUtil;
import com.bw.movie.utils.HttpUtil;

import butterknife.BindView;

public class RegisteredActivity extends BaseAcitvity implements ICoolor_LRE.IView, View.OnClickListener {

    @BindView(R.id.et_name)
    EditText et_name;
    @BindView(R.id.et_email)
    EditText et_email;
    @BindView(R.id.et_pwd)
    EditText et_pwd;
    @BindView(R.id.pwdcod)
    EditText pwdcod;
    @BindView(R.id.bt_get)
    Button bt_get;
    @BindView(R.id.tv_yi)
    TextView tv_yi;
    @BindView(R.id.bt_zhu)
    Button bt_zhu;
    @BindView(R.id.iv_shape)
    ImageView iv_shape;
    @Override
    protected BasePresenter initPresenter() {
        return new Presenter_LRE(this);
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_registered;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {
        bt_get.setOnClickListener(this);
        bt_zhu.setOnClickListener(this);
        tv_yi.setOnClickListener(this);
        iv_shape.setOnClickListener(this);
    }

    @Override
    public void getEmailCodeSuccess(EmailCodeBean emailCodeBean) {
        Log.i("xxx","getEmailCodeSuccess:"+emailCodeBean.getMessage());
        if (emailCodeBean.getMessage().equals("注册成功")){
            Toast.makeText(this, "注册成功", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void getLoginSuccess(LoginBean loginBean) {

    }

    @Override
    public void getRegisterSuccess(RegisterBean registerBean) {
        Log.i("xxx","getRegisterSuccess:"+registerBean.getMessage());
    }

    @Override
    public void getWxSuccess(LoginBean loginBean) {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.bt_get:
                if (HttpUtil.getInstance().isWifi(RegisteredActivity.this)){
                    if (!TextUtils.isEmpty(et_name.getText().toString())&&!TextUtils.isEmpty(et_email.getText().toString())&&!TextUtils.isEmpty(et_pwd.getText().toString())){
                        BasePresenter presenter = getPresenter();
                        if (presenter!=null&&presenter instanceof ICoolor_LRE.IPresenter){
                            ((ICoolor_LRE.IPresenter)presenter).getEmailCode(et_email.getText().toString());
                            Toast.makeText(this, "已发送", Toast.LENGTH_SHORT).show();
                        }
                    }else {
                        Toast.makeText(this, "昵称、邮箱帐号、密码 不能为空", Toast.LENGTH_SHORT).show();
                    }
                }else {
                    Toast.makeText(this, "没有网络", Toast.LENGTH_SHORT).show();
                }

                break;
            case R.id.bt_zhu:
                if (HttpUtil.getInstance().isWifi(RegisteredActivity.this)){
                    if (!TextUtils.isEmpty(et_name.getText().toString())&&!TextUtils.isEmpty(et_email.getText().toString())&&!TextUtils.isEmpty(et_pwd.getText().toString())&&!TextUtils.isEmpty(pwdcod.getText().toString())){
                        String encrypt = EncryptUtil.encrypt(et_pwd.getText().toString());
                        BasePresenter presenter = getPresenter();
                        if (presenter!=null&&presenter instanceof ICoolor_LRE.IPresenter){
                            ((ICoolor_LRE.IPresenter)presenter).getRegister(et_name.getText().toString()
                            ,encrypt
                            ,et_email.getText().toString()
                            ,pwdcod.getText().toString());
                        }
                    }else {
                        Toast.makeText(this, "昵称、邮箱帐号、密码、验证码 不能为空", Toast.LENGTH_SHORT).show();
                    }
                }else {
                    Toast.makeText(this, "没有网络", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.tv_yi:
                Intent intent = new Intent(RegisteredActivity.this, LoginActivity.class);
                startActivity(intent);
                break;
            case R.id.iv_shape:
                finish();
                break;
                default:
                    break;
        }
    }
}
