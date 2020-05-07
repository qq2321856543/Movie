package com.bw.movie.icoolor;

import com.bw.movie.base.IBaseView;
import com.bw.movie.bean.DateListBean;
import com.bw.movie.bean.UserReserveBean;

public interface ICoolor_UserReserve {
    interface IVew extends IBaseView{
        void getUserReserveSuccess(UserReserveBean userReserveBean);
    }
    interface IPersenter{
        void getUserReserve();
    }
    interface IModel{
        void getUserReserve(UserReserveCallback userReserveCallback);
    }
    interface UserReserveCallback{
        void getSuccess(UserReserveBean userReserveBean);
    }
}
