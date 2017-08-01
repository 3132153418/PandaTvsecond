package com.example.administrator.pandatvsecond.moudle.pandalive.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.administrator.pandatvsecond.R;
import com.example.administrator.pandatvsecond.model.bean.WatchTalkBean;

import java.text.SimpleDateFormat;
import java.util.List;

/**
 * Created by lenovo on 2017/7/31.
 */

public class WatchTalkRecyclerviewAdapter extends RecyclerView.Adapter<WatchTalkRecyclerviewAdapter.ViewHolder> {
    private List<WatchTalkBean.DataBean.ContentBean> content;
    private Context context;


    public WatchTalkRecyclerviewAdapter(List<WatchTalkBean.DataBean.ContentBean> content, Context context) {
        this.content = content;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View inflate = View.inflate(context, R.layout.live_smalllivee_watchtalk_recyclerview_item, null);
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.tv_watchtalk_recyclerview_address.setText(content.get(position).getAuthor());
        holder.tv_watchtalk_recyclerview_count.setText(content.get(position).getTid()+"楼");
        holder.tv_watchtalk_recyclerview_content.setText(content.get(position).getMessage());
        SimpleDateFormat sdf=new SimpleDateFormat("dd-MM-yyyy");
        String date=sdf.format(new java.util.Date());
        holder.tv_watchtalk_recyclerview_data.setText(date);
    }

    @Override
    public int getItemCount() {
        return content.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        private final TextView tv_watchtalk_recyclerview_address;
        private final TextView tv_watchtalk_recyclerview_count;
        private final TextView tv_watchtalk_recyclerview_content;
        private final TextView tv_watchtalk_recyclerview_data;

        public ViewHolder(View itemView) {
            super(itemView);
            tv_watchtalk_recyclerview_address = (TextView) itemView.findViewById(R.id.tv_watchtalk_recyclerview_address);
            tv_watchtalk_recyclerview_count = (TextView) itemView.findViewById(R.id.tv_watchtalk_recyclerview_count);
            tv_watchtalk_recyclerview_content = (TextView) itemView.findViewById(R.id.tv_watchtalk_recyclerview_content);
            tv_watchtalk_recyclerview_data = (TextView) itemView.findViewById(R.id.tv_watchtalk_recyclerview_data);

        }
    }
}
