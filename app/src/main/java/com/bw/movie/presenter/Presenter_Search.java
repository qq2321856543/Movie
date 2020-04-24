package com.bw.movie.presenter;

import com.bw.movie.base.BasePresenter;
import com.bw.movie.base.IBaseView;
import com.bw.movie.bean.Search_MovieByKeywordBean;
import com.bw.movie.icoolor.ICoolor_Search;
import com.bw.movie.model.Model_Search;

public class Presenter_Search extends BasePresenter implements ICoolor_Search.IPresenter {

    private Model_Search model;

    public Presenter_Search(IBaseView iBaseView) {
        super(iBaseView);
    }

    @Override
    protected void initModel() {
        model = new Model_Search();
    }

    @Override
    public void getSearch_MovieByKeyword(String keyword, int page, int count) {
        model.getSearch_MovieByKeyword(keyword, page, count, new ICoolor_Search.Search_MovieByKeywordCallback() {
            @Override
            public void getSuccess(Search_MovieByKeywordBean movieByKeywordBean) {
                IBaseView view = getView();
                if (view!=null&&view instanceof ICoolor_Search.IView){
                    ((ICoolor_Search.IView)view).getSearch_MovieByKeywordSuccess(movieByKeywordBean);
                }
            }
        });
    }
}
