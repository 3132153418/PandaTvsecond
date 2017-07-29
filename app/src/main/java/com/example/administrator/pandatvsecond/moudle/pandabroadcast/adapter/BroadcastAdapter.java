package com.example.administrator.pandatvsecond.moudle.pandabroadcast.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.administrator.pandatvsecond.R;
import com.example.administrator.pandatvsecond.model.bean.BroadcastBean;

import java.util.List;

/**
 * Created by Administrator on 2017/7/28.
 */

public class BroadcastAdapter extends RecyclerView.Adapter {
    private List<BroadcastBean.ListBean> mlist;
    private Context context;

    public BroadcastAdapter(List<BroadcastBean.ListBean> mlist, Context context) {
        this.mlist = mlist;
        this.context = context;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(View.inflate(context,R.layout.broadcast_item,null));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        ViewHolder viewHolder = (ViewHolder) holder;
        Glide.with(context).load(mlist.get(position).getImage()).into(viewHolder.imageView);
        viewHolder.name.setText(mlist.get(position).getTitle());
        viewHolder.time.setText(mlist.get(position).getVideoLength());
    }
    class ViewHolder extends RecyclerView.ViewHolder{
        ImageView imageView;
        TextView name,time;
        public ViewHolder(View itemView) {
            super(itemView);
            imageView = (ImageView) itemView.findViewById(R.id.broadcast_item_image);
            name = (TextView) itemView.findViewById(R.id.broadcast_item_name);
            time = (TextView) itemView.findViewById(R.id.broadcast_item_title);
        }
    }

    @Override
    public int getItemCount() {
        return mlist.size();
    }
}
