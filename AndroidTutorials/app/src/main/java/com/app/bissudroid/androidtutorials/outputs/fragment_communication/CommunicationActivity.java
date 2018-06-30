package com.app.bissudroid.androidtutorials.outputs.fragment_communication;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.app.bissudroid.androidtutorials.R;
import com.app.bissudroid.androidtutorials.viewmodels.CommViewModel;

public class CommunicationActivity extends AppCompatActivity implements Communicator {
    FragmentManager fragmentManager;
    String datavalue;
    FragmentTransaction fragmentTransaction;
    CommViewModel mainActivityViewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_communicator);
        mainActivityViewModel= ViewModelProviders.of(this).get(CommViewModel.class);
        Toolbar toolbar=findViewById(R.id.toolbar);
        toolbar.setTitle("Fragment Communication");
        fragmentManager=getSupportFragmentManager();
        fragmentTransaction=fragmentManager.beginTransaction();

        fragmentTransaction.add(R.id.framelayout,new FragmentOne()).addToBackStack(null);
        fragmentTransaction.add(R.id.framelayout2,new FragmentTwo()).addToBackStack(null);
        fragmentTransaction.commit();


    }

    @Override
    public void send(String data) {
        FragmentTwo fragmentTwo= (FragmentTwo) fragmentManager.findFragmentById(R.id.framelayout2);
        fragmentTwo.setData(data);
        datavalue=data;




    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();
        if(fragmentManager!=null && fragmentManager.getBackStackEntryCount()>=0){
            fragmentManager.popBackStackImmediate(null,FragmentManager.POP_BACK_STACK_INCLUSIVE);
            finish();
        }
    }
}
