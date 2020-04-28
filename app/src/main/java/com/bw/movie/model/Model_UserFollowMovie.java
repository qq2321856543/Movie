package com.bw.movie.model;

import com.bw.movie.bean.UserFollowMovieBean;
import com.bw.movie.icoolor.ICoolor_UserFollowMovie;
import com.bw.movie.utils.HttpUtil;

public class Model_UserFollowMovie implements ICoolor_UserFollowMovie.IModel {
    @Override
    public void getUserFollowMovie(int page, int count, UserFollowMovieBean userFollowMovieBean) {
        //HttpUtil.getInstance().getApis().getUserFollowMovie(page,count)
    }
}
