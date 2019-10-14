package com.darpan.learnc.urls;

import java.util.ArrayList;

public class dataBasePdf {

    private ArrayList<String> urlList=new
            ArrayList<>();


    public dataBasePdf(ArrayList<String> urlList) {
        this.urlList = urlList;
    }

    public ArrayList<String> getUrlList() {
        return urlList;
    }

    public void setUrlList(ArrayList<String> urlList) {
        this.urlList = urlList;
    }
}
