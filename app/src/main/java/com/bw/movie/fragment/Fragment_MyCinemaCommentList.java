package com.bw.movie.fragment;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.bw.movie.R;
import com.bw.movie.adapter.UserFollowMovieAdapter;
import com.bw.movie.base.BaseFragment;
import com.bw.movie.base.BasePresenter;
import com.bw.movie.bean.UserFollowMovieBean;
import com.bw.movie.icoolor.ICoolor_UserFollowMovie;
import com.bw.movie.presenter.Presenter_UserFollowMovie;

import java.util.List;

import butterknife.BindView;

public class Fragment_MyCinemaCommentList extends BaseFragment  {
    //TODO:用户的影院评论
    @BindView(R.id.rv)
    RecyclerView rv;
    private UserFollowMovieAdapter userFollowMovieAdapter;

    @Override
    protected BasePresenter initPresenter() {
        return null;
    }

    @Override
    protected int getLayout() {
        return R.layout.fragment_userfollowmovie;
    }

    @Override
    protected void initView(View view) {
//        RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(getContext(),RecyclerView.VERTICAL,false);
//        rv.setLayoutManager(layoutManager);
//        userFollowMovieAdapter = new UserFollowMovieAdapter(getContext());
//        rv.setAdapter(userFollowMovieAdapter);
    }

    @Override
    protected void initData() {

    }


}
