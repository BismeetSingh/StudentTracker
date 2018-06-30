package com.app.bissudroid.androidtutorials.outputs.fragment_communication;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.app.bissudroid.androidtutorials.R;
import com.app.bissudroid.androidtutorials.viewmodels.CommViewModel;

import timber.log.Timber;

public class FragmentTwo extends Fragment {
    CommViewModel mainActivityViewModel;
    TextView textView;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_two_comm, container, false);
        Timber.d("%s","OnCreateViewCalled");
        textView=view.findViewById(R.id.textview);
        return view;
    }
    public void setData(String data){
        Integer val=Integer.parseInt(data);
        textView.setText(getResources().getString(R.string.count, val));

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mainActivityViewModel= ViewModelProviders.of(getActivity()).get(CommViewModel.class);
    }
}
