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
import android.widget.ImageView;
import android.widget.TextView;

import com.app.bissudroid.androidtutorials.R;
import com.app.bissudroid.androidtutorials.models.CategoryListItems;

import java.util.List;

public class CategoriesImageAdapter extends ArrayAdapter<CategoryListItems> {
    Animation scaleup;
    private List<CategoryListItems> categoryListItems;
    private Context context;

    public CategoriesImageAdapter(@NonNull Context context) {
        super(context, 0);
        categoryListItems = CategoryListItems.categoryListItems();
        this.context = context;
        scaleup = AnimationUtils.loadAnimation(context, R.anim.scaleup);

    }

    @Override
    public int getCount() {
        return categoryListItems.size();
    }

    @Nullable
    @Override
    public CategoryListItems getItem(int position) {
        return categoryListItems.get(position);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        final ViewHolder vh;
        View view = convertView;
        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.category_list_items, parent, false);
            vh = new ViewHolder(view);
            view.setTag(vh);
            View finalView = view;
            new Handler().post(() -> finalView.startAnimation(scaleup));

        } else {
            vh = (ViewHolder) view.getTag();
        }


        vh.textViewTitle.setText(categoryListItems.get(position).getCategoryTitle());
        vh.imageView.setImageResource(categoryListItems.get(position).getImageid());

        return view;
    }

    static class ViewHolder {
        TextView textViewTitle;
        ImageView imageView;

        ViewHolder(View view) {
            textViewTitle = view.findViewById(R.id.txttopicname);
            imageView = view.findViewById(R.id.MediaPreview);
        }
    }
}
