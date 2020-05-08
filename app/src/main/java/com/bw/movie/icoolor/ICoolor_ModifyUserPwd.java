package com.bw.movie.icoolor;

import com.bw.movie.activity.ModifyUserPwdActivity;
import com.bw.movie.base.IBaseView;
import com.bw.movie.bean.DateListBean;
import com.bw.movie.bean.LoginBean;

public interface ICoolor_ModifyUserPwd {
    interface IVew extends IBaseView{
        void getModifyUserPwdSuccess(LoginBean loginBean);
    }
    interface IPersenter{
        void getModifyUserPwd(String oldPwd,String newPwd,String newPwd2);
    }
    interface IModel{
        void getModifyUserPwd(String oldPwd,String newPwd,String newPwd2,ModifyUserPwdCallback modifyUserPwdCallback);
    }
    interface ModifyUserPwdCallback{
        void getSuccess(LoginBean loginBean);
    }
}
