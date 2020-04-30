package com.bw.movie.presenter;

import com.bw.movie.base.BasePresenter;
import com.bw.movie.base.IBaseView;
import com.bw.movie.bean.BannerBean;
import com.bw.movie.bean.Movie_ComingSoonMovie;
import com.bw.movie.bean.Movie_HotMovieBean;
import com.bw.movie.bean.Movie_ReleaseMovieBean;
import com.bw.movie.bean.Moview_MoviesDetail;
import com.bw.movie.bean.RegisterBean;
import com.bw.movie.bean.UserFollowMovieBean;
import com.bw.movie.icoolor.ICoolor_Movie;
import com.bw.movie.icoolor.ICoolor_UserFollowMovie;
import com.bw.movie.model.Model_Movie;
import com.bw.movie.model.Model_UserFollowMovie;

public class Presenter_UserFollowMovie extends BasePresenter implements ICoolor_UserFollowMovie.IPresenter {


    private Model_UserFollowMovie model;

    public Presenter_UserFollowMovie(IBaseView iBaseView) {
        super(iBaseView);
    }

    @Override
    protected void initModel() {
        model = new Model_UserFollowMovie();
    }

    @Override
    public void getUserFollowMovie(int page, int count) {
        model.getUserFollowMovie(page, count, new ICoolor_UserFollowMovie.UserFollowMovieCallback() {
            @Override
            public void getSuccess(UserFollowMovieBean userFollowMovieBean) {
                IBaseView view = getView();
                if (view!=null){
                    ((ICoolor_UserFollowMovie.IVew)view).getUserFollowMovieSuccess(userFollowMovieBean);
                }
            }
        });
    }
}
