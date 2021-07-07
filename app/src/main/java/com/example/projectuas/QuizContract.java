package com.example.projectuas;

import android.provider.BaseColumns;

final class QuizContract {

    //membuat method QuizContract
    private QuizContract() {
    }

    public static class QuestionsTable implements BaseColumns {

        public static final String TABLE_NAME = "quiz_questions"; //deklarasi variabel dengan jenis data string
        public static final String COLUMN_QUESTION = "question"; //deklarasi variabel dengan jenis data string
        public static final String COLUMN_OPTION1 = "option1"; //deklarasi variabel dengan jenis data string
        public static final String COLUMN_OPTION2 = "option2"; //deklarasi variabel dengan jenis data string
        public static final String COLUMN_OPTION3 = "option3"; //deklarasi variabel dengan jenis data string
        public static final String COLUMN_OPTION4 = "option4"; //deklarasi variabel dengan jenis data string
        public static final String COLUMN_ANSWER = "answer"; //deklarasi variabel dengan jenis data string
        public static final String COLUMN_CATEGORY = "category"; //deklarasi variabel dengan jenis data string
    }
}