package com.bw.movie.icoolor;

import com.bw.movie.base.IBaseView;
import com.bw.movie.bean.NearbyCinemasBean;
import com.bw.movie.bean.RecommendCinemasBean;

public interface ICoolor_NearbyCinemas {
    interface IVew extends IBaseView{
        void getNearbyCinemasSuccess(NearbyCinemasBean nearbyCinemasBean);
    }
    interface IPresenter{
        void getNearbyCinemas(String longitude,String latitude,int page, int count);
    }
    interface IModel{
        void getNearbyCinemas(String longitude,String latitude,int page, int count, NearbyCinemasCallback nearbyCinemasCallback);
    }
    interface NearbyCinemasCallback{
        void getSuccess(NearbyCinemasBean nearbyCinemasBean);
    }
}
