package com.bw.movie.model;

import com.bw.movie.activity.ModifyUserPwdActivity;
import com.bw.movie.bean.LoginBean;
import com.bw.movie.bean.RegisterBean;
import com.bw.movie.icoolor.ICoolor_ModifyUserPwd;
import com.bw.movie.utils.HttpUtil;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class Model_ModifyUserPwd implements ICoolor_ModifyUserPwd.IModel {
    @Override
    public void getModifyUserPwd(String oldPwd, String newPwd, String newPwd2, final ICoolor_ModifyUserPwd.ModifyUserPwdCallback modifyUserPwdCallback) {
        HttpUtil.getInstance().getApis().getNewpwd(oldPwd,newPwd,newPwd2)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<LoginBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(LoginBean loginBean) {
                        modifyUserPwdCallback.getSuccess(loginBean);

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
