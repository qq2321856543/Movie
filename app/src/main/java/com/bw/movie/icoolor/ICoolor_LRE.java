package com.bw.movie.icoolor;

import com.bw.movie.base.IBaseView;
import com.bw.movie.bean.EmailCodeBean;
import com.bw.movie.bean.LoginBean;
import com.bw.movie.bean.RegisterBean;

public interface ICoolor_LRE {
    interface IView extends IBaseView{
        //邮箱验证码
        void getEmailCodeSuccess(EmailCodeBean emailCodeBean);
        //登录
        void getLoginSuccess(LoginBean loginBean);
        //注册
        void getRegisterSuccess(RegisterBean registerBean);
        //微信
        void getWxSuccess(LoginBean loginBean);

    }
    interface IPresenter{
        void getEmailCode(String email);
        void getLogin(String email,String pwd);
        void getRegister(String nickName,String pwd,String email,String code);
        void getWx(String code);
    }
    interface IModel{
        void getEmailCode(String email,EmailCodeCallback emailCodeCallback);
        void getLogin(String email,String pwd,LoginCallback loginCallback);
        void getRegister(String nickName,String pwd,String email,String code,RegisterCallback registerCallback);
        void getWx(String code,WxCallback wxCallback);
    }
    interface EmailCodeCallback{
        void getSuccess(EmailCodeBean emailCodeBean);
    }
    interface LoginCallback{
        void getSuccess(LoginBean loginBean);
    }
    interface RegisterCallback{
        void getSuccess(RegisterBean registerBean);
    }
    interface WxCallback{
        void getSuccess(LoginBean loginBean);
    }
}
