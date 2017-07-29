package com.example.administrator.pandatvsecond.moudle.pandalivechina;

import android.graphics.drawable.BitmapDrawable;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;

import com.example.administrator.pandatvsecond.R;
import com.example.administrator.pandatvsecond.base.BaseFragment;
import com.example.administrator.pandatvsecond.model.bean.PopupBean;
import com.example.administrator.pandatvsecond.moudle.pandalivechina.adapter.DragAdapter;
import com.example.administrator.pandatvsecond.moudle.pandalivechina.adapter.PandaDirectAdapter;
import com.example.administrator.pandatvsecond.moudle.pandalivechina.adapter.ZHPagerAdapter;
import com.example.administrator.pandatvsecond.moudle.pandalivechina.fragment.LiveFragment;
import com.example.administrator.pandatvsecond.util.MineLog;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/*
直播中国上面tablayout
 */

public class LiveChinaFragment extends BaseFragment implements LiveChinaContract.View, View.OnClickListener {

    @BindView(R.id.live_chena_IBtn)
    ImageButton liveChenaIBtn;

    Unbinder unbinder;
    private List<String> mListName;
    private List<BaseFragment> mList;
    private List<String> mListNameUrl;
    private Map<String, String> mMapAllUrl;
    private ViewPager liveChenaViewPager;
    private TabLayout liveChenaTabLayout;
    private ImageView personal_Cente, imageView;
    private PandaDirectAdapter adapter;
    private LiveChinaPresenter presenter;
    private ImageButton live_chena_IBtn;
    private DragGridView gridView;
    private DragGridView gridView_other;
    private DragAdapter dragAdapter;
    private DragAdapter other_adapter;
    private CheckBox button;

    private PopupWindow popupWindow;
    private ArrayList<BaseFragment> fragmentList = new ArrayList<BaseFragment>(); //碎片链表
    private ArrayList<String> channels = new ArrayList<>();
    private ArrayList<String> channels_other = new ArrayList<>();
    private ZHPagerAdapter title_adapter;


    @Override
    protected int getLayoutId() {
        return R.layout.livechina_fragment;
    }

    @Override
    protected void initView(View view) {
        new LiveChinaPresenter(this);
        liveChenaViewPager = (ViewPager) view.findViewById(R.id.live_chena_viewPager);
        liveChenaTabLayout = (TabLayout) view.findViewById(R.id.live_chena_TabLayout);
        live_chena_IBtn = (ImageButton) view.findViewById(R.id.live_chena_IBtn);

        live_chena_IBtn.setOnClickListener(this);
        title_adapter = new ZHPagerAdapter(getActivity().getSupportFragmentManager(), fragmentList, channels);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
        }

    }


    @Override
    protected void loadData() {
        presenter.start();
    }

    public void add_Fragment(PopupBean popupBean) {
        mListName = new ArrayList<>();
        mList = new ArrayList<>();
        mListNameUrl = new ArrayList<>();
        mMapAllUrl = new HashMap<>();
        List<PopupBean.TablistBean> tablist = popupBean.getTablist();
        List<PopupBean.AlllistBean> alllist = popupBean.getAlllist();
        LiveFragment badaLingFragment = null;
        Bundle bundle = null;
        for (PopupBean.TablistBean tablistBean : tablist) {
            mListName.add(tablistBean.getTitle());
            badaLingFragment = new LiveFragment();
            bundle = new Bundle();
            bundle.putString("url", tablistBean.getUrl());
            badaLingFragment.setBundle(bundle);
            mList.add(badaLingFragment);
            mListNameUrl.add(tablistBean.getUrl());
            mMapAllUrl.put(tablistBean.getTitle(), tablistBean.getUrl());
        }
        for (PopupBean.AlllistBean alllistBean : alllist) {
            mMapAllUrl.put(alllistBean.getTitle(), alllistBean.getUrl());
        }

        adapter = new PandaDirectAdapter(getChildFragmentManager(), mListName, mList);
        liveChenaViewPager.setAdapter(adapter);
        liveChenaTabLayout.setupWithViewPager(liveChenaViewPager);
    }
    public void upPopupWindow(View view) {
        View v = LayoutInflater.from(getActivity()).inflate(R.layout.activity_popup_columns, null);
        popupView(v);
        popupWindow = new PopupWindow(v, LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
        popupWindow.setFocusable(true);
        popupWindow.setBackgroundDrawable(new BitmapDrawable()); // 响应返回键必须的语句
        popupWindow.showAsDropDown(view, 0, 0);
    }

    public void popupView(View v) {
        imageView = (ImageView) v.findViewById(R.id.Fanhui);
        imageView.setOnClickListener(this);
        gridView = (DragGridView) v.findViewById(R.id.gridView_channel);
        gridView_other = (DragGridView) v.findViewById(R.id.gridView_channel_other);
        button = (CheckBox) v.findViewById(R.id.licechina_add_button);
        gridView.setNumColumns(3);
        dragAdapter = new DragAdapter(getActivity(), channels);
        gridView.setAdapter(dragAdapter);

        other_adapter = new DragAdapter(getActivity(), channels_other);
        gridView_other.setAdapter(other_adapter);
        gridView_other.setNumColumns(3);

        button.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    button.setText("完成");
                    gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

                        @Override
                        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                            String channel = channels.get(position);
                            if (channels.size() > 4) {
                                channels.remove(position);
                                channels_other.add(channel);
                                dragAdapter.notifyDataSetChanged();
                                other_adapter.notifyDataSetChanged();
                            }

                        }
                    });
                    gridView_other.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                            String channel = channels_other.get(position);
                            channels_other.remove(position);
                            channels.add(channel);
                            dragAdapter.notifyDataSetChanged();
                            other_adapter.notifyDataSetChanged();
                        }
                    });
                } else {
                    button.setText("编辑");
                    setRefresh();


                }
            }
        });

    }
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.live_chena_IBtn:
                View view = LayoutInflater.from(getActivity()).inflate(R.layout.livechina_fragment, null);
                upPopupWindow(view);
                break;
            case R.id.Fanhui:
                popupWindow.dismiss();
                break;
        }
    }
    public void setRefresh() {
        mListName.clear();
        mList.clear();
        mListName.addAll(channels);
        Set<String> strings = mMapAllUrl.keySet();

        LiveFragment badaLingFragment = null;
        Bundle bundle = null;
        String url = null;
        for (String nameTab : mListName) {
            url = mMapAllUrl.get(nameTab);
            MineLog.d("livechinataburl",url.toString());
            badaLingFragment = new LiveFragment();
            bundle = new Bundle();
            bundle.putString("url", url);
            MineLog.d("livechinaurl",url.toString());
            badaLingFragment.setBundle(bundle);
            mList.add(badaLingFragment);
        }
        adapter = new PandaDirectAdapter(getChildFragmentManager(), mListName, mList);
        liveChenaViewPager.setAdapter(adapter);
        liveChenaTabLayout.setupWithViewPager(liveChenaViewPager);

    }
    @Override
    public void getChinaLiveTab(PopupBean popupBean) {
        add_Fragment(popupBean);
        List<PopupBean.TablistBean> tablist = popupBean.getTablist();
        initDatatitle(tablist);

        List<PopupBean.AlllistBean> alllist = popupBean.getAlllist();
        initDataOther(alllist);
    }

    @Override
    public void showProgress() {

    }

    @Override
    public void dismissProgress() {

    }

    @Override
    public void setPresenter(LiveChinaContract.livechinaPresenter livechinaPresenter) {
        this.presenter = (LiveChinaPresenter) livechinaPresenter;

    }

    @Override
    public void showMessage(String msg) {

    }


    private void initDataOther(List<PopupBean.AlllistBean> alllistBeanList) {
        for (PopupBean.AlllistBean alllistBean : alllistBeanList) {
            channels_other.add(alllistBean.getTitle());
        }

    }

    private void initDatatitle(List<PopupBean.TablistBean> tablistBeanList) {
        for (PopupBean.TablistBean alllistBean : tablistBeanList) {
            channels.add(alllistBean.getTitle());
        }

    }


    @Override
    public void onRefresh() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        unbinder = ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }


}
