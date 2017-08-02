package com.example.administrator.pandatvsecond.moudle.pandahome.adapter;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
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

    private static OnClick onClick;



    public static final int BANNER = 0;//代表轮播图
    public static final int PANDAPAPER = 1;//代表熊猫播报
    public static final int PANDALIVESHOW = 2;//代表直播秀场
    public static final int PANDAWONDERFULTIME = 3;//代表精彩一刻
    public static final int PANDAGGSHOW = 4;//代表滚滚视频
    public static final int LIVECHINA = 5;//代表直播中国

    private Context context;
    private ArrayList<Object> home_datas;
    private LayoutInflater inflater;

    public interface OnClick {
        void setTypeBroadcastOne(View view,   List<HomeBean.DataBean.PandaeyeBean.ItemsBean> items);
        void setTypeBroadcastTwo(View view,  List<HomeBean.DataBean.PandaeyeBean.ItemsBean> items);
        void setTypeLive(HomeBean.DataBean.PandaliveBean.ListBean list);
        void setTypeSplendid(HomeBean.DataBean.AreaBean.ListscrollBean listscroll);
        void setTypeGG(HomeBean.DataBean.WallliveBean.ListBeanX listBeanX);
        void setTypeLiveChina(HomeBean.DataBean.ChinaliveBean.ListBeanXX list2);
        void setTypeLunBo(HomeBean.DataBean.BigImgBean imgBean);
    }

    public void setOnClick(OnClick onClick) {
        this.onClick = onClick;
    }

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
                View pandawonderfultime = inflater.inflate(R.layout.home_pandawonderfultime, null);
                PandaWonderfulTimeHolder pandawonderfultimeHolder = new PandaWonderfulTimeHolder(pandawonderfultime);
                return pandawonderfultimeHolder;
            case PANDAGGSHOW:
                View pandaggshow = inflater.inflate(R.layout.home_pandaggshow, null);
                PandaGGShowHolder pandaggshowHolder = new PandaGGShowHolder(pandaggshow);
                return pandaggshowHolder;
            case LIVECHINA:
                View livechina = inflater.inflate(R.layout.home_livechina, null);
                LiveChinaHolder liveChinaHolder = new LiveChinaHolder(livechina);
                return liveChinaHolder;

        }
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        switch (getItemViewType(position)) {
            case BANNER:
                BannerHolder bannerHolder = (BannerHolder) holder;
                 final List<HomeBean.DataBean.BigImgBean> bigImgBeen = (List<HomeBean.DataBean.BigImgBean>) home_datas.get(position);
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

                        onClick.setTypeLunBo(bigImgBeen.get(position));

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
                        onClick.setTypeBroadcastOne(v,items);
                        Toast.makeText(context, items.get(0).getTitle(), Toast.LENGTH_SHORT).show();
                    }
                });
                pandaPagerHolder.pandapager_tv_brief_two.setText(items.get(1).getBrief());
                TextView pandapager_tv_title_two = pandaPagerHolder.pandapager_tv_title_two;
                pandapager_tv_title_two.setText(items.get(1).getTitle());
                pandapager_tv_title_two.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        onClick.setTypeBroadcastTwo(v,items);
                        Toast.makeText(context, items.get(1).getTitle(), Toast.LENGTH_SHORT).show();
                    }
                });
                break;
            case PANDALIVESHOW:
                HomeBean.DataBean.PandaliveBean pandaliveBean = (HomeBean.DataBean.PandaliveBean) home_datas.get(position);
                final List<HomeBean.DataBean.PandaliveBean.ListBean> list = pandaliveBean.getList();
                PandaLiveShowHolder pandaLiveShowHolder = (PandaLiveShowHolder) holder;
                pandaLiveShowHolder.pandaliveshow_recyclerview.setLayoutManager(new GridLayoutManager(context, 3, GridLayoutManager.VERTICAL, true));
                PandaLiveShowAdapter pandaLiveShowAdapter = new PandaLiveShowAdapter(list, context);
                pandaLiveShowHolder.pandaliveshow_recyclerview.setAdapter(pandaLiveShowAdapter);
                pandaLiveShowAdapter.setonClickListener(new PandaLiveShowAdapter.SetOnItemListener() {
                    @Override
                    public void setOnItemListener(int postion) {
                        onClick.setTypeLive(list.get(postion));
                    }
                });
                break;
            case PANDAWONDERFULTIME:
                PandaWonderfulTimeHolder pandaWonderfulTimeHolder = (PandaWonderfulTimeHolder) holder;
                HomeBean.DataBean.AreaBean areaBean = (HomeBean.DataBean.AreaBean) home_datas.get(position);
                final List<HomeBean.DataBean.AreaBean.ListscrollBean> listscroll = areaBean.getListscroll();
                pandaWonderfulTimeHolder.pandawonderfultime_recyclerview.setLayoutManager(new GridLayoutManager(context, 2, GridLayoutManager.VERTICAL, true));
                PandaWonderfulTimeAdapter pandaWonderfulTimeAdapter = new PandaWonderfulTimeAdapter(listscroll, context);
                pandaWonderfulTimeHolder.pandawonderfultime_recyclerview.setAdapter(pandaWonderfulTimeAdapter);
              pandaWonderfulTimeAdapter.setonClickListener(new PandaWonderfulTimeAdapter.SetOnItemListener() {
                  @Override
                  public void setOnItemListener(int postion) {
                      onClick.setTypeSplendid(listscroll.get(postion));
                  }
              });
                break;
            case PANDAGGSHOW:
                PandaGGShowHolder pandaGGShowHolder = (PandaGGShowHolder) holder;
                HomeBean.DataBean.WallliveBean wallliveBean = (HomeBean.DataBean.WallliveBean) home_datas.get(position);
                final List<HomeBean.DataBean.WallliveBean.ListBeanX> list1 = wallliveBean.getList();
                pandaGGShowHolder.pandaggshow_recyclerview.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.VERTICAL, true));
                PandaGGShowAdapter pandaGGShowAdapter = new PandaGGShowAdapter(list1, context);

                pandaGGShowHolder.pandaggshow_recyclerview.setAdapter(pandaGGShowAdapter);
                pandaGGShowAdapter.setonClickListener(new PandaLiveShowAdapter.SetOnItemListener() {
                    @Override
                    public void setOnItemListener(int postion) {
                        onClick.setTypeGG(list1.get(postion));
                    }
                });
                break;
            case LIVECHINA:
                LiveChinaHolder pandaLiveChinaHolder = (LiveChinaHolder) holder;
                HomeBean.DataBean.ChinaliveBean chinaliveBean = (HomeBean.DataBean.ChinaliveBean) home_datas.get(position);
                final List<HomeBean.DataBean.ChinaliveBean.ListBeanXX> list2 = chinaliveBean.getList();
                pandaLiveChinaHolder.pandalivechina_recyclerview.setLayoutManager(new GridLayoutManager(context, 3, GridLayoutManager.VERTICAL, true));
                PandaLiveChinaAdapter pandaLiveChinaAdapter = new PandaLiveChinaAdapter(list2, context);
                pandaLiveChinaHolder.pandalivechina_recyclerview.setAdapter(pandaLiveChinaAdapter);
                pandaLiveChinaAdapter.setonClickListener(new PandaLiveShowAdapter.SetOnItemListener() {
                    @Override
                    public void setOnItemListener(int postion) {
                        onClick.setTypeLiveChina(list2.get(postion));
                    }
                });
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
        private final RecyclerView pandawonderfultime_recyclerview;

        public PandaWonderfulTimeHolder(View itemView) {
            super(itemView);
            ((TextView) itemView.findViewById(R.id.pandawonderfultime_commont).findViewById(R.id.tv_home_commont)).setText("精彩一刻");
            pandawonderfultime_recyclerview = (RecyclerView) itemView.findViewById(R.id.pandawonderfultime_recyclerview);
        }
    }

    class PandaGGShowHolder extends RecyclerView.ViewHolder {
        private final RecyclerView pandaggshow_recyclerview;
        public PandaGGShowHolder(View itemView) {
            super(itemView);
            ((TextView) itemView.findViewById(R.id.pandaggshow_commont).findViewById(R.id.tv_home_commont)).setText("滚滚视频");
            pandaggshow_recyclerview = (RecyclerView) itemView.findViewById(R.id.pandaggshow_recyclerview);
        }
    }

    class LiveChinaHolder extends RecyclerView.ViewHolder {
        private final RecyclerView pandalivechina_recyclerview;
        public LiveChinaHolder(View itemView) {
            super(itemView);
            ((TextView) itemView.findViewById(R.id.pandalivechina_commont).findViewById(R.id.tv_home_commont)).setText("直播中国");
            pandalivechina_recyclerview = (RecyclerView) itemView.findViewById(R.id.pandalivechina_recyclerview);
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
