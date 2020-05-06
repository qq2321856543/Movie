package com.bw.movie.activity;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bw.movie.R;
import com.bw.movie.base.BaseAcitvity;
import com.bw.movie.base.BasePresenter;
import com.bw.movie.bean.CinemaInfoBean;
import com.bw.movie.bean.LoginBean;
import com.bw.movie.fragment.Fragment_CinemaInfo;
import com.bw.movie.fragment.Fragment_cinemaComment;
import com.bw.movie.icoolor.ICoolor_CinemaInfo;
import com.bw.movie.presenter.Presenter_CinemaInfo;
import com.bw.movie.utils.HttpUtil;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;

import butterknife.BindView;

public class CinemaInfoActivity extends BaseAcitvity implements ICoolor_CinemaInfo.IVew {

    @BindView(R.id.iv_shape)
    ImageView iv_shape;
    @BindView(R.id.tv_name)
    TextView tv_name;
    @BindView(R.id.iv_xin)
    ImageView iv_xin;
    @BindView(R.id.ll)
    LinearLayout ll;
    @BindView(R.id.tv_type)
    TextView tv_type;
    @BindView(R.id.tab)
    TabLayout tab;
    @BindView(R.id.vp)
    ViewPager vp;
    @BindView(R.id.tv_chakan)
    TextView tv_chakan;
    ArrayList<Fragment> list = new ArrayList<>();
    ArrayList<String> tabs = new ArrayList<>();
    private int id;

    @Override
    protected BasePresenter initPresenter() {
        return new Presenter_CinemaInfo(this);
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_cinema_info;
    }

    @Override
    protected void initView() {

    }
    public void info(int id){
        if (HttpUtil.getInstance().isWifi(this)){
            BasePresenter presenter = getPresenter();
            if (presenter != null) {
                ((ICoolor_CinemaInfo.IPresenter)presenter).getCinemaInfo(id);
            }
        }
    }
    @Override
    protected void initData() {
        Intent intent = getIntent();
        id = intent.getIntExtra("id", 0);
        info(id);
        list.add(new Fragment_CinemaInfo());
        list.add(new Fragment_cinemaComment());
        tabs.add("影院详情");
        tabs.add("影院评价");
        tab.addTab(tab.newTab().setText(tabs.get(0)));
        tab.addTab(tab.newTab().setText(tabs.get(1)));
        FreamentPageAdap freamentPageAdap = new FreamentPageAdap(getSupportFragmentManager());
        vp.setAdapter(freamentPageAdap);
        tab.setupWithViewPager(vp);
        iv_shape.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        tv_chakan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(CinemaInfoActivity.this, CinemaScheduleListActivity.class);
                intent1.putExtra("id",id);
                startActivity(intent1);
            }
        });
    }

    @Override
    public void getCinemaInfoSuccess(CinemaInfoBean cinemaInfoBean) {
        final CinemaInfoBean.ResultBean result = cinemaInfoBean.getResult();
        tv_name.setText(result.getName());
        tv_type.setText(result.getLabel());
        if (result.getFollowCinema()==1){
            //已关注
            iv_xin.setImageResource(R.mipmap.xin);
        }else {
            //未关注
            iv_xin.setImageResource(R.mipmap.baixin);
        }
        EventBus.getDefault().post(result);
        EventBus.getDefault().postSticky(id);

        iv_xin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (result.getFollowCinema()==1){
                    BasePresenter presenter = getPresenter();
                    if (presenter != null) {
                        ((ICoolor_CinemaInfo.IPresenter)presenter).getCancelFollowCinemaSuccess(id);
                    }
                }else {
                    BasePresenter presenter = getPresenter();
                    if (presenter != null) {
                        ((ICoolor_CinemaInfo.IPresenter)presenter).getFollowCinema(id);
                    }
                    if (result.getFollowCinema()==1){
                        //已关注
                        iv_xin.setImageResource(R.mipmap.xin);
                    }else {
                        //未关注
                        iv_xin.setImageResource(R.mipmap.baixin);
                    }
                }
            }
        });

    }

    @Override
    public void getFollowCinemaSuccess(LoginBean loginBean) {
        Toast.makeText(this, ""+loginBean.getMessage(), Toast.LENGTH_SHORT).show();
        info(id);
    }

    @Override
    public void getCancelFollowCinemaSuccess(LoginBean loginBean) {
        Toast.makeText(this, ""+loginBean.getMessage(), Toast.LENGTH_SHORT).show();
        info(id);
    }

    public class FreamentPageAdap extends FragmentPagerAdapter{

        public FreamentPageAdap(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int i) {
            return list.get(i);
        }

        @Override
        public int getCount() {
            return list.size();
        }

        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            return tabs.get(position);
        }
    }
}
