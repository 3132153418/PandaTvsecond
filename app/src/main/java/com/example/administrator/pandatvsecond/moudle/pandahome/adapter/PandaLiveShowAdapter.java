package com.example.administrator.pandatvsecond.moudle.pandahome.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.administrator.pandatvsecond.R;
import com.example.administrator.pandatvsecond.model.bean.HomeBean;
import com.example.administrator.pandatvsecond.util.MineLog;

import java.util.List;

/**
 * Created by lenovo on 2017/7/29.
 */

public class PandaLiveShowAdapter extends RecyclerView.Adapter<PandaLiveShowAdapter.ViewHoler> {
    private List<HomeBean.DataBean.PandaliveBean.ListBean> list;
    private Context context;

    public PandaLiveShowAdapter(List<HomeBean.DataBean.PandaliveBean.ListBean> list, Context context) {
        MineLog.d("PandaLiveShowAdapter","集合的长度为:"+list.size());
        this.list = list;
        this.context = context;
    }

    @Override
    public ViewHoler onCreateViewHolder(ViewGroup parent, int viewType) {
        View inflate = View.inflate(context, R.layout.home_pandaliveshow_recycle_item, null);
        return  new ViewHoler(inflate);
    }

    @Override
    public void onBindViewHolder(ViewHoler holder, int position) {
        String title = list.get(position).getTitle();
        String image = list.get(position).getImage();
        MineLog.d("PandaLiveShowAdapter","每个Item的数据为"+title+"--"+image);
        Glide.with(context).load(image).into(holder.iv_pandaliveshow_recycler);
        holder.tv_pandaliveshow_recycler.setText(title);

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class ViewHoler extends RecyclerView.ViewHolder{

        private final ImageView iv_pandaliveshow_recycler;
        private final TextView tv_pandaliveshow_recycler;

        public ViewHoler(View itemView) {
            super(itemView);
            iv_pandaliveshow_recycler = (ImageView) itemView.findViewById(R.id.iv_pandaliveshow_recycler);
            tv_pandaliveshow_recycler = (TextView) itemView.findViewById(R.id.tv_pandaliveshow_recycler);

        }
    }
}
