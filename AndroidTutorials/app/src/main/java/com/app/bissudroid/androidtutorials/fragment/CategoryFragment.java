package com.app.bissudroid.androidtutorials.fragment;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.app.bissudroid.androidtutorials.Constants;
import com.app.bissudroid.androidtutorials.R;
import com.app.bissudroid.androidtutorials.adapter.CategoriesImageAdapter;
import com.app.bissudroid.androidtutorials.databinding.CategoryFragmentBinding;
import com.app.bissudroid.androidtutorials.fragment.activities.ActivityDetailsFragment;
import com.app.bissudroid.androidtutorials.viewmodels.MainActivityViewModel;

import dagger.android.support.AndroidSupportInjection;

public class CategoryFragment extends Fragment {
    CategoryFragmentBinding categoryFragmentBinding;
    MainActivityViewModel activityViewModel;


    public static CategoryFragment getInstance() {
        return new CategoryFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
       if(categoryFragmentBinding==null) {
           categoryFragmentBinding = CategoryFragmentBinding.inflate(inflater, container, false);
           categoryFragmentBinding.categorylist.setAdapter(new CategoriesImageAdapter(getActivity()));
       }

        return categoryFragmentBinding.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Toolbar toolbar = getActivity().findViewById(R.id.mytoolbar);
        toolbar.setTitle("Categories");
        activityViewModel = ViewModelProviders.of(getActivity()).get(MainActivityViewModel.class);
        categoryFragmentBinding.categorylist.setOnItemClickListener((parent, view, position, id) -> {
            FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
            Bundle bundle = new Bundle();
            bundle.putInt(Constants.POSITION_KEY, position);
            Handler handler = new Handler();
            handler.postDelayed(() -> {
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out
                        , android.R.anim.fade_in, android.R.anim.fade_out);
                ActivityDetailsFragment activityDetailsFragment = new ActivityDetailsFragment();
                activityDetailsFragment.setArguments(bundle);
                fragmentTransaction.replace(R.id.frame, activityDetailsFragment).addToBackStack(null);
                fragmentTransaction.commit();

            }, 200);


        });

    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        AndroidSupportInjection.inject(this);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        activityViewModel= ViewModelProviders.of(this).get(MainActivityViewModel.class);
    }

}
