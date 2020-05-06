package com.bw.movie.presenter;

import com.bw.movie.base.BasePresenter;
import com.bw.movie.base.IBaseView;
import com.bw.movie.bean.CinemaByRegionBean;
import com.bw.movie.bean.RegionListBean;
import com.bw.movie.icoolor.ICoolor_CinemaByRegion;
import com.bw.movie.model.Model_CinemaByRegion;

public class Presenter_CinemaByRegion extends BasePresenter implements ICoolor_CinemaByRegion.IPresenter {

    private Model_CinemaByRegion model;

    public Presenter_CinemaByRegion(IBaseView iBaseView) {
        super(iBaseView);
    }

    @Override
    protected void initModel() {
        model = new Model_CinemaByRegion();
    }

    @Override
    public void getCinemaByRegion(int regionId) {
        model.getCinemaByRegion(regionId, new ICoolor_CinemaByRegion.CinemaByRegionCallback() {
            @Override
            public void getSuccess(CinemaByRegionBean cinemaByRegionBean) {
                IBaseView view = getView();
                if (view != null) {
                    ((ICoolor_CinemaByRegion.IVew)view).getCinemaByRegionSuccess(cinemaByRegionBean);
                }
            }
        });
    }

    @Override
    public void getRegionList() {
        model.getRegionList(new ICoolor_CinemaByRegion.RegionListCallback() {
            @Override
            public void getSuccess(RegionListBean regionListBean) {
                IBaseView view = getView();
                if (view != null) {
                    ((ICoolor_CinemaByRegion.IVew)view).getRegionListSuccess(regionListBean);
                }
            }
        });
    }
}
