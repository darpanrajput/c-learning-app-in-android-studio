package com.darpan.learnc.models;

public class firstFragmentitems {
    private int Description;
    private  String Label;
    private String Title;
    private String Author;
    private String Time;
    private int lockImage;
    int Banner;

    public firstFragmentitems(String c_is_very_cool_language, String s, String s1, String by_me, String s2, int android_logo,int lock_image,int banner)
    {


    }

    public int getLockImage() {
        return lockImage;
    }

    public void setLockImage(int lockImage) {
        this.lockImage = lockImage;
    }

    public firstFragmentitems(int description, String label, String title, String author, String time, int lock_image,int banner) {
        Description = description;
        Label = label;
        Title = title;
        Author = author;
        Time = time;
        lockImage=lock_image;
        Banner=banner;
    }

    //setter

    public void setDescription(int description) {
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


    //getter


    public int getDescription() {
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

    public int getBanner() {
        return Banner;
    }

    public void setBanner(int banner) {
        Banner = banner;
    }
}
