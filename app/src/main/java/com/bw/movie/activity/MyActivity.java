package com.bw.movie.activity;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bw.movie.R;
import com.bw.movie.base.BaseAcitvity;
import com.bw.movie.base.BasePresenter;
import com.bw.movie.utils.SPUtils;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.controller.AbstractDraweeController;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequestBuilder;

import butterknife.BindView;

public class MyActivity extends BaseAcitvity implements View.OnClickListener {

    @BindView(R.id.sdv)
    SimpleDraweeView sdv;
    @BindView(R.id.name)
    TextView name;
    @BindView(R.id.sex)
    TextView sex;
    @BindView(R.id.riqi)
    TextView riqi;
    @BindView(R.id.tv_youxiang)
    TextView tv_youxiang;
    @BindView(R.id.iv_shap)
    ImageView iv_shap;
    @Override
    protected BasePresenter initPresenter() {
        return null;
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_my;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {
        iv_shap.setOnClickListener(this);

        String headPic = SPUtils.getString(this, SPUtils.USERINFO_NAME, "headPic");
        String nickName = SPUtils.getString(this, SPUtils.USERINFO_NAME, "nickName");
        String sex1 = SPUtils.getString(this, SPUtils.USERINFO_NAME, "sex");
        String birthday = SPUtils.getString(this, SPUtils.USERINFO_NAME, "birthday");
        String phone = SPUtils.getString(this, SPUtils.USERINFO_NAME, "phone");
        String email = SPUtils.getString(this, SPUtils.USERINFO_NAME, "email");
        Uri uri = Uri.parse(headPic);
        ImageRequest build = ImageRequestBuilder.newBuilderWithSource(uri)
                .setProgressiveRenderingEnabled(true).build();
        AbstractDraweeController build1 = Fresco.newDraweeControllerBuilder().setImageRequest(build).build();
        sdv.setController(build1);
        name.setText(nickName);
        if (sex1.equals("1")){

            sex.setText("男");
        }else {
            sex.setText("女");
        }
        riqi.setText(birthday);
        tv_youxiang.setText(email);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.iv_shap:
                finish();
                break;

            default:
        }

    }
}
