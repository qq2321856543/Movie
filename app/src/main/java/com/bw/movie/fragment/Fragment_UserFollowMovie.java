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

public class Fragment_UserFollowMovie extends BaseFragment implements ICoolor_UserFollowMovie.IVew {
    @BindView(R.id.rv)
    RecyclerView rv;
    private UserFollowMovieAdapter userFollowMovieAdapter;

    @Override
    protected BasePresenter initPresenter() {
        return new Presenter_UserFollowMovie(this);
    }

    @Override
    protected int getLayout() {
        return R.layout.fragment_userfollowmovie;
    }

    @Override
    protected void initView(View view) {
        RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(getContext(),RecyclerView.VERTICAL,false);
        rv.setLayoutManager(layoutManager);
        userFollowMovieAdapter = new UserFollowMovieAdapter(getContext());
        rv.setAdapter(userFollowMovieAdapter);
    }

    @Override
    protected void initData() {
        BasePresenter presenter = getPresenter();
        if (presenter!=null){
            ((ICoolor_UserFollowMovie.IPresenter)presenter).getUserFollowMovie(1,20);
        }
    }

    @Override
    public void getUserFollowMovieSuccess(UserFollowMovieBean userFollowMovieBean) {
        List<UserFollowMovieBean.ResultBean> result = userFollowMovieBean.getResult();
        userFollowMovieAdapter.setData(result);
    }
}
