package com.bw.movie.presenter;

import com.bw.movie.base.BasePresenter;
import com.bw.movie.base.IBaseView;
import com.bw.movie.bean.AllCinemaCommentBean;
import com.bw.movie.icoolor.ICoolor_AllCinemaComment;
import com.bw.movie.model.Model_AllCinemaComment;

public class Presenter_AllCinemaComment extends BasePresenter implements ICoolor_AllCinemaComment.IPresenter {

    private Model_AllCinemaComment model;

    public Presenter_AllCinemaComment(IBaseView iBaseView) {
        super(iBaseView);
    }

    @Override
    protected void initModel() {
        model = new Model_AllCinemaComment();
    }

    @Override
    public void getAllCinemaComment(int cinemaId, int page, int count) {
        model.getAllCinemaComment(cinemaId, page, count, new ICoolor_AllCinemaComment.AllCinemaCommenttCallback() {
            @Override
            public void getSuccess(AllCinemaCommentBean allCinemaCommentBean) {
                IBaseView view = getView();
                if (view != null) {
                    ((ICoolor_AllCinemaComment.IVew)view).getAllCinemaCommentSuccess(allCinemaCommentBean);
                }
            }
        });
    }
}
