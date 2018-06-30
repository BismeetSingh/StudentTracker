package com.app.bissudroid.androidtutorials.fragment;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import com.app.bissudroid.androidtutorials.R;
import com.app.bissudroid.androidtutorials.viewmodels.MainActivityViewModel;

public class AboutUsFragment extends Fragment {
    ImageButton email, whatsapp;
MainActivityViewModel mainActivityViewModel;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_about_us, container, false);
        email = view.findViewById(R.id.maildeveloper);
        whatsapp = view.findViewById(R.id.whatsappdeveloper);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if (getActivity() != null) {
            Toolbar toolbar=getActivity().findViewById(R.id.mytoolbar);
            if(toolbar!=null){
                toolbar.setTitle("About us");
            }
            mainActivityViewModel= ViewModelProviders.of(getActivity()).get(MainActivityViewModel.class);
            email.setOnClickListener(v -> {
                Intent intent=new Intent(Intent.ACTION_SENDTO);
                intent.setData(Uri.parse("mailto:bismeetsingh352@gmail.com"));
                intent.putExtra(Intent.EXTRA_SUBJECT,"Android App Query");
                startActivity(Intent.createChooser(intent,"Send Email"));


            });
        }
        whatsapp.setOnClickListener(v -> {
            PackageManager packageManager = getActivity().getPackageManager();
            Intent i = new Intent(Intent.ACTION_VIEW);

            try {
                String url = "https://api.whatsapp.com/send?phone=" + "919892308331";
                i.setPackage("com.whatsapp");
                i.setData(Uri.parse(url));
                if (i.resolveActivity(packageManager) != null) {
                    getActivity().startActivity(i);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public static AboutUsFragment getInstance(){
        return new AboutUsFragment();
    }
    //
//        https://play.google.com/store/apps/details?id=<YOUR_PACKAGE_NAME>
}

