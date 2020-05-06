package com.bw.movie.fragment;

import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.bw.movie.R;
import com.bw.movie.base.BaseFragment;
import com.bw.movie.base.BasePresenter;
import com.bw.movie.bean.CinemaInfoBean;
import com.bw.movie.bean.LoginBean;
import com.bw.movie.icoolor.ICoolor_CinemaInfo;
import com.bw.movie.presenter.Presenter_CinemaInfo;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import butterknife.BindView;

public class Fragment_CinemaInfo extends BaseFragment implements ICoolor_CinemaInfo.IVew {
    @BindView(R.id.tv_location)
    TextView tv_location;
    @BindView(R.id.tv_dianhua)
    TextView tv_dianhua;
    @BindView(R.id.tv_lu)
    TextView tv_lu;
    @Override
    protected BasePresenter initPresenter() {
        return new Presenter_CinemaInfo(this);
    }

    @Override
    protected int getLayout() {
        return R.layout.item_cineminfo;
    }

    @Override
    protected void initView(View view) {

    }

    @Override
    protected void initData() {

    }

    @Override
    public void getCinemaInfoSuccess(CinemaInfoBean cinemaInfoBean) {

    }

    @Override
    public void getFollowCinemaSuccess(LoginBean loginBean) {

    }

    @Override
    public void getCancelFollowCinemaSuccess(LoginBean loginBean) {

    }

    @Subscribe(threadMode = ThreadMode.MAIN,sticky = true)
    public void getEvent(CinemaInfoBean.ResultBean resultBean){
        tv_lu.setText(resultBean.getVehicleRoute());
    }

    @Override
    public void onResume() {
        super.onResume();
        if (!EventBus.getDefault().isRegistered(this)){
            EventBus.getDefault().register(this);
        }
    }

    @Override
    public void onPause() {
        super.onPause();
        EventBus.getDefault().unregister(this);
    }
}
