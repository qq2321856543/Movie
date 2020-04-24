package com.bw.movie.presenter;

import com.bw.movie.base.BasePresenter;
import com.bw.movie.base.IBaseView;
import com.bw.movie.bean.BannerBean;
import com.bw.movie.bean.Movie_ComingSoonMovie;
import com.bw.movie.bean.Movie_HotMovieBean;
import com.bw.movie.bean.Movie_ReleaseMovieBean;
import com.bw.movie.bean.Moview_MoviesDetail;
import com.bw.movie.icoolor.ICoolor_Movie;
import com.bw.movie.model.Model_Movie;

public class Presenter_Movie extends BasePresenter implements ICoolor_Movie.IPresenter {

    private Model_Movie model;

    public Presenter_Movie(IBaseView iBaseView) {
        super(iBaseView);
    }

    @Override
    protected void initModel() {
        model = new Model_Movie();
    }

    @Override
    public void getReleaseMovieList(int page, int count) {
        model.getReleaseMovieList(page, count, new ICoolor_Movie.ReleaseMovieCallback() {
            @Override
            public void getSuccess(Movie_ReleaseMovieBean releaseMovieBean) {
                IBaseView view = getView();
                if (view!=null&&view instanceof ICoolor_Movie.IVew){
                    ((ICoolor_Movie.IVew)view).getReleaseMovieSuccess(releaseMovieBean);
                }
            }
        });
    }

    @Override
    public void getComingSoonMovieList(int page, int count) {
        model.getComingSoonMovieList(page, count, new ICoolor_Movie.ComingSoonMovieCallback() {
            @Override
            public void getSuccess(Movie_ComingSoonMovie comingSoonMovie) {
                IBaseView view = getView();
                if (view!=null&&view instanceof ICoolor_Movie.IVew){
                    ((ICoolor_Movie.IVew)view).getComingSoonMovieSuccess(comingSoonMovie);
                }
            }
        });
    }

    @Override
    public void getHotMovieList(int page, int count) {
        model.getHotMovieList(page, count, new ICoolor_Movie.HotMovieCallback() {
            @Override
            public void getSuccess(Movie_HotMovieBean hotMovieBean) {
                IBaseView view = getView();
                if (view!=null&&view instanceof ICoolor_Movie.IVew){
                    ((ICoolor_Movie.IVew)view).getHotMovieSuccess(hotMovieBean);
                }
            }
        });
    }

    @Override
    public void getXbanner() {
        model.getXbanner(new ICoolor_Movie.BannerCallback() {
            @Override
            public void getSuccess(BannerBean bannerBean) {
                IBaseView view = getView();
                if (view!=null&&view instanceof ICoolor_Movie.IVew){
                    ((ICoolor_Movie.IVew)view).getXbanner(bannerBean);
                }
            }
        });
    }

    @Override
    public void getMoviesDetail(int movieId) {
        model.getMoviesDetail(movieId, new ICoolor_Movie.MoviesDetailCallback() {
            @Override
            public void getSuccess(Moview_MoviesDetail moviesDetail) {
                IBaseView view = getView();
                if (view!=null&&view instanceof ICoolor_Movie.IVew){
                    ((ICoolor_Movie.IVew)view).getMoviesDetailSuccess(moviesDetail);
                }
            }
        });
    }
}
