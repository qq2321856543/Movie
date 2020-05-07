package com.bw.movie.presenter;

import com.bw.movie.base.BasePresenter;
import com.bw.movie.base.IBaseView;
import com.bw.movie.bean.UserReserveBean;
import com.bw.movie.icoolor.ICoolor_UserReserve;
import com.bw.movie.model.Model_UserReserve;

public class Presenter_UserReserve extends BasePresenter implements ICoolor_UserReserve.IPersenter {

    private Model_UserReserve model;

    public Presenter_UserReserve(IBaseView iBaseView) {
        super(iBaseView);
    }

    @Override
    protected void initModel() {
        model = new Model_UserReserve();
    }

    @Override
    public void getUserReserve() {
        model.getUserReserve(new ICoolor_UserReserve.UserReserveCallback() {
            @Override
            public void getSuccess(UserReserveBean userReserveBean) {
                IBaseView view = getView();
                if (view != null) {
                    ((ICoolor_UserReserve.IVew)view).getUserReserveSuccess(userReserveBean);
                }
            }
        });
    }
}
