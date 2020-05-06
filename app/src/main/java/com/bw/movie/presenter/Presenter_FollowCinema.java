package com.bw.movie.presenter;

import com.bw.movie.base.BasePresenter;
import com.bw.movie.base.IBaseView;
import com.bw.movie.bean.LoginBean;
import com.bw.movie.icoolor.ICoolor_FollowCinema;
import com.bw.movie.model.Model_FollowCinema;

public class Presenter_FollowCinema extends BasePresenter implements ICoolor_FollowCinema.IPresenter {

    private Model_FollowCinema model;

    public Presenter_FollowCinema(IBaseView iBaseView) {
        super(iBaseView);
    }

    @Override
    protected void initModel() {
        model = new Model_FollowCinema();
    }

    @Override
    public void getFollowCinema(int cinemaId) {
        model.getFollowCinema(cinemaId, new ICoolor_FollowCinema.FollowCinemaCallback() {
            @Override
            public void getSuccess(LoginBean loginBean) {
                IBaseView view = getView();
                if (view != null) {
                    ((ICoolor_FollowCinema.IVew)view).getFollowCinemaSuccess(loginBean);
                }
            }
        });
    }

    @Override
    public void getCancelFollowCinemaSuccess(int cinemaId) {
        model.getCancelFollowCinemaSuccess(cinemaId, new ICoolor_FollowCinema.CancelFollowCinemaCallback() {
            @Override
            public void getSuccess(LoginBean loginBean) {
                IBaseView view = getView();
                if (view != null) {
                    ((ICoolor_FollowCinema.IVew)view).getCancelFollowCinemaSuccess(loginBean);
                }
            }
        });
    }
}
