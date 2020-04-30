package com.bw.movie.model;

import com.bw.movie.bean.UserFollowMovieBean;
import com.bw.movie.icoolor.ICoolor_UserFollowMovie;
import com.bw.movie.utils.HttpUtil;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class Model_UserFollowMovie implements ICoolor_UserFollowMovie.IModel {
    @Override
    public void getUserFollowMovie(int page, int count, final ICoolor_UserFollowMovie.UserFollowMovieCallback userFollowMovieCallback) {
        HttpUtil.getInstance().getApis().getUserFollowMovie(page,count)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<UserFollowMovieBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(UserFollowMovieBean userFollowMovieBean) {
                        userFollowMovieCallback.getSuccess(userFollowMovieBean);
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
