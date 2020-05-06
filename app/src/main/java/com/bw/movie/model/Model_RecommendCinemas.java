package com.bw.movie.model;

import com.bw.movie.bean.RecommendCinemasBean;
import com.bw.movie.icoolor.ICoolor_RecommendCinemas;
import com.bw.movie.utils.HttpUtil;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class Model_RecommendCinemas implements ICoolor_RecommendCinemas.IModel {
    @Override
    public void getRecommendCinemas(int page, int count, final ICoolor_RecommendCinemas.RecommendCinemasCallback recommendCinemasCallback) {
        HttpUtil.getInstance().getApis().getRecommendCinemasBean(page,count)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<RecommendCinemasBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(RecommendCinemasBean recommendCinemasBean) {
                        recommendCinemasCallback.getSuccess(recommendCinemasBean);
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
