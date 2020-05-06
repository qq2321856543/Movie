package com.bw.movie.presenter;

import com.bw.movie.base.BasePresenter;
import com.bw.movie.base.IBaseView;
import com.bw.movie.bean.CinemaInfoBean;
import com.bw.movie.bean.LoginBean;
import com.bw.movie.icoolor.ICoolor_CinemaInfo;
import com.bw.movie.model.Model_CinemaInfo;

public class Presenter_CinemaInfo extends BasePresenter implements ICoolor_CinemaInfo.IPresenter {

    private Model_CinemaInfo model;

    public Presenter_CinemaInfo(IBaseView iBaseView) {
        super(iBaseView);
    }

    @Override
    protected void initModel() {
        model = new Model_CinemaInfo();
    }

    @Override
    public void getCinemaInfo(int cinemaId) {
        model.getCinemaInfo(cinemaId, new ICoolor_CinemaInfo.CinemaInfoCallback() {
            @Override
            public void getSuccess(CinemaInfoBean cinemaInfoBean) {
                IBaseView view = getView();
                if (view != null) {
                    ((ICoolor_CinemaInfo.IVew)view).getCinemaInfoSuccess(cinemaInfoBean);
                }
            }
        });
    }

    @Override
    public void getFollowCinema(int cinemaId) {
        model.getFollowCinema(cinemaId, new ICoolor_CinemaInfo.FollowCinemaCallback() {
            @Override
            public void getSuccess(LoginBean loginBean) {
                IBaseView view = getView();
                if (view != null) {
                    ((ICoolor_CinemaInfo.IVew)view).getFollowCinemaSuccess(loginBean);
                }
            }
        });
    }

    @Override
    public void getCancelFollowCinemaSuccess(int cinemaId) {
        model.getCancelFollowCinemaSuccess(cinemaId, new ICoolor_CinemaInfo.CancelFollowCinemaCallback() {
            @Override
            public void getSuccess(LoginBean loginBean) {
                IBaseView view = getView();
                if (view != null) {
                    ((ICoolor_CinemaInfo.IVew)view).getCancelFollowCinemaSuccess(loginBean);
                }
            }
        });
    }
}
