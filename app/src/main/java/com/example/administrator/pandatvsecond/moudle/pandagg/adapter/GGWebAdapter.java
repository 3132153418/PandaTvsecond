package com.example.administrator.pandatvsecond.moudle.pandagg.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.administrator.pandatvsecond.R;
import com.example.administrator.pandatvsecond.model.bean.PandaTebieBean;

import java.util.List;

/**
 * Created by Administrator on 2017/8/1.
 */

public class GGWebAdapter extends RecyclerView.Adapter {
    private List<PandaTebieBean.VideoBean> mlist;
    private LayoutInflater inflater;
    private Context context;

    public GGWebAdapter(List<PandaTebieBean.VideoBean> mlist, Context context) {
        this.mlist = mlist;
        this.inflater = LayoutInflater.from(context);
        this.context = context;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(View.inflate(context, R.layout.ggwebview_item, null));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        ViewHolder viewHolder = (ViewHolder) holder;
        Glide.with(context).load(mlist.get(position).getImg()).into(viewHolder.imageView);
        viewHolder.textView.setText(mlist.get(position).getT());

    }

    class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView textView;

        public ViewHolder(View itemView) {
            super(itemView);
            imageView = (ImageView) itemView.findViewById(R.id.item_Image);
            textView = (TextView) itemView.findViewById(R.id.item_Text);
        }
    }


    @Override
    public int getItemCount() {
        return mlist.size();
    }
}
