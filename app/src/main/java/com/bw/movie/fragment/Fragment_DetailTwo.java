package com.bw.movie.fragment;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.VideoView;

import com.bw.movie.R;
import com.bw.movie.adapter.ShortFilmListAdapter;
import com.bw.movie.base.BaseFragment;
import com.bw.movie.base.BasePresenter;
import com.bw.movie.bean.Moview_MoviesDetail;
import com.bw.movie.icoolor.ICoolor_MoviesDetail;
import com.bw.movie.presenter.Presenter_MoviesDetail;
import com.bw.movie.utils.SPUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class Fragment_DetailTwo extends BaseFragment implements ICoolor_MoviesDetail.IVew {

    @BindView(R.id.rv)
    RecyclerView rv;
    private ShortFilmListAdapter shortFilmListAdapter;

    @Override
    protected BasePresenter initPresenter() {
        return new Presenter_MoviesDetail(this);
    }

    @Override
    protected int getLayout() {
        return R.layout.fragment_detail_two;
    }

    @Override
    protected void initView(View view) {
        RecyclerView.LayoutManager layoutManager1=new LinearLayoutManager(getContext(),RecyclerView.VERTICAL,false);
        rv.setLayoutManager(layoutManager1);
        shortFilmListAdapter = new ShortFilmListAdapter(getContext());
        rv.setAdapter(shortFilmListAdapter);
    }

    @Override
    protected void initData() {
        int movieId = SPUtils.getInt(getContext(), "idd", "movieId");
        BasePresenter presenter = getPresenter();
        if (presenter!=null && presenter instanceof ICoolor_MoviesDetail.IPresenter){
            ((ICoolor_MoviesDetail.IPresenter)presenter).getMoviesDetail(movieId);
        }

//        rv.addOnScrollListener(new RecyclerView.OnScrollListener() {
//
//            private int thisPosition = -1;
//
//            @Override
//            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
//                super.onScrollStateChanged(recyclerView, newState);
//                switch (newState) {
//                    case RecyclerView.SCROLL_STATE_IDLE: //滚动停止
//                        LinearLayoutManager layoutManager = (LinearLayoutManager) recyclerView.getLayoutManager();
//                        if (layoutManager != null) {
//                            int firstVisibleItem = layoutManager.findFirstVisibleItemPosition();
//                            int lastVisibleItem = layoutManager.findLastVisibleItemPosition();
//                            int eddVisibleItem = layoutManager.findLastCompletelyVisibleItemPosition();
//                            if (eddVisibleItem == thisPosition) return;
//                            thisPosition = eddVisibleItem;
//                            int thisVideoView = eddVisibleItem - firstVisibleItem;
//                            if (layoutManager != null && layoutManager.getChildAt(thisVideoView) != null
//                                    && layoutManager.getChildAt(thisVideoView).findViewById(R.id.main_video) != null) {
//                                VideoView videoView = layoutManager.getChildAt(thisVideoView).findViewById(R.id.main_video);
//                                videoView.start();
////                                LogUtils.loge("开始播放新视频");
//                            }
//                        }
//                        break;
//                    case RecyclerView.SCROLL_STATE_DRAGGING: //手指拖动
//                        break;
//                    case RecyclerView.SCROLL_STATE_SETTLING: //惯性滚动
//                        break;
//                }
//            }
//
//            @Override
//            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
//                super.onScrolled(recyclerView, dx, dy);
//
//
//            }
//        });

    }

    @Override
    public void getMoviesDetailSuccess(Moview_MoviesDetail moviesDetail) {
        Moview_MoviesDetail.ResultBean result = moviesDetail.getResult();
        List<Moview_MoviesDetail.ResultBean.ShortFilmListBean> shortFilmList = result.getShortFilmList();
        shortFilmListAdapter.setData(shortFilmList);
    }
}
