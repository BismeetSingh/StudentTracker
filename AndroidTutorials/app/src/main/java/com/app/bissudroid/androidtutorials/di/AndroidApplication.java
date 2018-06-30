package com.app.bissudroid.androidtutorials.di;

import com.app.bissudroid.androidtutorials.BuildConfig;

//import com.squareup.leakcanary.LeakCanary;

import dagger.android.AndroidInjector;
import dagger.android.support.DaggerApplication;
import timber.log.Timber;

public class AndroidApplication extends DaggerApplication {
    @Override
    protected AndroidInjector<? extends DaggerApplication> applicationInjector() {
        AndroidComponent androidComponent=DaggerAndroidComponent.builder().buildapp(this).buid();
        androidComponent.inject(this);
        return androidComponent;
    }

    @Override
    public void onCreate() {
        super.onCreate();
       // if (LeakCanary.isInAnalyzerProcess(this)) return;
//        LeakCanary.install(this);
        if(BuildConfig.DEBUG){
            Timber.plant(new Timber.DebugTree());
        }
        else {
            Timber.uprootAll();
        }
    }
}
