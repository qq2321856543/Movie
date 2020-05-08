package com.bw.movie.presenter;

import com.bw.movie.base.BasePresenter;
import com.bw.movie.base.IBaseView;
import com.bw.movie.bean.LoginBean;
import com.bw.movie.icoolor.ICoolor_ModifyUserPwd;
import com.bw.movie.model.Model_ModifyUserPwd;

public class Presenter_ModifyUserPwd extends BasePresenter implements ICoolor_ModifyUserPwd.IPersenter {

    private Model_ModifyUserPwd model;

    public Presenter_ModifyUserPwd(IBaseView iBaseView) {
        super(iBaseView);
    }

    @Override
    protected void initModel() {
        model = new Model_ModifyUserPwd();
    }

    @Override
    public void getModifyUserPwd(String oldPwd, String newPwd, String newPwd2) {
        model.getModifyUserPwd(oldPwd, newPwd, newPwd2, new ICoolor_ModifyUserPwd.ModifyUserPwdCallback() {
            @Override
            public void getSuccess(LoginBean loginBean) {
                IBaseView view = getView();
                if (view != null) {
                    ((ICoolor_ModifyUserPwd.IVew)view).getModifyUserPwdSuccess(loginBean);
                }
            }
        });
    }
}
