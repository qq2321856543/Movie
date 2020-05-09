package com.bw.movie.presenter;

import com.bw.movie.base.BasePresenter;
import com.bw.movie.base.IBaseView;
import com.bw.movie.bean.UpLoadHeadPicBean;
import com.bw.movie.icoolor.ICoolor_UploadHeadPic;
import com.bw.movie.model.Model_UploadHeadPic;

import java.io.File;

import okhttp3.RequestBody;

public class Presenter_UploadHeadPic extends BasePresenter implements ICoolor_UploadHeadPic.IPersenter {

    private Model_UploadHeadPic model;

    public Presenter_UploadHeadPic(IBaseView iBaseView) {
        super(iBaseView);
    }

    @Override
    protected void initModel() {
        model = new Model_UploadHeadPic();
    }

    @Override
    public void getUploadHeadPic(RequestBody body) {
        model.getUploadHeadPic(body, new ICoolor_UploadHeadPic.UploadHeadPicCallback() {
            @Override
            public void getSuccess(UpLoadHeadPicBean upLoadHeadPicBean) {
                IBaseView view = getView();
                if (view != null) {
                    ((ICoolor_UploadHeadPic.IVew)view).getUploadHeadPicSuccess(upLoadHeadPicBean);
                }
            }
        });
    }
}
