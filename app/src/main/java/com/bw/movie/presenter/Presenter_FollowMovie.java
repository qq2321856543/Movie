package com.bw.movie.presenter;

import com.bw.movie.base.BasePresenter;
import com.bw.movie.base.IBaseView;
import com.bw.movie.bean.BannerBean;
import com.bw.movie.bean.Movie_ComingSoonMovie;
import com.bw.movie.bean.Movie_HotMovieBean;
import com.bw.movie.bean.Movie_ReleaseMovieBean;
import com.bw.movie.bean.Moview_MoviesDetail;
import com.bw.movie.bean.RegisterBean;
import com.bw.movie.icoolor.ICoolor_FollowMovie;
import com.bw.movie.icoolor.ICoolor_Movie;
import com.bw.movie.model.Model_FollowMovie;
import com.bw.movie.model.Model_Movie;

public class Presenter_FollowMovie extends BasePresenter implements ICoolor_FollowMovie.IPresenter {


    private Model_FollowMovie model;

    public Presenter_FollowMovie(IBaseView iBaseView) {
        super(iBaseView);
    }

    @Override
    protected void initModel() {
        model = new Model_FollowMovie();
    }

    @Override
    public void getMoviesDetail(int movieId) {
        model.getMoviesDetail(movieId, new ICoolor_FollowMovie.MoviesDetailCallback() {
            @Override
            public void getSuccess(Moview_MoviesDetail moviesDetail) {
                IBaseView view = getView();
                if (view!=null){
                    ((ICoolor_FollowMovie.IVew)view).getMoviesDetailSuccess(moviesDetail);
                }
            }
        });
    }

    @Override
    public void getFollowMovieSuccess(int movieId) {
        model.getFollowMovieSuccess(movieId, new ICoolor_FollowMovie.FollowMovieCallback() {
            @Override
            public void getSuccess(RegisterBean registerBean) {
                IBaseView view = getView();
                if (view!=null){
                    ((ICoolor_FollowMovie.IVew)view).getFollowMovieSuccess(registerBean);
                }
            }
        });
    }

    @Override
    public void getCancelFollowMovie(int movieId) {
        model.getCancelFollowMovie(movieId, new ICoolor_FollowMovie.CancelFollowMovieCallback() {
            @Override
            public void getSuccess(RegisterBean registerBean) {
                IBaseView view = getView();
                if (view!=null){
                    ((ICoolor_FollowMovie.IVew)view).getCancelFollowMovie(registerBean);
                }
            }
        });
    }
}
