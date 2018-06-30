package com.app.bissudroid.androidtutorials.adapter;

import android.content.Context;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.TextView;

import com.app.bissudroid.androidtutorials.OnPositionChangeListener;
import com.app.bissudroid.androidtutorials.R;

import java.util.List;


public class DetailsAdapter extends ArrayAdapter<String> {
    private Context context;
    private int position;
    private List<String> contents;
    private Animation scaleup;
    private OnPositionChangeListener onPositionChangeListener;

    public DetailsAdapter(@NonNull Context context, @NonNull List<String> objects, int position, OnPositionChangeListener onPositionChangeListener) {
        super(context, 0, objects);
        contents = objects;
        this.onPositionChangeListener = onPositionChangeListener;
        this.context = context;
        this.position = position;
        scaleup= AnimationUtils.loadAnimation(context,R.anim.scaleup);
    }

    @Override
    public int getCount() {
        return contents == null ? 0 : contents.size();
    }

    @Nullable

    @Override
    public String getItem(int position) {
        return contents.get(position);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        final DetailsAdapter.ViewHolder vh;
        View view = convertView;
        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.categories_helper_items, parent, false);
            vh = new DetailsAdapter.ViewHolder(view);
            view.setTag(vh);
            View finalView = view;
            new Handler().post(() -> finalView.startAnimation(scaleup));
        } else {
            vh = (DetailsAdapter.ViewHolder) view.getTag();
        }
        //Disables run buttons for the theory (introduction) section.
        if (this.position == 0) {
            vh.content.setVisibility(View.INVISIBLE);
        }
        vh.content.setOnClickListener(v -> {
            onPositionChangeListener.onPositionItemClick(position);

//            Toast.makeText(context, ""+position, Toast.LENGTH_SHORT).show();

        });


        vh.textViewTitle.setText(contents.get(position));


        return view;
    }

    static class ViewHolder {
        TextView textViewTitle;
        ImageButton content;

        ViewHolder(View view) {
            textViewTitle = view.findViewById(R.id.catName);
            content = view.findViewById(R.id.accessContent);

        }

    }
}
