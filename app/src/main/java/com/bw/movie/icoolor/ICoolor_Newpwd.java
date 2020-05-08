package com.bw.movie.icoolor;

import com.bw.movie.base.IBaseView;
import com.bw.movie.bean.EmailCodeBean;
import com.bw.movie.bean.LoginBean;
import com.bw.movie.bean.RegisterBean;

public interface ICoolor_Newpwd {
    interface IView extends IBaseView{
        //邮箱验证码
        void getNewpwdSuccess(LoginBean loginBean);


    }
    interface IPresenter{
        void getNewpwd(String oldPwd,String newPwd,String newPwd2);

    }
    interface IModel{
        void getNewpwd(String oldPwd,String newPwd,String newPwd2, NewpwdCallback newpwdCallback);

    }
    interface NewpwdCallback{
        void getSuccess(LoginBean loginBean);
    }

}
