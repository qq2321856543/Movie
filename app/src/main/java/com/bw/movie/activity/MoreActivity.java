package com.bw.movie.activity;

import android.content.Intent;
import android.os.Parcelable;
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

import com.bw.movie.R;
import com.bw.movie.base.BaseAcitvity;
import com.bw.movie.base.BasePresenter;
import com.bw.movie.bean.Movie_ComingSoonMovie;
import com.bw.movie.bean.Movie_HotMovieBean;
import com.bw.movie.bean.Movie_ReleaseMovieBean;
import com.bw.movie.fragment.Fragment_one;
import com.bw.movie.fragment.Fragment_three;
import com.bw.movie.fragment.Fragment_two;

import java.util.ArrayList;

import butterknife.BindView;

/**
 * 更多
 */
public class MoreActivity extends BaseAcitvity implements View.OnClickListener {

    @BindView(R.id.iv_shape)
    ImageView iv_shape;
    @BindView(R.id.iv_search)
    ImageView iv_search;
    @BindView(R.id.tab)
    TabLayout tab;
    @BindView(R.id.vp)
    ViewPager vp;
    ArrayList<Fragment> fragmentList = new ArrayList<>();
    ArrayList<String> tabs = new ArrayList<>();
    @Override
    protected BasePresenter initPresenter() {
        return null;
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_more;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {
        Intent intent = getIntent();
        ArrayList<Movie_ReleaseMovieBean.ResultBean> list_one = intent.getParcelableArrayListExtra("list_one");
        ArrayList<Movie_ComingSoonMovie.ResultBean> list_two = intent.getParcelableArrayListExtra("list_two");
        ArrayList<Movie_HotMovieBean.ResultBean> list_three = intent.getParcelableArrayListExtra("list_three");
        int i = intent.getIntExtra("i",0);

        Fragment_one fragment_one = new Fragment_one();
        Fragment_two fragment_two = new Fragment_two();
        Fragment_three fragment_three = new Fragment_three();
        fragmentList.add(fragment_one);
        fragmentList.add(fragment_two);
        fragmentList.add(fragment_three);

        tabs.add("正在上映");
        tabs.add("即将上映");
        tabs.add("热门电影");
        tab.addTab(tab.newTab().setText(tabs.get(0)));
        tab.addTab(tab.newTab().setText(tabs.get(1)));
        tab.addTab(tab.newTab().setText(tabs.get(2)));
        FragmentPageAdap fragmentPageAdap = new FragmentPageAdap(getSupportFragmentManager());
        tab.setupWithViewPager(vp);
        vp.setAdapter(fragmentPageAdap);
        vp.setCurrentItem(i);

        iv_shape.setOnClickListener(this);
        iv_search.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.iv_shape:
                finish();
                break;
            case R.id.iv_search:
                Intent intent = new Intent(MoreActivity.this, Search_MovieByKeyword_Activity.class);
                startActivity(intent);
                break;

            default:
        }
    }

    public class FragmentPageAdap extends FragmentPagerAdapter{

        public FragmentPageAdap(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int i) {
            return fragmentList.get(i);
        }

        @Override
        public int getCount() {
            return fragmentList.size();
        }

        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            return tabs.get(position);
        }
    }
}
