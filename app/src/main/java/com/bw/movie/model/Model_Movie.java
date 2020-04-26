package com.bw.movie.model;

import com.bw.movie.bean.BannerBean;
import com.bw.movie.bean.Movie_ComingSoonMovie;
import com.bw.movie.bean.Movie_HotMovieBean;
import com.bw.movie.bean.Movie_ReleaseMovieBean;
import com.bw.movie.bean.Moview_MoviesDetail;
import com.bw.movie.bean.RegisterBean;
import com.bw.movie.icoolor.ICoolor_Movie;
import com.bw.movie.utils.HttpUtil;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class Model_Movie implements ICoolor_Movie.IModel {
    @Override
    public void getReleaseMovieList(int page, int count, final ICoolor_Movie.ReleaseMovieCallback releaseMovieCallback) {
        HttpUtil.getInstance().getApis().getReleaseMovieList(page,count)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Movie_ReleaseMovieBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(Movie_ReleaseMovieBean movie_releaseMovieBean) {
                        releaseMovieCallback.getSuccess(movie_releaseMovieBean);
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
    public void getComingSoonMovieList(int page, int count, final ICoolor_Movie.ComingSoonMovieCallback comingSoonMovieCallback) {
        HttpUtil.getInstance().getApis().getComingSoonMovieList(page,count)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Movie_ComingSoonMovie>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(Movie_ComingSoonMovie comingSoonMovie) {
                        comingSoonMovieCallback.getSuccess(comingSoonMovie);
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
    public void getHotMovieList(int page, int count, final ICoolor_Movie.HotMovieCallback hotMovieCallback) {
        HttpUtil.getInstance().getApis().getHotMovieList(page,count)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Movie_HotMovieBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(Movie_HotMovieBean hotMovieBean) {
                        hotMovieCallback.getSuccess(hotMovieBean);
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
    public void getXbanner(final ICoolor_Movie.BannerCallback bannerCallback) {
        HttpUtil.getInstance().getApis().getBanner()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<BannerBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(BannerBean bannerBean) {
                        bannerCallback.getSuccess(bannerBean);
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
    public void getMoviesDetail(int movieId, final ICoolor_Movie.MoviesDetailCallback moviesDetailCallback) {
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
    public void getReserve(int movieId, final ICoolor_Movie.ReserveCallback reserveCallback) {
        HttpUtil.getInstance().getApis().getReserve(movieId)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<RegisterBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(RegisterBean registerBean) {
                        reserveCallback.getSuccess(registerBean);
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
