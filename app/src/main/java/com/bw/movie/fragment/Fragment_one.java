package com.bw.movie.fragment;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.bw.movie.R;
import com.bw.movie.adapter.MoreAdapter;
import com.bw.movie.base.BaseAcitvity;
import com.bw.movie.base.BaseFragment;
import com.bw.movie.base.BasePresenter;
import com.bw.movie.bean.BannerBean;
import com.bw.movie.bean.Movie_ComingSoonMovie;
import com.bw.movie.bean.Movie_HotMovieBean;
import com.bw.movie.bean.Movie_ReleaseMovieBean;
import com.bw.movie.bean.Moview_MoviesDetail;
import com.bw.movie.icoolor.ICoolor_Movie;
import com.bw.movie.presenter.Presenter_Movie;

import java.util.List;

import butterknife.BindView;

public class Fragment_one extends BaseFragment implements ICoolor_Movie.IVew {
    @BindView(R.id.rv)
    RecyclerView rv;
    private MoreAdapter moreAdapter;

    @Override
    protected BasePresenter initPresenter() {
        return new Presenter_Movie(this);
    }

    @Override
    protected int getLayout() {
        return R.layout.fragment_one;
    }

    @Override
    protected void initView(View view) {
        RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(getContext(),RecyclerView.VERTICAL,false);
        rv.setLayoutManager(layoutManager);
        moreAdapter = new MoreAdapter(getContext());
        rv.setAdapter(moreAdapter);
    }

    @Override
    protected void initData() {
        BasePresenter presenter = getPresenter();
        if (presenter!=null&&presenter instanceof ICoolor_Movie.IPresenter){
            //正在热映
            ((ICoolor_Movie.IPresenter)presenter).getReleaseMovieList(1,10);
        }
    }

    @Override
    public void getReleaseMovieSuccess(Movie_ReleaseMovieBean releaseMovieBean) {
        List<Movie_ReleaseMovieBean.ResultBean> result = releaseMovieBean.getResult();
        moreAdapter.setData(result);
    }

    @Override
    public void getComingSoonMovieSuccess(Movie_ComingSoonMovie comingSoonMovie) {

    }

    @Override
    public void getHotMovieSuccess(Movie_HotMovieBean hotMovieBean) {

    }

    @Override
    public void getXbanner(BannerBean bannerBean) {

    }

    @Override
    public void getMoviesDetailSuccess(Moview_MoviesDetail moviesDetail) {

    }
}
