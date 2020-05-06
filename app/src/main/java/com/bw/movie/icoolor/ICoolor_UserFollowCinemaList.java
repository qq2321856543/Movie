package com.bw.movie.icoolor;

import com.bw.movie.base.IBaseView;
import com.bw.movie.bean.UserFollowCinemaListBean;

public interface ICoolor_UserFollowCinemaList {
    interface IVew extends IBaseView{
        void getUserFollowCinemaListSuccess(UserFollowCinemaListBean userFollowCinemaListBean);
    }
    interface IPresenter{
        void getUserFollowCinemaList(int page,int count);
    }
    interface IModel{
        void getUserFollowCinemaList(int page,int count,UserFollowCinemaListCallback userFollowCinemaListCallback);
    }
    interface UserFollowCinemaListCallback{
        void getSuccess(UserFollowCinemaListBean userFollowCinemaListBean);
    }
}
