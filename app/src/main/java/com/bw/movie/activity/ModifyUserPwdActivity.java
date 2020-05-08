package com.bw.movie.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.bw.movie.R;
import com.bw.movie.base.BaseAcitvity;
import com.bw.movie.base.BasePresenter;
import com.bw.movie.bean.LoginBean;
import com.bw.movie.icoolor.ICoolor_ModifyUserPwd;
import com.bw.movie.presenter.Presenter_ModifyUserPwd;

import butterknife.BindView;

public class ModifyUserPwdActivity extends BaseAcitvity implements ICoolor_ModifyUserPwd.IVew {
    @BindView(R.id.et_pwd)
    EditText et_pwd;
    @BindView(R.id.et_newpwd)
    EditText et_newpwd;
    @BindView(R.id.et_newpwd2)
    EditText et_newpwd2;
    @BindView(R.id.bt_ok)
    Button bt_ok;
    @BindView(R.id.iv_shape)
    ImageView iv_shape;

    @Override
    protected BasePresenter initPresenter() {
        return new Presenter_ModifyUserPwd(this);
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_modify_user_pwd;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {
        iv_shape.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        bt_ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BasePresenter presenter = getPresenter();
                if (presenter != null) {
                    ((ICoolor_ModifyUserPwd.IPersenter)presenter).getModifyUserPwd(et_pwd.getText().toString(),et_newpwd.getText().toString(),et_newpwd2.getText().toString());
                }
            }
        });
    }

    @Override
    public void getModifyUserPwdSuccess(LoginBean loginBean) {
        Toast.makeText(this, ""+loginBean.getMessage(), Toast.LENGTH_SHORT).show();
    }
}
