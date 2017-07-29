package com.example.administrator.pandatvsecond.moudle.pandalivechina.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.administrator.pandatvsecond.R;
import com.example.administrator.pandatvsecond.base.BaseFragment;
import com.example.administrator.pandatvsecond.model.bean.ChangchengBean;
import com.example.administrator.pandatvsecond.moudle.pandalivechina.adapter.ZhiBochenaAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by Administrator on 2017/7/22.
 */

public class LiveFragment extends BaseFragment implements LiveContract.View {
    private LivePresenter presenter;
    private ListView mListView;
    private ZhiBochenaAdapter mAdapter;
    private List<ChangchengBean.LiveBean> mList = new ArrayList<>();


    Unbinder unbinder;
    private String url;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        unbinder = ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.zhibochena_listview;
    }


    @Override
    protected void initView(View view) {
        mListView = (ListView) view.findViewById(R.id.ZhiboChena_ListView);
        mAdapter = new ZhiBochenaAdapter(getContext(), mList);
        mListView.setAdapter(mAdapter);
    }

    @Override
    protected void loadData() {
        new LivePresenter(this);
        url = bundle.getString("url");
        if(url!=null) {
            presenter.setUrl(url);

        }

    }


    @Override
    public void getManager(ChangchengBean changchengBean) {
        mList.addAll(changchengBean.getLive());
        mAdapter.notifyDataSetChanged();


    }

    @Override
    public void showMessage(String msg) {

    }

    @Override
    public void onRefresh() {

    }

    @Override
    public void showProgress() {

    }

    @Override
    public void dismissProgress() {

    }

    @Override
    public void setPresenter(LiveContract.Presenter presenter) {
        this.presenter = (LivePresenter) presenter;
    }
}
