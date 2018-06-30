package com.app.bissudroid.androidtutorials.fragment.activities;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.app.bissudroid.androidtutorials.Constants;
import com.app.bissudroid.androidtutorials.OnPositionChangeListener;
import com.app.bissudroid.androidtutorials.R;
import com.app.bissudroid.androidtutorials.adapter.DetailsAdapter;
import com.app.bissudroid.androidtutorials.fragment.ProgramsFilesNamesFragment;
import com.app.bissudroid.androidtutorials.outputs.Activity_Main_Activity;
import com.app.bissudroid.androidtutorials.outputs.FirstActivity;
import com.app.bissudroid.androidtutorials.outputs.LifeCycle;
import com.app.bissudroid.androidtutorials.outputs.animations.MoveActivity;
import com.app.bissudroid.androidtutorials.outputs.examples.DatePickerActivity;
import com.app.bissudroid.androidtutorials.outputs.examples.TimeActivity;
import com.app.bissudroid.androidtutorials.outputs.fragments.FragmentFirstActivity;
import com.app.bissudroid.androidtutorials.outputs.fragments.FragmentSecondActivity;
import com.app.bissudroid.androidtutorials.outputs.fragments.ThirdFragmentActivity;
import com.app.bissudroid.androidtutorials.outputs.materialdesign.BottomNavActivity;
import com.app.bissudroid.androidtutorials.outputs.materialdesign.CollapsingToolbarActivity;
import com.app.bissudroid.androidtutorials.outputs.materialdesign.FabActivity;
import com.app.bissudroid.androidtutorials.outputs.materialdesign.NavDrawerActivity;
import com.app.bissudroid.androidtutorials.outputs.materialdesign.SharedElementSourceActivity;
import com.app.bissudroid.androidtutorials.outputs.materialdesign.TextInputLayoutActivity;
import com.app.bissudroid.androidtutorials.outputs.materialdesign.ToolbarActivity;
import com.app.bissudroid.androidtutorials.outputs.widgets.ButtonsImplementation;
import com.app.bissudroid.androidtutorials.outputs.widgets.CheckBoxImplementation;
import com.app.bissudroid.androidtutorials.outputs.widgets.EditTextImplementation;
import com.app.bissudroid.androidtutorials.outputs.widgets.ImageViewImplementation;
import com.app.bissudroid.androidtutorials.outputs.widgets.ProgressDialogImplementation;
import com.app.bissudroid.androidtutorials.outputs.widgets.RadioButtonImplementation;
import com.app.bissudroid.androidtutorials.outputs.widgets.SeekbarActivity;
import com.app.bissudroid.androidtutorials.outputs.widgets.SpinnerImplementation;
import com.app.bissudroid.androidtutorials.outputs.widgets.SwitchesImplementation;
import com.app.bissudroid.androidtutorials.outputs.widgets.TextViewImplementation;
import com.app.bissudroid.androidtutorials.outputs.widgets.ToggleButtonsImplementation;
import com.app.bissudroid.androidtutorials.outputs.widgets.WebViewImplementation;
import com.app.bissudroid.androidtutorials.viewmodels.MainActivityViewModel;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import timber.log.Timber;

public class ActivityDetailsFragment extends Fragment implements AdapterView.OnItemClickListener, OnPositionChangeListener {
    int position;
    MainActivityViewModel activityViewModel;
    private ListView listView;
    private FragmentManager fragmentManager;
    private List<String> topicslist;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.categories_helper, container, false);
//        activityViewModel= ViewModelProviders.of(getActivity()).get(MainActivityViewModel.class);
        listView = view.findViewById(R.id.itemslist);
        if (getArguments() != null) {
            position = getArguments().getInt(Constants.POSITION_KEY, 0);
        }
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Toolbar toolbar = Objects.requireNonNull(getActivity()).findViewById(R.id.mytoolbar);
        toolbar.setTitle(getString(R.string.categories));
        super.onActivityCreated(savedInstanceState);
        setPositionList();
        activityViewModel = ViewModelProviders.of(Objects.requireNonNull(getActivity())).get(MainActivityViewModel.class);
        DetailsAdapter detailsAdapter = new DetailsAdapter(Objects.requireNonNull(getActivity()), topicslist, position, this);
        listView.setAdapter(detailsAdapter);
        listView.setOnItemClickListener(this);
        fragmentManager = getFragmentManager();


    }


    private void setPositionList() {
        Resources resources = getResources();
        switch (position) {
            case 0:
                topicslist = Arrays.asList(resources.getStringArray(R.array.introduction));
                break;
            case 1:
                topicslist = Arrays.asList(resources.getStringArray(R.array.activities));
                Timber.d(topicslist.toString());
                break;
            case 2:
                topicslist = Arrays.asList(resources.getStringArray(R.array.fragments));
                break;
            case 3:
                topicslist = Arrays.asList(resources.getStringArray(R.array.widgets));
                break;
            case 4:
                topicslist = Arrays.asList(resources.getStringArray(R.array.animations));
                break;
            case 5:
                topicslist = Arrays.asList(resources.getStringArray(R.array.materialdesign));
                break;



        }

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Timber.d("%d", position);
//        Fragment fragment=null;
        if (this.position == 0) {
            Bundle bundle = new Bundle();
            bundle.putInt(Constants.POSITION_KEY, position);
            ActivityInfoFragment activityInfoFragment = new ActivityInfoFragment();
            activityInfoFragment.setArguments(bundle);
            fragmentManager.beginTransaction().replace(R.id.frame, activityInfoFragment).addToBackStack(null).
                    setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out, android.R.anim.fade_in,
                            android.R.anim.fade_out).commit();


        } else {

            Bundle bundle = new Bundle();
            bundle.putInt(Constants.POSITION_KEY, this.position);
            bundle.putInt(Constants.SUB_POS_KEY, position);
            ProgramsFilesNamesFragment programsFilesNamesFragment = new ProgramsFilesNamesFragment();
            programsFilesNamesFragment.setArguments(bundle);
            fragmentManager.beginTransaction().replace(R.id.frame, programsFilesNamesFragment).addToBackStack(null).
                    setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out, android.R.anim.fade_in,
                            android.R.anim.fade_out).commit();
        }
    }


    @Override
    public void onPositionItemClick(int pos) {
        Timber.d(String.valueOf(pos));
        if (position == 1) {
            if (pos == 0) {
                startActivity(new Intent(getActivity(), Activity_Main_Activity.class));
            } else if (pos == 1) {

                startActivity(new Intent(getActivity(), LifeCycle.class));
            } else startActivity(new Intent(getActivity(), FirstActivity.class));
        } else if (position == 2) {
            if (pos == 0)
                startActivity(new Intent(getActivity(), FragmentFirstActivity.class));
            else if (pos == 1)
                startActivity(new Intent(getActivity(), FragmentSecondActivity.class));
            else startActivity(new Intent(getActivity(), ThirdFragmentActivity.class));
        } else if (position == 3) {
            if (pos == 0) startActivity(new Intent(getActivity(), TextViewImplementation.class));
            if (pos == 1) startActivity(new Intent(getActivity(), EditTextImplementation.class));
            if (pos == 2) startActivity(new Intent(getActivity(), ButtonsImplementation.class));
            if (pos == 3) startActivity(new Intent(getActivity(), ImageViewImplementation.class));
            if (pos == 4) startActivity(new Intent(getActivity(), SwitchesImplementation.class));
            if (pos == 5)
                startActivity(new Intent(getActivity(), ToggleButtonsImplementation.class));
            if (pos == 6) startActivity(new Intent(getActivity(), SpinnerImplementation.class));
            if(pos==7)startActivity(new Intent(getActivity(), SeekbarActivity.class));
            if (pos == 8) startActivity(new Intent(getActivity(), RadioButtonImplementation.class));
            if (pos == 9)
                startActivity(new Intent(getActivity(), CheckBoxImplementation.class));
            if (pos == 10)
                startActivity(new Intent(getActivity(), ProgressDialogImplementation.class));
            if (pos == 11) startActivity(new Intent(getActivity(), WebViewImplementation.class));
            if (pos == 12) startActivity(new Intent(getActivity(), DatePickerActivity.class));
            if (pos == 13) startActivity(new Intent(getActivity(), TimeActivity.class));


        } else if (position == 4) {
            startActivity(new Intent(getActivity(), MoveActivity.class).putExtra(Constants.POSITION_KEY, pos));

        } else if (position == 5) {
            if (pos == 0) {
                startActivity(new Intent(getActivity(), ToolbarActivity.class));
            } else if (pos == 1) {
                startActivity(new Intent(getActivity(), CollapsingToolbarActivity.class));
            } else if (pos == 2) {
                startActivity(new Intent(getActivity(), NavDrawerActivity.class));

            } else if (pos == 3) {
                startActivity(new Intent(getActivity(), FabActivity.class));

            }
            else if(pos==4){
                startActivity(new Intent(getActivity(), BottomNavActivity.class));
            }
            else if(pos==5){
                startActivity(new Intent(getActivity(), TextInputLayoutActivity.class));
            }
            else if(pos==6){
                startActivity(new Intent(getActivity(), SharedElementSourceActivity.class));
            }

        }



    }
}
