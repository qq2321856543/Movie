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
import com.bw.movie.bean.UserFollowCinemaListBean;
import com.bw.movie.bean.UserFollowMovieBean;

import java.util.ArrayList;
import java.util.List;

public class UserFollowCinemaListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    Context context;
    private List<UserFollowCinemaListBean.ResultBean> list=new ArrayList<>();

    public UserFollowCinemaListAdapter(Context context) {
        this.context = context;
    }
    public void setData(List<UserFollowCinemaListBean.ResultBean> mlist){
        list = mlist;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = View.inflate(context, R.layout.item_more, null);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, final int i) {
        String imageUrl = list.get(i).getLogo();

        Glide.with(context).load(imageUrl).error(R.mipmap.ic_launcher).placeholder(R.mipmap.ic_launcher).into(((ViewHolder)viewHolder).iv);
        ((ViewHolder)viewHolder).tv_name.setText(list.get(i).getName());
        ((ViewHolder)viewHolder).tv_dao.setText(list.get(i).getName());
        ((ViewHolder)viewHolder).tv_zhu.setText(list.get(i).getAddress());

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

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            iv = itemView.findViewById(R.id.iv);
            tv_name = itemView.findViewById(R.id.tv_name);
            tv_dao = itemView.findViewById(R.id.tv_dao);
            tv_zhu = itemView.findViewById(R.id.tv_zhu);
            tv_ping = itemView.findViewById(R.id.tv_ping);
        }
    }
}
