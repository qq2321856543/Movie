package com.bw.movie.model;

import com.bw.movie.bean.CinemaByRegionBean;
import com.bw.movie.bean.RegionListBean;
import com.bw.movie.icoolor.ICoolor_CinemaByRegion;
import com.bw.movie.utils.HttpUtil;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class Model_CinemaByRegion implements ICoolor_CinemaByRegion.IModel {
    @Override
    public void getCinemaByRegion(int regionId, final ICoolor_CinemaByRegion.CinemaByRegionCallback cinemaByRegionCallback) {
        HttpUtil.getInstance().getApis().getCinemaByRegion(regionId)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<CinemaByRegionBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(CinemaByRegionBean cinemaByRegionBean) {
                        cinemaByRegionCallback.getSuccess(cinemaByRegionBean);

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
    public void getRegionList(final ICoolor_CinemaByRegion.RegionListCallback regionListCallback) {
        HttpUtil.getInstance().getApis().getRegionList()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<RegionListBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(RegionListBean regionListBean) {
                        regionListCallback.getSuccess(regionListBean);

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
