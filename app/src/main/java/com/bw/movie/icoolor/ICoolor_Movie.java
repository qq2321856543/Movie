package com.bw.movie.icoolor;

import com.bw.movie.base.IBaseView;
import com.bw.movie.bean.BannerBean;
import com.bw.movie.bean.Movie_ComingSoonMovie;
import com.bw.movie.bean.Movie_HotMovieBean;
import com.bw.movie.bean.Movie_ReleaseMovieBean;
import com.bw.movie.bean.Moview_MoviesDetail;

public interface ICoolor_Movie {
    interface IVew extends IBaseView{
        //正在热映
        void getReleaseMovieSuccess(Movie_ReleaseMovieBean releaseMovieBean);
        //即将上映
        void getComingSoonMovieSuccess(Movie_ComingSoonMovie comingSoonMovie);
        //热门电影
        void getHotMovieSuccess(Movie_HotMovieBean hotMovieBean);
        //轮播
        void getXbanner(BannerBean bannerBean);
        //电影详情
        void getMoviesDetailSuccess(Moview_MoviesDetail moviesDetail);
    }
    interface IPresenter{
        //正在热映
        void getReleaseMovieList(int page,int count);
        //即将上映
        void getComingSoonMovieList(int page,int count);
        //热门电影
        void getHotMovieList(int page,int count);
        //轮播
        void getXbanner();
        //电影详情
        void getMoviesDetail(int movieId);
    }
    interface IModel{
        //正在热映
        void getReleaseMovieList(int page,int count,ReleaseMovieCallback releaseMovieCallback);
        //即将上映
        void getComingSoonMovieList(int page,int count,ComingSoonMovieCallback comingSoonMovieCallback);
        //热门电影
        void getHotMovieList(int page,int count,HotMovieCallback hotMovieCallback);
        //轮播
        void getXbanner(BannerCallback bannerCallback);
        //电影详情
        void getMoviesDetail(int movieId,MoviesDetailCallback moviesDetailCallback);
    }
    interface ReleaseMovieCallback{
        void getSuccess(Movie_ReleaseMovieBean releaseMovieBean);
    }
    interface ComingSoonMovieCallback{
        void getSuccess(Movie_ComingSoonMovie comingSoonMovie);
    }
    interface HotMovieCallback{
        void getSuccess(Movie_HotMovieBean hotMovieBean);
    }
    interface BannerCallback{
        void getSuccess(BannerBean bannerBean);
    }
    interface MoviesDetailCallback{
        void getSuccess(Moview_MoviesDetail moviesDetail);
    }
}
