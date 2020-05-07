package com.bw.movie.icoolor;

import com.bw.movie.base.IBaseView;
import com.bw.movie.bean.DateListBean;
import com.bw.movie.bean.MyMovieCommentListBean;

public interface ICoolor_MyMovieCommentList {
    interface IVew extends IBaseView{
        void getMyMovieCommentListSuccess(MyMovieCommentListBean myMovieCommentListBean);
    }
    interface IPersenter{
        void getMyMovieCommentList(int page,int count);
    }
    interface IModel{
        void getMyMovieCommentList(int page,int count,MyMovieCommentListCallback myMovieCommentListCallback);
    }
    interface MyMovieCommentListCallback{
        void getSuccess(MyMovieCommentListBean myMovieCommentListBean);
    }
}
