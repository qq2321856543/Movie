package com.bw.movie.icoolor;

import com.bw.movie.base.IBaseView;
import com.bw.movie.bean.DateListBean;

public interface ICoolor_DateList {
    interface IVew extends IBaseView{
        void getDataListSuccess(DateListBean dateListBean);
    }
    interface IPersenter{
        void getDataList();
    }
    interface IModel{
        void getDataList(DataListCallback dataListCallback);
    }
    interface DataListCallback{
        void getSuccess(DateListBean dateListBean);
    }
}
