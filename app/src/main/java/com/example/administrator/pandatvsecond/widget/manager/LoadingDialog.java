package com.example.administrator.pandatvsecond.widget.manager;

import android.app.Dialog;
import android.content.Context;
import android.view.Gravity;
import com.example.administrator.pandatvsecond.R;
/**
 * Created by lenovo on 2017/7/28.
 */

public class LoadingDialog extends Dialog {

    private static LoadingDialog loadingDialog;

    public LoadingDialog(Context context) {
        super(context);
    }

    public LoadingDialog(Context context, int themeResId) {
        super(context, themeResId);
    }
    public static LoadingDialog show(Context context){
        loadingDialog = new LoadingDialog(context, R.style.LoadingDialog);
        loadingDialog.setContentView(R.layout.dialog_loading);
        loadingDialog.setCancelable(false);//设置不可取消
        loadingDialog.setCanceledOnTouchOutside(false);//设置点击外部不可取消
        loadingDialog.getWindow().getAttributes().gravity = Gravity.CENTER;
        loadingDialog.show();
        return loadingDialog;
    }
    public static void dimiss(){
        if (loadingDialog != null && loadingDialog.isShowing())
            loadingDialog.dismiss();
    }

}
