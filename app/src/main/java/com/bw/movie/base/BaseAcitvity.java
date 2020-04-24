package com.bw.movie.base;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import butterknife.ButterKnife;

public abstract class BaseAcitvity<P extends BasePresenter> extends AppCompatActivity implements IBaseView {

    private P mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayout());
        if (getSupportActionBar()!=null){
            getSupportActionBar().hide();
        }

        ButterKnife.bind(this);
        mPresenter = initPresenter();

        initView();
        initData();
    }
    public P getPresenter(){
        return mPresenter;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mPresenter!=null){
            mPresenter.detachView();
            mPresenter=null;
        }
    }

    protected abstract P initPresenter();

    protected abstract int getLayout();

    protected abstract void initView();

    protected abstract void initData();
}
