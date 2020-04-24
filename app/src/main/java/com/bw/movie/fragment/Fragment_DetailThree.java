package com.bw.movie.fragment;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.bw.movie.R;
import com.bw.movie.adapter.PosterListAdapter;
import com.bw.movie.base.BaseFragment;
import com.bw.movie.base.BasePresenter;
import com.bw.movie.bean.Moview_MoviesDetail;
import com.bw.movie.icoolor.ICoolor_MoviesDetail;
import com.bw.movie.presenter.Presenter_MoviesDetail;
import com.bw.movie.utils.SPUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class Fragment_DetailThree extends BaseFragment implements ICoolor_MoviesDetail.IVew {
    @BindView(R.id.rv)
    RecyclerView rv;
    private PosterListAdapter posterListAdapter;

    @Override
    protected BasePresenter initPresenter() {
        return new Presenter_MoviesDetail(this);
    }

    @Override
    protected int getLayout() {
        return R.layout.fragment_detail_three;
    }

    @Override
    protected void initView(View view) {
        RecyclerView.LayoutManager layoutManager1=new GridLayoutManager(getContext(),3);
        rv.setLayoutManager(layoutManager1);
        posterListAdapter = new PosterListAdapter(getContext());
        rv.setAdapter(posterListAdapter);
    }

    @Override
    protected void initData() {
        int movieId = SPUtils.getInt(getContext(), "idd", "movieId");
        BasePresenter presenter = getPresenter();
        if (presenter!=null && presenter instanceof ICoolor_MoviesDetail.IPresenter){
            ((ICoolor_MoviesDetail.IPresenter)presenter).getMoviesDetail(movieId);
        }
    }

    @Override
    public void getMoviesDetailSuccess(Moview_MoviesDetail moviesDetail) {
        Moview_MoviesDetail.ResultBean result = moviesDetail.getResult();
        List<String> posterList = result.getPosterList();
        posterListAdapter.setData(posterList);
    }
}
