package com.bw.movie.activity;

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
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bw.movie.R;
import com.bw.movie.adapter.ComingSoonMovieAdapter;
import com.bw.movie.base.BaseAcitvity;
import com.bw.movie.base.BasePresenter;
import com.bw.movie.bean.Moview_MoviesDetail;
import com.bw.movie.bean.RegisterBean;
import com.bw.movie.fragment.Fragment_DetailFour;
import com.bw.movie.fragment.Fragment_DetailOne;
import com.bw.movie.fragment.Fragment_DetailThree;
import com.bw.movie.fragment.Fragment_DetailTwo;
import com.bw.movie.icoolor.ICoolor_FollowMovie;
import com.bw.movie.presenter.Presenter_FollowMovie;
import com.bw.movie.utils.SPUtils;
import com.bw.movie.view.DrawerLayout;

import org.greenrobot.eventbus.EventBus;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import butterknife.BindView;

public class MoviesDetailActivity extends BaseAcitvity implements ICoolor_FollowMovie.IVew {

    @BindView(R.id.iv_max)
    ImageView iv_max;
    @BindView(R.id.tv_ping)
    TextView tv_ping;
    @BindView(R.id.tv_count)
    TextView tv_count;
    @BindView(R.id.tv_name)
    TextView tv_name;
    @BindView(R.id.tv_type)
    TextView tv_type;
    @BindView(R.id.tv_s)
    TextView tv_s;
    @BindView(R.id.tv_riqi)
    TextView tv_riqi;
    @BindView(R.id.tv_diqu)
    TextView tv_diqu;
    @BindView(R.id.tv_guanzhu)
    TextView tv_guanzhu;
    @BindView(R.id.iv_xin)
    ImageView iv_xin;
    @BindView(R.id.iv_shap)
    ImageView iv_shap;
    @BindView(R.id.tab)
    TabLayout tab;
    @BindView(R.id.vp)
    ViewPager vp;

    ArrayList<Fragment> fragmentList = new ArrayList<>();
    ArrayList<String> tabs = new ArrayList<>();
    @Override
    protected BasePresenter initPresenter() {
        return new Presenter_FollowMovie(this);
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_movies_detail;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {
        iv_shap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        Intent intent = getIntent();
        ArrayList<Moview_MoviesDetail.ResultBean> resultBeans = intent.getParcelableArrayListExtra("resultBeans");
        final Moview_MoviesDetail.ResultBean list = resultBeans.get(0);
        Glide.with(this).load(resultBeans.get(0).getImageUrl()).error(R.mipmap.ic_launcher).placeholder(R.mipmap.ic_launcher).into(iv_max);
        tv_ping.setText("评分："+resultBeans.get(0).getScore()+"分");
        tv_count.setText("评论 "+list.getCommentNum()+"万条");
        tv_name.setText(list.getName());
        tv_type.setText(list.getMovieType());
        Log.i("ggg",""+list.getMovieType());
        tv_s.setText(list.getDuration());
        Date date = new Date(list.getReleaseTime());
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String format = dateFormat.format(date);
        String[] split = format.split("-");

        tv_riqi.setText(split[1]+"月"+split[2]+"日"+"上映");
       // tv_riqi.setText(list.getReleaseTime()+"");
        tv_diqu.setText(list.getPlaceOrigin());
        int whetherFollow = list.getWhetherFollow();

        if (whetherFollow==1){
            tv_guanzhu.setText("已关注");
            iv_xin.setImageResource(R.mipmap.xin);
        }else {
            iv_xin.setImageResource(R.mipmap.baixin);
            tv_guanzhu.setText("关注");
        }
        iv_xin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("uuu","setOnClickListener=");

                BasePresenter presenter = getPresenter();
                if (presenter!=null){
                    ((ICoolor_FollowMovie.IPresenter)presenter).getMoviesDetail(list.getMovieId());
                }

            }
        });
        //Fragment设置数据
        int movieId = list.getMovieId();
//        EventBus.getDefault().postSticky(movieId);
        SPUtils.putInt(MoviesDetailActivity.this,"idd","movieId",movieId);


        DrawerLayout drawerLayout = new DrawerLayout(MoviesDetailActivity.this);
        drawerLayout.setInitialState(DrawerLayout.State.Close);


        //===========================
        Fragment_DetailOne fragment_detailOne = new Fragment_DetailOne();
        Fragment_DetailTwo fragment_detailTwo = new Fragment_DetailTwo();
        Fragment_DetailThree fragment_detailThree = new Fragment_DetailThree();
        Fragment_DetailFour fragment_detailFour = new Fragment_DetailFour();
        fragmentList.add(fragment_detailOne);
        fragmentList.add(fragment_detailTwo);
        fragmentList.add(fragment_detailThree);
        fragmentList.add(fragment_detailFour);
        tabs.add("介绍");
        tabs.add("预告");
        tabs.add("剧照");
        tabs.add("影评");
        tab.addTab(tab.newTab().setText(tabs.get(0)));
        tab.addTab(tab.newTab().setText(tabs.get(1)));
        tab.addTab(tab.newTab().setText(tabs.get(2)));
        tab.addTab(tab.newTab().setText(tabs.get(3)));
        FragmentPageAdap fragmentPageAdap = new FragmentPageAdap(getSupportFragmentManager());
        vp.setAdapter(fragmentPageAdap);
        tab.setupWithViewPager(vp);

    }

    @Override
    public void getMoviesDetailSuccess(Moview_MoviesDetail moviesDetail) {
        Moview_MoviesDetail.ResultBean result = moviesDetail.getResult();
        Log.i("fff","id="+result.getMovieId());

        int whetherFollow = result.getWhetherFollow();
        if (whetherFollow==1){
//            tv_guanzhu.setText("已关注");
//            iv_xin.setImageResource(R.mipmap.xin);
            Log.i("uuu","getMoviesDetailSuccess="+1);
            BasePresenter presenter = getPresenter();
            if (presenter!=null){
                ((ICoolor_FollowMovie.IPresenter)presenter).getCancelFollowMovie(result.getMovieId());
            }
        }else {

//            iv_xin.setImageResource(R.mipmap.baixin);
//            tv_guanzhu.setText("关注");
            BasePresenter presenter = getPresenter();
            if (presenter!=null){
                ((ICoolor_FollowMovie.IPresenter)presenter).getFollowMovieSuccess(result.getMovieId());

            }
        }
    }

    @Override
    public void getFollowMovieSuccess(RegisterBean registerBean) {
        String status = registerBean.getStatus();
        Log.i("uuu","getFollowMovieSuccess");

        if (status.equals("0000")){
            tv_guanzhu.setText("已关注");
            iv_xin.setImageResource(R.mipmap.xin);
            Toast.makeText(this, "关注成功", Toast.LENGTH_SHORT).show();
            Log.i("uuu","getFollowMovieSuccess关注成功");

        }else {
            iv_xin.setImageResource(R.mipmap.baixin);
            tv_guanzhu.setText("关注");
            Toast.makeText(this, "关注失败", Toast.LENGTH_SHORT).show();
            Log.i("uuu","getFollowMovieSuccess关注失败");

        }
    }

    @Override
    public void getCancelFollowMovie(RegisterBean registerBean) {
        String status = registerBean.getStatus();
        Log.i("uuu","getCancelFollowMovie");

        if (status.equals("0000")){
            tv_guanzhu.setText("关注");
            iv_xin.setImageResource(R.mipmap.baixin);
            Toast.makeText(this, "取消关注成功", Toast.LENGTH_SHORT).show();
            Log.i("uuu","getCancelFollowMovie取消关注成功");

        }else {
            iv_xin.setImageResource(R.mipmap.xin);
            tv_guanzhu.setText("取消关注");
            Toast.makeText(this, "取消关注失败", Toast.LENGTH_SHORT).show();
            Log.i("uuu","getCancelFollowMovie取消关注失败");

        }
    }

    public class FragmentPageAdap extends FragmentPagerAdapter {

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
