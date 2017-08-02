package com.example.administrator.pandatvsecond.util;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Environment;
import android.widget.Toast;

import com.example.administrator.pandatvsecond.R;
import com.example.administrator.pandatvsecond.app.App;
import com.example.administrator.pandatvsecond.model.bean.UpdateBean;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by lenovo on 2017/8/2.
 */

public class VersionUpdateUtils {
    private static int versionCode;
    public static String TAG = "VersionUpdateUtils";
    private static String versionsUrl;


//    private static VersionUpdateUtils versionUpdateUtils;
//    public static VersionUpdateUtils newInstance(){
//        if (versionUpdateUtils==null) {
//            synchronized (VersionUpdateUtils.class){
//                versionUpdateUtils = new VersionUpdateUtils();
//            }
//        }
//        return versionUpdateUtils;
//    }


    public static String getAppVersionName() {
        String versionName = "";
        try {
            PackageManager pm = App.context.getPackageManager();
            PackageInfo pi = pm.getPackageInfo(App.context.getPackageName(), 0);
            versionName = pi.versionName;
            versionCode = pi.versionCode;
            MineLog.d(TAG, "versionCode" + versionCode);
            if (versionName == null || versionName.length() <= 0) {
                return "";
            }
        } catch (Exception e) {
            MineLog.d(TAG, "versionName" + versionName);
        }
        return versionName;
    }

    public static boolean isNeedVersionUpdata(UpdateBean updateBean) {
        getAppVersionName();
        String versionsNum = updateBean.getData().getVersionsNum();
        versionsUrl = updateBean.getData().getVersionsUrl();
        int versionsInt = Integer.parseInt(versionsNum);
        if (versionCode < versionsInt) {
            return true;
        } else {
            return false;
        }
//        SuperLog.d("版本更新bean打印",updateBean.getData().getVersionsinfo().toString());
    }

    public static void showWarnUpdateDialog() {
        new AlertDialog.Builder(App.context).setTitle("版本升级")//设置对话框标题
                .setMessage("检测到最新版本，新版本对系统做了更好的优化")//设置显示的内容
                .setPositiveButton("立即更新", new DialogInterface.OnClickListener() {//添加确定按钮

                    @Override
                    public void onClick(DialogInterface dialog, int which) {//确定按钮的响应事件

                        dialog.dismiss();
                        showUpdateDialog();
                        dialog.dismiss();
                    }
                }).setNegativeButton("稍后再说", new DialogInterface.OnClickListener() {//添加返回按钮
            @Override
            public void onClick(DialogInterface dialog, int which) {//响应事件

                dialog.dismiss();
            }
        }).show();//在按键响应事件中显示此对话框
    }

    private static void showUpdateDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(App.context);
        // 设置提示框的标题
        builder.setTitle("版本升级").setIcon(R.drawable.logo_ipnda)
                .setMessage("发现新版本！请及时更新")
                .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                        loadNewVersionProgress();//下载最新的版本程序
                    }
                })
                .setNegativeButton("取消", null);
        builder.create().show();
    }

    private static void loadNewVersionProgress() {
        final String uri = versionsUrl;
        final ProgressDialog pd;    //进度条对话框
        pd = new ProgressDialog(App.context);
        pd.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        pd.setMessage("正在下载更新");
        pd.show();
        //启动子线程下载任务
        new Thread() {
            @Override
            public void run() {
                try {
                    File file = getFileFromServer(uri, pd);
                    sleep(3000);
                    installApk(file);
                    pd.dismiss(); //结束掉进度条对话框
                } catch (Exception e) {
                    App.context.runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Toast.makeText(App.context, "下载失败", Toast.LENGTH_SHORT).show();
                        }
                    });
                    e.printStackTrace();
                }
            }
        }.start();
    }

    private static void installApk(File file) {
        Intent intent = new Intent();
        //执行动作
        intent.setAction(Intent.ACTION_VIEW);
        //执行的数据类型
        intent.setDataAndType(Uri.fromFile(file), "application/vnd.android.package-archive");
        App.context.startActivity(intent);
    }

    private static File getFileFromServer(String uri, final ProgressDialog pd) throws Exception {
        //如果相等的话表示当前的sdcard挂载在手机上并且是可用的
        if (Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)) {
            URL url = new URL(uri);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setConnectTimeout(5000);
            //获取到文件的大小
            pd.setMax(conn.getContentLength());
            InputStream is = conn.getInputStream();
            long time = System.currentTimeMillis();//当前时间的毫秒数
            File file = new File(Environment.getExternalStorageDirectory().getAbsolutePath(), time + "updata.apk");
            if (!file.exists())
                file.createNewFile();
            FileOutputStream fos = new FileOutputStream(file);
            BufferedInputStream bis = new BufferedInputStream(is);
            byte[] buffer = new byte[1024];
            int len,total = 0;
            while ((len = bis.read(buffer)) != -1) {
                fos.write(buffer, 0, len);
                total += len;
                //获取当前下载量
                pd.setProgress(total);
            }
            fos.close();
            bis.close();
            is.close();
            return file;
        } else {
            return null;
        }
    }


}
