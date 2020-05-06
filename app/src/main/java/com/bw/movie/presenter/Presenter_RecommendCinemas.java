package com.bw.movie.presenter;

import com.bw.movie.base.BasePresenter;
import com.bw.movie.base.IBaseView;
import com.bw.movie.bean.RecommendCinemasBean;
import com.bw.movie.icoolor.ICoolor_RecommendCinemas;
import com.bw.movie.model.Model_RecommendCinemas;

public class Presenter_RecommendCinemas extends BasePresenter implements ICoolor_RecommendCinemas.IPresenter {

    private Model_RecommendCinemas model;

    public Presenter_RecommendCinemas(IBaseView iBaseView) {
        super(iBaseView);
    }

    @Override
    protected void initModel() {
        model = new Model_RecommendCinemas();
    }
    @Override
    public void getRecommendCinemas(int page, int count) {
        model.getRecommendCinemas(page, count, new ICoolor_RecommendCinemas.RecommendCinemasCallback() {
            @Override
            public void getSuccess(RecommendCinemasBean recommendCinemasBean) {
                IBaseView view = getView();
                if (view!=null){
                    ((ICoolor_RecommendCinemas.IVew)view).getRecommendCinemasSuccess(recommendCinemasBean);
                }
            }
        });
    }


}
