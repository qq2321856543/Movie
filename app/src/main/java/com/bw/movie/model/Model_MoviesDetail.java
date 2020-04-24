package com.bw.movie.model;

import android.util.Log;

import com.bw.movie.bean.Moview_MoviesDetail;
import com.bw.movie.icoolor.ICoolor_MoviesDetail;
import com.bw.movie.utils.HttpUtil;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class Model_MoviesDetail implements ICoolor_MoviesDetail.IModel {
    @Override
    public void getMoviesDetail(int movieId, final ICoolor_MoviesDetail.MoviesDetailCallback moviesDetailCallback) {
        HttpUtil.getInstance().getApis().getMoviesDetail(movieId)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Moview_MoviesDetail>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        Log.i("qqq","onSubscribe");
                    }

                    @Override
                    public void onNext(Moview_MoviesDetail moviesDetail) {
                        Log.i("qqq","onNext");

                        moviesDetailCallback.getSuccess(moviesDetail);
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.i("qqq","onError");

                    }

                    @Override
                    public void onComplete() {
                        Log.i("qqq","onComplete");

                    }
                });
    }
}
