package com.bw.movie.adapter;

import android.content.Context;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bw.movie.R;
import com.bw.movie.bean.Movie_ReleaseMovieBean;

import java.util.ArrayList;
import java.util.List;

public class ReleaseMovieAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    Context context;
    private List<Movie_ReleaseMovieBean.ResultBean> list=new ArrayList<>();
    private Onclick monclick;

    public ReleaseMovieAdapter(Context context) {
        this.context = context;
    }
    public void setData(List<Movie_ReleaseMovieBean.ResultBean> mlist){
        list = mlist;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = View.inflate(context, R.layout.item_releasemovie, null);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, final int i) {
        String imageUrl = list.get(i).getImageUrl();
        Uri uri = Uri.parse(imageUrl);
        ((ViewHolder)viewHolder).iv.setImageURI(uri);
        // Glide.with(context).load(imageUrl).error(R.mipmap.ic_launcher).placeholder(R.mipmap.ic_launcher).into(((ViewHolder)viewHolder).iv);
        ((ViewHolder)viewHolder).tv_fen.setText(list.get(i).getScore()+"");
        ((ViewHolder)viewHolder).tv_name.setText(list.get(i).getName());
        ((ViewHolder)viewHolder).ll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                monclick.click(list.get(i).getMovieId());
            }
        });
    }
    public void SetOnclick(Onclick onclick){
        monclick = onclick;
    }
    public interface Onclick{
        void click(int movieId);
    }
    @Override
    public int getItemCount() {
        return list.size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder{

        private final ImageView iv;
        private final TextView tv_fen;
        private final TextView tv_name;
        private final Button bt_ok;
        private final LinearLayout ll;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            iv = itemView.findViewById(R.id.iv);
            tv_fen = itemView.findViewById(R.id.tv_fen);
            tv_name = itemView.findViewById(R.id.tv_name);
            bt_ok = itemView.findViewById(R.id.bt_ok);
            ll = itemView.findViewById(R.id.ll);
        }
    }
}
