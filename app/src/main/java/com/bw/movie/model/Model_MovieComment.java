package com.bw.movie.model;

import com.bw.movie.bean.LoginBean;
import com.bw.movie.icoolor.ICoolor_MovieComment;
import com.bw.movie.utils.HttpUtil;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class Model_MovieComment implements ICoolor_MovieComment.IModel {
    @Override
    public void getMovieComment(int movieId, String commentContent, double score, final ICoolor_MovieComment.MovieCommentCallback movieCommentCallback) {
        HttpUtil.getInstance().getApis().getMovieComment(movieId,commentContent,score)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<LoginBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(LoginBean loginBean) {
                        movieCommentCallback.getSuccess(loginBean);

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
