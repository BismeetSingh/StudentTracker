package com.app.bissudroid.androidtutorials.outputs.animations;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.util.Log;
import android.view.View;

import timber.log.Timber;

public class MyViewModel extends ViewModel {
public MutableLiveData<String> toastmsg=new MutableLiveData<>();

    public void onBtnClick(){
        Timber.d("Clicked");
        toastmsg.setValue("Hey Sent A Toast");

    }
}
