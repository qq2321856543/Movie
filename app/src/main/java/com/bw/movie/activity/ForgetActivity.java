package com.bw.movie.activity;

import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.bw.movie.R;
import com.bw.movie.base.BaseAcitvity;
import com.bw.movie.base.BasePresenter;
import com.bw.movie.bean.EmailCodeBean;
import com.bw.movie.bean.LoginBean;
import com.bw.movie.bean.RegisterBean;
import com.bw.movie.icoolor.ICoolor_LRE;
import com.bw.movie.icoolor.ICoolor_Newpwd;
import com.bw.movie.presenter.Presenter_Newpwd;
import com.bw.movie.utils.EncryptUtil;
import com.bw.movie.utils.HttpUtil;

import butterknife.BindView;

public class ForgetActivity extends BaseAcitvity implements ICoolor_Newpwd.IView {
    @BindView(R.id.iv_shape)
    ImageView iv_shape;
    @BindView(R.id.email)
    EditText email;
    @BindView(R.id.pwd)
    EditText pwd;
    @BindView(R.id.et_newpwd)
    EditText et_newpwd;
    @BindView(R.id.bt_get)
    Button bt_get;
    @BindView(R.id.bt_deng)
    Button bt_deng;

    @Override
    protected BasePresenter initPresenter() {
        return new Presenter_Newpwd(this);
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_forget;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {
        bt_deng.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (HttpUtil.getInstance().isWifi(ForgetActivity.this)){
                    if (!TextUtils.isEmpty(email.getText().toString())&&!TextUtils.isEmpty(pwd.getText().toString())&&!TextUtils.isEmpty(et_newpwd.getText().toString())){
//                        String str1 = EncryptUtil.encrypt(email.getText().toString());
//                        String str1 = EncryptUtil.encrypt(pwd.getText().toString());
//                        String str1 = EncryptUtil.encrypt(et_newpwd.getText().toString());

                        BasePresenter presenter = getPresenter();
                        if (presenter!=null){
                            //((ICoolor_Newpwd.IPresenter)presenter).getNewpwd(e);
                        }
                    }else {
                        Toast.makeText(ForgetActivity.this, "不能有空值", Toast.LENGTH_SHORT).show();
                    }
                }else {
                    Toast.makeText(ForgetActivity.this, "没有网络", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }


    @Override
    public void getNewpwdSuccess(RegisterBean registerBean) {

    }
}
