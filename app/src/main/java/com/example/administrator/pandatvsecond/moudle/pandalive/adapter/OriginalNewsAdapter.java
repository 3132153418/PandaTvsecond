package com.example.administrator.pandatvsecond.moudle.pandalive.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.administrator.pandatvsecond.R;
import com.example.administrator.pandatvsecond.model.bean.OriginalNewsBean;

/**
 * Created by lenovo on 2017/7/31.
 */

public class OriginalNewsAdapter extends RecyclerView.Adapter<OriginalNewsAdapter.ViewHoder> {

    private Context context;
    private OriginalNewsBean originalNewsBean;

    public OriginalNewsAdapter(Context context, OriginalNewsBean originalNewsBean) {
        this.context = context;
        this.originalNewsBean = originalNewsBean;
    }

    @Override
    public ViewHoder onCreateViewHolder(ViewGroup parent, int viewType) {
        View inflate = View.inflate(context, R.layout.live_common_item, null);
        return new ViewHoder(inflate);
    }

    @Override
    public void onBindViewHolder(ViewHoder holder, int position) {
        Glide.with(context).load(originalNewsBean.getVideo().get(position).getImg()).into(holder.iv_livecommon);
        holder.tv_livecommon_title.setText(originalNewsBean.getVideo().get(position).getT());
        holder.tv_livecommon_data.setText(originalNewsBean.getVideo().get(position).getPtime());
        holder.tv_livecommon_time.setText(originalNewsBean.getVideo().get(position).getLen());
    }

    @Override
    public int getItemCount() {
        return originalNewsBean.getVideo().size();
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
