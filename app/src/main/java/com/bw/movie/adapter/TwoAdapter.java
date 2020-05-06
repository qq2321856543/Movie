package com.bw.movie.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bw.movie.R;
import com.bw.movie.bean.CinemaByRegionBean;
import com.bw.movie.bean.QuBean;

import java.util.List;

public class TwoAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    Context context;
    List<CinemaByRegionBean.ResultBean> list;
    private Onclick monclick;

    public TwoAdapter(Context context, List<CinemaByRegionBean.ResultBean> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = View.inflate(context, R.layout.item_two, null);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, final int i) {
        ((ViewHolder)viewHolder).tv.setText(list.get(i).getName());
        if (list.get(i).getIs()){
            ((ViewHolder)viewHolder).ll.setBackgroundColor(0xff141931);
        }else {
            ((ViewHolder)viewHolder).ll.setBackgroundColor(0xff171D3A);
        }
        ((ViewHolder)viewHolder).tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                monclick.Click(i,list.get(i).getId());
            }
        });
    }
    public void SetOn(Onclick onclick){
        monclick = onclick;
    }
    public interface Onclick{
        void Click(int postion,int id);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder{

        private final TextView tv;
        private final RelativeLayout ll;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tv = itemView.findViewById(R.id.tv);
            ll = itemView.findViewById(R.id.ll);
        }
    }
}
