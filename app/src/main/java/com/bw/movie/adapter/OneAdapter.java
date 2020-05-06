package com.bw.movie.adapter;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bw.movie.R;
import com.bw.movie.bean.RegionListBean;

import java.util.List;

public class OneAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    Context context;
    List<RegionListBean.ResultBean> list;
    private Onclick monclick;

    public OneAdapter(Context context, List<RegionListBean.ResultBean> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = View.inflate(context, R.layout.item_one, null);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull final RecyclerView.ViewHolder viewHolder, final int i) {
        ((ViewHolder)viewHolder).tv.setText(list.get(i).getRegionName());
        if (list.get(i).getIs()){
            ((ViewHolder)viewHolder).ll.setBackgroundColor(0xff141931);
        }else {
            ((ViewHolder)viewHolder).ll.setBackgroundColor(0xff1c2243);
        }
        ((ViewHolder)viewHolder).tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                monclick.Click(list.get(i).getRegionId());
            }
        });
    }
    public void SetOn(Onclick onclick){
        monclick = onclick;
    }
    public interface Onclick{
        void Click(int postion);
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
