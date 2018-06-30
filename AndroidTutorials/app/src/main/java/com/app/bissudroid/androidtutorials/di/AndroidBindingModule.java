package com.app.bissudroid.androidtutorials.di;

import com.app.bissudroid.androidtutorials.activity.MainActivity;
import com.app.bissudroid.androidtutorials.fragment.CategoryFragment;
import com.app.bissudroid.androidtutorials.fragment.activities.ActivityDetailsFragment;
import com.app.bissudroid.androidtutorials.fragment.activities.ActivityInfoFragment;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class AndroidBindingModule {
    @ContributesAndroidInjector
    abstract MainActivity getMainActivity();

    @ContributesAndroidInjector
    abstract CategoryFragment getCategoryFragment();

    @ContributesAndroidInjector
    abstract ActivityDetailsFragment getActivityDetailsFragment();

    @ContributesAndroidInjector
    abstract ActivityInfoFragment getActivityInfoFragment();
}
