package com.bw.movie.presenter;

import com.bw.movie.base.BasePresenter;
import com.bw.movie.base.IBaseView;
import com.bw.movie.bean.YingPingBean;
import com.bw.movie.icoolor.HomePageYingPingContral;
import com.bw.movie.model.HomePageYingPingModel;

public class HomePageYingPingPresenter extends BasePresenter implements HomePageYingPingContral.getPresetner {


    private HomePageYingPingModel model;

    public HomePageYingPingPresenter(IBaseView iBaseView) {
        super(iBaseView);
    }

    @Override
    protected void initModel() {
        model = new HomePageYingPingModel();
    }

    @Override
    public void getYingPing(int movieId, int page, int count) {
        model.getYingPing(movieId, page, count, new HomePageYingPingContral.getModel.CallBackYingPing() {
            @Override
            public void getYingPingSucc(YingPingBean yingPingBean) {
                IBaseView view = getView();
                if (view!=null){
                    ((HomePageYingPingContral.getView)view).getYingPingrSucc(yingPingBean);
                }
            }

            @Override
            public void getYingPingFiuld(String str) {

            }
        });
    }
}
