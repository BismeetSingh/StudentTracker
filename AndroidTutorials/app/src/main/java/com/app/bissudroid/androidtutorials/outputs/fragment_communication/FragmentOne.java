package com.app.bissudroid.androidtutorials.outputs.fragment_communication;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.app.bissudroid.androidtutorials.R;
import com.app.bissudroid.androidtutorials.viewmodels.CommViewModel;

import timber.log.Timber;

public class FragmentOne extends Fragment implements View.OnClickListener {
    int count = 0;
    CommViewModel mainActivityViewModel;
    Communicator communicator;
    Button btn;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        communicator = (Communicator) context;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_one_comm, container, false);
        Timber.d("%s","OnCreateViewCalled");
        btn = view.findViewById(R.id.clickme);
        btn.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View v) {
        count++;
        communicator.send(String.valueOf(count));

    }



    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if(savedInstanceState!=null){
            count++;
            communicator.send(String.valueOf(count));
        }
        mainActivityViewModel= ViewModelProviders.of(getActivity()).get(CommViewModel.class);
    }



}
