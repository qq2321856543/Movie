package com.bw.movie.adapter;

import android.app.Dialog;
import android.content.Context;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bw.movie.R;
import com.bw.movie.bean.Moview_MoviesDetail;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.ArrayList;
import java.util.List;

/**
 * 演员
 */
public class PosterListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    Context context;
    private List<String> list=new ArrayList<>();

    public PosterListAdapter(Context context) {
        this.context = context;
    }
    public void setData(List<String> mlist){
        list = mlist;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = View.inflate(context, R.layout.item_director, null);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        final String s = list.get(i);
        Uri uri = Uri.parse(s);
        ((ViewHolder)viewHolder).iv.setImageURI(uri);
        ((ViewHolder)viewHolder).iv.setOnClickListener(new View.OnClickListener() {

            private Dialog mLoadingDialog;

            @Override
            public void onClick(View v) {
                    if (mLoadingDialog==null){
                        mLoadingDialog = new Dialog(context);
                        mLoadingDialog.setCancelable(true);
                        View view = View.inflate(context, R.layout.dialog_ivmax, null);
                        SimpleDraweeView iv=view.findViewById(R.id.iv);
                        Uri parse = Uri.parse(s);
                        iv.setImageURI(parse);
                        mLoadingDialog.addContentView(view,
                                new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
                                        ViewGroup.LayoutParams.WRAP_CONTENT));
                    }
                    mLoadingDialog.show();


            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder{

        private final SimpleDraweeView iv;
        private final TextView tv_name;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            iv = itemView.findViewById(R.id.iv);
            tv_name = itemView.findViewById(R.id.tv_name);
        }
    }
}
