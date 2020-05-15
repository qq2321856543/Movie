package com.bw.movie.base;

import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Environment;
import android.support.multidex.MultiDex;

import com.facebook.cache.disk.DiskCacheConfig;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.imagepipeline.core.ImagePipelineConfig;
import com.tencent.mm.opensdk.constants.ConstantsAPI;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;


public class App extends Application {

    private static Context mcontext;
    private static final String APP_ID = "wxb3852e6a6b7d9516";
    private static IWXAPI api;
    @Override
    public void onCreate() {
        super.onCreate();
        regToWx();
        mcontext = getApplicationContext();
        MultiDex.install(this);

        ImagePipelineConfig build = ImagePipelineConfig.newBuilder(this)
                .setMainDiskCacheConfig(DiskCacheConfig.newBuilder(this)
                        .setBaseDirectoryPath(Environment.getDownloadCacheDirectory())
                        .setBaseDirectoryName("cc/")
                        .setMaxCacheSize(10 * 1024 * 1024)
                        .build())
                .build();

        Fresco.initialize(this);
    }
    public static Context getAppContext(){
        return mcontext;
    }
    private void regToWx() {
        // 通过WXAPIFactory工厂，获取IWXAPI的实例
        api = WXAPIFactory.createWXAPI(this, APP_ID, true);

        // 将应用的appId注册到微信
        api.registerApp(APP_ID);

        //建议动态监听微信启动广播进行注册到微信
        registerReceiver(new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                // 将该app注册到微信
                api.registerApp(APP_ID);
            }
        }, new IntentFilter(ConstantsAPI.ACTION_REFRESH_WXAPP));
    }

    public static IWXAPI getWxApi(){
        return api;
    }
}
