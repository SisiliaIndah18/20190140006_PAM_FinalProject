package com.example.projectuas.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.projectuas.Question;
import com.example.projectuas.QuestionActivity;
import com.example.projectuas.R;
import com.example.projectuas.ToggleButtonGroupTableLayout;

import java.util.ArrayList;

public class QuestionAdapter extends RecyclerView.Adapter {

    private Context mContext; //deklarasi variabel dengan jenis data context
    private ArrayList<Question> mQuestionList; //deklarasi variabel dengan jenis data arraylist
    private String mCategoryLabel; //deklarasi variabel dengan jenis data string

    //membuat konstruktor QuestionAdapter
    public QuestionAdapter(Context context, ArrayList<Question> questionList, String category) {
        this.mContext = context; //memberikan nilai mContext dengan context
        this.mQuestionList = questionList; //memberikan nilai mQuestionList dengan questionList
        this.mCategoryLabel = category; //memberikan nilai mCategoryLabel dengan category
    }

    //membuat konstruktor RecyclerView
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        mCategoryLabel = mCategoryLabel.length() > 2 ? (mCategoryLabel.substring(0, 1).toUpperCase() + mCategoryLabel.substring(1)) : mCategoryLabel.toUpperCase(); //set category label
        ((QuestionActivity) mContext).setTitle(mCategoryLabel); //set title question
        View questionView = LayoutInflater.from(mContext).inflate(R.layout.question_card_layout, parent, false); //menampilkan layout question_card_layout untuk card question
        return new QuestionViewHolder(questionView);//mengambalikan nilai ke questionView
    }

    //membuat konstruktor onBindViewHolder
    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        final Question question = mQuestionList.get(position); //deklarasi variabel mQuestionList yang berisi item diklik
        final QuestionViewHolder questionViewHolder = (QuestionViewHolder) holder;
        questionViewHolder.mQuestion.setText(question.getmQuestion()); //set question
        questionViewHolder.mRb1.setText(question.getmOption1()); //set mRb1 ke question
        questionViewHolder.mRb2.setText(question.getmOption2()); //set mRb2 ke question
        questionViewHolder.mRb3.setText(question.getmOption3()); //set mRb3 ke question
        questionViewHolder.mRb4.setText(question.getmOption4()); //set mRb4 ke question

        ArrayList<RadioButton> radioButtons = questionViewHolder.mTableLayout.getChildren(); //memberikan nilai pada radio button
        for (final RadioButton rb : radioButtons) {
            rb.setOnClickListener(new View.OnClickListener() { //membuat event pad aradio button
                @Override
                public void onClick(View v) { //membuat konstruktor onClick
                    questionViewHolder.mTableLayout.checkAnswer(rb, question.getmAnswer(), mContext); //menampilkan question dan jawaban
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return mQuestionList.size(); //untuk mengembalikan ke variabel mQuestionList
    }

    //membuat class QuestionViewHolder
    class QuestionViewHolder extends RecyclerView.ViewHolder {

        TextView mQuestion; //deklarasi variabel mQuestion
        RadioButton mRb1; //deklarasi variabel mRb1
        RadioButton mRb2; //deklarasi variabel mRb2
        RadioButton mRb3; //deklarasi variabel mRb3
        RadioButton mRb4; //deklarasi variabel mRb4
        ToggleButtonGroupTableLayout mTableLayout; // deklarasi variabel mTableLayout

        QuestionViewHolder(View itemView) { //untuk menampilkan
            super(itemView);
            mQuestion = itemView.findViewById(R.id.question); //set id question
            mRb1 = itemView.findViewById(R.id.rb1); //set id untuk radio button 1
            mRb2 = itemView.findViewById(R.id.rb2); //set id untuk radio button 2
            mRb3 = itemView.findViewById(R.id.rb3); //set id untuk radio button 3
            mRb4 = itemView.findViewById(R.id.rb4); //set id untuk radio button 4
            mTableLayout = itemView.findViewById(R.id.table_layout);  //set id untuk table layout
        }
    }
}