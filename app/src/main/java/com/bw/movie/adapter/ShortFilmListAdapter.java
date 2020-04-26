package com.bw.movie.adapter;

import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.VideoView;

import com.bw.movie.R;
import com.bw.movie.bean.Moview_MoviesDetail;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.ArrayList;
import java.util.List;

/**
 * 演员
 */
public class ShortFilmListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    Context context;
    private List<Moview_MoviesDetail.ResultBean.ShortFilmListBean> list=new ArrayList<>();

    public ShortFilmListAdapter(Context context) {
        this.context = context;
    }
    public void setData(List<Moview_MoviesDetail.ResultBean.ShortFilmListBean> mlist){
        list = mlist;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = View.inflate(context, R.layout.item_shortfilm, null);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        String videoUrl = list.get(i).getVideoUrl();
        MediaController controller = new MediaController(context);
        ((ViewHolder)viewHolder).vv.setVideoURI(Uri.parse(videoUrl));
        controller.setMediaPlayer(((ViewHolder)viewHolder).vv);
        ((ViewHolder)viewHolder).vv.setMediaController(controller);
//        ((ViewHolder)viewHolder).vv.setBackgroundDrawable(new BitmapDrawable());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder{

        private final VideoView vv;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            vv = itemView.findViewById(R.id.main_video);
        }
    }
}
