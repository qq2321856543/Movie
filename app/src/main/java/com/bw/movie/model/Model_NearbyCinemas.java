package com.bw.movie.model;

import com.bw.movie.bean.NearbyCinemasBean;
import com.bw.movie.bean.RecommendCinemasBean;
import com.bw.movie.icoolor.ICoolor_NearbyCinemas;
import com.bw.movie.icoolor.ICoolor_RecommendCinemas;
import com.bw.movie.utils.HttpUtil;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class Model_NearbyCinemas implements ICoolor_NearbyCinemas.IModel {

    @Override
    public void getNearbyCinemas(String longitude, String latitude, int page, int count, final ICoolor_NearbyCinemas.NearbyCinemasCallback nearbyCinemasCallback) {
        HttpUtil.getInstance().getApis().getNearbyCinemasBean(longitude,latitude,page,count)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<NearbyCinemasBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(NearbyCinemasBean nearbyCinemasBean) {
                        nearbyCinemasCallback.getSuccess(nearbyCinemasBean);
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
