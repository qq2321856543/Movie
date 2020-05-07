package com.bw.movie.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.bw.movie.R;
import com.bw.movie.adapter.UserReserveAdapter;
import com.bw.movie.base.BaseAcitvity;
import com.bw.movie.base.BasePresenter;
import com.bw.movie.bean.Moview_MoviesDetail;
import com.bw.movie.bean.UserReserveBean;
import com.bw.movie.icoolor.ICoolor_UserReserve;
import com.bw.movie.presenter.Presenter_UserReserve;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class UserReserveActivity extends BaseAcitvity implements ICoolor_UserReserve.IVew {
    @BindView(R.id.rv)
    RecyclerView rv;
    @BindView(R.id.iv_shape)
    ImageView iv_shape;
    private UserReserveAdapter userReserveAdapter;

    @Override
    protected BasePresenter initPresenter() {
        return new Presenter_UserReserve(this);
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_user_reserve;
    }

    @Override
    protected void initView() {
        RecyclerView.LayoutManager layoutManager1=new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        rv.setLayoutManager(layoutManager1);
        userReserveAdapter = new UserReserveAdapter(this);
        rv.setAdapter(userReserveAdapter);
    }

    @Override
    protected void initData() {
        BasePresenter presenter = getPresenter();
        if (presenter != null) {
            ((ICoolor_UserReserve.IPersenter)presenter).getUserReserve();
        }
        iv_shape.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }

    @Override
    public void getUserReserveSuccess(UserReserveBean userReserveBean) {
        final List<UserReserveBean.ResultBean> result = userReserveBean.getResult();
        userReserveAdapter.setData(result);
//        final ArrayList<UserReserveBean.ResultBean> resultBeans = new ArrayList<>();
//        resultBeans.addAll(result);
        //TODO:我的预约点击跳转详情页
        userReserveAdapter.SetOnclick(new UserReserveAdapter.Onclick() {
            @Override
            public void click(int movieId) {
//                Intent intent = new Intent(UserReserveActivity.this, MoviesDetailActivity.class);
//                intent.putParcelableArrayListExtra("resultBeans",resultBeans);
//                startActivity(intent);

            }
        });
    }
}
