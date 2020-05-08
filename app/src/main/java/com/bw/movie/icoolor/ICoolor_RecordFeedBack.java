package com.bw.movie.icoolor;

import com.bw.movie.base.IBaseView;
import com.bw.movie.bean.DateListBean;
import com.bw.movie.bean.LoginBean;

public interface ICoolor_RecordFeedBack {
    interface IVew extends IBaseView{
        void getRecordFeedBackSuccess(LoginBean loginBean);
    }
    interface IPersenter{
        void getRecordFeedBack(String content);
    }
    interface IModel{
        void getRecordFeedBack(String content,RecordFeedBackCallback recordFeedBackCallback);
    }
    interface RecordFeedBackCallback{
        void getSuccess(LoginBean loginBean);
    }
}
