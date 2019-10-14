package com.darpan.learnc.models;

import java.util.List;

public class secondfragmentsItems {
    private String Description;
    private String Label;
    private String Title;
    private String Author;
    private String Time;
    private int mImageView;
    private List<firstFragmentitems> nestedList;

    public secondfragmentsItems(List<firstFragmentitems> nestedList) {
        this.nestedList = nestedList;
    }

    public List<firstFragmentitems> getNestedList() {
        return nestedList;
    }

    public void setNestedList(List<firstFragmentitems> nestedList) {
        this.nestedList = nestedList;
    }

    public secondfragmentsItems() {

    }

    public secondfragmentsItems(String description, String label, String title, String author, String time, int mImageView, List<firstFragmentitems> nestedList) {
        Description = description;
        Label = label;
        Title = title;
        Author = author;
        Time = time;
        this.mImageView = mImageView;
        this.nestedList = nestedList;
    }

    //setter


    public void setDescription(String description) {
        Description = description;
    }

    public void setLabel(String label) {
        Label = label;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public void setAuthor(String author) {
        Author = author;
    }

    public void setTime(String time) {
        Time = time;
    }

    public void setmImageView(int mImageView) {
        this.mImageView = mImageView;
    }

    //getter


    public String getDescription() {
        return Description;
    }

    public String getLabel() {
        return Label;
    }

    public String getTitle() {
        return Title;
    }

    public String getAuthor() {
        return Author;
    }

    public String getTime() {
        return Time;
    }

    public int getmImageView() {
        return mImageView;
    }
}
