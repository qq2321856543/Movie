package com.bw.movie.activity;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.load.engine.Resource;
import com.bw.movie.R;
import com.bw.movie.base.BaseAcitvity;
import com.bw.movie.base.BasePresenter;
import com.bw.movie.fragment.Fragment_Movie;
import com.bw.movie.fragment.Fragment_Movietheater;
import com.bw.movie.fragment.Fragment_My;

import java.util.ArrayList;

import butterknife.BindView;

public class HomeActivity extends BaseAcitvity  {
    ArrayList<Fragment> list = new ArrayList<>();
    ArrayList<String> tabs = new ArrayList<>();
    ArrayList<Integer> imagelist = new ArrayList<>();

    @BindView(R.id.vp)
    ViewPager vp;
    @BindView(R.id.tab)
    TabLayout tab;
    @Override
    protected BasePresenter initPresenter() {
        return null;
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_home;
    }

    @Override
    protected void initView() {

    }
    @SuppressLint("ResourceType")
    @Override
    protected void initData() {
        showDialog();
        Fragment_Movie fragment_movie = new Fragment_Movie();
        Fragment_Movietheater fragment_movietheater = new Fragment_Movietheater();
        Fragment_My fragment_my = new Fragment_My();
        list.add(fragment_movie);
        list.add(fragment_movietheater);
        list.add(fragment_my);
        tabs.add("电影");
        tabs.add("影院");
        tabs.add("我的");
        tab.addTab(tab.newTab().setText(tabs.get(0)));
        tab.addTab(tab.newTab().setText(tabs.get(1)));
        tab.addTab(tab.newTab().setText(tabs.get(2)));
        imagelist.add(R.mipmap.wode);
        imagelist.add(R.mipmap.yingyuan);
        imagelist.add(R.mipmap.wode);
        FragmentPageAdap fragmentPageAdap = new FragmentPageAdap(getSupportFragmentManager());
        vp.setAdapter(fragmentPageAdap);
        tab.setupWithViewPager(vp);

        for (int i=0;i<tab.getTabCount();i++){
            TabLayout.Tab tabAt = tab.getTabAt(i);
            if (tabAt!=null){
                tabAt.setCustomView(fragmentPageAdap.getTabView(i));
            }
        }
        tab.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tabb) {
                View view = tabb.getCustomView();
                TextView tv=view.findViewById(R.id.tv);

                tv.setVisibility(View.VISIBLE);
                view.findViewById(R.id.iv).setFocusable(true);
                view.findViewById(R.id.ll).setBackgroundColor(Color.WHITE);
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tabb) {
                View view = tabb.getCustomView();
                TextView tv=view.findViewById(R.id.tv);

                tv.setVisibility(View.GONE);
                view.findViewById(R.id.iv).setFocusable(false);
                int i = Color.parseColor("#1C2243");
                view.findViewById(R.id.ll).setBackgroundColor(i);
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        hideDialog();
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
        public View getTabView(int position){
            View view = LayoutInflater.from(getApplicationContext()).inflate(R.layout.tab, null);
            TextView tv=view.findViewById(R.id.tv);
            ImageView iv=view.findViewById(R.id.iv);
            tv.setText(tabs.get(position));
            iv.setImageResource(imagelist.get(position));
            return view;
        }
    }
}
