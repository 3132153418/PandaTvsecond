package com.example.administrator.pandatvsecond.base;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.administrator.pandatvsecond.app.App;
import com.umeng.analytics.MobclickAgent;

import butterknife.ButterKnife;

/**
 * Created by Administrator on 2017/7/27.
 */

public abstract class BaseActivity extends AppCompatActivity{

    private BaseFragment lastFragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        App.context = this;
        setContentView(getLauoutId());
        ButterKnife.bind(this);
        initView();
        loadData();
    }

    protected abstract int getLauoutId();
    protected abstract void loadData();
    protected abstract void initView();

    public void onResume() {
        super.onResume();
        MobclickAgent.onResume(this);
    }
    public void onPause() {
        super.onPause();
        MobclickAgent.onPause(this);
    }

    public void setParams(Bundle bundle){

    }
    /**
     * 切换Fragment的方法
     * @param fragmentClass 要跳转的Fragment
     * @param containId 容器ID
     * @param isHidden 是否隐藏
     * @param bundle 参数
     * @param isBack 是否添加到回退栈
     * @return
     */
    public BaseFragment changeFragment(Class<? extends BaseFragment> fragmentClass,int containId,boolean isHidden,Bundle bundle,boolean isBack) {

        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        //获取Fragment的类名，用类名当做Tag
        String fragmentName = fragmentClass.getSimpleName();
        //根据tag来查找当前Fragment，如果不为null 就代表当前Fragment已经被加载过至少一次
        BaseFragment currentFragment = (BaseFragment) manager.findFragmentByTag(fragmentName);
        if(currentFragment == null){
            //如果Fragment为null 就创建Fragment对象，添加到FragmentManager中
            try {
                //通过Java动态代理创建的对象
                currentFragment = fragmentClass.newInstance();
                //添加到FragmentManager中
                transaction.add(containId,currentFragment,fragmentName);

            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        if(isHidden) {
            //隐藏上一个Fragment
            if (lastFragment != null)
                transaction.hide(lastFragment);
            //显示当前Fragment
            transaction.show(currentFragment);
        }else {
            //替换上一个Fragment
            transaction.replace(containId,currentFragment,fragmentName);
        }
        //传递参数
        if(bundle != null){
            currentFragment.setBundle(bundle);
        }

        if(isBack){
            transaction.addToBackStack(fragmentName);
        }

        transaction.commit();

        lastFragment = currentFragment;

        return lastFragment;

    }


}
