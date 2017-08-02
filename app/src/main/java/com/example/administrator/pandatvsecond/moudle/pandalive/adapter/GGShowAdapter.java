package com.example.administrator.pandatvsecond.moudle.pandalive.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.administrator.pandatvsecond.R;
import com.example.administrator.pandatvsecond.model.bean.GGShowBean;

/**
 * Created by lenovo on 2017/7/31.
 */

public class GGShowAdapter extends RecyclerView.Adapter<GGShowAdapter.ViewHoder> {

    private Context context;
    private GGShowBean ggShowBean;

    public GGShowAdapter(Context context, GGShowBean ggShowBean) {
        this.context = context;
        this.ggShowBean = ggShowBean;
    }

    @Override
    public ViewHoder onCreateViewHolder(ViewGroup parent, int viewType) {
        View inflate = View.inflate(context, R.layout.live_common_item, null);
        return new ViewHoder(inflate);
    }

    @Override
    public void onBindViewHolder(ViewHoder holder, int position) {
        Glide.with(context).load(ggShowBean.getVideo().get(position).getImg()).into(holder.iv_livecommon);
        holder.tv_livecommon_title.setText(ggShowBean.getVideo().get(position).getT());
        holder.tv_livecommon_data.setText(ggShowBean.getVideo().get(position).getPtime());
        holder.tv_livecommon_time.setText(ggShowBean.getVideo().get(position).getLen());
    }

    @Override
    public int getItemCount() {
        return ggShowBean.getVideo().size();
    }

    class ViewHoder extends RecyclerView.ViewHolder{


        private final ImageView iv_livecommon;
        private final TextView tv_livecommon_time;
        private final TextView tv_livecommon_title;
        private final TextView tv_livecommon_data;

        public ViewHoder(View itemView) {
            super(itemView);
            iv_livecommon = (ImageView) itemView.findViewById(R.id.iv_livecommon);
            tv_livecommon_time = (TextView) itemView.findViewById(R.id.tv_livecommon_time);
            tv_livecommon_title = (TextView) itemView.findViewById(R.id.tv_livecommon_title);
            tv_livecommon_data = (TextView) itemView.findViewById(R.id.tv_livecommon_data);

        }
    }
}
