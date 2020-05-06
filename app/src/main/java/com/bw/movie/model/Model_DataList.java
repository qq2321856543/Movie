package com.bw.movie.model;

import com.bw.movie.bean.DateListBean;
import com.bw.movie.icoolor.ICoolor_DateList;
import com.bw.movie.utils.HttpUtil;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class Model_DataList implements ICoolor_DateList.IModel {
    @Override
    public void getDataList(final ICoolor_DateList.DataListCallback dataListCallback) {
        HttpUtil.getInstance().getApis().getDataList()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<DateListBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(DateListBean dateListBean) {
                        dataListCallback.getSuccess(dateListBean);

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
