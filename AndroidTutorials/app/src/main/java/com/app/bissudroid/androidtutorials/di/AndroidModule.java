package com.app.bissudroid.androidtutorials.di;

import android.app.Application;
import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class AndroidModule {
    @Provides
    @Singleton
    static Context getContext(Application application)
    {
        return application.getApplicationContext();
    }


}
