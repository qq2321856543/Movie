package com.bw.movie.model;

import com.bw.movie.bean.BannerBean;
import com.bw.movie.bean.Movie_ComingSoonMovie;
import com.bw.movie.bean.Movie_HotMovieBean;
import com.bw.movie.bean.Movie_ReleaseMovieBean;
import com.bw.movie.bean.Moview_MoviesDetail;
import com.bw.movie.bean.RegisterBean;
import com.bw.movie.icoolor.ICoolor_FollowMovie;
import com.bw.movie.icoolor.ICoolor_Movie;
import com.bw.movie.utils.HttpUtil;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class Model_FollowMovie implements ICoolor_FollowMovie.IModel {


    @Override
    public void getMoviesDetail(int movieId, final ICoolor_FollowMovie.MoviesDetailCallback moviesDetailCallback) {
        HttpUtil.getInstance().getApis().getMoviesDetail(movieId)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Moview_MoviesDetail>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(Moview_MoviesDetail moviesDetail) {
                        moviesDetailCallback.getSuccess(moviesDetail);
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
    public void getFollowMovieSuccess(int movieId, final ICoolor_FollowMovie.FollowMovieCallback followMovieCallback) {
        HttpUtil.getInstance().getApis().getFollowMovie(movieId)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<RegisterBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(RegisterBean registerBean) {
                        followMovieCallback.getSuccess(registerBean);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                }) ;
    }

    @Override
    public void getCancelFollowMovie(int movieId, final ICoolor_FollowMovie.CancelFollowMovieCallback cancelFollowMovieCallback) {
            HttpUtil.getInstance().getApis().getCancelFollowMovie(movieId)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new Observer<RegisterBean>() {
                        @Override
                        public void onSubscribe(Disposable d) {

                        }

                        @Override
                        public void onNext(RegisterBean registerBean) {
                            cancelFollowMovieCallback.getSuccess(registerBean);
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
