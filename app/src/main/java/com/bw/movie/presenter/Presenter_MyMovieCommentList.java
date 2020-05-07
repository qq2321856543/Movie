package com.bw.movie.presenter;

import com.bw.movie.base.BasePresenter;
import com.bw.movie.base.IBaseView;
import com.bw.movie.bean.MyMovieCommentListBean;
import com.bw.movie.icoolor.ICoolor_MyMovieCommentList;
import com.bw.movie.model.Model_MyMovieCommentList;

public class Presenter_MyMovieCommentList extends BasePresenter implements ICoolor_MyMovieCommentList.IPersenter {

    private Model_MyMovieCommentList model;

    public Presenter_MyMovieCommentList(IBaseView iBaseView) {
        super(iBaseView);
    }

    @Override
    protected void initModel() {
        model = new Model_MyMovieCommentList();
    }

    @Override
    public void getMyMovieCommentList(int page, int count) {
        model.getMyMovieCommentList(page, count, new ICoolor_MyMovieCommentList.MyMovieCommentListCallback() {
            @Override
            public void getSuccess(MyMovieCommentListBean myMovieCommentListBean) {
                IBaseView view = getView();
                if (view != null) {
                    ((ICoolor_MyMovieCommentList.IVew)view).getMyMovieCommentListSuccess(myMovieCommentListBean);
                }
            }
        });
    }
}
