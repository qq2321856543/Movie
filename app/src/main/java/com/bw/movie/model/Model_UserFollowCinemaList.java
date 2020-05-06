package com.bw.movie.model;

import com.bw.movie.bean.UserFollowCinemaListBean;
import com.bw.movie.icoolor.ICoolor_UserFollowCinemaList;
import com.bw.movie.utils.HttpUtil;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class Model_UserFollowCinemaList implements ICoolor_UserFollowCinemaList.IModel {
    @Override
    public void getUserFollowCinemaList(int page, int count, final ICoolor_UserFollowCinemaList.UserFollowCinemaListCallback userFollowCinemaListCallback) {
        HttpUtil.getInstance().getApis().getUserFollowCinemaListBean(page,count)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<UserFollowCinemaListBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(UserFollowCinemaListBean userFollowCinemaListBean) {
                        userFollowCinemaListCallback.getSuccess(userFollowCinemaListBean);

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
