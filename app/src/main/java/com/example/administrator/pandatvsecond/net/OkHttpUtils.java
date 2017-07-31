package com.example.administrator.pandatvsecond.net;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.administrator.pandatvsecond.app.App;
import com.example.administrator.pandatvsecond.net.callback.MyCallBack;
import com.example.administrator.pandatvsecond.widget.manager.Keys;
import com.google.gson.Gson;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Map;
import java.util.Set;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.Headers;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by Administrator on 2017/7/27.
 */

public class OkHttpUtils implements Ihttp {
    private String jsonId;
    byte[] bytes;
    private static OkHttpUtils okHttpUtils;
    private OkHttpClient okHttpClient;
    public OkHttpUtils(){

        this.okHttpClient = new OkHttpClient.Builder().build();
    }
    public static OkHttpUtils getInstance(){
        if (okHttpUtils == null){
            synchronized (OkHttpUtils.class){
                if (okHttpUtils == null){
                    okHttpUtils = new OkHttpUtils();
                }
            }

        }
        return okHttpUtils;
    }
    @Override
    public <T> void get(String url, MyCallBack<T> callBack) {

    }


    @Override
    public <T> void get(String url, Map<String, String> params, final MyCallBack<T> callBack) {

        StringBuffer sb = new StringBuffer(url);
        if(params != null && params.size() > 0){
            sb.append("?");
            Set<String> keys = params.keySet();
            for (String key : keys) {
                String value = params.get(key);
                sb.append(key).append("=").append(value).append("&");
            }
            url = sb.deleteCharAt(sb.length()-1).toString();
        }
        Request request = new Request.Builder().url(url).build();
        okHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, final IOException e) {
                App.context.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        //执行在主线程
                        callBack.onError(e.getMessage().toString());
                    }
                });

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                final String jsonData = response.body().string();
                //执行在子线程中
                App.context.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        //执行在主线程
                        callBack.onSusses(getGeneric(jsonData,callBack));
                    }
                });

            }
        });
    }

    @Override
    public <T> void get(String url, Map<String, String> params, Map<String, String> heards, final MyCallBack<T> callBack) {

        StringBuffer sb = new StringBuffer(url);
        if(params != null && params.size() > 0){
            sb.append("?");
            Set<String> keys = params.keySet();
            for (String key : keys) {
                String value = params.get(key);
                sb.append(key).append("=").append(value).append("&");
            }
            url = sb.deleteCharAt(sb.length()-1).toString();
        }
        Request.Builder builder = new Request.Builder();
        if(heards != null && heards.size() > 0){
            Set<String> keys = heards.keySet();
            for (String key : keys){
                String value = heards.get(key);
                builder.addHeader(key,value);
            }
        }
        Request request = builder.url(url).build();
        okHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, final IOException e) {
                App.context.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        //执行在主线程
                        callBack.onError(e.getMessage().toString());
                    }
                });

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                final String jsonData = response.body().string();
                //执行在子线程中
                App.context.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        //执行在主线程
                        callBack.onSusses(getGeneric(jsonData,callBack));
                    }
                });

            }
        });
    }

    @Override
    public <T> void loginPost(String url, Map<String, String> params, Map<String, String> heards, final MyCallBack<T> callBack) {
        StringBuffer sb = new StringBuffer(url);
        if (params != null && params.size() > 0) {
            sb.append("?");
            Set<String> strings = params.keySet();
            for (String string : strings) {
                String s = params.get(string);
                sb.append(string).append("=").append(s).append("&");
            }
            url = sb.deleteCharAt(sb.length() - 1).toString();
        }
        Request.Builder builder = new Request.Builder();

        if (heards != null && heards.size() > 0) {
            Set<String> strings = heards.keySet();
            for (String string : strings) {
                String s = heards.get(string);
                builder.addHeader(string, s);
            }
        }
        Request request = builder.url(url).build();

        okHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                //okhttp请求失败的回调
                Log.d("loginPostOkHttpUtils", "网络请求异常" + e.toString());
                App.context.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        //执行在主线程
                        callBack.onError("loginPost执行了网络请求异常");
                    }
                });
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                Headers headers = response.headers();
                jsonId = headers.get("Set-Cookie");
                bytes = response.body().bytes();
                //执行在子线程中
                App.context.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        saveCookie(jsonId);
                        Drawable drawable = byteToDrawable(bytes);

                        callBack.onSuccess(drawable);
                    }
                });

            }
        });
    }

    @Override
    public <T> void registerPost(String url, Map<String, String> params, Map<String, String> heards, final MyCallBack<T> callBack) {
        StringBuffer sb = new StringBuffer(url);
        if (params != null && params.size() > 0) {
            sb.append("?");
            Set<String> strings = params.keySet();
            for (String string : strings) {
                String s = params.get(string);
                sb.append(string).append("=").append(s).append("&");
            }
            url = sb.deleteCharAt(sb.length() - 1).toString();
        }
        Request.Builder builder = new Request.Builder();

        if (heards != null && heards.size() > 0) {
            Set<String> strings = heards.keySet();
            for (String string : strings) {
                String s = heards.get(string);
                builder.addHeader(string, s);
            }
        }
        final Request request = builder.url(url).build();

        okHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                //okhttp请求失败的回调
                Log.d("registerPostOkHttpUtils", "网络请求异常" + e.toString());
                App.context.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        //执行在主线程
                        callBack.onError("registerPost执行了网络请求异常");
                    }
                });
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                final String string = response.body().string();
                Log.i("yanzhengma",string);
                //执行在子线程中
                App.context.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {

                        callBack.onsusses(string);
                    }
                });

            }
        });
    }
    public void saveCookie(String value){
        SharedPreferences cookie = App.context.getSharedPreferences("cookie", Context.MODE_PRIVATE);
        SharedPreferences.Editor edit = cookie.edit();
        edit.putString("Cookie",value);
        edit.commit();
    }
    @Override
    public <T> void post(String url, MyCallBack<T> callBack) {


    }

    @Override
    public <T> void post(String url, Map<String, String> params, final MyCallBack<T> callBack) {

        FormBody.Builder builder = new FormBody.Builder();
        if(params !=null && params.size() > 0){
            Set<String> keys = params.keySet();
            for (String key : keys) {
                String value = params.get(key);
                builder.add(key,value);
            }
        }
        Request request = new Request.Builder().url(url).post(builder.build()).build();
        okHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, final IOException e) {
                App.context.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        //执行在主线程
                        callBack.onError(e.getMessage().toString());
                    }
                });

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                final String jsonData = response.body().string();
                //执行在子线程中
                App.context.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        //执行在主线程
                        callBack.onSusses(getGeneric(jsonData,callBack));
                    }
                });

            }
        });
    }

    @Override
    public <T> void post(String url, Map<String, String> params, Map<String, String> heards, MyCallBack<T> callBack) {

    }

    @Override
    public void loadImage(String url, ImageView imageView) {
        Glide.with(App.context).load(url).into(imageView);

    }
    public void loadImgCode(String url,final MyCallBack<Bundle> callback){
        Request request = new Request.Builder().url(url).build();
        okHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, final IOException e) {
                App.context.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        //执行在主线程
                        callback.onError(e.getMessage().toString());
                    }
                });

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                byte[] bytes = response.body().bytes();
                Headers headers = response.headers();
                String jsessionId =  headers.get("Set-Cookie");
                final Bundle bundle = new Bundle();
                bundle.putString(Keys.JSESSIONID,jsessionId);
                bundle.putByteArray(Keys.IMGCODE,bytes);

                //执行在子线程中
                App.context.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        //执行在主线程
                        callback.onSusses(bundle);
                    }
                });

            }
        });
    }

    /**
     * 自动解析json至回调中的JavaBean
     * @param jsonData
     * @param callBack
     * @param <T>
     * @return
     */
    private <T> T getGeneric(String jsonData,MyCallBack<T> callBack){
        Gson gson = new Gson();
        //通过反射获取泛型的实例
        Type[] types = callBack.getClass().getGenericInterfaces();
        Type[] actualTypeArguments = ((ParameterizedType) types[0]).getActualTypeArguments();
        Type type = actualTypeArguments[0];
        T t = gson.fromJson(jsonData,type);
        return t;
    }




    public static Drawable byteToDrawable(byte[] byteArray) {
        try {
            String string = new String(byteArray, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        ByteArrayInputStream ins = new ByteArrayInputStream(byteArray);
        return Drawable.createFromStream(ins, null);
    }
}
