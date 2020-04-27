package com.bw.movie.adapter;

import android.content.Context;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bw.movie.R;
import com.bw.movie.bean.Movie_ComingSoonMovie;
import com.bw.movie.bean.Movie_ReleaseMovieBean;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ComingSoonMovieAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    Context context;
    private List<Movie_ComingSoonMovie.ResultBean> list=new ArrayList<>();
    private Onclick monclick;
    private Onclick_ok monclick_ok;

    public ComingSoonMovieAdapter(Context context) {
        this.context = context;
    }
    public void setData(List<Movie_ComingSoonMovie.ResultBean> mlist){
        list = mlist;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = View.inflate(context, R.layout.item_comingsoonmovie, null);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, final int i) {
        Date date = new Date(list.get(i).getReleaseTime());
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String format = dateFormat.format(date);
        String[] split = format.split("-");

        ((ViewHolder)viewHolder).tv_shijian.setText(split[1]+"月"+split[2]+"日"+"上映");

        String imageUrl = list.get(i).getImageUrl();
        Uri uri = Uri.parse(imageUrl);
        ((ViewHolder)viewHolder).iv.setImageURI(uri);
        ((ViewHolder)viewHolder).tv_name.setText(list.get(i).getName());
        //((ViewHolder)viewHolder).tv_shijian.setText(list.get(i).getReleaseTime()+"上映");
        ((ViewHolder)viewHolder).tv_count.setText(list.get(i).getWantSeeNum()+"人想看");
        if (list.get(0).getWhetherReserve()==1){

            ((ViewHolder)viewHolder).bt_ok.setText("已预约");
        }else {
            ((ViewHolder)viewHolder).bt_ok.setText("预约");

        }

        //点击事件
        ((ViewHolder)viewHolder).rl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                monclick.click(list.get(i).getMovieId());
            }
        });
        //预约点击
        ((ViewHolder)viewHolder).bt_ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                monclick_ok.click(list.get(i).getMovieId());
            }
        });
    }
    public void SetOnclick(Onclick onclick){
        monclick = onclick;
    }
    public interface Onclick{
        void click(int movieId);
    }
    public void SetOnclick_ok(Onclick_ok onclick_ok){
        monclick_ok = onclick_ok;
    }
    public interface Onclick_ok{
        void click(int movieId);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder{

        private final ImageView iv;
        private final TextView tv_shijian;
        private final TextView tv_name;
        private final TextView tv_count;
        private final Button bt_ok;
        private final RelativeLayout rl;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            iv = itemView.findViewById(R.id.iv);
            tv_name = itemView.findViewById(R.id.tv_name);
            tv_shijian = itemView.findViewById(R.id.tv_shijian);
            tv_count = itemView.findViewById(R.id.tv_count);
            bt_ok = itemView.findViewById(R.id.bt_ok);
            rl = itemView.findViewById(R.id.rl);
        }
    }
}
