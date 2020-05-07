package com.bw.movie.fragment;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.bw.movie.R;
import com.bw.movie.adapter.CinemaScheduleListAdapter;
import com.bw.movie.base.BaseFragment;
import com.bw.movie.base.BasePresenter;
import com.bw.movie.bean.CinemaScheduleListBean;
import com.bw.movie.icoolor.ICoolor_CinemaScheduleList;
import com.bw.movie.presenter.Presenter_CinemaScheduleList;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.List;

import butterknife.BindView;

public class Fragment_CinemaScheduleList extends BaseFragment implements ICoolor_CinemaScheduleList.IVew {
    @BindView(R.id.rv)
    RecyclerView rv;
    private CinemaScheduleListAdapter cinemaScheduleListAdapter;

    @Override
    protected BasePresenter initPresenter() {
        return new Presenter_CinemaScheduleList(this);
    }

    @Override
    protected int getLayout() {
        return R.layout.fragment_cinemaschedulelist;
    }

    @Override
    protected void initView(View view) {
        RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(getContext(),RecyclerView.VERTICAL,false);
        rv.setLayoutManager(layoutManager);
        cinemaScheduleListAdapter = new CinemaScheduleListAdapter(getContext());
        rv.setAdapter(cinemaScheduleListAdapter);
    }
    @Subscribe(threadMode = ThreadMode.MAIN,sticky = true)
    public void getEvent(Integer id){
        Log.i("yyy","id:"+id);

        BasePresenter presenter = getPresenter();
        if (presenter != null) {
            ((ICoolor_CinemaScheduleList.IPresenter)presenter).getCinemaScheduleList(id,1,20);

        }
    }
    //TODO:影院排期列表购票
    @Override
    protected void initData() {
        //影院排期列表购票点击回调
        cinemaScheduleListAdapter.SetOncli(new CinemaScheduleListAdapter.Oncli() {
            @Override
            public void click(int movieId) {

            }
        });

    }

    @Override
    public void getCinemaScheduleListSuccess(CinemaScheduleListBean cinemaScheduleListBean) {
        List<CinemaScheduleListBean.ResultBean> result = cinemaScheduleListBean.getResult();
        if (result!=null){

            cinemaScheduleListAdapter.setData(result);
        }
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
