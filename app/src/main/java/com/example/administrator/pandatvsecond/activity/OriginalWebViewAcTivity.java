package com.example.administrator.pandatvsecond.activity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.administrator.pandatvsecond.R;
import com.umeng.socialize.ShareAction;
import com.umeng.socialize.UMShareAPI;
import com.umeng.socialize.UMShareListener;
import com.umeng.socialize.bean.SHARE_MEDIA;
import com.umeng.socialize.media.UMImage;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by lenovo on 2017/7/21.
 */
public class OriginalWebViewAcTivity extends AppCompatActivity {
    @BindView(R.id.original_web_back)
    ImageView originalWebBack;
    @BindView(R.id.original_web)
    WebView originalWeb;
    @BindView(R.id.original_web_title)
    TextView originalwebtitle;
    @BindView(R.id.original_share)
    ImageView originalShare;
    private ProgressDialog dialog;
    private boolean isCollect = false;
    private String url;
    private String title;
    private String imageurl;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.original_webview);

        ButterKnife.bind(this);
        url = getIntent().getStringExtra("url");
        title = getIntent().getStringExtra("title");
        imageurl = getIntent().getStringExtra("image");
        originalwebtitle.setText(title);
        originalWeb.loadUrl(url);
        WebSettings settings = originalWeb.getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setUseWideViewPort(true);
        settings.setLoadWithOverviewMode(true);
        settings.setSupportZoom(true);
        settings.setBuiltInZoomControls(true);
        settings.setDisplayZoomControls(false);
        originalWeb.setWebViewClient(new WebViewClient() {

            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }

            //开始加载时
            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                dialog = new ProgressDialog(OriginalWebViewAcTivity.this);
                dialog.setMessage("请稍等......");
                dialog.show();
            }

            //加载结束时
            @Override
            public void onPageFinished(WebView view, String url) {
                dialog.cancel();
                super.onPageFinished(view, url);
            }
        });
    }

    @OnClick({R.id.original_web_back, R.id.original_share})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.original_web_back:
                finish();
                break;
            case R.id.original_share:
                UMImage image = new UMImage(OriginalWebViewAcTivity.this, imageurl);//网络图片
                image.compressStyle = UMImage.CompressStyle.SCALE;//大小压缩，默认为大小压缩，适合普通很大的图
                new ShareAction(OriginalWebViewAcTivity.this)
                        .withText(title + "/n" + url)
                        .withMedia(image)
                        .setDisplayList(SHARE_MEDIA.SINA, SHARE_MEDIA.QQ)
                        .setCallback(new UMShareListener() {
                            @Override
                            public void onStart(SHARE_MEDIA share_media) {
                                Toast.makeText(OriginalWebViewAcTivity.this, "开始分享,请您稍后", Toast.LENGTH_SHORT).show();
                            }

                            @Override
                            public void onResult(SHARE_MEDIA share_media) {
                                Toast.makeText(OriginalWebViewAcTivity.this, "恭喜您分享成功喽！", Toast.LENGTH_SHORT).show();
                            }

                            @Override
                            public void onError(SHARE_MEDIA share_media, Throwable throwable) {

                            }

                            @Override
                            public void onCancel(SHARE_MEDIA share_media) {
                                Toast.makeText(OriginalWebViewAcTivity.this, "取消分享", Toast.LENGTH_SHORT).show();
                            }
                        })
                        .open();
                break;
            //            case R.id.original_shoucang:
//                if (isCollect) {
//                    originalShoucang.setBackgroundResource(R.drawable.collect_no);
//                    isCollect = false;
//                    Toast toast = Toast.makeText(OriginalWebViewAcTivity.this, "恭喜您收藏成功啦", Toast.LENGTH_SHORT);
//                    toast.setGravity(Gravity.CENTER, 0, 0);
//                    View inflate = View.inflate(OriginalWebViewAcTivity.this, R.layout.item_toast, null);
//                    ((TextView) inflate.findViewById(R.id.tv_toast)).setText("已取消收藏");
//                    toast.setView(inflate);
//                    toast.show();
//                }else {
//                    originalShoucang.setBackgroundResource(R.drawable.collect_yes);
//                    isCollect = true;
//                    Toast toast = Toast.makeText(OriginalWebViewAcTivity.this, "恭喜您收藏成功啦", Toast.LENGTH_SHORT);
//                    toast.setGravity(Gravity.CENTER, 0, 0);
//                    View inflate = View.inflate(OriginalWebViewAcTivity.this, R.layout.item_toast, null);
//                    ((TextView) inflate.findViewById(R.id.tv_toast)).setText("已添加，请到[我的收藏]中查看");
//                    toast.setView(inflate);
//                    toast.show();
//                }
//
//                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        UMShareAPI.get(this).onActivityResult(requestCode, resultCode, data);
    }

}
