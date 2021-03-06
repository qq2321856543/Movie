package com.bw.movie.base;

import com.bw.movie.bean.AllCinemaCommentBean;
import com.bw.movie.bean.BannerBean;
import com.bw.movie.bean.CinemaByRegionBean;
import com.bw.movie.bean.CinemaInfoBean;
import com.bw.movie.bean.CinemaScheduleListBean;
import com.bw.movie.bean.DateListBean;
import com.bw.movie.bean.EmailCodeBean;
import com.bw.movie.bean.LoginBean;
import com.bw.movie.bean.Movie_ComingSoonMovie;
import com.bw.movie.bean.Movie_HotMovieBean;
import com.bw.movie.bean.Movie_ReleaseMovieBean;
import com.bw.movie.bean.Moview_MoviesDetail;
import com.bw.movie.bean.MyMovieCommentListBean;
import com.bw.movie.bean.NearbyCinemasBean;
import com.bw.movie.bean.RecommendCinemasBean;
import com.bw.movie.bean.RegionListBean;
import com.bw.movie.bean.RegisterBean;
import com.bw.movie.bean.Search_MovieByKeywordBean;
import com.bw.movie.bean.UpLoadHeadPicBean;
import com.bw.movie.bean.UserFollowCinemaListBean;
import com.bw.movie.bean.UserFollowMovieBean;
import com.bw.movie.bean.UserReserveBean;
import com.bw.movie.bean.YingPingBean;

import java.io.File;

import io.reactivex.Observable;
import okhttp3.RequestBody;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface Apis {
    //邮箱验证码
    @POST("user/v2/sendOutEmailCode")
    @FormUrlEncoded
    Observable<EmailCodeBean> getEmailCode(@Field("email") String email);

    //注册
    @POST("user/v2/register")
    @FormUrlEncoded
    Observable<RegisterBean> getRegister(@Field("nickName") String nickName
            , @Field("pwd") String pwd
            , @Field("email") String email
            , @Field("code") String code);

    //登录
    @POST("user/v2/login")
    @FormUrlEncoded
    Observable<LoginBean> getLogin(@Field("email") String email,@Field("pwd") String pwd);

    //微信登录
    @POST("user/v1/weChatBindingLogin")
    @FormUrlEncoded
    Observable<LoginBean> getWx(@Field("code") String code);

    //修改密码
    @POST("user/v1/verify/modifyUserPwd")
    @FormUrlEncoded
    Observable<LoginBean> getNewpwd(@Field("oldPwd") String oldPwd,@Field("newPwd") String newPwd,@Field("newPwd2") String newPwd2);

    //轮播
    @GET("tool/v2/banner")
    Observable<BannerBean> getBanner();

    //正在热映
    @GET("movie/v2/findReleaseMovieList")
    Observable<Movie_ReleaseMovieBean> getReleaseMovieList(@Query("page") int page,@Query("count") int count);

    //即将上映
    @GET("movie/v2/findComingSoonMovieList")
    Observable<Movie_ComingSoonMovie> getComingSoonMovieList(@Query("page") int page, @Query("count") int count);

    //热门电影
    @GET("movie/v2/findHotMovieList")
    Observable<Movie_HotMovieBean> getHotMovieList(@Query("page") int page, @Query("count") int count);

    //模糊查询电影
    @GET("movie/v2/findMovieByKeyword")
    Observable<Search_MovieByKeywordBean> getSearch_MovieByKeyword(@Query("keyword") String keyword, @Query("page") int page, @Query("count") int count);

    //电影详情
    @GET("movie/v2/findMoviesDetail")
    Observable<Moview_MoviesDetail> getMoviesDetail(@Query("movieId") int movieId);

    //影视评价
    @GET("movie/v2/findAllMovieComment")
    Observable<YingPingBean> getYingPing(@Query("movieId") int movieId, @Query("page")int page, @Query("count")int count);

    //预约
    @POST("movie/v2/verify/reserve")
    @FormUrlEncoded
    Observable<RegisterBean> getReserve(@Field("movieId") int movieId);

    //关注
    @GET("movie/v1/verify/followMovie")
    Observable<RegisterBean> getFollowMovie(@Query("movieId") int movieId);

    //取消关注
    @GET("movie/v1/verify/cancelFollowMovie")
    Observable<RegisterBean> getCancelFollowMovie(@Query("movieId") int movieId);

    //用户关注列表
    @GET("user/v2/verify/findUserFollowMovieList")
    Observable<UserFollowMovieBean> getUserFollowMovie(@Query("page") int page,@Query("count") int count);

    //推荐影院
    @GET("cinema/v1/findRecommendCinemas")
    Observable<RecommendCinemasBean> getRecommendCinemasBean(@Query("page") int page,@Query("count") int count);

    //附近影院
    @GET("cinema/v1/findNearbyCinemas")
    Observable<NearbyCinemasBean> getNearbyCinemasBean(@Query("longitude") String longitude,@Query("latitude") String latitude,@Query("page") int page,@Query("count") int count);

    //根据区域查询影院
    @GET("cinema/v2/findCinemaByRegion")
    Observable<CinemaByRegionBean> getCinemaByRegion(@Query("regionId") int regionId);

    //查询区域列表
    @GET("tool/v2/findRegionList")
    Observable<RegionListBean> getRegionList();

    //查询影院详情
    @GET("cinema/v1/findCinemaInfo")
    Observable<CinemaInfoBean> getCinemaInfo(@Query("cinemaId") int cinemaId);

    //关注影院
    @GET("cinema/v1/verify/followCinema")
    Observable<LoginBean> getfollowCinema(@Query("cinemaId") int cinemaId);

    //取消关注影院
    @GET("cinema/v1/verify/cancelFollowCinema")
    Observable<LoginBean> getcancelFollowCinema(@Query("cinemaId") int cinemaId);

    //影院用户评论
    @GET("cinema/v1/findAllCinemaComment")
    Observable<AllCinemaCommentBean> getAllCinemaComment(@Query("cinemaId") int cinemaId,@Query("page") int page,@Query("count") int count);

    //查询一周排期的时间
    @GET("tool/v2/findDateList")
    Observable<DateListBean> getDataList();

    //影院下电影排期
    @GET("cinema/v2/findCinemaScheduleList")
    Observable<CinemaScheduleListBean> getCinemaScheduleList(@Query("cinemaId") int cinemaId,@Query("page") int page,@Query("count") int count);

    //用户关注的影院
    @GET("user/v2/verify/findUserFollowCinemaList")
    Observable<UserFollowCinemaListBean> getUserFollowCinemaListBean(@Query("page") int page,@Query("count") int count);

    //用户预约电影
    @GET("user/v2/verify/findUserReserve")
    Observable<UserReserveBean> getUserReserve();

    //添加用户对影片的评价
    @POST("movie/v1/verify/movieComment")
    @FormUrlEncoded
    Observable<LoginBean> getMovieComment(@Field("movieId") int movieId,@Field("commentContent") String commentContent,@Field("score") double score);

    //查询我对电影的评论列表
    @GET("user/v2/verify/findMyMovieCommentList")
    Observable<MyMovieCommentListBean> getMyMovieCommentList(@Query("page") int page,@Query("count") int count);

    //查询我对电影的评论列表
    @POST("tool/v1/verify/recordFeedBack")
    @FormUrlEncoded
    Observable<LoginBean> getRecordFeedBack(@Field("content") String content);

    //头像上传
    @POST("user/v1/verify/uploadHeadPic")
    Observable<UpLoadHeadPicBean> getUpLoadHeadPicBean(@Body RequestBody body);
}
