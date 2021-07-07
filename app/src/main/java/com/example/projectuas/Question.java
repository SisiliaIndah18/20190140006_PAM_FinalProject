package com.example.projectuas;

public class Question {

    private String mQuestion; //deklarasi variabel dengan jenis data string
    private String mOption1; //deklarasi variabel dengan jenis data string
    private String mOption2; //deklarasi variabel dengan jenis data string
    private String mOption3; //deklarasi variabel dengan jenis data string
    private String mOption4; //deklarasi variabel dengan jenis data string
    private String mAnswer; //deklarasi variabel dengan jenis data string
    private String mCategory; //deklarasi variabel dengan jenis data string

    //method question sebagai objek di QuizDBHelper
    Question() {
    }

    //membuat konstruktor Question
    Question(String mQuestion, String option1, String option2, String option3, String option4, String answer, String category) {
        this.mQuestion = mQuestion; //memberikan nilai mQuestion dengan mQuestion
        this.mOption1 = option1; //memberikan nilai mOption1 dengan option1
        this.mOption2 = option2; //memberikan nilai mOption2 dengan option2
        this.mOption3 = option3; //memberikan nilai mOption3 dengan option3
        this.mOption4 = option4; //memberikan nilai mOption4 dengan option4
        this.mAnswer = answer; //memberikan nilai mAnswer dengan answer
        this.mCategory = category; //memberikan nilai mCategory dengan category
    }

    //method set getmQuestion
    public String getmQuestion() {
        return mQuestion;
    }

    //method set getmOption1
    public String getmOption1() {
        return mOption1;
    }

    //method set getmOption2
    public String getmOption2() {
        return mOption2;
    }

    //method set getmOption3
    public String getmOption3() {
        return mOption3;
    }

    //method set getmOption4
    public String getmOption4() {
        return mOption4;
    }

    //method set getmAnswer
    public String getmAnswer() {
        return mAnswer;
    }

    //method set getmCategory
    public String getmCategory() {
        return mCategory;
    }

    //method set setmQuestion
    public void setmQuestion(String mQuestion) {
        this.mQuestion = mQuestion;
    }

    //method set setmOption1
    public void setmOption1(String mOption1) {
        this.mOption1 = mOption1;
    }

    //method set setmOption2
    public void setmOption2(String mOption2) {
        this.mOption2 = mOption2;
    }

    //method set setmOption3
    public void setmOption3(String mOption3) {
        this.mOption3 = mOption3;
    }

    //method set setmOption4
    public void setmOption4(String mOption4) {
        this.mOption4 = mOption4;
    }

    //method set setmAnswer
    public void setmAnswer(String mAnswer) {
        this.mAnswer = mAnswer;
    }

    //method set setmCategory
    public void setmCategory(String mCategory) {
        this.mCategory = mCategory;
    }
}
