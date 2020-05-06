package com.bw.movie.model;

import com.bw.movie.bean.CinemaScheduleListBean;
import com.bw.movie.icoolor.ICoolor_CinemaScheduleList;
import com.bw.movie.utils.HttpUtil;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class Model_CinemaScheduleList implements ICoolor_CinemaScheduleList.IModel {
    @Override
    public void getCinemaScheduleList(int cinemaId, int page, int count, final ICoolor_CinemaScheduleList.CinemaScheduleListCallback cinemaScheduleListCallback) {
        HttpUtil.getInstance().getApis().getCinemaScheduleList(cinemaId,page,count)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<CinemaScheduleListBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(CinemaScheduleListBean cinemaScheduleListBean) {
                        cinemaScheduleListCallback.getSuccess(cinemaScheduleListBean);

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
