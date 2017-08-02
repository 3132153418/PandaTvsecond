package com.example.administrator.pandatvsecond.moudle.pandalive.fragment;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.administrator.pandatvsecond.R;
import com.example.administrator.pandatvsecond.base.BaseFragment;
import com.example.administrator.pandatvsecond.model.bean.live.MoreEyeBean;
import com.example.administrator.pandatvsecond.moudle.pandalive.adapter.SmallLiveMoreEyeAdapter;

import java.util.List;

import static com.example.administrator.pandatvsecond.app.App.context;

/**
 * Created by lenovo on 2017/7/31.
 */

public class SmallLiveMoreEyeFragment extends BaseFragment {
    private List<MoreEyeBean.ListBean> listBean;
    private RecyclerView moreeye_recycleview;
    public SmallLiveMoreEyeFragment(List<MoreEyeBean.ListBean> listBean) {
        this.listBean = listBean;
    }

    public SmallLiveMoreEyeFragment() {
    }

    @Override
    protected int getLayoutId() {
        return R.layout.live_smalllive_moreeye;
    }

    @Override
    protected void initView(View view) {
        moreeye_recycleview = (RecyclerView) view.findViewById(R.id.moreeye_recycleview);
        moreeye_recycleview.setLayoutManager(new GridLayoutManager(context, 3, GridLayoutManager.VERTICAL, true));
        moreeye_recycleview.setAdapter(new SmallLiveMoreEyeAdapter(listBean, context));
    }

    @Override
    protected void loadData() {

    }
}
