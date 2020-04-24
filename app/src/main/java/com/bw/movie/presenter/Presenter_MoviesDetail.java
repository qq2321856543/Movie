package com.bw.movie.presenter;

import android.util.Log;

import com.bw.movie.base.BasePresenter;
import com.bw.movie.base.IBaseView;
import com.bw.movie.bean.Moview_MoviesDetail;
import com.bw.movie.icoolor.ICoolor_MoviesDetail;
import com.bw.movie.model.Model_MoviesDetail;

public class Presenter_MoviesDetail extends BasePresenter implements ICoolor_MoviesDetail.IPresenter {

    private Model_MoviesDetail model;

    public Presenter_MoviesDetail(IBaseView iBaseView) {
        super(iBaseView);
    }

    @Override
    protected void initModel() {
        model = new Model_MoviesDetail();
    }

    @Override
    public void getMoviesDetail(int movieId) {
        Log.i("qqq","Pceng");
        model.getMoviesDetail(movieId, new ICoolor_MoviesDetail.MoviesDetailCallback() {
            @Override
            public void getSuccess(Moview_MoviesDetail moviesDetail) {
                IBaseView view = getView();
                if (view!=null){
                    ((ICoolor_MoviesDetail.IVew)view).getMoviesDetailSuccess(moviesDetail);
                }
            }
        });
    }
}
