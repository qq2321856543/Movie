package com.bw.movie.activity;

import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.bw.movie.R;
import com.bw.movie.base.BaseAcitvity;
import com.bw.movie.base.BasePresenter;
import com.bw.movie.bean.UserFollowMovieBean;
import com.bw.movie.fragment.Fragment_UserFollowMovie;
import com.bw.movie.fragment.Fragment_UserFollowcCinema;
import com.bw.movie.icoolor.ICoolor_UserFollowMovie;
import com.bw.movie.presenter.Presenter_UserFollowMovie;

import java.util.ArrayList;

import butterknife.BindView;

public class UserFollowMovieActivity extends BaseAcitvity  {

    ArrayList<Fragment> list = new ArrayList<>();
    ArrayList<String> tabs = new ArrayList<>();
    @BindView(R.id.iv_shape)
    ImageView iv_shape;
    @BindView(R.id.tab)
    TabLayout tab;
    @BindView(R.id.vp)
    ViewPager vp;
    @Override
    protected BasePresenter initPresenter() {
        return new Presenter_UserFollowMovie(this);
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_user_follow_movie;
    }

    @Override
    protected void initView() {
    }

    @Override
    protected void initData() {
        iv_shape.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        list.add(new Fragment_UserFollowMovie());
        list.add(new Fragment_UserFollowcCinema());
        tabs.add("电影");
        tabs.add("影院");
        tab.addTab(tab.newTab().setText(tabs.get(0)));
        tab.addTab(tab.newTab().setText(tabs.get(1)));
        FragmentPageAdap fragmentPageAdap = new FragmentPageAdap(getSupportFragmentManager());

        vp.setAdapter(fragmentPageAdap);
        tab.setupWithViewPager(vp);

    }
    public class FragmentPageAdap extends FragmentPagerAdapter{

        public FragmentPageAdap(FragmentManager fm) {
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
