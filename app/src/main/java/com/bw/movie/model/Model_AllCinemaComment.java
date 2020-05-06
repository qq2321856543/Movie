package com.bw.movie.model;

import com.bw.movie.bean.AllCinemaCommentBean;
import com.bw.movie.icoolor.ICoolor_AllCinemaComment;
import com.bw.movie.utils.HttpUtil;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class Model_AllCinemaComment implements ICoolor_AllCinemaComment.IModel {
    @Override
    public void getAllCinemaComment(int cinemaId, int page, int count, final ICoolor_AllCinemaComment.AllCinemaCommenttCallback allCinemaCommenttCallback) {
        HttpUtil.getInstance().getApis().getAllCinemaComment(cinemaId,page,count)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<AllCinemaCommentBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(AllCinemaCommentBean allCinemaCommentBean) {
                        allCinemaCommenttCallback.getSuccess(allCinemaCommentBean);

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
