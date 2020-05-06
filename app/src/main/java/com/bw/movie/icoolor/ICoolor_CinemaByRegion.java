package com.bw.movie.icoolor;

import com.bw.movie.base.IBaseView;
import com.bw.movie.bean.CinemaByRegionBean;
import com.bw.movie.bean.NearbyCinemasBean;
import com.bw.movie.bean.RegionListBean;

public interface ICoolor_CinemaByRegion {
    interface IVew extends IBaseView{
        void getCinemaByRegionSuccess(CinemaByRegionBean cinemaByRegionBean);
        void getRegionListSuccess(RegionListBean regionListBean);
    }
    interface IPresenter{
        void getCinemaByRegion(int regionId);
        void getRegionList();
    }
    interface IModel{
        void getCinemaByRegion(int regionId, CinemaByRegionCallback cinemaByRegionCallback);
        void getRegionList(RegionListCallback regionListCallback);

    }
    interface CinemaByRegionCallback{
        void getSuccess(CinemaByRegionBean cinemaByRegionBean);
    }
    interface RegionListCallback{
        void getSuccess(RegionListBean regionListBean);
    }
}
