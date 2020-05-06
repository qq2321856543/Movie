package com.bw.movie.presenter;

import com.bw.movie.base.BasePresenter;
import com.bw.movie.base.IBaseView;
import com.bw.movie.bean.DateListBean;
import com.bw.movie.icoolor.ICoolor_DateList;
import com.bw.movie.model.Model_DataList;

public class Presenter_DataList extends BasePresenter implements ICoolor_DateList.IPersenter {

    private Model_DataList model;

    public Presenter_DataList(IBaseView iBaseView) {
        super(iBaseView);
    }

    @Override
    protected void initModel() {
        model = new Model_DataList();
    }

    @Override
    public void getDataList() {
        model.getDataList(new ICoolor_DateList.DataListCallback() {
            @Override
            public void getSuccess(DateListBean dateListBean) {
                IBaseView view = getView();
                if (view != null) {
                    ((ICoolor_DateList.IVew)view).getDataListSuccess(dateListBean);
                }
            }
        });
    }
}
