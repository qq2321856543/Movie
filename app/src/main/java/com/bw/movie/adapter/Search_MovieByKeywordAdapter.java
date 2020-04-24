package com.bw.movie.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bw.movie.R;
import com.bw.movie.bean.Movie_HotMovieBean;
import com.bw.movie.bean.Search_MovieByKeywordBean;

import java.util.ArrayList;
import java.util.List;

public class Search_MovieByKeywordAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    Context context;
    private List<Search_MovieByKeywordBean.ResultBean> list=new ArrayList<>();

    public Search_MovieByKeywordAdapter(Context context) {
        this.context = context;
    }
    public void setData(List<Search_MovieByKeywordBean.ResultBean> mlist){
        list = mlist;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = View.inflate(context, R.layout.item_search_moviebykeyword, null);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        String imageUrl = list.get(i).getImageUrl();

        Glide.with(context).load(imageUrl).error(R.mipmap.ic_launcher).placeholder(R.mipmap.ic_launcher).into(((ViewHolder)viewHolder).iv);
        ((ViewHolder)viewHolder).tv_ping.setText("评分: "+list.get(i).getScore()+"");
        ((ViewHolder)viewHolder).tv_zhu.setText("主演: "+list.get(i).getStarring()+"");
        ((ViewHolder)viewHolder).tv_name.setText(list.get(i).getName());
        ((ViewHolder)viewHolder).tv_dao.setText("导演: "+list.get(i).getDirector());


    }

    @Override
    public int getItemCount() {
        return list.size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder{

        private final ImageView iv;
        private final TextView tv_ping;
        private final TextView tv_name;
        private final TextView tv_zhu;
        private final TextView tv_dao;
        private final Button bt_ok;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            iv = itemView.findViewById(R.id.iv);
            tv_ping = itemView.findViewById(R.id.tv_ping);
            tv_name = itemView.findViewById(R.id.tv_name);
            tv_zhu = itemView.findViewById(R.id.tv_zhu);
            tv_dao = itemView.findViewById(R.id.tv_dao);
            bt_ok = itemView.findViewById(R.id.bt_ok);
        }
    }
}
