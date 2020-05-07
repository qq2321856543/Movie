package com.bw.movie.model;

import com.bw.movie.bean.UserReserveBean;
import com.bw.movie.icoolor.ICoolor_UserReserve;
import com.bw.movie.utils.HttpUtil;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class Model_UserReserve implements ICoolor_UserReserve.IModel {
    @Override
    public void getUserReserve(final ICoolor_UserReserve.UserReserveCallback userReserveCallback) {
        HttpUtil.getInstance().getApis().getUserReserve()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<UserReserveBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(UserReserveBean userReserveBean) {
                        userReserveCallback.getSuccess(userReserveBean);

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
