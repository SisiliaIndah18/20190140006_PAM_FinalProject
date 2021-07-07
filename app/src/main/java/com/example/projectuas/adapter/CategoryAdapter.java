package com.example.projectuas.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.example.projectuas.CategoryItem;
import com.example.projectuas.QuestionActivity;
import com.example.projectuas.R;

import java.util.ArrayList;

public class CategoryAdapter extends ArrayAdapter<CategoryItem> {

    public static final String CATEGORY_COLOR = "CategoryColor"; //deklarasi variabel dengan jenis data string
    public static final String CATEGORY_ID = "CategoryID"; //deklarasi variabel dengan jenis data string
    private Context mContext; //deklarasi variabel dengan jenis data context
    private ArrayList<CategoryItem> mCategoryItems; //deklarasi variabel dengan jenis data arraylist

    //membuat konstruktor CategoryAdapter
    public CategoryAdapter(@NonNull Context context, int resource, @NonNull ArrayList<CategoryItem> categoryItems) {
        super(context, resource, categoryItems);
        this.mContext = context; //memberikan nilai mContext dengan context
        this.mCategoryItems = categoryItems; //memberikan nilai mCategoryItems dengan categoryItems
    }

    @Override
    public int getCount() { //fungsi get count untuk mengembalikan jumlah item yang ditampilkan
        return super.getCount();
    }

    //fungsi ini secara otomatis dipanggil ketika item list siap untuk ditampilkan atau akan ditampilkan
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        CategoryViewHolder categoryViewHolder; //deklarasi categoryViewHolder
        final CategoryItem categoryItem = mCategoryItems.get(position); //deklarasi category item

        if (convertView == null) { //membuat kondisi apakah null atau tidak
            convertView = LayoutInflater.from(mContext).inflate(R.layout.grid_view_item, parent, false); //menampilkan layout grid_view_item untuk item
            categoryViewHolder = new CategoryViewHolder(convertView); //membuat objek view holder
            convertView.setTag(categoryViewHolder); //menyimpan data dalam tampilan
        }
        categoryViewHolder = (CategoryViewHolder) convertView.getTag();
        categoryViewHolder.categoryImage.setBackgroundColor(categoryItem.getmBgColor()); //set background color di category image
        categoryViewHolder.categoryTitle.setText(categoryItem.getmCategoryTitle()); //set judul di category title
        categoryViewHolder.categoryImage.setOnClickListener(new View.OnClickListener() { //membuat event untuk mengklik
            @Override
            public void onClick(View v) {
                Intent questionIntent = new Intent(mContext, QuestionActivity.class); //membuat intent ke kelas QuestionActivity
                questionIntent.putExtra(CATEGORY_ID, categoryItem.getmCategoryID()); // mengirimkan category id
                questionIntent.putExtra(CATEGORY_COLOR, categoryItem.getmBgColor()); // mengirimkan category color
                mContext.startActivity(questionIntent); //kondisi untuk menjalankan method intent
            }
        });
        return convertView; //mengambalikan ke convert view
    }

    //membuat method CategoryViewHolder
    static class CategoryViewHolder extends RecyclerView.ViewHolder {

        ImageView categoryImage; //deklarasi variabel categoryImage
        TextView categoryTitle; //deklarasi variabel categoryTitle

        CategoryViewHolder(View itemView) { //untuk menampilkan item
            super(itemView);
            categoryImage = itemView.findViewById(R.id.category_image); //set id untuk image
            categoryTitle = itemView.findViewById(R.id.category_title); //set id untuk title
        }
    }
}
