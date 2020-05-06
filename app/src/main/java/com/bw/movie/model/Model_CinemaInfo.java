package com.bw.movie.model;

import com.bw.movie.bean.CinemaByRegionBean;
import com.bw.movie.bean.CinemaInfoBean;
import com.bw.movie.bean.LoginBean;
import com.bw.movie.bean.RegionListBean;
import com.bw.movie.icoolor.ICoolor_CinemaByRegion;
import com.bw.movie.icoolor.ICoolor_CinemaInfo;
import com.bw.movie.utils.HttpUtil;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class Model_CinemaInfo implements ICoolor_CinemaInfo.IModel {

    @Override
    public void getCinemaInfo(int cinemaId, final ICoolor_CinemaInfo.CinemaInfoCallback cinemaInfoCallback) {
        HttpUtil.getInstance().getApis().getCinemaInfo(cinemaId)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<CinemaInfoBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(CinemaInfoBean cinemaInfoBean) {
                        cinemaInfoCallback.getSuccess(cinemaInfoBean);
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
    public void getFollowCinema(int cinemaId, final ICoolor_CinemaInfo.FollowCinemaCallback followCinemaCallback) {
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
    public void getCancelFollowCinemaSuccess(int cinemaId, final ICoolor_CinemaInfo.CancelFollowCinemaCallback cancelFollowCinemaCallback) {
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
