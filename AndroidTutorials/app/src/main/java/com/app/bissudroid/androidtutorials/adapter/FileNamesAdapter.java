package com.app.bissudroid.androidtutorials.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.app.bissudroid.androidtutorials.R;

import java.util.List;

public class FileNamesAdapter extends ArrayAdapter<String> {
    List<String> filenames;
    Context context;

    public FileNamesAdapter(@NonNull Context context, List<String> listitems) {
        super(context, 0);
        this.context = context;
        this.filenames = listitems;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        final FileNamesAdapter.ViewHolder vh;
        View view = convertView;
        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.load_files, parent, false);
            vh = new FileNamesAdapter.ViewHolder(view);
            view.setTag(vh);
        } else {
            vh = (FileNamesAdapter.ViewHolder) view.getTag();
        }


        vh.textViewTitle.setText(filenames.get(position));


        return view;
    }

    @Nullable
    @Override
    public String getItem(int position) {
        return filenames.get(position);
    }

    @Override
    public int getCount() {
        return filenames==null?0:filenames.size();
    }

    static class ViewHolder {
        TextView textViewTitle;


        ViewHolder(View view) {
            textViewTitle = view.findViewById(R.id.catName);


        }

    }
}
