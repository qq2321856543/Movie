package com.bw.movie.fragment;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

import com.bw.movie.R;
import com.bw.movie.adapter.ActorAdapter;
import com.bw.movie.adapter.DirectorAdapter;
import com.bw.movie.base.App;
import com.bw.movie.base.BaseFragment;
import com.bw.movie.base.BasePresenter;
import com.bw.movie.bean.Moview_MoviesDetail;
import com.bw.movie.icoolor.ICoolor_MoviesDetail;
import com.bw.movie.presenter.Presenter_MoviesDetail;
import com.bw.movie.utils.SPUtils;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class Fragment_DetailOne extends BaseFragment implements ICoolor_MoviesDetail.IVew {

    @BindView(R.id.tv_nei)
    TextView tv_nei;
    @BindView(R.id.tv_dao)
    TextView tv_dao;
    @BindView(R.id.rv_dao)
    RecyclerView rv_dao;
    @BindView(R.id.tv_yanyuan)
    TextView tv_yanyuan;
    @BindView(R.id.rv_yanyuan)
    RecyclerView rv_yanyuan;
    private DirectorAdapter directorAdapter;
    private ActorAdapter actorAdapter;

    @Override
    protected BasePresenter initPresenter() {
        return new Presenter_MoviesDetail(this);
    }

    @Override
    protected int getLayout() {
        return R.layout.fragment_detail_one;
    }

    @Override
    protected void initView(View view) {
        RecyclerView.LayoutManager layoutManager=new GridLayoutManager(getContext(),4);
        rv_dao.setLayoutManager(layoutManager);
        directorAdapter = new DirectorAdapter(getContext());
        rv_dao.setAdapter(directorAdapter);
        RecyclerView.LayoutManager layoutManager1=new GridLayoutManager(getContext(),4);
        rv_yanyuan.setLayoutManager(layoutManager1);
        actorAdapter = new ActorAdapter(getContext());
        rv_yanyuan.setAdapter(actorAdapter);
    }

    @Override
    protected void initData() {
        int movieId = SPUtils.getInt(getContext(), "idd", "movieId");
        BasePresenter presenter = getPresenter();
        if (presenter!=null && presenter instanceof ICoolor_MoviesDetail.IPresenter){
            Log.i("qqq","presenter");
            ((ICoolor_MoviesDetail.IPresenter)presenter).getMoviesDetail(movieId);
        }

    }


    @Override
    public void getMoviesDetailSuccess(Moview_MoviesDetail moviesDetail) {
        Moview_MoviesDetail.ResultBean result = moviesDetail.getResult();
        List<Moview_MoviesDetail.ResultBean.MovieDirectorBean> movieDirector = result.getMovieDirector();
        directorAdapter.setData(movieDirector);
        tv_nei.setText(result.getSummary());
        tv_dao.setText("导演 "+result.getMovieDirector().size());
        tv_yanyuan.setText("演员 "+result.getMovieActor().size());
        List<Moview_MoviesDetail.ResultBean.MovieActorBean> movieActor = result.getMovieActor();
        actorAdapter.setData(movieActor);
    }


}
