package com.app.bissudroid.androidtutorials.fragment;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.app.bissudroid.androidtutorials.Constants;
import com.app.bissudroid.androidtutorials.OnPositionChangeListener;
import com.app.bissudroid.androidtutorials.R;
import com.app.bissudroid.androidtutorials.adapter.ExamplesAdapter;
import com.app.bissudroid.androidtutorials.outputs.MenuActivity;
import com.app.bissudroid.androidtutorials.outputs.adapter.RecyclerViewActivity;
import com.app.bissudroid.androidtutorials.outputs.architecture_components.ViewModelActivity;
import com.app.bissudroid.androidtutorials.outputs.examples.CustomDialogActivity;
import com.app.bissudroid.androidtutorials.outputs.examples.CustomToastActivity;
import com.app.bissudroid.androidtutorials.outputs.examples.DatePickerActivity;
import com.app.bissudroid.androidtutorials.outputs.fragment_communication.CommunicationActivity;
import com.app.bissudroid.androidtutorials.outputs.fragment_communication.Communicator;
import com.app.bissudroid.androidtutorials.outputs.notifications.NotificationActivity;
import com.app.bissudroid.androidtutorials.outputs.sharedpreferences.RegistrationActivity;
import com.app.bissudroid.androidtutorials.outputs.sheets.SheetsActivity;
import com.app.bissudroid.androidtutorials.outputs.viewpager.ViewPagerActivity;
import com.app.bissudroid.androidtutorials.viewmodels.MainActivityViewModel;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import timber.log.Timber;

public class ExamplesFragment extends Fragment implements OnPositionChangeListener{
    private ListView listViewItems;
    MainActivityViewModel activityViewModel;
    private List<String> items;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.categories_helper,container,false);
        listViewItems=view.findViewById(R.id.itemslist);

        return view;
    }
    public static ExamplesFragment getInstance(){
        return new ExamplesFragment();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Toolbar toolbar= Objects.requireNonNull(getActivity()).findViewById(R.id.mytoolbar);
        toolbar.setTitle("Examples");
        activityViewModel= ViewModelProviders.of(Objects.requireNonNull(getActivity())).get(MainActivityViewModel.class);
        getList();
        ExamplesAdapter examplesAdapter=new ExamplesAdapter(getActivity(),items,this);
        listViewItems.setAdapter(examplesAdapter);
        listViewItems.setOnItemClickListener((parent, view, position, id) -> {
            Bundle bundle=new Bundle();
            bundle.putInt(Constants.POSITION_KEY,position);
            FragmentManager fragmentManager=getActivity().getSupportFragmentManager();
            FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
            ExampleItemsFragment exampleItemsFragment=new ExampleItemsFragment();
            exampleItemsFragment.setArguments(bundle);
            fragmentTransaction.replace(R.id.frame,exampleItemsFragment).addToBackStack(null).commit();
        });
    }

    private void getList() {
        items=Arrays.asList(getResources().getStringArray(R.array.examples));
    }

    @Override
    public void onPositionItemClick(int position) {
        Timber.d("%d",position);
        switch (position){
            case 0:
                startActivity(new Intent(getActivity(), CustomToastActivity.class));
                break;
            case 1:
                startActivity(new Intent(getActivity(), CustomDialogActivity.class));
                break;
            case 2:
                startActivity(new Intent(getActivity(), RecyclerViewActivity.class));
                break;
            case 5:
                startActivity(new Intent(getActivity(), MenuActivity.class));
                break;
                //TODO fix notifications.
            case 6:
                startActivity(new Intent(getActivity(), NotificationActivity.class));
                break;
            case 7:

                startActivity(new Intent(getActivity(), SheetsActivity.class));
                break;
            case 3:
                startActivity(new Intent(getActivity(), CommunicationActivity.class));
                break;
            case 4:
                startActivity(new Intent(getActivity(), RegistrationActivity.class));
                break;
            case 8:
                startActivity(new Intent(getActivity(), ViewPagerActivity.class));
                break;
            case 9:
                startActivity(new Intent(getActivity(), ViewModelActivity.class));

        }

    }
}
