package com.bw.movie.icoolor;

import com.bw.movie.base.IBaseView;
import com.bw.movie.bean.DateListBean;
import com.bw.movie.bean.LoginBean;

public interface ICoolor_MovieComment {
    interface IVew extends IBaseView{
        void getMovieCommentSuccess(LoginBean loginBean);
    }
    interface IPersenter{
        void getMovieComment(int movieId,String commentContent,double score);
    }
    interface IModel{
        void getMovieComment(int movieId,String commentContent,double score,MovieCommentCallback movieCommentCallback);
    }
    interface MovieCommentCallback{
        void getSuccess(LoginBean loginBean);
    }
}
