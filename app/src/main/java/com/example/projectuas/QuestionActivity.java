package com.example.projectuas;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.projectuas.adapter.QuestionAdapter;

import java.util.ArrayList;
import java.util.Objects;

import static com.example.projectuas.adapter.CategoryAdapter.CATEGORY_COLOR;
import static com.example.projectuas.adapter.CategoryAdapter.CATEGORY_ID;

public class QuestionActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView; //deklarasi variabel untuk RecyclerView
    private QuestionAdapter mAdapter; //deklarasi variabel untuk QuestionAdapter
    private ArrayList<Question> mQuestionList; //deklarasi variabel dengan jenis data arraylist
    private QuizDBHelper mDbHelper; //deklarasi variabel untuk QuizDBHelper
    private ConstraintLayout mParentLayout; //deklarasi variabel untuk ConstraintLayout
    private TextView mScoreTextView; //deklarasi variabel untuk TextView
    private TextView mRemaningQuestionsTextView; //deklarasi variabel untuk TextView
    private int mTotalQuestions; //deklarasi variabel dengan jenis data integer
    private int mScore; //deklarasi variabel dengan jenis data integer

    //membuat kosntruktor
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question); ////set untuk menampilkan layout activity_question

        //set display action bar
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        //membuat bundle
        Bundle categoryBundle = null;
        if (getIntent() != null) {
            categoryBundle = getIntent().getExtras();
        }

        //set untuk question_layout
        mParentLayout = findViewById(R.id.question_layout);
        if (categoryBundle != null) {
            String hexColor = String.format("#%06X", (0xFFFFFF & categoryBundle.getInt(CATEGORY_COLOR)));
            hexColor = "#44"+hexColor.substring(1);
            mParentLayout.setBackgroundColor(Color.parseColor(hexColor));
        }

        mScoreTextView = findViewById(R.id.score); //set untuk text view score
        mRemaningQuestionsTextView = findViewById(R.id.remaining_questions); //set untuk reimaining question
        mRecyclerView = findViewById(R.id.recyclerView); //set untuk recyclerView
        mRecyclerView.setNestedScrollingEnabled(false); //set enable scrolling
        mRecyclerView.setHasFixedSize(true); //memfixed ukuran

        //membuat objek dari mDbHelper menjadi QuizDBHelper
        mDbHelper = new QuizDBHelper(this, categoryBundle);
        if (categoryBundle != null) {
            mQuestionList = mDbHelper.getAllQuestions(categoryBundle.getString(CATEGORY_ID)); //mengambil pertanyaan dari mDbHelper
            mTotalQuestions = mQuestionList.size();
            mScore = 0;
            displayScore();
        }
        //membuat objek dari mAdapter menjadi QuestionAdapter
        mAdapter = new QuestionAdapter(this, mQuestionList, categoryBundle.getString(CATEGORY_ID));
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this)); //set layout
        mRecyclerView.setAdapter(mAdapter); //set adapter
    }

    //methode display score
    public void displayScore() {
        String scoreString = "Score " + mScore + "/" + mTotalQuestions;
        mScoreTextView.setText(scoreString);
        mRemaningQuestionsTextView.setText("Remaining: " + mTotalQuestions--);
    }

    //methode update score
    public void updateScore() {
        mScore++;
    }
}
