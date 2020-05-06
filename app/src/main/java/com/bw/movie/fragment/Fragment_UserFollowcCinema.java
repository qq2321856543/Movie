package com.bw.movie.fragment;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.bw.movie.R;
import com.bw.movie.adapter.UserFollowCinemaListAdapter;
import com.bw.movie.base.BaseFragment;
import com.bw.movie.base.BasePresenter;
import com.bw.movie.bean.UserFollowCinemaListBean;
import com.bw.movie.icoolor.ICoolor_UserFollowCinemaList;
import com.bw.movie.presenter.Presenter_CinemaScheduleList;
import com.bw.movie.presenter.Presenter_UserFollowCinemaList;

import java.util.List;

import butterknife.BindView;

public class Fragment_UserFollowcCinema extends BaseFragment implements ICoolor_UserFollowCinemaList.IVew {
    @BindView(R.id.rv)
    RecyclerView rv;
    private UserFollowCinemaListAdapter userFollowCinemaListAdapter;

    @Override
    protected BasePresenter initPresenter() {
        return new Presenter_UserFollowCinemaList(this);
    }

    @Override
    protected int getLayout() {
        return R.layout.fragment_userfollowcinema;
    }

    @Override
    protected void initView(View view) {
        RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(getContext(),RecyclerView.VERTICAL,false);
        rv.setLayoutManager(layoutManager);
        userFollowCinemaListAdapter = new UserFollowCinemaListAdapter(getContext());
        rv.setAdapter(userFollowCinemaListAdapter);
    }

    @Override
    protected void initData() {
        BasePresenter presenter = getPresenter();
        if (presenter != null) {
            ((ICoolor_UserFollowCinemaList.IPresenter)presenter).getUserFollowCinemaList(1,20);
        }
    }

    @Override
    public void getUserFollowCinemaListSuccess(UserFollowCinemaListBean userFollowCinemaListBean) {
        List<UserFollowCinemaListBean.ResultBean> result = userFollowCinemaListBean.getResult();
        userFollowCinemaListAdapter.setData(result);
    }
}
