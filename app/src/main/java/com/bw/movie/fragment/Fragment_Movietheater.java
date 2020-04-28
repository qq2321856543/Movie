package com.bw.movie.fragment;

import android.util.Log;
import android.view.View;

import com.bw.movie.R;
import com.bw.movie.base.BaseFragment;
import com.bw.movie.base.BasePresenter;

public class Fragment_Movietheater extends BaseFragment {
    @Override
    protected BasePresenter initPresenter() {
        return null;
    }

    @Override
    protected int getLayout() {
        return R.layout.fragment_movietheater;
    }

    @Override
    protected void initView(View view) {

    }

    @Override
    protected void initData() {
        Log.i("ppp","Two");

    }
}
