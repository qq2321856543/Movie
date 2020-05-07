package com.bw.movie.model;

import com.bw.movie.bean.MyMovieCommentListBean;
import com.bw.movie.icoolor.ICoolor_MyMovieCommentList;
import com.bw.movie.utils.HttpUtil;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class Model_MyMovieCommentList implements ICoolor_MyMovieCommentList.IModel {
    @Override
    public void getMyMovieCommentList(int page, int count, final ICoolor_MyMovieCommentList.MyMovieCommentListCallback myMovieCommentListCallback) {
        HttpUtil.getInstance().getApis().getMyMovieCommentList(page,count)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<MyMovieCommentListBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(MyMovieCommentListBean myMovieCommentListBean) {
                        myMovieCommentListCallback.getSuccess(myMovieCommentListBean);

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
