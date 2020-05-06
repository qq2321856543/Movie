package com.bw.movie.model;

import com.bw.movie.bean.LoginBean;
import com.bw.movie.icoolor.ICoolor_FollowCinema;
import com.bw.movie.utils.HttpUtil;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class Model_FollowCinema implements ICoolor_FollowCinema.IModel {
    @Override
    public void getFollowCinema(int cinemaId, final ICoolor_FollowCinema.FollowCinemaCallback followCinemaCallback) {
        HttpUtil.getInstance().getApis().getfollowCinema(cinemaId)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<LoginBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(LoginBean loginBean) {
                        followCinemaCallback.getSuccess(loginBean);

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    @Override
    public void getCancelFollowCinemaSuccess(int cinemaId, final ICoolor_FollowCinema.CancelFollowCinemaCallback cancelFollowCinemaCallback) {
        HttpUtil.getInstance().getApis().getcancelFollowCinema(cinemaId)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<LoginBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(LoginBean loginBean) {
                        cancelFollowCinemaCallback.getSuccess(loginBean);

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
