package com.bw.movie.fragment;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.bw.movie.R;
import com.bw.movie.adapter.YingPingAdapter;
import com.bw.movie.base.BaseFragment;
import com.bw.movie.base.BasePresenter;
import com.bw.movie.bean.Moview_MoviesDetail;
import com.bw.movie.bean.YingPingBean;
import com.bw.movie.icoolor.HomePageYingPingContral;
import com.bw.movie.icoolor.ICoolor_MoviesDetail;
import com.bw.movie.presenter.HomePageYingPingPresenter;
import com.bw.movie.utils.SPUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class Fragment_DetailFour extends BaseFragment implements HomePageYingPingContral.getView {


    @BindView(R.id.ying_re)
    RecyclerView yingRe;
    @Override
    protected BasePresenter initPresenter() {
        return new HomePageYingPingPresenter(this);
    }

    @Override
    protected int getLayout() {
        return R.layout.fragment_detail_four;
    }

    @Override
    protected void initView(View view) {

    }

    @Override
    protected void initData() {
        int movieId = SPUtils.getInt(getContext(), "idd", "movieId");
        BasePresenter presenter = getPresenter();
        if (presenter instanceof HomePageYingPingPresenter) {
            ((HomePageYingPingPresenter) presenter).getYingPing(movieId, 1, 100);
        }
    }

    @Override
    public void getYingPingrSucc(YingPingBean yingPingBean) {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false);
        yingRe.setLayoutManager(linearLayoutManager);
        YingPingAdapter yingPingAdapter = new YingPingAdapter(getContext(),yingPingBean.getResult());
        yingRe.setAdapter(yingPingAdapter);
    }

    @Override
    public void getYingPingFiuld(String str) {

    }
}
