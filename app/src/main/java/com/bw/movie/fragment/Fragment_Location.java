package com.bw.movie.fragment;

import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.bw.movie.R;
import com.bw.movie.activity.CinemaInfoActivity;
import com.bw.movie.adapter.OneAdapter;
import com.bw.movie.adapter.TwoAdapter;
import com.bw.movie.base.BaseFragment;
import com.bw.movie.base.BasePresenter;
import com.bw.movie.bean.CinemaByRegionBean;
import com.bw.movie.bean.RegionListBean;
import com.bw.movie.icoolor.ICoolor_CinemaByRegion;
import com.bw.movie.presenter.Presenter_CinemaByRegion;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class Fragment_Location extends BaseFragment implements ICoolor_CinemaByRegion.IVew {
    @BindView(R.id.rv)
    RecyclerView rv;
    @BindView(R.id.rvv)
    RecyclerView rvv;
    ArrayList<String> strings = new ArrayList<>();
    private OneAdapter oneAdapter;

    @Override
    protected BasePresenter initPresenter() {
        return new Presenter_CinemaByRegion(this);
    }

    @Override
    protected int getLayout() {
        return R.layout.fragment_location;
    }

    @Override
    protected void initView(View view) {

    }

    @Override
    protected void initData() {
        BasePresenter presenter = getPresenter();
        if (presenter != null) {
            ((ICoolor_CinemaByRegion.IPresenter)presenter).getRegionList();
        }



    }


    @Override
    public void getCinemaByRegionSuccess(CinemaByRegionBean cinemaByRegionBean) {
        final List<CinemaByRegionBean.ResultBean> result = cinemaByRegionBean.getResult();
        RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(getContext(),RecyclerView.VERTICAL,false);
        rvv.setLayoutManager(layoutManager);
        final TwoAdapter twoAdapter = new TwoAdapter(getContext(), result);
        rvv.setAdapter(twoAdapter);
        twoAdapter.SetOn(new TwoAdapter.Onclick() {
            @Override
            public void Click(int postion,int id) {
                for (CinemaByRegionBean.ResultBean resultBean:result){
                    resultBean.setIs(false);
                }
                result.get(postion).setIs(true);
                twoAdapter.notifyDataSetChanged();
                Intent intent = new Intent(getContext(), CinemaInfoActivity.class);
                intent.putExtra("id",id);
                startActivity(intent);
            }
        });
    }

    @Override
    public void getRegionListSuccess(final RegionListBean regionListBean) {
        final List<RegionListBean.ResultBean> result = regionListBean.getResult();
        RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(getContext(),RecyclerView.VERTICAL,false);
        rv.setLayoutManager(layoutManager);
        oneAdapter = new OneAdapter(getContext(), result);
        rv.setAdapter(oneAdapter);
        oneAdapter.SetOn(new OneAdapter.Onclick() {
            @Override
            public void Click(int postion) {
                for (RegionListBean.ResultBean resultBean:result){
                    resultBean.setIs(false);
                }
                result.get(postion-1).setIs(true);
                oneAdapter.notifyDataSetChanged();

                BasePresenter presenter = getPresenter();
                if (presenter != null) {

                    ((ICoolor_CinemaByRegion.IPresenter)presenter).getCinemaByRegion(postion);
                }
            }
        });
    }
}
