package com.app.bissudroid.androidtutorials.outputs.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.app.bissudroid.androidtutorials.R;
import com.app.bissudroid.androidtutorials.models.Users;

import java.util.ArrayList;
import java.util.List;

public class CustomRecyclerViewAdapter extends RecyclerView.Adapter<CustomRecyclerViewAdapter.CustomHolder> {
    private List<Users> usersList;
    private LayoutInflater layoutInflater;

    public CustomRecyclerViewAdapter(Context context) {
        layoutInflater=LayoutInflater.from(context);
        usersList=new ArrayList<>();
    }

    @NonNull
    @Override
    public CustomHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view=layoutInflater.inflate(R.layout.recycler_view_list_items,parent,false);
        return new CustomHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CustomHolder holder, int position) {
        Users users=usersList.get(position);
        holder.email.setText(users.getEmail());
        holder.phone.setText(users.getPhoneno());
        holder.name.setText(users.getName());

    }
    public void updateData(List<Users> users){
        usersList=users;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return usersList==null?0:usersList.size();
    }

    class CustomHolder extends RecyclerView.ViewHolder {
        TextView name,phone,email;
        CustomHolder(View itemView) {
            super(itemView);
            name=itemView.findViewById(R.id.rname);
            phone=itemView.findViewById(R.id.rphone);
            email=itemView.findViewById(R.id.remail);
        }
    }
}
