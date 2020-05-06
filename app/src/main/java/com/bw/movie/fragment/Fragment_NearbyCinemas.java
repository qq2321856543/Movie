package com.bw.movie.fragment;

import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.RelativeLayout;

import com.bw.movie.R;
import com.bw.movie.activity.CinemaInfoActivity;
import com.bw.movie.adapter.NearbyCinemasAdapter;
import com.bw.movie.adapter.RecommendCinemasAdapter;
import com.bw.movie.base.BaseFragment;
import com.bw.movie.base.BasePresenter;
import com.bw.movie.bean.NearbyCinemasBean;
import com.bw.movie.bean.RecommendCinemasBean;
import com.bw.movie.icoolor.ICoolor_NearbyCinemas;
import com.bw.movie.presenter.Presenter_NearbyCinemas;
import com.bw.movie.utils.SPUtils;

import java.util.List;

import butterknife.BindView;

public class Fragment_NearbyCinemas extends BaseFragment implements ICoolor_NearbyCinemas.IVew {
    @BindView(R.id.rv)
    RecyclerView rv;
    @Override
    protected BasePresenter initPresenter() {
        return new Presenter_NearbyCinemas(this);
    }

    @Override
    protected int getLayout() {
        return R.layout.fragment_nearbycinemas;
    }

    @Override
    protected void initView(View view) {

    }

    @Override
    protected void initData() {
        String jing = SPUtils.getString(getContext(), SPUtils.USERINFO_NAME, "jing");
        String wei = SPUtils.getString(getContext(), SPUtils.USERINFO_NAME, "wei");
        BasePresenter presenter = getPresenter();
        if (presenter != null) {
            ((ICoolor_NearbyCinemas.IPresenter)presenter).getNearbyCinemas(jing,wei,1,10);
        }
    }

    @Override
    public void getNearbyCinemasSuccess(NearbyCinemasBean nearbyCinemasBean) {
        List<NearbyCinemasBean.ResultBean> result = nearbyCinemasBean.getResult();
        RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(getContext(),RecyclerView.VERTICAL,false);
        rv.setLayoutManager(layoutManager);
        NearbyCinemasAdapter nearbyCinemasAdapter = new NearbyCinemasAdapter(getContext(), result);
        rv.setAdapter(nearbyCinemasAdapter);
        nearbyCinemasAdapter.SetOnclick(new NearbyCinemasAdapter.Onclick() {
            @Override
            public void click(int id) {
                Intent intent = new Intent(getContext(), CinemaInfoActivity.class);
                intent.putExtra("id",id);
                startActivity(intent);
            }
        });
    }
}
