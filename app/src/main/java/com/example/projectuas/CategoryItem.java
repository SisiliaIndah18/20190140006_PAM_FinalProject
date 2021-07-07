package com.example.projectuas;

public class CategoryItem {
    private int mBgColor; //deklarasi variabel dengan jenis data integer
    private String mCategoryTitle; //deklarasi variabel dengan jenis data string
    private String mCategoryID; //deklarasi variabel dengan jenis data string

    //membuat konstruktor CategoryItem
    public CategoryItem(int imageId, String categoryTitle, String categoryID) {
        this.mBgColor = imageId; //memberikan nilai mBgColor dengan imageId
        this.mCategoryTitle = categoryTitle; //memberikan nilai mCategoryTitle dengan categoryTitle
        this.mCategoryID = categoryID; //memberikan nilai mCategoryID dengan categoryID
    }

    public int getmBgColor() { //method getmBgColor
        return mBgColor; //mengembalikan ke nilai mBgColor
    }

    public String getmCategoryTitle() { //getmCategoryTitle
        return mCategoryTitle; //mengembalikan ke nilai mCategoryTitle
    }

    public String getmCategoryID() { //getmCategoryID
        return mCategoryID; //mengembalikan ke nilai mCategoryID
    }
}
