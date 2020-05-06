package com.bw.movie.icoolor;

import com.bw.movie.base.IBaseView;
import com.bw.movie.bean.CinemaByRegionBean;
import com.bw.movie.bean.CinemaInfoBean;
import com.bw.movie.bean.LoginBean;
import com.bw.movie.bean.RegionListBean;

public interface ICoolor_CinemaInfo {
    interface IVew extends IBaseView{
        void getCinemaInfoSuccess(CinemaInfoBean cinemaInfoBean);
        //关注影院
        void getFollowCinemaSuccess(LoginBean loginBean);
        //取消关注影院
        void getCancelFollowCinemaSuccess(LoginBean loginBean);
    }
    interface IPresenter{
        void getCinemaInfo(int cinemaId);
        void getFollowCinema(int cinemaId);
        void getCancelFollowCinemaSuccess(int cinemaId);
    }
    interface IModel{
        void getCinemaInfo(int cinemaId, CinemaInfoCallback cinemaInfoCallback);
        void getFollowCinema(int cinemaId,FollowCinemaCallback followCinemaCallback);
        void getCancelFollowCinemaSuccess(int cinemaId,CancelFollowCinemaCallback cancelFollowCinemaCallback);

    }
    interface CinemaInfoCallback{
        void getSuccess(CinemaInfoBean cinemaInfoBean);
    }
    interface FollowCinemaCallback{
        void getSuccess(LoginBean loginBean);
    }
    interface CancelFollowCinemaCallback{
        void getSuccess(LoginBean loginBean);
    }

}
