package com.example.projectuas;

import android.os.Bundle;
import android.util.Log;
import android.widget.GridView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.projectuas.adapter.CategoryAdapter;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private GridView mGridView; //deklarasi variabel untuk gridview
    private CategoryAdapter mCategoryAdapter; //deklarasai variabel untuk category adapter
    private ArrayList<CategoryItem> mCategoryItems; //deklarasi variabel dengan jenis data arraylist
    private int[] mColors; //deklarasi variabel color dengan jenis data integer
    private String[] mCategoryTitles; //deklarasi variabel dengan jenis data string
    private String[] mCategoryID; //deklarasi variabel dengan jenis data string

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); //set untuk menampilkan layout activity_main

        setUpCategoryItems(); //set category items

        mGridView = findViewById(R.id.categories_list); //untuk menampilkan grid view dengan id categories_list
        mCategoryAdapter = new CategoryAdapter(this, R.layout.grid_view_item, mCategoryItems); //sebagai adapter untuk mengambil data dari layout grid_view_item dan menampilkan di activity_main
        mGridView.setAdapter(mCategoryAdapter); //set adapter di grid view
    }

    private void setUpCategoryItems() {
        mCategoryItems = new ArrayList<>(); //set mCategoryItems menggunakan array list
        mCategoryTitles = getResources().getStringArray(R.array.category_title); //mengambil string array dengan nama category_title
        mCategoryID = getResources().getStringArray(R.array.category_ID); //mengambil string array dengan nama category_ID

        mColors = getResources().getIntArray(R.array.colors); //mengambil color array yang akan digunakan di layout grid view item

        //membaca data pada arraylist category title
        for (int i = 0; i < mCategoryTitles.length; i++) {
            mCategoryItems.add(new CategoryItem(mColors[i], mCategoryTitles[i], mCategoryID[i])); //untuk menambahkan warna, judul, dan id disetiap items
            Log.d("TAG", "Title\t" + mCategoryTitles[i] + "\tID\t" + mCategoryID[i]);
        }
    }
}