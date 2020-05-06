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
import com.bw.movie.bean.DateListBean;
import com.bw.movie.fragment.Fragment_CinemaScheduleList;
import com.bw.movie.icoolor.ICoolor_DateList;
import com.bw.movie.presenter.Presenter_DataList;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class CinemaScheduleListActivity extends BaseAcitvity implements ICoolor_DateList.IVew {
    @BindView(R.id.iv_shape)
    ImageView iv_shape;
    @BindView(R.id.tab)
    TabLayout tab;
    @BindView(R.id.vp)
    ViewPager vp;
    ArrayList<Fragment> list = new ArrayList<>();
    ArrayList<String> tabs = new ArrayList<>();
    private List<String> result;

    @Override
    protected BasePresenter initPresenter() {
        return new Presenter_DataList(this);
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_cinema_schedule_list;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {
        BasePresenter presenter = getPresenter();
        if (presenter != null) {
            ((ICoolor_DateList.IPersenter)presenter).getDataList();
        }
        iv_shape.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    @Override
    public void getDataListSuccess(DateListBean dateListBean) {
        result = dateListBean.getResult();
        for (int i=0;i<7;i++){
            list.add(new Fragment_CinemaScheduleList());
        }
        tab.addTab(tab.newTab().setText(result.get(0)));
        tab.addTab(tab.newTab().setText(result.get(1)));
        tab.addTab(tab.newTab().setText(result.get(2)));
        tab.addTab(tab.newTab().setText(result.get(3)));
        tab.addTab(tab.newTab().setText(result.get(4)));
        tab.addTab(tab.newTab().setText(result.get(5)));
        tab.addTab(tab.newTab().setText(result.get(6)));
        FragmentPagerAd fragmentPagerAd = new FragmentPagerAd(getSupportFragmentManager());
        vp.setAdapter(fragmentPagerAd);
        tab.setupWithViewPager(vp);
    }
    public class FragmentPagerAd extends FragmentPagerAdapter{

        public FragmentPagerAd(FragmentManager fm) {
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
            return result.get(position);
        }
    }
}
