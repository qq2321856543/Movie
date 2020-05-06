package com.bw.movie.fragment;

import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.bw.movie.R;
import com.bw.movie.activity.CinemaInfoActivity;
import com.bw.movie.adapter.RecommendCinemasAdapter;
import com.bw.movie.base.BaseFragment;
import com.bw.movie.base.BasePresenter;
import com.bw.movie.bean.RecommendCinemasBean;
import com.bw.movie.icoolor.ICoolor_RecommendCinemas;
import com.bw.movie.presenter.Presenter_RecommendCinemas;

import java.util.List;

import butterknife.BindView;

public class Fragment_RecommendCinemas extends BaseFragment implements ICoolor_RecommendCinemas.IVew {
    @BindView(R.id.rv)
    RecyclerView rv;
    @Override
    protected BasePresenter initPresenter() {
        return new Presenter_RecommendCinemas(this);
    }

    @Override
    protected int getLayout() {
        return R.layout.fragment_recommendcinemas;
    }

    @Override
    protected void initView(View view) {

    }

    @Override
    protected void initData() {
        BasePresenter presenter = getPresenter();
        if (presenter != null) {
            ((ICoolor_RecommendCinemas.IPresenter)presenter).getRecommendCinemas(1,10);
        }
    }

    @Override
    public void getRecommendCinemasSuccess(RecommendCinemasBean recommendCinemasBean) {
        final List<RecommendCinemasBean.ResultBean> result = recommendCinemasBean.getResult();
        RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(getContext(),RecyclerView.VERTICAL,false);
        rv.setLayoutManager(layoutManager);
        RecommendCinemasAdapter recommendCinemasAdapter = new RecommendCinemasAdapter(getContext(), result);
        rv.setAdapter(recommendCinemasAdapter);
        //点击跳转影院详情
        recommendCinemasAdapter.Onclick(new RecommendCinemasAdapter.SetOn() {
            @Override
            public void click(int id) {
                Intent intent = new Intent(getContext(), CinemaInfoActivity.class);
                intent.putExtra("id",id);
                startActivity(intent);

            }
        });
    }
}
