package com.bw.movie.model;

import android.util.Log;

import com.bw.movie.bean.EmailCodeBean;
import com.bw.movie.bean.LoginBean;
import com.bw.movie.bean.RegisterBean;
import com.bw.movie.icoolor.ICoolor_LRE;
import com.bw.movie.utils.HttpUtil;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class Model_LRE implements ICoolor_LRE.IModel {
    @Override
    public void getEmailCode(String email, final ICoolor_LRE.EmailCodeCallback emailCodeCallback) {
        HttpUtil.getInstance().getApis().getEmailCode(email)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<EmailCodeBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                    }

                    @Override
                    public void onNext(EmailCodeBean emailCodeBean) {
                        emailCodeCallback.getSuccess(emailCodeBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        e.printStackTrace();
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    @Override
    public void getLogin(String email, String pwd, final ICoolor_LRE.LoginCallback loginCallback) {
        HttpUtil.getInstance().getApis().getLogin(email,pwd)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<LoginBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        Log.i("xxx","onSubscribe");
                    }

                    @Override
                    public void onNext(LoginBean loginBean) {
                        loginCallback.getSuccess(loginBean);
                        Log.i("xxx","onNext");

                    }

                    @Override
                    public void onError(Throwable e) {
                        e.printStackTrace();
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    @Override
    public void getRegister(String nickName, String pwd, String email, String code, final ICoolor_LRE.RegisterCallback registerCallback) {
        HttpUtil.getInstance().getApis().getRegister(nickName,pwd,email,code)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<RegisterBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(RegisterBean registerBean) {
                        registerCallback.getSuccess(registerBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        e.printStackTrace();
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    @Override
    public void getWx(String code, final ICoolor_LRE.WxCallback wxCallback) {
        HttpUtil.getInstance().getApis().getWx(code)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<LoginBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(LoginBean loginBean) {
                        wxCallback.getSuccess(loginBean);
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
