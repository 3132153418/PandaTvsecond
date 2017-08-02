package com.example.administrator.pandatvsecond.moudle.pandalive.fragment;

import android.support.v7.widget.LinearLayoutManager;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.administrator.pandatvsecond.R;
import com.example.administrator.pandatvsecond.base.BaseFragment;
import com.example.administrator.pandatvsecond.model.bean.live.WatchTalkBean;
import com.example.administrator.pandatvsecond.moudle.pandalive.adapter.WatchTalkRecyclerviewAdapter;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.List;

/**
 * Created by lenovo on 2017/7/31.
 */

public class SmallLiveWatchTalkFragment extends BaseFragment implements View.OnClickListener{


    private List<WatchTalkBean.DataBean.ContentBean> content;
    private EditText edt_smalllive_watchtalk;
    private Button btn_smalllive_watchtalk;
    private XRecyclerView recyclerview;
    private WatchTalkRecyclerviewAdapter watchTalkRecyclerviewAdapter;

    public SmallLiveWatchTalkFragment(List<WatchTalkBean.DataBean.ContentBean> content) {
        this.content = content;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.live_smalllive_watchtalk;
    }

    @Override
    protected void initView(View view) {
        edt_smalllive_watchtalk = (EditText) view.findViewById(R.id.edt_smalllive_watchtalk);
        btn_smalllive_watchtalk = (Button) view.findViewById(R.id.btn_smalllive_watchtalk);
        btn_smalllive_watchtalk.setOnClickListener(this);
        recyclerview = (XRecyclerView) view.findViewById(R.id.recyclerview_smalllive_watchtalk);
        recyclerview.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, true));
        recyclerview.setPullRefreshEnabled(true);
        recyclerview.setLoadingMoreEnabled(true);
        recyclerview.setLoadingListener(new XRecyclerView.LoadingListener() {
            @Override
            public void onRefresh() {

            }

            @Override
            public void onLoadMore() {

            }
        });
        watchTalkRecyclerviewAdapter = new WatchTalkRecyclerviewAdapter(content,getActivity());
        recyclerview.setAdapter(watchTalkRecyclerviewAdapter);
    }

    @Override
    protected void loadData() {

    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.btn_smalllive_watchtalk:
                String trim = edt_smalllive_watchtalk.getText().toString().trim();
                if (TextUtils.isEmpty(trim)) {
                    Toast.makeText(getActivity(), "请输入内容", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(getActivity(), trim, Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }
}
