package com.bw.movie.model;

import android.util.Log;

import com.bw.movie.bean.UpLoadHeadPicBean;
import com.bw.movie.icoolor.ICoolor_UploadHeadPic;
import com.bw.movie.utils.HttpUtil;

import java.io.File;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import okhttp3.RequestBody;

public class Model_UploadHeadPic implements ICoolor_UploadHeadPic.IModel {
    @Override
    public void getUploadHeadPic(RequestBody body, final ICoolor_UploadHeadPic.UploadHeadPicCallback uploadHeadPicCallback) {
        HttpUtil.getInstance().getApis().getUpLoadHeadPicBean(body)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<UpLoadHeadPicBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        Log.i("ggg","onSubscribe");
                    }

                    @Override
                    public void onNext(UpLoadHeadPicBean upLoadHeadPicBean) {
                        Log.i("ggg","onNext");

                        uploadHeadPicCallback.getSuccess(upLoadHeadPicBean);

                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.i("ggg","onError");

                        e.printStackTrace();
                    }

                    @Override
                    public void onComplete() {
                        Log.i("ggg","onComplete");

                    }
                });
    }
}
