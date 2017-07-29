package com.example.administrator.pandatvsecond.moudle.pandahome.adapter;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.administrator.pandatvsecond.R;
import com.example.administrator.pandatvsecond.model.bean.HomeBean;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.listener.OnBannerListener;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lenovo on 2017/7/28.
 */

public class HomeRecycleviewAdapter extends RecyclerView.Adapter {

    public static final int BANNER = 0;//代表轮播图
    public static final int PANDAPAPER = 1;//代表熊猫播报
    public static final int PANDALIVESHOW = 2;//代表直播秀场
    public static final int PANDAWONDERFULTIME = 3;//代表精彩一刻
    public static final int PANDAGGSHOW = 4;//代表滚滚视频
    public static final int LIVECHINA = 5;//代表直播中国

    private Context context;
    private ArrayList<Object> home_datas;
    private LayoutInflater inflater;

    public HomeRecycleviewAdapter(Context context, ArrayList<Object> home_datas) {
        this.context = context;
        this.inflater = LayoutInflater.from(context);
        this.home_datas = home_datas;
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0) {
            return BANNER;//轮播图
        } else if (home_datas.get(position) instanceof HomeBean.DataBean.PandaeyeBean) {
            return PANDAPAPER;//熊猫播报
        } else if (home_datas.get(position) instanceof HomeBean.DataBean.PandaliveBean) {
            return PANDALIVESHOW;//直播秀场
        } else if (home_datas.get(position) instanceof HomeBean.DataBean.AreaBean) {
            return PANDAWONDERFULTIME;//精彩一刻
        } else if (home_datas.get(position) instanceof HomeBean.DataBean.WallliveBean) {
            return PANDAGGSHOW;//滚滚视频用的是长城直播
        } else if (home_datas.get(position) instanceof HomeBean.DataBean.ChinaliveBean) {
            return LIVECHINA;//直播中国
        }
        return super.getItemViewType(position);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        switch (viewType) {
            case BANNER:
                View banner = inflater.inflate(R.layout.home_banner, null);
                BannerHolder bannerHolder = new BannerHolder(banner);
                return bannerHolder;
            case PANDAPAPER:
                View pandapaper = inflater.inflate(R.layout.home_pandapager, null);
                PandaPagerHolder pandaPagerHolder = new PandaPagerHolder(pandapaper);
                return pandaPagerHolder;
            case PANDALIVESHOW:
                View pandaliveshow = inflater.inflate(R.layout.home_pandaliveshow, null);
                PandaLiveShowHolder pandaliveshowHolder = new PandaLiveShowHolder(pandaliveshow);
                return pandaliveshowHolder;
            case PANDAWONDERFULTIME:
                View pandawonderfultime = inflater.inflate(R.layout.home_banner, null);
                PandaWonderfulTimeHolder pandawonderfultimeHolder = new PandaWonderfulTimeHolder(pandawonderfultime);
                return pandawonderfultimeHolder;
            case PANDAGGSHOW:
                View pandaggshow = inflater.inflate(R.layout.home_banner, null);
                PandaGGShowHolder pandaggshowHolder = new PandaGGShowHolder(pandaggshow);
                return pandaggshowHolder;
            case LIVECHINA:
                View livechina = inflater.inflate(R.layout.home_banner, null);
                LiveChinaHolder liveChinaHolder = new LiveChinaHolder(livechina);
                return liveChinaHolder;
        }
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        switch (getItemViewType(position)) {
            case BANNER:
                BannerHolder bannerHolder = (BannerHolder) holder;
                List<HomeBean.DataBean.BigImgBean> bigImgBeen = (List<HomeBean.DataBean.BigImgBean>) home_datas.get(position);
                ArrayList<String> images = new ArrayList<>();
                ArrayList<String> titles = new ArrayList<>();

                for (HomeBean.DataBean.BigImgBean bigImgBean : bigImgBeen) {
                    images.add(bigImgBean.getImage());
                    titles.add(bigImgBean.getTitle());
                }

                bannerHolder.banner.setImages(images);
                bannerHolder.banner.setBannerTitles(titles);
                bannerHolder.banner.setOnBannerListener(new OnBannerListener() {
                    @Override
                    public void OnBannerClick(int position) {
                        Toast.makeText(context, "点击了第" + position + "张轮播图", Toast.LENGTH_SHORT).show();
                    }
                });
                bannerHolder.banner.start();
                break;
            case PANDAPAPER:
                PandaPagerHolder pandaPagerHolder = (PandaPagerHolder) holder;
                HomeBean.DataBean.PandaeyeBean pandaeyeBeen = (HomeBean.DataBean.PandaeyeBean) home_datas.get(position);
                Glide.with(context).load(pandaeyeBeen.getPandaeyelogo()).into(pandaPagerHolder.pandapager_icon);
                final List<HomeBean.DataBean.PandaeyeBean.ItemsBean> items = pandaeyeBeen.getItems();
                pandaPagerHolder.pandapager_tv_brief_one.setText(items.get(0).getBrief());
                TextView pandapager_tv_title_one = pandaPagerHolder.pandapager_tv_title_one;
                pandapager_tv_title_one.setText(items.get(0).getTitle());
                pandapager_tv_title_one.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(context, items.get(0).getTitle(), Toast.LENGTH_SHORT).show();
                    }
                });
                pandaPagerHolder.pandapager_tv_brief_two.setText(items.get(1).getBrief());
                TextView pandapager_tv_title_two = pandaPagerHolder.pandapager_tv_title_two;
                pandapager_tv_title_two.setText(items.get(1).getTitle());
                pandapager_tv_title_two.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(context, items.get(1).getTitle(), Toast.LENGTH_SHORT).show();
                    }
                });
                break;
            case PANDALIVESHOW:
                HomeBean.DataBean.PandaliveBean pandaliveBean = (HomeBean.DataBean.PandaliveBean) home_datas.get(position);
                List<HomeBean.DataBean.PandaliveBean.ListBean> list = pandaliveBean.getList();
                PandaLiveShowHolder pandaLiveShowHolder = (PandaLiveShowHolder) holder;
                pandaLiveShowHolder.pandaliveshow_recyclerview.setLayoutManager(new GridLayoutManager(context,3));
                pandaLiveShowHolder.pandaliveshow_recyclerview.setAdapter(new PandaLiveShowAdapter(list,context));
                break;
        }
    }

    @Override
    public int getItemCount() {
        return home_datas.size();
    }

    class BannerHolder extends RecyclerView.ViewHolder {

        private final Banner banner;

        public BannerHolder(View itemView) {
            super(itemView);
            banner = (Banner) itemView.findViewById(R.id.banner);
            banner.setBannerStyle(BannerConfig.CIRCLE_INDICATOR_TITLE_INSIDE);
            banner.setIndicatorGravity(Gravity.RIGHT);
            banner.setViewPagerIsScroll(true);
            banner.setImageLoader(new GlideImageLoader());
            banner.isAutoPlay(true);
            banner.setDelayTime(2000);
        }
    }

    class PandaPagerHolder extends RecyclerView.ViewHolder {

        private final ImageView pandapager_icon;
        private final TextView pandapager_tv_brief_one;
        private final TextView pandapager_tv_title_one;
        private final TextView pandapager_tv_brief_two;
        private final TextView pandapager_tv_title_two;

        public PandaPagerHolder(View itemView) {
            super(itemView);
            pandapager_icon = (ImageView) itemView.findViewById(R.id.pandapager_icon);
            pandapager_tv_brief_one = (TextView) itemView.findViewById(R.id.pandapager_tv_brief_one);
            pandapager_tv_title_one = (TextView) itemView.findViewById(R.id.pandapager_tv_title_one);
            pandapager_tv_brief_two = (TextView) itemView.findViewById(R.id.pandapager_tv_brief_two);
            pandapager_tv_title_two = (TextView) itemView.findViewById(R.id.pandapager_tv_title_two);
            ((TextView) itemView.findViewById(R.id.pandapager_commont).findViewById(R.id.tv_home_commont)).setText("熊猫播报");
        }
    }

    class PandaLiveShowHolder extends RecyclerView.ViewHolder {

        private final RecyclerView pandaliveshow_recyclerview;

        public PandaLiveShowHolder(View itemView) {
            super(itemView);
            ((TextView) itemView.findViewById(R.id.pandaliveshow_commont).findViewById(R.id.tv_home_commont)).setText("直播秀场");
            pandaliveshow_recyclerview = (RecyclerView) itemView.findViewById(R.id.pandaliveshow_recyclerview);
        }
    }

    class PandaWonderfulTimeHolder extends RecyclerView.ViewHolder {

        public PandaWonderfulTimeHolder(View itemView) {
            super(itemView);

        }
    }

    class PandaGGShowHolder extends RecyclerView.ViewHolder {

        public PandaGGShowHolder(View itemView) {
            super(itemView);

        }
    }

    class LiveChinaHolder extends RecyclerView.ViewHolder {

        public LiveChinaHolder(View itemView) {
            super(itemView);

        }
    }

    public class GlideImageLoader extends ImageLoader {
        @Override
        public void displayImage(Context context, Object path, ImageView imageView) {
            Glide.with(context).load(path).into(imageView);
        }

        @Override
        public ImageView createImageView(Context context) {
            ImageView contentimageView = new ImageView(context);
            contentimageView.setScaleType(ImageView.ScaleType.FIT_XY);
            ViewGroup.LayoutParams params =
                    new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                            ViewGroup.LayoutParams.MATCH_PARENT);
            contentimageView.setLayoutParams(params);
            return contentimageView;
        }
    }

}
