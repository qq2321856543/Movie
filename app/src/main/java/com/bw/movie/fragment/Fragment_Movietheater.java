package com.bw.movie.fragment;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bw.movie.R;
import com.bw.movie.activity.Search_MovieByKeyword_Activity;
import com.bw.movie.base.App;
import com.bw.movie.base.BaseFragment;
import com.bw.movie.base.BasePresenter;
import com.bw.movie.utils.SPUtils;

import java.util.ArrayList;

import butterknife.BindView;

public class Fragment_Movietheater extends BaseFragment {
    @BindView(R.id.city)
    TextView city;
    @BindView(R.id.iv_search)
    ImageView iv_search;
    @BindView(R.id.tab)
    TabLayout tab;
    @BindView(R.id.vp)
    ViewPager vp;
    ArrayList<Fragment> list = new ArrayList<>();
    ArrayList<String> tabs = new ArrayList<>();
    @Override
    protected BasePresenter initPresenter() {
        return null;
    }

    @Override
    protected int getLayout() {
        return R.layout.fragment_movietheater;
    }

    @Override
    protected void initView(View view) {
        String diqu = SPUtils.getString(getContext(), SPUtils.USERINFO_NAME, "diqu");
        city.setText(diqu);
    }

    @Override
    protected void initData() {
        list.clear();
        list.add(new Fragment_RecommendCinemas());
        list.add(new Fragment_NearbyCinemas());
        list.add(new Fragment_Location());
        tabs.clear();
        tabs.add("推荐影院");
        tabs.add("附近影院");
        tabs.add("海淀区 ▼");
        tab.addTab(tab.newTab().setText(tabs.get(0)));
        tab.addTab(tab.newTab().setText(tabs.get(1)));
        tab.addTab(tab.newTab().setText(tabs.get(2)));
        FragmentPageAdap fragmentPageAdap = new FragmentPageAdap(getChildFragmentManager());
        vp.setAdapter(fragmentPageAdap);
        tab.setupWithViewPager(vp);

        iv_search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), Search_MovieByKeyword_Activity.class);
                startActivity(intent);
            }
        });
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
