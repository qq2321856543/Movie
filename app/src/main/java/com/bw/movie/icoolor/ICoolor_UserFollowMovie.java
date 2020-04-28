package com.bw.movie.icoolor;

import com.bw.movie.base.IBaseView;
import com.bw.movie.bean.Moview_MoviesDetail;
import com.bw.movie.bean.RegisterBean;
import com.bw.movie.bean.UserFollowMovieBean;

public interface ICoolor_UserFollowMovie {
    interface IVew extends IBaseView{
        //用户关注
        void getUserFollowMovieSuccess(UserFollowMovieBean userFollowMovieBean);


    }
    interface IPresenter{

        //用户关注
        void getUserFollowMovie(int page,int count);
    }
    interface IModel{

        //用户关注
        void getUserFollowMovie(int page,int count,UserFollowMovieBean userFollowMovieBean);
    }

    interface UserFollowMovieCallback{
        void getSuccess(UserFollowMovieBean userFollowMovieBean);
    }

}
