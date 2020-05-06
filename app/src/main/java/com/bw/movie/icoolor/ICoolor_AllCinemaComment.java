package com.bw.movie.icoolor;

import com.bw.movie.base.IBaseView;
import com.bw.movie.bean.AllCinemaCommentBean;
import com.bw.movie.bean.LoginBean;

public interface ICoolor_AllCinemaComment {
    interface IVew extends IBaseView{
        void getAllCinemaCommentSuccess(AllCinemaCommentBean allCinemaCommentBean);
    }
    interface IPresenter{
        void getAllCinemaComment(int cinemaId,int page,int count);

    }
    interface IModel{
        void getAllCinemaComment(int cinemaId,int page,int count, AllCinemaCommenttCallback allCinemaCommenttCallback);
    }

    interface AllCinemaCommenttCallback{
        void getSuccess(AllCinemaCommentBean allCinemaCommentBean);
    }

}
