package com.bw.movie.presenter;

import com.bw.movie.base.BasePresenter;
import com.bw.movie.base.IBaseView;
import com.bw.movie.bean.RegisterBean;
import com.bw.movie.icoolor.ICoolor_Newpwd;
import com.bw.movie.model.Model_Newpwd;

public class Presenter_Newpwd extends BasePresenter implements ICoolor_Newpwd.IPresenter {

    private Model_Newpwd model;

    public Presenter_Newpwd(IBaseView iBaseView) {
        super(iBaseView);
    }

    @Override
    protected void initModel() {
        model = new Model_Newpwd();
    }

    @Override
    public void getNewpwd(String oldPwd, String newPwd, String newPwd2) {
        model.getNewpwd(oldPwd, newPwd, newPwd2, new ICoolor_Newpwd.NewpwdCallback() {
            @Override
            public void getSuccess(RegisterBean registerBean) {
                IBaseView view = getView();
                if (view!=null){
                    ((ICoolor_Newpwd.IView)view).getNewpwdSuccess(registerBean);
                }
            }
        });
    }
}
