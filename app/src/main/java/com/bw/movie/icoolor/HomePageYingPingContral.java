package com.bw.movie.icoolor;


import com.bw.movie.base.IBaseView;
import com.bw.movie.bean.YingPingBean;


public class HomePageYingPingContral {
    public interface getView extends IBaseView {
        void getYingPingrSucc(YingPingBean yingPingBean);
        void getYingPingFiuld(String str);


    }
    public interface getPresetner{
        void getYingPing(int movieId, int page, int count);

    }
    public interface getModel{
        void getYingPing(int movieId, int page, int count, CallBackYingPing callBackYingPing);
        interface CallBackYingPing{
            void getYingPingSucc(YingPingBean yingPingBean);
            void getYingPingFiuld(String str);
        }

    }
}
