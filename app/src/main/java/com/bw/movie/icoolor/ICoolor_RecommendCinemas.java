package com.bw.movie.icoolor;

import com.bw.movie.base.IBaseView;
import com.bw.movie.bean.RecommendCinemasBean;

public interface ICoolor_RecommendCinemas {
    interface IVew extends IBaseView{
        void getRecommendCinemasSuccess(RecommendCinemasBean recommendCinemasBean);
    }
    interface IPresenter{
        void getRecommendCinemas(int page,int count);
    }
    interface IModel{
        void getRecommendCinemas(int page,int count,RecommendCinemasCallback recommendCinemasCallback);
    }
    interface RecommendCinemasCallback{
        void getSuccess(RecommendCinemasBean recommendCinemasBean);
    }
}
