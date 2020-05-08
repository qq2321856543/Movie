package com.bw.movie.presenter;

import com.bw.movie.base.BasePresenter;
import com.bw.movie.base.IBaseView;
import com.bw.movie.bean.LoginBean;
import com.bw.movie.icoolor.ICoolor_RecordFeedBack;
import com.bw.movie.model.Model_RecordFeedBack;

public class Presenter_RecordFeedBack extends BasePresenter implements ICoolor_RecordFeedBack.IPersenter {

    private Model_RecordFeedBack model;

    public Presenter_RecordFeedBack(IBaseView iBaseView) {
        super(iBaseView);
    }

    @Override
    protected void initModel() {
        model = new Model_RecordFeedBack();
    }

    @Override
    public void getRecordFeedBack(String content) {
        model.getRecordFeedBack(content, new ICoolor_RecordFeedBack.RecordFeedBackCallback() {
            @Override
            public void getSuccess(LoginBean loginBean) {
                IBaseView view = getView();
                if (view != null) {
                    ((ICoolor_RecordFeedBack.IVew)view).getRecordFeedBackSuccess(loginBean);
                }
            }
        });
    }
}
