package com.bw.movie.fragment;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.bw.movie.R;
import com.bw.movie.adapter.MyMovieCommentListAdapter;
import com.bw.movie.adapter.UserFollowMovieAdapter;
import com.bw.movie.base.BaseFragment;
import com.bw.movie.base.BasePresenter;
import com.bw.movie.bean.MyMovieCommentListBean;
import com.bw.movie.bean.UserFollowMovieBean;
import com.bw.movie.icoolor.ICoolor_MyMovieCommentList;
import com.bw.movie.icoolor.ICoolor_UserFollowMovie;
import com.bw.movie.presenter.Presenter_MyMovieCommentList;
import com.bw.movie.presenter.Presenter_UserFollowMovie;

import java.util.List;

import butterknife.BindView;

public class Fragment_MyMovieCommentList extends BaseFragment implements ICoolor_MyMovieCommentList.IVew {
    @BindView(R.id.rv)
    RecyclerView rv;
    private MyMovieCommentListAdapter myMovieCommentListAdapter;

    @Override
    protected BasePresenter initPresenter() {
        return new Presenter_MyMovieCommentList(this);
    }

    @Override
    protected int getLayout() {
        return R.layout.fragment_mymoviecommentlist;
    }

    @Override
    protected void initView(View view) {
        RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(getContext(),RecyclerView.VERTICAL,false);
        rv.setLayoutManager(layoutManager);
        myMovieCommentListAdapter = new MyMovieCommentListAdapter(getContext());
        rv.setAdapter(myMovieCommentListAdapter);
    }

    @Override
    protected void initData() {
        BasePresenter presenter = getPresenter();
        if (presenter!=null){
            ((ICoolor_MyMovieCommentList.IPersenter)presenter).getMyMovieCommentList(1,20);
        }
    }


    @Override
    public void getMyMovieCommentListSuccess(MyMovieCommentListBean myMovieCommentListBean) {
        List<MyMovieCommentListBean.ResultBean> result = myMovieCommentListBean.getResult();
        myMovieCommentListAdapter.setData(result);
    }
}
