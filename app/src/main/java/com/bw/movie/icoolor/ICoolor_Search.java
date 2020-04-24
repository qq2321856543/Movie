package com.bw.movie.icoolor;

import com.bw.movie.base.IBaseView;
import com.bw.movie.bean.Search_MovieByKeywordBean;

public interface ICoolor_Search {
    interface IView extends IBaseView{
        //模糊查询电影
        void getSearch_MovieByKeywordSuccess(Search_MovieByKeywordBean movieByKeywordBean);
    }
    interface IPresenter{
        void getSearch_MovieByKeyword(String keyword,int page,int count);
    }
    interface IModel{
        void getSearch_MovieByKeyword(String keyword,int page,int count,Search_MovieByKeywordCallback movieByKeywordCallback);
    }
    interface Search_MovieByKeywordCallback{
        void getSuccess(Search_MovieByKeywordBean movieByKeywordBean);
    }
}
