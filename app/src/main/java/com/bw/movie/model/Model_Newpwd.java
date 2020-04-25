package com.bw.movie.model;

import com.bw.movie.bean.RegisterBean;
import com.bw.movie.icoolor.ICoolor_Newpwd;
import com.bw.movie.utils.HttpUtil;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class Model_Newpwd implements ICoolor_Newpwd.IModel {
    @Override
    public void getNewpwd(String oldPwd, String newPwd, String newPwd2, final ICoolor_Newpwd.NewpwdCallback newpwdCallback) {
        HttpUtil.getInstance().getApis().getNewpwd(oldPwd,newPwd,newPwd2)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<RegisterBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(RegisterBean registerBean) {
                        newpwdCallback.getSuccess(registerBean);
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
