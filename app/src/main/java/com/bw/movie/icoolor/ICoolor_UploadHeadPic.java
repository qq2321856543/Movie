package com.bw.movie.icoolor;

import com.bw.movie.base.IBaseView;
import com.bw.movie.bean.DateListBean;
import com.bw.movie.bean.UpLoadHeadPicBean;

import java.io.File;

import okhttp3.RequestBody;

public interface ICoolor_UploadHeadPic {
    interface IVew extends IBaseView{
        void getUploadHeadPicSuccess(UpLoadHeadPicBean upLoadHeadPicBean);
    }
    interface IPersenter{
        void getUploadHeadPic(RequestBody body);
    }
    interface IModel{
        void getUploadHeadPic(RequestBody body,UploadHeadPicCallback uploadHeadPicCallback);
    }
    interface UploadHeadPicCallback{
        void getSuccess(UpLoadHeadPicBean upLoadHeadPicBean);
    }
}
