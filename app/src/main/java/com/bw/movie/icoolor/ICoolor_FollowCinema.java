package com.bw.movie.icoolor;

import com.bw.movie.base.IBaseView;
import com.bw.movie.bean.CinemaInfoBean;
import com.bw.movie.bean.LoginBean;

public interface ICoolor_FollowCinema {
    interface IVew extends IBaseView{
        void getFollowCinemaSuccess(LoginBean loginBean);
        void getCancelFollowCinemaSuccess(LoginBean loginBean);
    }
    interface IPresenter{
        void getFollowCinema(int cinemaId);
        void getCancelFollowCinemaSuccess(int cinemaId);

    }
    interface IModel{
        void getFollowCinema(int cinemaId,FollowCinemaCallback followCinemaCallback);
        void getCancelFollowCinemaSuccess(int cinemaId,CancelFollowCinemaCallback cancelFollowCinemaCallback);
    }
    interface FollowCinemaCallback{
        void getSuccess(LoginBean loginBean);
    }
    interface CancelFollowCinemaCallback{
        void getSuccess(LoginBean loginBean);
    }

}
