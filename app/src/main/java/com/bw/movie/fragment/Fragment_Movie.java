package com.bw.movie.fragment;

import android.content.Intent;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationClient;
import com.amap.api.location.AMapLocationClientOption;
import com.amap.api.location.AMapLocationListener;
import com.amap.api.maps2d.AMap;
import com.amap.api.maps2d.CameraUpdateFactory;
import com.amap.api.maps2d.LocationSource;
import com.amap.api.maps2d.MapView;
import com.amap.api.maps2d.UiSettings;
import com.amap.api.maps2d.model.LatLng;
import com.bumptech.glide.Glide;
import com.bw.movie.R;
import com.bw.movie.activity.MoreActivity;
import com.bw.movie.activity.MoviesDetailActivity;
import com.bw.movie.activity.Search_MovieByKeyword_Activity;
import com.bw.movie.adapter.ComingSoonMovieAdapter;
import com.bw.movie.adapter.HotMovieAdapter;
import com.bw.movie.adapter.ReleaseMovieAdapter;
import com.bw.movie.base.App;
import com.bw.movie.base.BaseFragment;
import com.bw.movie.base.BasePresenter;
import com.bw.movie.bean.BannerBean;
import com.bw.movie.bean.Movie_ComingSoonMovie;
import com.bw.movie.bean.Movie_HotMovieBean;
import com.bw.movie.bean.Movie_ReleaseMovieBean;
import com.bw.movie.bean.Moview_MoviesDetail;
import com.bw.movie.bean.RegisterBean;
import com.bw.movie.icoolor.ICoolor_Movie;
import com.bw.movie.icoolor.ICoolor_MoviesDetail;
import com.bw.movie.presenter.Presenter_Movie;
import com.bw.movie.presenter.Presenter_MoviesDetail;
import com.bw.movie.utils.HttpUtil;
import com.bw.movie.utils.SPUtils;
import com.stx.xhb.xbanner.XBanner;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import butterknife.BindView;

public class Fragment_Movie extends BaseFragment implements ICoolor_Movie.IVew, View.OnClickListener, LocationSource, AMapLocationListener {
    //AMap是地图对象
    private AMap aMap;
    private MapView mapView;
    //声明AMapLocationClient类对象，定位发起端
    private AMapLocationClient mLocationClient = null;
    //声明mLocationOption对象，定位参数
    public AMapLocationClientOption mLocationOption = null;
    //声明mListener对象，定位监听器
    private LocationSource.OnLocationChangedListener mListener = null;
    //标识，用于判断是否只显示一次定位信息和用户重新定位
    private boolean isFirstLoc = true;
    private String city1;


    @BindView(R.id.rv_one)
    RecyclerView rv_one;
    @BindView(R.id.rv_two)
    RecyclerView rv_two;
    @BindView(R.id.rv_three)
    RecyclerView rv_three;

    @BindView(R.id.tv_one)
    TextView tv_one;
    @BindView(R.id.tv_two)
    TextView tv_two;
    @BindView(R.id.tv_three)
    TextView tv_three;

    @BindView(R.id.iv_max)
    ImageView iv_max;
    @BindView(R.id.tv_name)
    TextView tv_name;
    @BindView(R.id.tv_fen)
    TextView tv_fen;
    @BindView(R.id.bt_ok)
    Button bt_ok;
    @BindView(R.id.xb)
    XBanner xb;
    @BindView(R.id.tv_postion)
    TextView tv_postion;
    @BindView(R.id.city)
    TextView city;

    @BindView(R.id.iv_search)
    ImageView iv_search;
    private ReleaseMovieAdapter releaseMovieAdapter;
    private ComingSoonMovieAdapter comingSoonMovieAdapter;
    private HotMovieAdapter hotMovieAdapter;
    private List<Movie_ReleaseMovieBean.ResultBean> result1;
    private List<Movie_ComingSoonMovie.ResultBean> result2;
    private List<Movie_HotMovieBean.ResultBean> result3;

    @Override
    protected BasePresenter initPresenter() {
        return new Presenter_Movie(this);
    }

    @Override
    protected int getLayout() {
        return R.layout.fragment_movie;
    }

    @Override
    protected void initView(View view) {
        mapView = (MapView) view.findViewById(R.id.map);
        //在activity执行onCreate时执行mMapView.onCreate(savedInstanceState)，实现地图生命周期管理
        if (aMap == null) {
            aMap = mapView.getMap();
            //设置显示定位按钮 并且可以点击
            UiSettings settings = aMap.getUiSettings();
            aMap.setLocationSource(this);//设置了定位的监听
            // 是否显示定位按钮
            settings.setMyLocationButtonEnabled(true);
            aMap.setMyLocationEnabled(true);//显示定位层并且可以触发定位,默认是flase
        }
        location();



        RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,false);
        rv_one.setLayoutManager(layoutManager);
        releaseMovieAdapter = new ReleaseMovieAdapter(getContext());
        rv_one.setAdapter(releaseMovieAdapter);

        RecyclerView.LayoutManager layoutManager1=new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false);
        rv_two.setLayoutManager(layoutManager1);
        comingSoonMovieAdapter = new ComingSoonMovieAdapter(getContext());
        rv_two.setAdapter(comingSoonMovieAdapter);

        RecyclerView.LayoutManager layoutManager2=new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,false);
        rv_three.setLayoutManager(layoutManager2);
        hotMovieAdapter = new HotMovieAdapter(getContext());
        rv_three.setAdapter(hotMovieAdapter);
    }

    @Override
    protected void initData() {

        if (city1 != null){
            city.setText(city1+"");
        }

        tv_one.setOnClickListener(this);
        tv_two.setOnClickListener(this);
        tv_three.setOnClickListener(this);
        if (HttpUtil.getInstance().isWifi(getContext())){
            //有网络
            BasePresenter presenter = getPresenter();
            if (presenter!=null&&presenter instanceof ICoolor_Movie.IPresenter){
                showDialog();
                //轮播
                ((ICoolor_Movie.IPresenter)presenter).getXbanner();
                //正在热映
                ((ICoolor_Movie.IPresenter)presenter).getReleaseMovieList(1,5);
                //即将上映
                ((ICoolor_Movie.IPresenter)presenter).getComingSoonMovieList(1,5);
                //热门电影
                ((ICoolor_Movie.IPresenter)presenter).getHotMovieList(1,5);
            }
        }else {
            //无网络
        }
        //点击跳转搜索
        iv_search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), Search_MovieByKeyword_Activity.class);

                startActivity(intent);
            }
        });
        releaseMovieAdapter.SetOnclick(new ReleaseMovieAdapter.Onclick() {
            @Override
            public void click(int movieId) {
                BasePresenter presenter = getPresenter();
                if (presenter!=null){
                    ((Presenter_Movie)presenter).getMoviesDetail(movieId);
                }
            }
        });
        comingSoonMovieAdapter.SetOnclick(new ComingSoonMovieAdapter.Onclick() {
            @Override
            public void click(int movieId) {
                BasePresenter presenter = getPresenter();
                if (presenter!=null){
                    ((Presenter_Movie)presenter).getMoviesDetail(movieId);
                }
            }
        });
        hotMovieAdapter.SetOnclick(new HotMovieAdapter.Onclick() {
            @Override
            public void click(int movieId) {
                BasePresenter presenter = getPresenter();
                if (presenter!=null){
                    ((Presenter_Movie)presenter).getMoviesDetail(movieId);
                }
            }
        });
        //点击预约购票
        comingSoonMovieAdapter.SetOnclick_ok(new ComingSoonMovieAdapter.Onclick_ok() {
            @Override
            public void click(int movieId) {
                BasePresenter presenter = getPresenter();
                if (presenter!=null){
                    ((Presenter_Movie)presenter).getReserve(movieId);
                }
            }
        });

    }

    @Override
    public void getReleaseMovieSuccess(Movie_ReleaseMovieBean releaseMovieBean) {
        hideDialog();

        result1 = releaseMovieBean.getResult();
        releaseMovieAdapter.setData(result1);
    }

    @Override
    public void getComingSoonMovieSuccess(Movie_ComingSoonMovie comingSoonMovie) {
        hideDialog();

        result2 = comingSoonMovie.getResult();
        comingSoonMovieAdapter.setData(result2);
    }

    @Override
    public void getHotMovieSuccess(Movie_HotMovieBean hotMovieBean) {
        hideDialog();
        result3 = hotMovieBean.getResult();
        hotMovieAdapter.setData(result3);
        Glide.with(getContext()).load(result3.get(0).getHorizontalImage()).error(R.mipmap.ic_launcher).placeholder(R.mipmap.ic_launcher).into(iv_max);
        tv_name.setText(result3.get(0).getName());
        tv_fen.setText(result3.get(0).getScore()+"分");
        iv_max.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BasePresenter presenter = getPresenter();
                if (presenter!=null){
                    ((Presenter_Movie)presenter).getMoviesDetail(result3.get(0).getMovieId());
                }
            }
        });
    }

    @Override
    public void getXbanner(BannerBean bannerBean) {
        final List<BannerBean.ResultBean> result = bannerBean.getResult();
        xb.setBannerData(result);
        xb.loadImage(new XBanner.XBannerAdapter() {
            @Override
            public void loadBanner(XBanner banner, Object model, View view, int position) {
                BannerBean.ResultBean resultBean = result.get(position);
                String imageUrl = resultBean.getImageUrl();
                Glide.with(getContext()).load(imageUrl).error(R.mipmap.ic_launcher).placeholder(R.mipmap.ic_launcher).into((ImageView) view);
                tv_postion.setText(position+"/4");
            }
        });
    }


    @Override
    public void getMoviesDetailSuccess(Moview_MoviesDetail moviesDetail) {
        Moview_MoviesDetail.ResultBean result = moviesDetail.getResult();
        ArrayList<Moview_MoviesDetail.ResultBean> resultBeans = new ArrayList<>();
        resultBeans.add(result);
        Intent intent = new Intent(App.getAppContext(), MoviesDetailActivity.class);
        intent.putParcelableArrayListExtra("resultBeans",resultBeans);

        startActivity(intent);
    }

    //预约
    @Override
    public void getReserveSuccess(RegisterBean registerBean) {
        String message = registerBean.getMessage();
        if (message.equals("预约成功")){
            Toast.makeText(getContext(), "预约成功!", Toast.LENGTH_SHORT).show();
            comingSoonMovieAdapter.notifyDataSetChanged();
        }else {
            Toast.makeText(getContext(), "预约失败", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.tv_one:
                startActivity(0);

                break;
            case R.id.tv_two:
                startActivity(1);

                break;
            case R.id.tv_three:
                startActivity(2);

                break;
                default:
        }
    }
    public void startActivity(int i){
        Intent intent = new Intent(App.getAppContext(), MoreActivity.class);
        ArrayList<Movie_ReleaseMovieBean.ResultBean> list_one = new ArrayList<>();
        list_one.addAll(result1);

        ArrayList<Movie_ComingSoonMovie.ResultBean> list_two = new ArrayList<>();
        list_two.addAll(result2);

        ArrayList<Movie_HotMovieBean.ResultBean> list_three = new ArrayList<>();
        list_three.addAll(result3);

        intent.putParcelableArrayListExtra("list_one",list_one);
        intent.putParcelableArrayListExtra("list_two",list_two);
        intent.putParcelableArrayListExtra("list_three",list_three);

        intent.putExtra("i",i);
        startActivity(intent);
    }

    @Override
    public void onLocationChanged(AMapLocation aMapLocation) {
        Boolean is=true;

        if (aMapLocation != null) {
            if (aMapLocation.getErrorCode() == 0) {
                //定位成功回调信息，设置相关消息
                aMapLocation.getLocationType();//获取当前定位结果来源，如网络定位结果，详见官方定位类型表
                aMapLocation.getLatitude();//获取纬度
                aMapLocation.getLongitude();//获取经度
                SPUtils.putString(getContext(),SPUtils.USERINFO_NAME,"jing",aMapLocation.getLatitude()+"");
                SPUtils.putString(getContext(),SPUtils.USERINFO_NAME,"wei",aMapLocation.getLongitude()+"");
                aMapLocation.getAccuracy();//获取精度信息
                SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                Date date = new Date(aMapLocation.getTime());
                df.format(date);//定位时间
                aMapLocation.getAddress();//地址，如果option中设置isNeedAddress为false，则没有此结果，网络定位结果中会有地址信息，GPS定位不返回地址信息。
                aMapLocation.getCountry();//国家信息
                aMapLocation.getProvince();//省信息
                aMapLocation.getCity();//城市信息
                aMapLocation.getDistrict();//城区信息
                SPUtils.putString(getContext(),SPUtils.USERINFO_NAME,"diqu",aMapLocation.getDistrict()+"");

                aMapLocation.getStreet();//街道信息
                aMapLocation.getStreetNum();//街道门牌号信息
                aMapLocation.getCityCode();//城市编码
                aMapLocation.getAdCode();//地区编码

                // 如果不设置标志位，此时再拖动地图时，它会不断将地图移动到当前的位置
                if (isFirstLoc) {
                    //设置缩放级别
                    aMap.moveCamera(CameraUpdateFactory.zoomTo(17));
                    //将地图移动到定位点
                    aMap.moveCamera(CameraUpdateFactory.changeLatLng(new LatLng(aMapLocation.getLatitude(), aMapLocation.getLongitude())));
                    //点击定位按钮 能够将地图的中心移动到定位点
                    mListener.onLocationChanged(aMapLocation);
                    //添加图钉
                    //  aMap.addMarker(getMarkerOptions(amapLocation));
                    //获取定位信息
                    StringBuffer buffer = new StringBuffer();
                    buffer.append(aMapLocation.getCountry() + ""
                            + aMapLocation.getProvince() + ""
                            + aMapLocation.getCity() + ""
                            + aMapLocation.getProvince() + ""
                            + aMapLocation.getDistrict() + ""
                            + aMapLocation.getStreet() + ""
                            + aMapLocation.getStreetNum());
                    //Toast.makeText(getContext(), buffer.toString(), Toast.LENGTH_LONG).show();
                    city1 = aMapLocation.getCity();
                    //Toast.makeText(getContext(), ""+city1+"11", Toast.LENGTH_SHORT).show();
                    city.setText(city1+"");
                    isFirstLoc = false;
                }


            } else {
                //显示错误信息ErrCode是错误码，errInfo是错误信息，详见错误码表。
                Log.e("AmapError", "location Error, ErrCode:"
                        + aMapLocation.getErrorCode() + ", errInfo:"
                        + aMapLocation.getErrorInfo());

            }
        }
    }

    @Override
    public void activate(OnLocationChangedListener onLocationChangedListener) {
        mListener = onLocationChangedListener;
    }

    @Override
    public void deactivate() {
        mListener = null;
    }

    public class SpaceItemDecoration extends RecyclerView.ItemDecoration {
        private int space;

        public SpaceItemDecoration(int space) {
            this.space = space;
        }

        @Override
        public void getItemOffsets(Rect outRect, View view,
                                   RecyclerView parent, RecyclerView.State state) {
            outRect.left = space;
            outRect.right = space;
            outRect.bottom = space;

            // Add top margin only for the first item to avoid double space between items
            if (parent.getChildPosition(view) == 0) {
                outRect.top = space;
            }
        }
    }

    private void location() {
        //初始化定位
        mLocationClient = new AMapLocationClient(getContext());
        //设置定位回调监听
        mLocationClient.setLocationListener(this);
        //初始化定位参数
        mLocationOption = new AMapLocationClientOption();
        //设置定位模式为Hight_Accuracy高精度模式，Battery_Saving为低功耗模式，Device_Sensors是仅设备模式
        mLocationOption.setLocationMode(AMapLocationClientOption.AMapLocationMode.Hight_Accuracy);
        //设置是否返回地址信息（默认返回地址信息）
        mLocationOption.setNeedAddress(true);
        //设置是否只定位一次,默认为false
        mLocationOption.setOnceLocation(false);
        //设置是否强制刷新WIFI，默认为强制刷新
        mLocationOption.setWifiActiveScan(true);
        //设置是否允许模拟位置,默认为false，不允许模拟位置
        mLocationOption.setMockEnable(false);
        //设置定位间隔,单位毫秒,默认为2000ms
        mLocationOption.setInterval(2000);
        //给定位客户端对象设置定位参数
        mLocationClient.setLocationOption(mLocationOption);
        //启动定位
        mLocationClient.startLocation();
    }
}
