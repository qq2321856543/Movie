package com.bw.movie.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bw.movie.R;
import com.bw.movie.base.BaseAcitvity;
import com.bw.movie.base.BasePresenter;
import com.bw.movie.utils.SPUtils;

import butterknife.BindView;

public class MainActivity extends BaseAcitvity {

    @BindView(R.id.iv)
    ImageView iv;
    @Override
    protected BasePresenter initPresenter() {
        return null;
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {
        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                String string = SPUtils.getString(MainActivity.this, SPUtils.USERINFO_NAME, SPUtils.USERINFO_KEY_USER_ID);
                String string1 = SPUtils.getString(MainActivity.this, SPUtils.USERINFO_NAME, SPUtils.USERINFO_KEY_SESSION_ID);
                if (TextUtils.isEmpty(string)&&TextUtils.isEmpty(string1)){
                    Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                    startActivity(intent);
                    finish();
                }else {
                    Intent intent = new Intent(MainActivity.this, HomeActivity.class);
                    startActivity(intent);
                    finish();
                }

            }
        },3000);
    }
}
