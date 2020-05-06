package com.bw.movie.icoolor;

import com.bw.movie.base.IBaseView;
import com.bw.movie.bean.CinemaScheduleListBean;

public interface ICoolor_CinemaScheduleList {
    interface IVew extends IBaseView{
        void getCinemaScheduleListSuccess(CinemaScheduleListBean cinemaScheduleListBean);
    }
    interface IPresenter{
        void getCinemaScheduleList(int cinemaId,int page,int count);
    }
    interface IModel{
        void getCinemaScheduleList(int cinemaId,int page,int count,CinemaScheduleListCallback cinemaScheduleListCallback);
    }
    interface CinemaScheduleListCallback{
        void getSuccess(CinemaScheduleListBean cinemaScheduleListBean);
    }
}
