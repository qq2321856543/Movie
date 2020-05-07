package com.bw.movie.presenter;

import com.bw.movie.base.BasePresenter;
import com.bw.movie.base.IBaseView;
import com.bw.movie.bean.LoginBean;
import com.bw.movie.icoolor.ICoolor_MovieComment;
import com.bw.movie.model.Model_MovieComment;

public class Presenter_MovieComment extends BasePresenter implements ICoolor_MovieComment.IPersenter {

    private Model_MovieComment model;

    public Presenter_MovieComment(IBaseView iBaseView) {
        super(iBaseView);
    }

    @Override
    protected void initModel() {
        model = new Model_MovieComment();
    }

    @Override
    public void getMovieComment(int movieId, String commentContent, double score) {
        model.getMovieComment(movieId, commentContent, score, new ICoolor_MovieComment.MovieCommentCallback() {
            @Override
            public void getSuccess(LoginBean loginBean) {
                IBaseView view = getView();
                if (view != null) {
                    ((ICoolor_MovieComment.IVew)view).getMovieCommentSuccess(loginBean);
                }
            }
        });
    }
}
