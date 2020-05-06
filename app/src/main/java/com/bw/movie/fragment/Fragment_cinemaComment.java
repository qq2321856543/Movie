package com.bw.movie.fragment;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.bw.movie.R;
import com.bw.movie.adapter.AllCinemaCommentAdapter;
import com.bw.movie.base.BaseFragment;
import com.bw.movie.base.BasePresenter;
import com.bw.movie.bean.AllCinemaCommentBean;
import com.bw.movie.bean.CinemaInfoBean;
import com.bw.movie.icoolor.ICoolor_AllCinemaComment;
import com.bw.movie.presenter.Presenter_AllCinemaComment;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.List;

import butterknife.BindView;

public class Fragment_cinemaComment extends BaseFragment implements ICoolor_AllCinemaComment.IVew {
    @BindView(R.id.rv)
    RecyclerView rv;
    @Override
    protected BasePresenter initPresenter() {
        return new Presenter_AllCinemaComment(this);
    }

    @Override
    protected int getLayout() {
        return R.layout.item_cinemacomment;
    }

    @Override
    protected void initView(View view) {

    }

    @Override
    protected void initData() {

    }

    @Override
    public void getAllCinemaCommentSuccess(AllCinemaCommentBean allCinemaCommentBean) {
        Log.i("yyy","getAllCinemaCommentSuccess"+allCinemaCommentBean.getMessage());
        List<AllCinemaCommentBean.ResultBean> result = allCinemaCommentBean.getResult();
        RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(getContext(),RecyclerView.VERTICAL,false);
        rv.setLayoutManager(layoutManager);
        AllCinemaCommentAdapter allCinemaCommentAdapter = new AllCinemaCommentAdapter(getContext(), result);
        rv.setAdapter(allCinemaCommentAdapter);
    }
    @Subscribe(threadMode = ThreadMode.MAIN,sticky = true)
    public void getEvent(Integer id){
        Log.i("yyy","getEvent");
        BasePresenter presenter = getPresenter();
        if (presenter != null) {
            ((ICoolor_AllCinemaComment.IPresenter)presenter).getAllCinemaComment(id,1,20);
        }
    }
    @Override
    public void onResume() {
        super.onResume();
        if (!EventBus.getDefault().isRegistered(this)){
            EventBus.getDefault().register(this);
        }
    }

    @Override
    public void onPause() {
        super.onPause();
        EventBus.getDefault().unregister(this);
    }
}
