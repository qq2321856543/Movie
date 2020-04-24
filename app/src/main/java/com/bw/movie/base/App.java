package com.bw.movie.base;

import android.app.Application;
import android.content.Context;

import com.facebook.drawee.backends.pipeline.Fresco;


public class App extends Application {

    private static Context mcontext;

    @Override
    public void onCreate() {
        super.onCreate();
        mcontext = getApplicationContext();
        Fresco.initialize(this);
    }
    public static Context getAppContext(){
        return mcontext;
    }
}
