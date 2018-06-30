package com.app.bissudroid.androidtutorials.models;

import com.app.bissudroid.androidtutorials.R;

import java.util.ArrayList;
import java.util.List;

public class CategoryListItems {
    private int imageid;
    private String categoryTitle;

    public int getImageid() {
        return imageid;
    }

    public String getCategoryTitle() {
        return categoryTitle;
    }

    public CategoryListItems(int imageid, String categoryTitle) {

        this.imageid = imageid;
        this.categoryTitle = categoryTitle;
    }
    public static List<CategoryListItems> categoryListItems(){
        List<CategoryListItems> categoryListItems=new ArrayList<>();
        categoryListItems.add(new CategoryListItems(R.drawable.training,"Introduction"));
        categoryListItems.add(new CategoryListItems(R.drawable.training,"Activities"));
        categoryListItems.add(new CategoryListItems(R.drawable.training,"Fragments"));
        categoryListItems.add(new CategoryListItems(R.drawable.training,"Widgets"));
        categoryListItems.add(new CategoryListItems(R.drawable.training,"Animations"));
        categoryListItems.add(new CategoryListItems(R.drawable.training,"Material Design"));


        return categoryListItems;
    }

}
