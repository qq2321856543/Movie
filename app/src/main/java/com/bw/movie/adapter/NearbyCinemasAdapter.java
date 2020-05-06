package com.bw.movie.adapter;

import android.content.Context;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bw.movie.R;
import com.bw.movie.bean.NearbyCinemasBean;
import com.bw.movie.bean.RecommendCinemasBean;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

public class NearbyCinemasAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    Context context;
    List<NearbyCinemasBean.ResultBean> list;
    private Onclick monclick;

    public NearbyCinemasAdapter(Context context, List<NearbyCinemasBean.ResultBean> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = View.inflate(context, R.layout.item_nearbycinemas, null);
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
        ((ViewHolder)viewHolder).juli.setText(list.get(i).getDistance()+"km");
        ((ViewHolder)viewHolder).rl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                monclick.click(list.get(i).getId());
            }
        });
    }
    public void SetOnclick(Onclick onclick){
        monclick = onclick;
    }
    public interface Onclick{
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
        private final TextView juli;
        private final RelativeLayout rl;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            iv = itemView.findViewById(R.id.iv);
            tv_dao = itemView.findViewById(R.id.tv_dao);
            tv_name = itemView.findViewById(R.id.tv_name);
            //m = itemView.findViewById(R.id.m);
            juli = itemView.findViewById(R.id.juli);
            rl = itemView.findViewById(R.id.rl);
        }
    }
}
