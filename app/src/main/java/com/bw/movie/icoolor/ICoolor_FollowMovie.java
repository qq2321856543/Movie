package com.bw.movie.icoolor;

import com.bw.movie.base.IBaseView;
import com.bw.movie.bean.BannerBean;
import com.bw.movie.bean.Movie_ComingSoonMovie;
import com.bw.movie.bean.Movie_HotMovieBean;
import com.bw.movie.bean.Movie_ReleaseMovieBean;
import com.bw.movie.bean.Moview_MoviesDetail;
import com.bw.movie.bean.RegisterBean;

public interface ICoolor_FollowMovie {
    interface IVew extends IBaseView{
        //电影详情
        void getMoviesDetailSuccess(Moview_MoviesDetail moviesDetail);
        //关注电影
        void getFollowMovieSuccess(RegisterBean registerBean);
        //取消关注
        void getCancelFollowMovie(RegisterBean registerBean);

    }
    interface IPresenter{

        //电影详情
        void getMoviesDetail(int movieId);
        //关注电影
        void getFollowMovieSuccess(int movieId);
        //取消关注
        void getCancelFollowMovie(int movieId);
    }
    interface IModel{

        //电影详情
        void getMoviesDetail(int movieId, MoviesDetailCallback moviesDetailCallback);
        //关注电影
        void getFollowMovieSuccess(int movieId,FollowMovieCallback followMovieCallback);
        //取消关注
        void getCancelFollowMovie(int movieId,CancelFollowMovieCallback cancelFollowMovieCallback);
    }

    interface MoviesDetailCallback{
        void getSuccess(Moview_MoviesDetail moviesDetail);
    }
    interface FollowMovieCallback{
        void getSuccess(RegisterBean registerBean);
    }
    interface CancelFollowMovieCallback{
        void getSuccess(RegisterBean registerBean);
    }
}
