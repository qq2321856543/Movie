package com.bw.movie.model;

import com.bw.movie.bean.LoginBean;
import com.bw.movie.icoolor.ICoolor_RecordFeedBack;
import com.bw.movie.utils.HttpUtil;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class Model_RecordFeedBack implements ICoolor_RecordFeedBack.IModel {
    @Override
    public void getRecordFeedBack(String content, final ICoolor_RecordFeedBack.RecordFeedBackCallback recordFeedBackCallback) {
        HttpUtil.getInstance().getApis().getRecordFeedBack(content)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<LoginBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(LoginBean loginBean) {
                        recordFeedBackCallback.getSuccess(loginBean);

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
