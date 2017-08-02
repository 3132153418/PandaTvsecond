package com.example.administrator.pandatvsecond.util;

import android.database.sqlite.SQLiteDatabase;

import com.example.administrator.pandatvsecond.app.App;
import com.example.administrator.pandatvsecond.model.db.VideoCollectBean;
import com.jiyun.com.day07_greendao.DaoMaster;
import com.jiyun.com.day07_greendao.DaoSession;
import com.jiyun.com.day07_greendao.VideoCollectBeanDao;

import org.greenrobot.greendao.query.QueryBuilder;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lenovo on 2017/8/2.
 */

public class GreeDaoUtils {

    public void add(String name,VideoCollectBean bean){
        DaoMaster.DevOpenHelper openHelper = new DaoMaster.DevOpenHelper(App.context, name, null);
        SQLiteDatabase writableDatabase = openHelper.getWritableDatabase();
        DaoMaster daoMaster=new DaoMaster(writableDatabase);
        DaoSession daoSession = daoMaster.newSession();
        daoSession.insert(bean);
    }

    public List<VideoCollectBean> select(String name){
        DaoMaster.DevOpenHelper openHelper = new DaoMaster.DevOpenHelper(App.context, name, null);
        SQLiteDatabase writableDatabase = openHelper.getReadableDatabase();
        DaoMaster daoMaster=new DaoMaster(writableDatabase);
        DaoSession daoSession = daoMaster.newSession();
        VideoCollectBeanDao videoCollectBeanDao = daoSession.getVideoCollectBeanDao();
        QueryBuilder<VideoCollectBean> videoCollectBeanQueryBuilder = videoCollectBeanDao.queryBuilder();
        List<VideoCollectBean> list = videoCollectBeanQueryBuilder.list();
        return  list;
    }

    public void select(String name, ArrayList<VideoCollectBean> arr ){
        DaoMaster.DevOpenHelper openHelper = new DaoMaster.DevOpenHelper(App.context, name, null);
        SQLiteDatabase writableDatabase = openHelper.getReadableDatabase();
        DaoMaster daoMaster=new DaoMaster(writableDatabase);
        DaoSession daoSession = daoMaster.newSession();
        VideoCollectBeanDao videoCollectBeanDao = daoSession.getVideoCollectBeanDao();
        QueryBuilder<VideoCollectBean> videoCollectBeanQueryBuilder = videoCollectBeanDao.queryBuilder();
        List<VideoCollectBean> list = videoCollectBeanQueryBuilder.list();
        arr.clear();
        for (int x=0;x<list.size();x++){
            arr.add(list.get(x));
        }

    }




    public void delect(String name,VideoCollectBean collectBean){
        DaoMaster.DevOpenHelper openHelper = new DaoMaster.DevOpenHelper(App.context, name, null);
        SQLiteDatabase writableDatabase = openHelper.getWritableDatabase();
        DaoMaster daoMaster=new DaoMaster(writableDatabase);
        DaoSession daoSession = daoMaster.newSession();
        VideoCollectBeanDao videoCollectBeanDao = daoSession.getVideoCollectBeanDao();
        videoCollectBeanDao.delete(collectBean);
    }


}
