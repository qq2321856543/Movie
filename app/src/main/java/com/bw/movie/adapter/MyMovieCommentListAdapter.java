package com.bw.movie.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bw.movie.R;
import com.bw.movie.bean.MyMovieCommentListBean;
import com.bw.movie.bean.UserFollowMovieBean;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class MyMovieCommentListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    Context context;
    private List<MyMovieCommentListBean.ResultBean> list=new ArrayList<>();

    public MyMovieCommentListAdapter(Context context) {
        this.context = context;
    }
    public void setData(List<MyMovieCommentListBean.ResultBean> mlist){
        list = mlist;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = View.inflate(context, R.layout.item_mymoviecommentlist, null);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, final int i) {
        String imageUrl = list.get(i).getImageUrl();

        Glide.with(context).load(imageUrl).error(R.mipmap.ic_launcher).placeholder(R.mipmap.ic_launcher).into(((ViewHolder)viewHolder).iv);
        ((ViewHolder)viewHolder).tv_name.setText(list.get(i).getMovieName());
        ((ViewHolder)viewHolder).tv_dao.setText("导演: "+list.get(i).getDirector());
        ((ViewHolder)viewHolder).tv_zhu.setText("主演: "+list.get(i).getStarring());
        ((ViewHolder)viewHolder).tv_ping.setText("评分: "+list.get(i).getMovieScore()+"分");
        ((ViewHolder)viewHolder).tv_mypingjia.setText(list.get(i).getMyCommentContent());
        ((ViewHolder)viewHolder).tv_myfen.setText("（"+list.get(i).getMyCommentScore()+"分）");
        //((ViewHolder)viewHolder).tv_myshijian.setText("评分: "+list.get(i).getMyCommentScore()+"分");
        long commentTime = list.get(i).getCommentTime();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String format = dateFormat.format(commentTime);
        String[] split = format.split("-");

        ((ViewHolder)viewHolder).tv_myshijian.setText(split[1]+"月"+split[2]+"日");
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder{

        private final ImageView iv;
        private final TextView tv_dao;
        private final TextView tv_name;
        private final TextView tv_zhu;
        private final TextView tv_ping;
        private final TextView tv_mypingjia;
        private final TextView tv_myfen;
        private final TextView tv_myshijian;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            iv = itemView.findViewById(R.id.iv);
            tv_name = itemView.findViewById(R.id.tv_name);
            tv_dao = itemView.findViewById(R.id.tv_dao);
            tv_zhu = itemView.findViewById(R.id.tv_zhu);
            tv_ping = itemView.findViewById(R.id.tv_ping);
            tv_mypingjia = itemView.findViewById(R.id.tv_mypingjia);
            tv_myfen = itemView.findViewById(R.id.tv_myfen);
            tv_myshijian = itemView.findViewById(R.id.tv_myshijian);
        }
    }
}
