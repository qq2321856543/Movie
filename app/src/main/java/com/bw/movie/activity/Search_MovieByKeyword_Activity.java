package com.bw.movie.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import com.bw.movie.R;
import com.bw.movie.adapter.Search_MovieByKeywordAdapter;
import com.bw.movie.base.BaseAcitvity;
import com.bw.movie.base.BasePresenter;
import com.bw.movie.bean.Search_MovieByKeywordBean;
import com.bw.movie.icoolor.ICoolor_Search;
import com.bw.movie.presenter.Presenter_Search;

import java.util.List;

import butterknife.BindView;

public class Search_MovieByKeyword_Activity extends BaseAcitvity implements ICoolor_Search.IView {

    @BindView(R.id.iv_shap)
    ImageView iv_shap;
    @BindView(R.id.et)
    EditText et;
    @BindView(R.id.rv)
    RecyclerView rv;
    private Search_MovieByKeywordAdapter search_movieByKeywordAdapter;

    @Override
    protected BasePresenter initPresenter() {
        return new Presenter_Search(this);
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_search__movie_by_keyword_;
    }

    @Override
    protected void initView() {
        RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(this,RecyclerView.VERTICAL,false);
        rv.setLayoutManager(layoutManager);
        search_movieByKeywordAdapter = new Search_MovieByKeywordAdapter(this);
        rv.setAdapter(search_movieByKeywordAdapter);
    }

    @Override
    protected void initData() {
        iv_shap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        et.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                BasePresenter presenter = getPresenter();
                if (presenter!=null && presenter instanceof ICoolor_Search.IPresenter){
                    ((ICoolor_Search.IPresenter)presenter).getSearch_MovieByKeyword(et.getText().toString(),1,5);
                }
            }
        });
    }

    @Override
    public void getSearch_MovieByKeywordSuccess(Search_MovieByKeywordBean movieByKeywordBean) {
        List<Search_MovieByKeywordBean.ResultBean> result = movieByKeywordBean.getResult();
        if (result!=null){
            search_movieByKeywordAdapter.setData(result);
        }
    }
}
