package com.bw.movie.activity;

import com.bw.movie.R;
import com.bw.movie.base.BaseAcitvity;
import com.bw.movie.base.BasePresenter;
import com.bw.movie.bean.EmailCodeBean;
import com.bw.movie.bean.LoginBean;
import com.bw.movie.bean.RegisterBean;
import com.bw.movie.icoolor.ICoolor_LRE;

public class ForgetActivity extends BaseAcitvity implements ICoolor_LRE.IView {


    @Override
    protected BasePresenter initPresenter() {
        return null;
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

    }

    @Override
    public void getEmailCodeSuccess(EmailCodeBean emailCodeBean) {

    }

    @Override
    public void getLoginSuccess(LoginBean loginBean) {

    }

    @Override
    public void getRegisterSuccess(RegisterBean registerBean) {

    }
}
