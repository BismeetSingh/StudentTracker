package com.app.bissudroid.androidtutorials.di;

import android.app.Application;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjectionModule;
import dagger.android.AndroidInjector;
import dagger.android.support.AndroidSupportInjection;
import dagger.android.support.AndroidSupportInjectionModule;
import dagger.android.support.DaggerApplication;
@Singleton
@Component(modules = {AndroidSupportInjectionModule.class, AndroidInjectionModule.class,AndroidModule.class,
AndroidBindingModule.class})
public interface AndroidComponent extends AndroidInjector<DaggerApplication>{
    @Component.Builder
    interface Builder{
        AndroidComponent buid();
        @BindsInstance
        Builder buildapp(Application application);
    }
}
