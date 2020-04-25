package com.bw.movie.activity;

import android.content.Intent;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
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
import com.bw.movie.utils.SPUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import butterknife.BindView;

public class LoginActivity extends BaseAcitvity implements ICoolor_LRE.IView, View.OnClickListener {
    @BindView(R.id.email)
    EditText email;
    @BindView(R.id.pwd)
    EditText pwd;
    @BindView(R.id.bt_wang)
    Button bt_wang;
    @BindView(R.id.tv_zhu)
    TextView tv_zhu;
    @BindView(R.id.bt_deng)
    Button bt_deng;
    @BindView(R.id.ll_wx)
    LinearLayout ll_wx;

    @Override
    protected BasePresenter initPresenter() {
        return new Presenter_LRE(this);
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_log_in;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {
        bt_deng.setOnClickListener(this);
        bt_wang.setOnClickListener(this);
        ll_wx.setOnClickListener(this);
        tv_zhu.setOnClickListener(this);
    }

    @Override
    public void getEmailCodeSuccess(EmailCodeBean emailCodeBean) {

    }

    @Override
    public void getLoginSuccess(LoginBean loginBean) {
        Log.i("xxx",""+loginBean.getMessage());
        Toast.makeText(this, "登录成功"+loginBean.getMessage()+loginBean.getStatus(), Toast.LENGTH_SHORT).show();
        if (loginBean.getMessage().equals("登陆成功")){
            Toast.makeText(this, "登陆成功", Toast.LENGTH_SHORT).show();
            LoginBean.ResultBean result = loginBean.getResult();
            int userId = result.getUserId();
            String sessionId = result.getSessionId();
            LoginBean.ResultBean.UserInfoBean userInfo = result.getUserInfo();
            SPUtils.putString(this,SPUtils.USERINFO_NAME,SPUtils.USERINFO_KEY_USER_ID,String.valueOf(userId));
            SPUtils.putString(this,SPUtils.USERINFO_NAME,SPUtils.USERINFO_KEY_SESSION_ID,sessionId);
            //跳转
            Intent intent = new Intent(LoginActivity.this, HomeActivity.class);
            startActivity(intent);
        }
    }

    @Override
    public void getRegisterSuccess(RegisterBean registerBean) {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            //忘记密码
            case R.id.bt_wang:
                Intent intent1 = new Intent(LoginActivity.this, ForgetActivity.class);
                startActivity(intent1);
                break;
            //点击登录
            case R.id.bt_deng:
                Toast.makeText(this, "跳转", Toast.LENGTH_SHORT).show();
                if (HttpUtil.getInstance().isWifi(this)){
                    String string = pwd.getText().toString();
                    if (!TextUtils.isEmpty(email.getText().toString())&&!TextUtils.isEmpty(string)){

                        String pwd = EncryptUtil.encrypt(string);
                        BasePresenter presenter = getPresenter();
                        if (presenter!=null&&presenter instanceof ICoolor_LRE.IPresenter){
                            ((ICoolor_LRE.IPresenter)presenter).getLogin(email.getText().toString(),pwd);
                            Toast.makeText(this, "有网络跳转", Toast.LENGTH_SHORT).show();

                        }
                    }else {
                        Toast.makeText(this, "邮箱帐号、密码 不能为空", Toast.LENGTH_SHORT).show();
                    }
                }else {
                    Toast.makeText(this, "没有网络", Toast.LENGTH_SHORT).show();
                }
                break;
            //微信登录
            case R.id.ll_wx:
                break;
             //没有帐号 注册
            case R.id.tv_zhu:
                Intent intent = new Intent(LoginActivity.this, RegisteredActivity.class);
                startActivity(intent);
                break;
                default:
        }
    }



}
