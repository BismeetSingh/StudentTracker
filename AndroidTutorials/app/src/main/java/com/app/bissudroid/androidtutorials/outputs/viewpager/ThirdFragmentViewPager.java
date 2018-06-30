package com.app.bissudroid.androidtutorials.outputs.viewpager;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.app.bissudroid.androidtutorials.R;

public class ThirdFragmentViewPager extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.second_fragment,container,false);
        TextView view1=view.findViewById(R.id.fragmentname);
        view1.setText("Fragment Three");
        return view;
    }
}
