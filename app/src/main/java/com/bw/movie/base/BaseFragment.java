package com.bw.movie.base;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;

public abstract class BaseFragment<P extends BasePresenter> extends Fragment {

    private P presenter;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = View.inflate(getActivity(), getLayout(), null);
        presenter = initPresenter();
        ButterKnife.bind(this,view);
        initView(view);
        initData();
        return view;
    }

    protected abstract P initPresenter();

    protected abstract int getLayout();

    protected abstract void initView(View view);


    protected abstract void initData();

    public P getPresenter(){
        return presenter;
    }
}
