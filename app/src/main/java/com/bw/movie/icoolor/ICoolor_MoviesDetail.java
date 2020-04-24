package com.bw.movie.icoolor;

import com.bw.movie.base.IBaseView;
import com.bw.movie.bean.BannerBean;
import com.bw.movie.bean.Movie_ComingSoonMovie;
import com.bw.movie.bean.Movie_HotMovieBean;
import com.bw.movie.bean.Movie_ReleaseMovieBean;
import com.bw.movie.bean.Moview_MoviesDetail;

/**
 * 电影详情
 */
public interface ICoolor_MoviesDetail {
    interface IVew extends IBaseView{
       //电影详情
        void getMoviesDetailSuccess(Moview_MoviesDetail moviesDetail);
    }
    interface IPresenter{
        //电影详情
        void getMoviesDetail(int movieId);
    }
    interface IModel{
        //电影详情
        void getMoviesDetail(int movieId,MoviesDetailCallback moviesDetailCallback);
    }
    interface MoviesDetailCallback{
        void getSuccess(Moview_MoviesDetail moviesDetail);
    }

}
