package com.bw.movie.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bw.movie.R;
import com.bw.movie.base.BaseAcitvity;
import com.bw.movie.base.BasePresenter;
import com.bw.movie.bean.LoginBean;
import com.bw.movie.icoolor.ICoolor_MovieComment;
import com.bw.movie.presenter.Presenter_MovieComment;
import com.bw.movie.view.RatingBar;

import butterknife.BindView;

public class MovieCommentActivity extends BaseAcitvity implements ICoolor_MovieComment.IVew {
    @BindView(R.id.tv_name)
    TextView tv_name;
    @BindView(R.id.rb)
    RatingBar rb;
    @BindView(R.id.tv_wodepingfen)
    TextView tv_wodepingfen;
    @BindView(R.id.et_xie)
    EditText et_xie;
    @BindView(R.id.iv_shape)
    ImageView iv_shape;
    @BindView(R.id.bt_tijiao)
    Button bt_tijiao;
    float i=0;

    @Override
    protected BasePresenter initPresenter() {
        return new Presenter_MovieComment(this);
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_movie_comment;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {
        Intent intent = getIntent();
        final int id = intent.getIntExtra("id", 0);
        String name = intent.getStringExtra("name");
        tv_name.setText(name);
        final Editable text = et_xie.getText();
        rb.setOnRatingChangeListener(new RatingBar.OnRatingChangeListener() {
            @Override
            public void onRatingChange(float ratingCount) {
                i=ratingCount*2;
                tv_wodepingfen.setText("我的评分 （"+i+"分）");
            }
        });
        //点击提交
        bt_tijiao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                BasePresenter presenter = getPresenter();
                if (presenter != null) {
                    ((ICoolor_MovieComment.IPersenter)presenter).getMovieComment(id,text.toString(),(double)i);
                }
            }
        });
        iv_shape.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }

    @Override
    public void getMovieCommentSuccess(LoginBean loginBean) {
        Toast.makeText(this, ""+loginBean.getMessage(), Toast.LENGTH_SHORT).show();
    }
}
