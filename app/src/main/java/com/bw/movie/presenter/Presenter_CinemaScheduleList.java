package com.bw.movie.presenter;

import com.bw.movie.base.BasePresenter;
import com.bw.movie.base.IBaseView;
import com.bw.movie.bean.CinemaScheduleListBean;
import com.bw.movie.icoolor.ICoolor_CinemaScheduleList;
import com.bw.movie.model.Model_CinemaScheduleList;

public class Presenter_CinemaScheduleList extends BasePresenter implements ICoolor_CinemaScheduleList.IPresenter {

    private Model_CinemaScheduleList model;

    public Presenter_CinemaScheduleList(IBaseView iBaseView) {
        super(iBaseView);
    }

    @Override
    protected void initModel() {
        model = new Model_CinemaScheduleList();
    }

    @Override
    public void getCinemaScheduleList(int cinemaId, int page, int count) {
        model.getCinemaScheduleList(cinemaId, page, count, new ICoolor_CinemaScheduleList.CinemaScheduleListCallback() {
            @Override
            public void getSuccess(CinemaScheduleListBean cinemaScheduleListBean) {
                IBaseView view = getView();
                if (view != null) {
                    ((ICoolor_CinemaScheduleList.IVew)view).getCinemaScheduleListSuccess(cinemaScheduleListBean);
                }
            }
        });
    }
}
