package com.bw.movie.model;

import com.bw.movie.bean.Search_MovieByKeywordBean;
import com.bw.movie.icoolor.ICoolor_Search;
import com.bw.movie.utils.HttpUtil;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class Model_Search implements ICoolor_Search.IModel {
    @Override
    public void getSearch_MovieByKeyword(String keyword, int page, int count, final ICoolor_Search.Search_MovieByKeywordCallback movieByKeywordCallback) {
        HttpUtil.getInstance().getApis().getSearch_MovieByKeyword(keyword,page,count)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Search_MovieByKeywordBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(Search_MovieByKeywordBean movieByKeywordBean) {
                        movieByKeywordCallback.getSuccess(movieByKeywordBean);
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
