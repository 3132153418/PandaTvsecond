package com.example.administrator.pandatvsecond.moudle.pandahome.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.administrator.pandatvsecond.R;
import com.example.administrator.pandatvsecond.model.bean.HomeBean;
import com.example.administrator.pandatvsecond.util.MineLog;

import java.text.SimpleDateFormat;
import java.util.List;

/**
 * Created by lenovo on 2017/7/29.
 */

public class PandaWonderfulTimeAdapter extends RecyclerView.Adapter<PandaWonderfulTimeAdapter.ViewHoler> {
    private List<HomeBean.DataBean.AreaBean.ListscrollBean> listscroll;
    private Context context;

    public PandaWonderfulTimeAdapter(List<HomeBean.DataBean.AreaBean.ListscrollBean> listscroll, Context context) {
        this.listscroll = listscroll;
        this.context = context;
    }

    @Override
    public ViewHoler onCreateViewHolder(ViewGroup parent, int viewType) {
        View inflate = View.inflate(context, R.layout.home_pandalwonderfultime_recycle_item, null);
        return  new ViewHoler(inflate);
    }

    @Override
    public void onBindViewHolder(ViewHoler holder, final int position) {
        String image = listscroll.get(position).getImage();
        String title = listscroll.get(position).getTitle();
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        String date=sdf.format(new java.util.Date());
        MineLog.d("PandaWonderfulTimeAdapter","每个Item的数据为"+title+"--"+image+"---"+date);
        Glide.with(context).load(image).into(holder.iv_pandaliveshow_recycler);
        holder.tv_pandawonderfultime_recycler_title.setText(title);
        holder.tv_pandawonderfultime_recycler_time.setText(date);
        LinearLayout linearLayout = (LinearLayout) holder.itemView.findViewById(R.id.pandaWonderfulTime);
        linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setOnItemListener.setOnItemListener(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return listscroll.size();
    }

    public static class ViewHoler extends RecyclerView.ViewHolder{

        private final ImageView iv_pandaliveshow_recycler;
        private final TextView tv_pandawonderfultime_recycler_title;
        private final TextView tv_pandawonderfultime_recycler_time;

        public ViewHoler(View itemView) {
            super(itemView);
            iv_pandaliveshow_recycler = (ImageView) itemView.findViewById(R.id.iv_pandawonderfultime_recycler);
            tv_pandawonderfultime_recycler_title = (TextView) itemView.findViewById(R.id.tv_pandawonderfultime_recycler_title);
            tv_pandawonderfultime_recycler_time = (TextView) itemView.findViewById(R.id.tv_pandawonderfultime_recycler_time);


        }
    }

    public SetOnItemListener setOnItemListener;
    public void setonClickListener(SetOnItemListener setOnItemListener){
        this.setOnItemListener= (setOnItemListener);
    }
    public interface SetOnItemListener{
        void setOnItemListener(int postion);
    }}
