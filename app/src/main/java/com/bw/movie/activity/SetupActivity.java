package com.bw.movie.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.bw.movie.R;
import com.bw.movie.base.BaseAcitvity;
import com.bw.movie.base.BasePresenter;

import butterknife.BindView;

public class SetupActivity extends BaseAcitvity implements View.OnClickListener {
    //TODO:设置页 清除缓存 版本更新 重置密码
    @BindView(R.id.rl_qingchu)
    RelativeLayout rl_qingchu;
    @BindView(R.id.rl_banben)
    RelativeLayout rl_banben;
    @BindView(R.id.rl_chongzhi)
    RelativeLayout rl_chongzhi;
    @BindView(R.id.bt_tuichu)
    Button bt_tuichu;
    @BindView(R.id.iv_shape)
    ImageView iv_shape;
    @Override
    protected BasePresenter initPresenter() {
        return null;
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_setup;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {
        rl_qingchu.setOnClickListener(this);
        rl_banben.setOnClickListener(this);
        rl_chongzhi.setOnClickListener(this);
        bt_tuichu.setOnClickListener(this);
        iv_shape.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.rl_qingchu:
                break;
            case R.id.rl_banben:
                break;
            case R.id.rl_chongzhi:
                break;
            case R.id.bt_tuichu:
                Intent intent = new Intent(SetupActivity.this, LoginActivity.class);
                startActivity(intent);
                break;
            case R.id.iv_shape:
                finish();
                break;
                default:
        }
    }
}
