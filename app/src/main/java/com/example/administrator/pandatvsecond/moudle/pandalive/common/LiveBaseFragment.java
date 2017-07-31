package com.example.administrator.pandatvsecond.moudle.pandalive.common;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.administrator.pandatvsecond.util.MineLog;

/**
 * Created by lenovo on 2017/7/31.
 */

public abstract class LiveBaseFragment extends Fragment {
    //Fragment的View加载完毕的标记
    private boolean isViewCreated = false;

    //Fragment对用户可见的标记
    private boolean isUIVisible  =false;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(getLayoutId(), null);
        initView(view);

        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        isViewCreated = true;
        lazyLoad();
        MineLog.d("SmallLiveFragment","onViewCreated"+isViewCreated);
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        MineLog.d("SmallLiveFragment", "isVisibleToUser方法执行");
        //isVisibleToUser这个boolean值表示:该Fragment的UI 用户是否可见
        if (isVisibleToUser) {
            MineLog.d("SmallLiveFragment", "isVisibleToUser方法执行true");
            isUIVisible = true;
            lazyLoad();
        } else {
            isUIVisible = false;
        }
    }

    private void lazyLoad() {
        MineLog.d("SmallLiveFragment", "lazyLoad方法执行时" + "isUIVisible为" + isUIVisible + "isViewCreated为" + isViewCreated);
        //这里进行双重标记判断,是因为setUserVisibleHint会多次回调,并且会在onCreateView执行前回调,必须确保onCreateView加载完毕且页面可见,才加载数据
        if (isViewCreated && isUIVisible) {
            MineLog.d("SmallLiveFragment", "loadData方法执行");
            loadData();
            //数据加载完毕,恢复标记,防止重复加载
            isViewCreated = false;
            isUIVisible = false;
        }
    }


    protected abstract int getLayoutId();

    protected abstract void initView(View view);

    protected abstract void loadData();
}
