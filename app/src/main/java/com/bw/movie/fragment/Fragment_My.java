package com.bw.movie.fragment;

import android.content.Intent;
import android.net.Uri;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bw.movie.R;
import com.bw.movie.activity.MyActivity;
import com.bw.movie.activity.MyMovieCommentListActivity;
import com.bw.movie.activity.RecordFeedBackActivity;
import com.bw.movie.activity.SetupActivity;
import com.bw.movie.activity.UserFollowMovieActivity;
import com.bw.movie.activity.UserReserveActivity;
import com.bw.movie.base.BaseFragment;
import com.bw.movie.base.BasePresenter;
import com.bw.movie.utils.SPUtils;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.controller.AbstractDraweeController;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequestBuilder;

import butterknife.BindView;

public class Fragment_My extends BaseFragment implements View.OnClickListener {
    @BindView(R.id.rl1)
    RelativeLayout rl1;
    @BindView(R.id.rl2)
    RelativeLayout rl2;
    @BindView(R.id.iv_youjian)
    ImageView iv_youjian;
    @BindView(R.id.iv_wodeguanzhu)
    ImageView iv_wodeguanzhu;
    @BindView(R.id.ll_wodeyuyue)
    LinearLayout ll_wodeyuyue;
    @BindView(R.id.iv_goupiaojilu)
    ImageView iv_goupiaojilu;
    @BindView(R.id.iv_kanguodedianying)
    ImageView iv_kanguodedianying;
    @BindView(R.id.iv_wodepinglun)
    ImageView iv_wodepinglun;
    @BindView(R.id.iv_yijianfankui)
    ImageView iv_yijianfankui;
    @BindView(R.id.iv_shezhi)
    ImageView iv_shezhi;
    @BindView(R.id.sdv)
    SimpleDraweeView sdv;
    @BindView(R.id.tv_name)
    TextView tv_name;

    @Override
    protected BasePresenter initPresenter() {
        return null;
    }

    @Override
    protected int getLayout() {
        return R.layout.fragment_my;
    }

    @Override
    protected void initView(View view) {

    }

    @Override
    protected void initData() {
        rl1.setOnClickListener(this);
        iv_wodeguanzhu.setOnClickListener(this);
        ll_wodeyuyue.setOnClickListener(this);
        iv_wodepinglun.setOnClickListener(this);
        iv_shezhi.setOnClickListener(this);
        iv_yijianfankui.setOnClickListener(this);

        String nickName = SPUtils.getString(getContext(), SPUtils.USERINFO_NAME, "nickName");


        tv_name.setText(nickName);

        Runnable task = new Runnable() {
            @Override
            public void run() {
                /**
                 * 此处执行任务
                 * */
                mHanlder.sendEmptyMessage(1);
                mHanlder.postDelayed(this, 1 * 1000);//延迟5秒,再次执行task本身,实现了循环的效果
            }
        };
        mHanlder.postDelayed(task, 1000);//第一次调用,延迟1秒执行task

    }
    private Handler mHanlder = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case 1:
                    String headPic = SPUtils.getString(getContext(), SPUtils.USERINFO_NAME, "headPic");
                    Uri uri = Uri.parse(headPic);
                    ImageRequest build = ImageRequestBuilder.newBuilderWithSource(uri)
                            .setProgressiveRenderingEnabled(true).build();
                    AbstractDraweeController build1 = Fresco.newDraweeControllerBuilder().setImageRequest(build).build();
                    sdv.setController(build1);
                    break;
                default:
                    break;
            }
            super.handleMessage(msg);
        }
    };



    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.rl1:
                Intent intent = new Intent(getContext(), MyActivity.class);
                startActivity(intent);
                break;
            case R.id.iv_wodeguanzhu:
                Intent intent1 = new Intent(getContext(), UserFollowMovieActivity.class);
                startActivity(intent1);
                break;
            case R.id.ll_wodeyuyue:
                Intent intent2 = new Intent(getContext(), UserReserveActivity.class);
                startActivity(intent2);
                break;
            case R.id.iv_wodepinglun:
                Intent intent3 = new Intent(getContext(), MyMovieCommentListActivity.class);
                startActivity(intent3);
                break;
            case R.id.iv_shezhi:
                Intent intent4 = new Intent(getContext(), SetupActivity.class);
                startActivity(intent4);
                break;
            case R.id.iv_yijianfankui:
                Intent intent5 = new Intent(getContext(), RecordFeedBackActivity.class);
                startActivity(intent5);
                break;
                default:
        }
    }
}
