package com.bw.movie.presenter;

import com.bw.movie.base.BasePresenter;
import com.bw.movie.base.IBaseView;
import com.bw.movie.bean.UserFollowCinemaListBean;
import com.bw.movie.icoolor.ICoolor_UserFollowCinemaList;
import com.bw.movie.model.Model_UserFollowCinemaList;

public class Presenter_UserFollowCinemaList extends BasePresenter implements ICoolor_UserFollowCinemaList.IPresenter {

    private Model_UserFollowCinemaList model;

    public Presenter_UserFollowCinemaList(IBaseView iBaseView) {
        super(iBaseView);
    }

    @Override
    protected void initModel() {
        model = new Model_UserFollowCinemaList();
    }

    @Override
    public void getUserFollowCinemaList(int page, int count) {
        model.getUserFollowCinemaList(page, count, new ICoolor_UserFollowCinemaList.UserFollowCinemaListCallback() {
            @Override
            public void getSuccess(UserFollowCinemaListBean userFollowCinemaListBean) {
                IBaseView view = getView();
                if (view != null) {
                    ((ICoolor_UserFollowCinemaList.IVew)view).getUserFollowCinemaListSuccess(userFollowCinemaListBean);
                }
            }
        });
    }
}
