package com.app.bissudroid.androidtutorials.fragment;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.app.bissudroid.androidtutorials.Constants;
import com.app.bissudroid.androidtutorials.R;
import com.app.bissudroid.androidtutorials.activity.CodeActivity;
import com.app.bissudroid.androidtutorials.adapter.FileNamesAdapter;
import com.app.bissudroid.androidtutorials.viewmodels.MainActivityViewModel;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ExampleItemsFragment extends Fragment implements ListView.OnItemClickListener{
    private ListView listView;
    int position=0;
    private List<String> filenames;
    private String defaultfilename="MainActivity.java";
    private String textcode;
    String arr[];
    String title="";
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.categories_helper, container, false);
        listView = view.findViewById(R.id.itemslist);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if(getArguments()!=null){
            position=getArguments().getInt(Constants.POSITION_KEY,0);
        }
        MainActivityViewModel mainActivityViewModel = ViewModelProviders.of(getActivity()).get(MainActivityViewModel.class);

        setUpFilenames();
        FileNamesAdapter fileNamesAdapter=new FileNamesAdapter(getActivity(),filenames);
        listView.setAdapter(fileNamesAdapter);
        listView.setOnItemClickListener(this);
    }

    private void setUpFilenames() {
        Resources resources=getResources();

        switch (position){

            case 0:
                title="Custom Toast";
                filenames= Arrays.asList(resources.getStringArray(R.array.CustomSection));

            case 1:
                title="Custom Alert Dialog";
                filenames= Arrays.asList(resources.getStringArray(R.array.CustomSection));
                break;
            case 6:
                title="Notifications";
                filenames=Arrays.asList(resources.getStringArray(R.array.file_activity_names));
                break;
            case 7:
                title="Bottom Navigation View";
                filenames=Arrays.asList(resources.getStringArray(R.array.bottomitems));
                break;
            case 4:
                title="Shared Preferences";
                filenames=Arrays.asList(resources.getStringArray(R.array.SharedPreferences));
                break;
            case 8:
                title="ViewPager";
                filenames= Arrays.asList(resources.getStringArray(R.array.ViewpagerItems));
                break;
            case 5:
                title="Menus";
                filenames=Arrays.asList(resources.getStringArray(R.array.MenuItems));
                break;
            case 2:
                title="RecyclerView";
                filenames=Arrays.asList(resources.getStringArray(R.array.RecyclerViewcontents));
                break;
            case 9:
                title="ViewModels";
                filenames=Arrays.asList(resources.getStringArray(R.array.Archcomponents));
                break;
            case 3:
                title="Inter Fragment Communication";
                filenames=Arrays.asList(resources.getStringArray(R.array.fragmentcommunication));
                break;
        }

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int pos, long id) {

        if(position==0){

            if(pos==0){
                textcode=getString(R.string.Toastjava);

            }
            else if(pos==1){
                textcode=getString(R.string.ToastXML);
                defaultfilename="activity_main.xml";
            }
            else if(pos==2){
                textcode=getString(R.string.CustomToastXml);
                defaultfilename="custom_toast.xml";
            }
            else if(pos==3){
                textcode=getString(R.string.drawableToast);
                defaultfilename="custom_background.xml";
            }
        }
        else if(position==1){
            if(pos==0){
                textcode=getString(R.string.activitydialog);

            }
            else if(pos==1){
                textcode=getString(R.string.ToastXML);
                defaultfilename="activity_main.xml";
            }
            else if(pos==2){
                textcode=getString(R.string.customdialog);
                defaultfilename="custom_dialog.xml";
            }
            else if(pos==3){
                textcode=getString(R.string.drawableToast);
                defaultfilename="custom_background.xml";
            }
        }
        else if(position==6){
            if(pos==0){
                textcode=getString(R.string.notificationJava);
            }
            else {
                textcode=getString(R.string.notificationXml);
                defaultfilename="activity_main.xml";
            }
        }
        else if(position==7){
            if(pos==0)textcode=getString(R.string.BottomJava);
            else if(pos==1) {
            textcode=getString(R.string.activitybtm);
                defaultfilename="activity_main.xml";
            }
            else if(pos==2){
                textcode=getString(R.string.fragmentbtmsheet);
                defaultfilename="fragment_bottom_sheet_dialog.xml";
            }
            else if(pos==3){
                textcode=getString(R.string.bottomlayout);
                defaultfilename="bottom_sheet.xml";

            }
        }
        else if(position==8){
            if(pos==0){
                textcode=getString(R.string.MainActivityViewPager);
            }
            else if(pos==1){
                textcode=getString(R.string.activity_viewpager);
                defaultfilename="activity_main.xml";

            }
            else if(pos==2){
                textcode=getString(R.string.OneFragmentViewPager);
                defaultfilename="FirstFragment.java";

            }
            else if(pos==3){
                textcode=getString(R.string.TwoFragmentViewpager);
                defaultfilename="SecondFragment.java";

            }
            else if(pos==4){
                textcode=getString(R.string.ThirdViewPager);
                defaultfilename="ThirdFragment.java";

            }
            else if(pos==5){
                textcode=getString(R.string.OneFragmentViewPagerXml);
                defaultfilename="fragment_one.xml";

            }

            else if(pos==6){
                textcode=getString(R.string.TwoFragmentViewPagerXml);
                defaultfilename="fragment_two.xml";

            }else if(pos==7){
                textcode=getString(R.string.ThirdFragmentViewPagerXml);
                defaultfilename="fragment_third.xml";

            }

        }
        else if(position==4){
            if(pos==0){
                textcode=getString(R.string.RegistrationActivity);
                defaultfilename="RegistrationActivity.java";
            }
            else if(pos==1){
                textcode=getString(R.string.LoginActivity);
                defaultfilename="LoginActivity.java";

            }
            else if(pos==2){
                textcode=getString(R.string.activity_main_preferences);
                defaultfilename="activity_main.xml";
            }
            else if(pos==3){
                textcode=getString(R.string.activity_login);
                defaultfilename="activity_login.xml";
            }
        }
        else if(position==5){
            if(pos==0){
                textcode=getString(R.string.MainActivityMenu);
                defaultfilename="MainActivity.java";
            }
            else if(pos==1){
                textcode=getString(R.string.XmlActivityMenu);
                defaultfilename="activity_main.xml";

            }
            else if(pos==2){
                textcode=getString(R.string.MenuXMlMenu);
                defaultfilename="menu_main.xml";
            }
            else if(pos==3){
                textcode=getString(R.string.toolbarMenu);
                defaultfilename="toolbar.xml";
            }

        }
        else if(position==9) {
            if (pos == 0) {
                textcode = getString(R.string.abtarchcomponents);
                defaultfilename = "Introduction";
            } else if (pos == 1) {
                defaultfilename="MainActivity.java";
                textcode = getString(R.string.archMain);

            } else if (pos == 2) {
                textcode = getString(R.string.ModelMain);
                defaultfilename = "MyViewModel.java";
            } else if (pos == 3) {
                textcode = getString(R.string.actarchmain);
                defaultfilename = "activity_viewmodel.xml";
            }

        }
        else if(position==3){
            if(pos==0){
                textcode=getString(R.string.MainActivityComm);
            }
            else if(pos==1){
                textcode=getString(R.string.actComm);
                defaultfilename="activity_main.xml";

            }
            else if(pos==2){
                textcode=getString(R.string.FragOneComm);
                defaultfilename="FragmentOne.java";

            }
            else if(pos==3){
                textcode=getString(R.string.FragTwoComm);
                defaultfilename="FragmentTwo.java";

            }
            else if(pos==4){
                textcode=getString(R.string.fragxmlonecomm);
                defaultfilename="fragment_one.xml";

            }
            else if(pos==5){
                textcode=getString(R.string.fragxmltwocomm);
                defaultfilename="fragment_two.xml";

            }

            else if(pos==6){
                textcode=getString(R.string.CommunicatorInterface);
                defaultfilename="Communicator.java";

            }

        }
        else if(position==2){
            if(pos==0){
                defaultfilename="Introduction";
                textcode=getString(R.string.abtRecyclerView);


//                textcode=getString(R.string.In)
            }
            else if(pos==1){
                textcode=getString(R.string.MainActRView);
                defaultfilename="MainActivity.java";

            }
            else if(pos==2){
                textcode=getString(R.string.actxmlRView);
                defaultfilename="activity_main.xml";

            }
            else if(pos==3){
                textcode=getString(R.string.itemsRView);
                defaultfilename="items.xml";

            }
            else if(pos==4){
                textcode=getString(R.string.Radapter);
                defaultfilename="CustomRecyclerViewAdapter.java";

            }
            else if(pos==5) {
                textcode = getString(R.string.Users);
                defaultfilename = "Users";

            }




        }


            if (textcode != null)
            startActivity(new Intent(getActivity(), CodeActivity.class).putExtra(Constants.FIELD_KEY, textcode)
                    .putExtra("title",title)
                    .putExtra(Constants.FIELDFILENAME, defaultfilename));

    }
}
