package com.bw.movie.presenter;

import android.util.Log;
import android.widget.Toast;

import com.bw.movie.base.App;
import com.bw.movie.base.BasePresenter;
import com.bw.movie.base.IBaseView;
import com.bw.movie.bean.EmailCodeBean;
import com.bw.movie.bean.LoginBean;
import com.bw.movie.bean.RegisterBean;
import com.bw.movie.icoolor.ICoolor_LRE;
import com.bw.movie.model.Model_LRE;

public class Presenter_LRE extends BasePresenter implements ICoolor_LRE.IPresenter {

    private Model_LRE model;

    public Presenter_LRE(IBaseView iBaseView) {
        super(iBaseView);
    }

    @Override
    protected void initModel() {
        model = new Model_LRE();
    }

    @Override
    public void getEmailCode(String email) {
        model.getEmailCode(email, new ICoolor_LRE.EmailCodeCallback() {
            @Override
            public void getSuccess(EmailCodeBean emailCodeBean) {
                IBaseView view = getView();
                if (view!=null&&view instanceof ICoolor_LRE.IView){
                    ((ICoolor_LRE.IView)view).getEmailCodeSuccess(emailCodeBean);
                }
            }
        });
    }

    @Override
    public void getLogin(String email, String pwd) {

        model.getLogin(email, pwd, new ICoolor_LRE.LoginCallback() {
            @Override
            public void getSuccess(LoginBean loginBean) {
                IBaseView view = getView();
                if (view!=null&&view instanceof ICoolor_LRE.IView){
                    ((ICoolor_LRE.IView)view).getLoginSuccess(loginBean);
                    Log.i("xxx","getLogin2");
                }
            }
        });
    }

    @Override
    public void getRegister(String nickName, String pwd, String email, String code) {
        model.getRegister(nickName, pwd, email, code, new ICoolor_LRE.RegisterCallback() {
            @Override
            public void getSuccess(RegisterBean registerBean) {
                IBaseView view = getView();
                if (view!=null&&view instanceof ICoolor_LRE.IView){
                    ((ICoolor_LRE.IView)view).getRegisterSuccess(registerBean);
                }
            }
        });
    }

    @Override
    public void getWx(String code) {
        model.getWx(code, new ICoolor_LRE.WxCallback() {
            @Override
            public void getSuccess(LoginBean loginBean) {
                IBaseView view = getView();
                if (view!=null&&view instanceof ICoolor_LRE.IView){
                    ((ICoolor_LRE.IView)view).getWxSuccess(loginBean);
                }
            }
        });
    }
}
