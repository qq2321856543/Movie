package com.bw.movie.adapter;

import android.content.Context;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bw.movie.R;
import com.bw.movie.bean.Movie_HotMovieBean;
import com.bw.movie.bean.RecommendCinemasBean;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.controller.AbstractDraweeController;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequestBuilder;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

public class RecommendCinemasAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    Context context;
    List<RecommendCinemasBean.ResultBean> list;
    private SetOn msetOn;

    public RecommendCinemasAdapter(Context context, List<RecommendCinemasBean.ResultBean> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = View.inflate(context, R.layout.item_recommendcinemas, null);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, final int i) {
        String logo = list.get(i).getLogo();
        Uri uri = Uri.parse(logo);
        ((ViewHolder)viewHolder).iv.setImageURI(uri);
        ((ViewHolder)viewHolder).tv_name.setText(list.get(i).getName());
        ((ViewHolder)viewHolder).tv_dao.setText(list.get(i).getAddress());
        ((ViewHolder)viewHolder).rl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                msetOn.click(list.get(i).getId());
            }
        });
    }
    public void Onclick(SetOn setOn){
        msetOn = setOn;
    }
    public interface SetOn{
        void click(int id);
    }


    @Override
    public int getItemCount() {
        return list.size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder{

        private final SimpleDraweeView iv;
        private final TextView tv_name;
        private final TextView tv_dao;
        private final RelativeLayout rl;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            iv = itemView.findViewById(R.id.iv);
            tv_dao = itemView.findViewById(R.id.tv_dao);
            tv_name = itemView.findViewById(R.id.tv_name);
            rl = itemView.findViewById(R.id.rl);
        }
    }
}
