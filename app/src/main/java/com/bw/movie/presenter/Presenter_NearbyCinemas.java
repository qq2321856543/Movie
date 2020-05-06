package com.bw.movie.presenter;

import com.bw.movie.base.BasePresenter;
import com.bw.movie.base.IBaseView;
import com.bw.movie.bean.NearbyCinemasBean;
import com.bw.movie.icoolor.ICoolor_NearbyCinemas;
import com.bw.movie.model.Model_NearbyCinemas;

public class Presenter_NearbyCinemas extends BasePresenter implements ICoolor_NearbyCinemas.IPresenter {

    private Model_NearbyCinemas model;

    public Presenter_NearbyCinemas(IBaseView iBaseView) {
        super(iBaseView);
    }

    @Override
    protected void initModel() {
        model = new Model_NearbyCinemas();
    }

    @Override
    public void getNearbyCinemas(String longitude, String latitude, int page, int count) {
        model.getNearbyCinemas(longitude, latitude, page, count, new ICoolor_NearbyCinemas.NearbyCinemasCallback() {
            @Override
            public void getSuccess(NearbyCinemasBean nearbyCinemasBean) {
                IBaseView view = getView();
                if (view!=null){
                    ((ICoolor_NearbyCinemas.IVew)view).getNearbyCinemasSuccess(nearbyCinemasBean);
                }
            }
        });
    }
}
