package com.bw.movie.model;

import com.bw.movie.bean.YingPingBean;
import com.bw.movie.icoolor.HomePageYingPingContral;
import com.bw.movie.utils.HttpUtil;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class HomePageYingPingModel implements HomePageYingPingContral.getModel {
    @Override
    public void getYingPing(int movieId, int page, int count, final CallBackYingPing callBackYingPing) {
        HttpUtil.getInstance().getApis().getYingPing(movieId,page,count)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<YingPingBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(YingPingBean yingPingBean) {
                        callBackYingPing.getYingPingSucc(yingPingBean);
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
