package com.example.administrator.pandatvsecond.moudle.pandagg.adapter;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.androidkun.adapter.BaseAdapter;
import com.androidkun.adapter.ViewHolder;
import com.bumptech.glide.Glide;
import com.example.administrator.pandatvsecond.R;
import com.example.administrator.pandatvsecond.app.App;
import com.example.administrator.pandatvsecond.model.bean.GGbean;
import com.example.administrator.pandatvsecond.moudle.pandahome.adapter.PandaLiveShowAdapter;

import java.util.List;

/**
 * Created by lenovo on 2017/7/28.
 */

public class GGAdapter extends BaseAdapter<GGbean.ListBean> {

    public GGAdapter(Context context,List<GGbean.ListBean> datas) {
        super(context, R.layout.gg_data_item, datas);
    }

    @Override
    public void convert(ViewHolder holder, final GGbean.ListBean gGbean) {
            holder.setText(R.id.gg_title, gGbean.getTitle());
            holder.setText(R.id.gg_destri, gGbean.getBrief());
            holder.setText(R.id.gg_len, gGbean.getVideoLength());
            ImageView imageView = (ImageView) holder.itemView.findViewById(R.id.gg_image);
            Glide.with(App.context.getApplication()).load(gGbean.getImage()).into(imageView);
        LinearLayout linearLayout = (LinearLayout) holder.itemView.findViewById(R.id.gg_Linear);
        linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setOnItemListener.setOnItemListener(gGbean);
            }
        });
        }
    public SetOnItemListener setOnItemListener;
    public void setonClickListener(SetOnItemListener setOnItemListener){
        this.setOnItemListener=setOnItemListener;
    }
    public interface SetOnItemListener{
        void setOnItemListener(GGbean.ListBean listBean);
    }
    }

