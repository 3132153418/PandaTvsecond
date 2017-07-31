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

import java.util.List;

/**
 * Created by lenovo on 2017/7/29.
 */

public class PandaLiveChinaAdapter extends RecyclerView.Adapter<PandaLiveChinaAdapter.ViewHoler> {
    private List<HomeBean.DataBean.ChinaliveBean.ListBeanXX> list2;
    private Context context;

    public PandaLiveChinaAdapter(List<HomeBean.DataBean.ChinaliveBean.ListBeanXX> list2, Context context) {
        this.list2 = list2;
        this.context = context;
    }

    @Override
    public ViewHoler onCreateViewHolder(ViewGroup parent, int viewType) {
        View inflate = View.inflate(context, R.layout.home_pandalivechina_recycle_item, null);
        return  new ViewHoler(inflate);
    }

    @Override
    public void onBindViewHolder(ViewHoler holder, int position) {
        String title = list2.get(position).getTitle();
        String image = list2.get(position).getImage();
        Glide.with(context).load(image).into(holder.iv_pandalivechina_recycler);
        holder.tv_pandalivechina_recycler.setText(title);

    }

    @Override
    public int getItemCount() {
        return list2.size();
    }

    public static class ViewHoler extends RecyclerView.ViewHolder{

        private final ImageView iv_pandalivechina_recycler;
        private final TextView tv_pandalivechina_recycler;

        public ViewHoler(View itemView) {
            super(itemView);
            iv_pandalivechina_recycler = (ImageView) itemView.findViewById(R.id.iv_pandalivechina_recycler);
            tv_pandalivechina_recycler = (TextView) itemView.findViewById(R.id.tv_pandalivechina_recycler);

        }
    }
}
