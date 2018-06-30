package com.app.bissudroid.androidtutorials.fragment.activities;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.app.bissudroid.androidtutorials.Constants;
import com.app.bissudroid.androidtutorials.R;
import com.app.bissudroid.androidtutorials.viewmodels.MainActivityViewModel;

import timber.log.Timber;

public class ActivityInfoFragment extends Fragment {
    int position = 0;
    TextView textView;
    MainActivityViewModel activityViewModel;
    Toolbar toolbar;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.activity_info,container,false);
        textView = view.findViewById(R.id.generalinfo);
        return view;
    }

    private void setTextForGeneralInfo() {
        switch (position) {
            case 0:
                toolbar.setTitle("History");
                textView.setText(
                        R.string.history);
                break;
            case 1:
                toolbar.setTitle("Beneath Android");
                textView.setText(R.string.architectureinfo);
                break;
            case 2:
                toolbar.setTitle("The Linux Kernel");
                textView.setText(R.string.linuxkernel);
                break;
            case 3:
                toolbar.setTitle("Dalvik VM");
                textView.setText(R.string.dalvik);
                break;

        }
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            position = getArguments().getInt(Constants.POSITION_KEY, 0);
            Timber.d("%d", position);
        }

//            activityViewModel= ViewModelProviders.of(this).get(MainActivityViewModel.class);
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        activityViewModel = ViewModelProviders.of(getActivity()).get(MainActivityViewModel.class);
        toolbar = getActivity().findViewById(R.id.mytoolbar);
        setTextForGeneralInfo();
//        getActivity().findViewById(R.id.bottomview).setVisibility(View.GONE);
    }
}
