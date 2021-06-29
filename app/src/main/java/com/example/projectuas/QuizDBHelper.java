package com.example.projectuas;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.util.Log;

import com.example.projectuas.QuizContract.QuestionsTable;

import java.util.ArrayList;
import java.util.List;

public class QuizDBHelper extends SQLiteOpenHelper {

    private static final String DB_NAME = "quizzes.db";
    private static final int DB_VERSION = 8;

    public static final String CATEGORY_MTK = "matematika";
    public static final String CATEGORY_IPA = "ipa";
    public static final String CATEGORY_IPS = "ips";
    public static final String CATEGORY_AGAMA = "agama";
    public static final String CATEGORY_OLAHRAGA = "olahraga";
    public static final String CATEGORY_PROGRAM = "pemrograman";

    private final String CREATE_TABLE_QUERY = "CREATE TABLE " + QuizContract.QuestionsTable.TABLE_NAME +
            "(" +
            QuestionsTable._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            QuestionsTable.COLUMN_QUESTION + " TEXT, " +
            QuestionsTable.COLUMN_OPTION1 + " TEXT, " +
            QuestionsTable.COLUMN_OPTION2 + " TEXT, " +
            QuestionsTable.COLUMN_OPTION3 + " TEXT, " +
            QuestionsTable.COLUMN_OPTION4 + " TEXT, " +
            QuestionsTable.COLUMN_ANSWER + " TEXT, " +
            QuestionsTable.COLUMN_CATEGORY + " TEXT" +
            ")";

    private final String DROP_TABLE_QUERY = "DROP TABLE IF EXISTS " + QuestionsTable.TABLE_NAME;

    private SQLiteDatabase db;
    private List<Question> mQuestionList;

    private Bundle categoryIntentBundle;

    public QuizDBHelper(Context context, Bundle bundle) {
        super(context, DB_NAME, null, DB_VERSION);
        this.categoryIntentBundle = bundle;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        this.db = db;
        db.execSQL(CREATE_TABLE_QUERY);

        setUpQuestions();
        insertQuestions();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(DROP_TABLE_QUERY);
        onCreate(db);
    }

    private void setUpQuestions() {
        mQuestionList = new ArrayList<>();

        //questions for category agama
        mQuestionList.add(new Question("Berikut ini adalah cara-cara bersyukur kepada Allah SWT, kecuali...", "Membaca hamdalah", "Mengerjakan salat lima waktu", "Berpuasa sepanjang waktu", "Belajar dan mengaji Al-Quran", "Berpuasa sepanjang waktu", CATEGORY_AGAMA));
        mQuestionList.add(new Question("Apa Tugas dan fungsi manusia di bumi ?", "Beribadah dan menuntut ilmu", "Beribadah dan bekerja keras", "Beribadah dan mencari pekerjaan", "Beribadah dan khalifah di bumi", "Beribadah dan khalifah di bumi", CATEGORY_AGAMA));
        mQuestionList.add(new Question("Batas antara alam dunia dengan alam akhirat disebut...", "Alam barzah", "Yaumul hisab", "Yaumul mahsyar", "Yaumul ba’as", "Alam barzah", CATEGORY_AGAMA));
        mQuestionList.add(new Question("Kiamat kecil di kenal dengan istilah...", "Kiamat Kubro", "Kiamat Sugro", "Kiamat Zalzalah", "Hari Akhir", "Kiamat Sugro", CATEGORY_AGAMA));
        mQuestionList.add(new Question("Apa hukum menuntut ilmu bagi manusia ?", "Wajib 'ain", "Wajib", "Sunnah", "Wajib kifayah", "Wajib 'ain", CATEGORY_AGAMA));

        //questions for category ips
        mQuestionList.add(new Question("Benua terluas di permukaan bumi adalah….", "Amerika", "Afrika", "Asia", "Australia", "Asia", CATEGORY_IPS));
        mQuestionList.add(new Question("Objek sosiologi yang menjelaskan tentang gejala-gejala kehidupan sosial dan proses hubungan antar manusia yang mempengaruhi kesatuan hidup manusia itu sendiri merupakan objek sosiologi...", "Material", "Formal", "Primer", "Sekunder", "Material", CATEGORY_IPS));
        mQuestionList.add(new Question("Sebagian besar penduduk yang berasal dari wilayah Asia Timur dan Asia Tenggara adalah ras….", "Negroid", "Kaukasoid", "Mongoloid", "Europoid", "Mongoloid", CATEGORY_IPS));
        mQuestionList.add(new Question("Negara Amerika Serikat banyak melakukan investasi seperti peminjaman dana pembangunan untuk Indonesia sebagai negara berkembang. Peminjaman dana pembangunan yang dilakukan Amerika di Indonesia adalah globalisasi dalam bentuk...", "Globalisasi perdagangan", "Globalisasi pembiayaan", "Globalisasi produksi", "Globalisasi pembangunan", "Globalisasi pembiayaan", CATEGORY_IPS));
        mQuestionList.add(new Question("Timbulnya suatu penemuan baru dalam masyarakat didorong kuat oleh faktor ….", "Rasa tidak puas terhadap hal yang sudah ada", "Keinginan untuk menyaingi bangsa lain yang sudah maju", "Adanya kesadaran masyarakat terhadap kurangnya unsur kebudayaan baru", "Adanya penghargaan penemuan baru", "Adanya kesadaran masyarakat terhadap kurangnya unsur kebudayaan baru", CATEGORY_IPS));

        //questions for category ipa
        mQuestionList.add(new Question("Berikut ini merupakan ciri-ciri yang dimiliki oleh kelompok Protista adalah…", "Prokariotik", "Eukariotik", "Makroskopis", "Multiseluler", "Eukariotik", CATEGORY_IPA));
        mQuestionList.add(new Question("Upaya meminimalisasi sampah hasil limbah rumah tangga agar tidak mencemari perairan dapat dilakukan dengan cara mendaur ulang sampah-sampah di sekitar kita. Seperti dibuat menjadi kompos, kerajinan tangan, dan benda berguna lainnya. Upaya tersebut disebut dengan istilah...", "Recycle", "Reuse", "Reduce", "Repair", "Recycle", CATEGORY_IPA));
        mQuestionList.add(new Question("Pencemaran lingkungan akibat membuang sampah sembarangan dapat menimbulkan berbagai macam penyakit. Bentuk usaha untuk menanggulangi masalah tersebut adalah dengan cara...", "Menimbun sampah plastik di dalam tanah", "Mengolah sampah organik untuk pupuk kompos", "Mengolah sampah anorganik untuk makanan ternak", "Membuang sampah ke selokan agar tidak menumpuk", "Mengolah sampah organik untuk pupuk kompos", CATEGORY_IPA));
        mQuestionList.add(new Question("Penyakit menular pada alat kelamin manusia yang disebabkan oleh bakteri Treponema pallidum disebut...", "HIV", "Gonorhoe", "Sifilis", "Keputihan", "Sifilis", CATEGORY_IPA));
        mQuestionList.add(new Question("Jenis ayam berikut ini yang merupakan hasil persilangan beberapa jenis ayam unggul dari berbagai negara adalah ayam….", "Ayam jago", "Ayam hutan", "Ayam broiler", "Ayam kampung", "Ayam broiler", CATEGORY_IPA));

        //questions for category pemrograman
        mQuestionList.add(new Question("Dalam menyusun suatu program,langkah pertama yang harus di lakkukan adalah...", "Membuat program", "Membuat Algoritma", "Proses", "Mempelajari program", "Membuat Algoritma", CATEGORY_PROGRAM));
        mQuestionList.add(new Question("Pemberian nama variabel yang benar adalah...", "%nama", "nama_mahasiswa", "NamaMahasiswa", "&nilai", "nama_mahasiswa", CATEGORY_PROGRAM));
        mQuestionList.add(new Question("Indeks array secara default dimulai dari...", "-1", "0", "1", "9", "0", CATEGORY_PROGRAM));
        mQuestionList.add(new Question("Operator logika yang menyatakan \"atau\" dalam lambang berikut ini adalah...", "&&", "||", "!", "<>", "||", CATEGORY_PROGRAM));
        mQuestionList.add(new Question("Tipe data untuk TRUE FALSE adalah...", "String", "Boolean", "Byte", "Char", "Boolean", CATEGORY_PROGRAM));

        //questions for category olahraga
        mQuestionList.add(new Question("Tindakan menghadang bola atau menghlang-halangi smasher yang sedang melakukan smash disebut....", "Blok", "Tip", "Toss", "Servis", "Blok", CATEGORY_OLAHRAGA));
        mQuestionList.add(new Question("Pukulan bola yang menukik ke arah lapangan lawan adalah....", "Blok", "Smash", "Servis", "Passing", "Smash", CATEGORY_OLAHRAGA));
        mQuestionList.add(new Question("Batas jarak awalan pada lompat jauh adalah....", "25-40 m", "30-45 m", "50-55 m", "55-60 m", "30-45 m", CATEGORY_OLAHRAGA));
        mQuestionList.add(new Question("Tembakan sambil melompat dalam bola basket di sebut juga dengan istilah...", "Jump Shoot", "Lay Up", "Rebound", "Pivot", "Jump Shoot", CATEGORY_OLAHRAGA));
        mQuestionList.add(new Question("Suatu sistem latihan yang diselingi oleh masa-masa istirahat, disebut....", "Fartlek", "Joging", "Cross country", "Interval training", "Interval training", CATEGORY_OLAHRAGA));

        //questions for category matematika
        mQuestionList.add(new Question("Sebuah taman berbentuk persegi. Di sekeliling taman itu ditanami pohon pinus dengan jarak antar pohon 4 m. Panjang sisi taman itu adalah 65 m. Banyak pohon pinus yang dibutuhkan adalah ...", "50", "55", "60", "65", "65", CATEGORY_MTK));
        mQuestionList.add(new Question("Harga satu kaus dan dua celana Rp150.000,00 sedangkan harga 3 kaus dan 3 celana Rp      000,00. Harga 2 kaus dan 5 celana adalah.…", "Rp60.000,00", "Rp90.000,00", "Rp270.000,00", "Rp360.000,00", "Rp360.000,00", CATEGORY_MTK));
        mQuestionList.add(new Question("Diketahui barisan aritmetika dengan U4= 20 dan U8= 44. Suku ke-40 baris itu adalah…", "106", "236", "246", "275", "236", CATEGORY_MTK));
        mQuestionList.add(new Question("Dari pasangan sisi-sisi segitiga dibawah ini, yang merupakah sisi-sisi segitiga siku-siku adalah...", "8 cm, 12 cm, 16 cm", "9 cm, 12 cm, 15 cm", "9 cm, 12 cm, 17 cm", "12 cm, 14 cm, 20 cm", "9 cm, 12 cm, 15 cm", CATEGORY_MTK));
        mQuestionList.add(new Question("Sebuah lapangan berbentuk lingkaran dengan diameter 56 m. Di sekeliling lapangan akan dipasang lampu dengan jarak 4 m. Berapa banyak lampu yang diperlukan?", "24 buah", "30 buah", "34 buah", "44 buah", "44 buah", CATEGORY_MTK));
    }

    private void insertQuestions() {
        for(Question q : mQuestionList) {
            ContentValues contentValues = new ContentValues();
            contentValues.put(QuestionsTable.COLUMN_QUESTION, q.getmQuestion());
            contentValues.put(QuestionsTable.COLUMN_OPTION1, q.getmOption1());
            contentValues.put(QuestionsTable.COLUMN_OPTION2, q.getmOption2());
            contentValues.put(QuestionsTable.COLUMN_OPTION3, q.getmOption3());
            contentValues.put(QuestionsTable.COLUMN_OPTION4, q.getmOption4());
            contentValues.put(QuestionsTable.COLUMN_ANSWER, q.getmAnswer());
            contentValues.put(QuestionsTable.COLUMN_CATEGORY, q.getmCategory());
            db.insert(QuestionsTable.TABLE_NAME, null, contentValues);
        }
    }

    public ArrayList<Question> getAllQuestions(String categoryID) {
        Log.d("TAG", "Getting all questions for : " + categoryID);
        ArrayList<Question> questionList = new ArrayList<>();
        db = getReadableDatabase();
        String SELECT_TABLE_QUERY = "SELECT * FROM " + QuestionsTable.TABLE_NAME + " WHERE " + QuestionsTable.COLUMN_CATEGORY + " = \"" + categoryID + "\"";
        Cursor cursor = db.rawQuery(SELECT_TABLE_QUERY, null);
        if(cursor.moveToFirst()) {
            do {
                Question question = new Question();
                question.setmQuestion(cursor.getString(cursor.getColumnIndex(QuestionsTable.COLUMN_QUESTION)));
                question.setmOption1(cursor.getString(cursor.getColumnIndex(QuestionsTable.COLUMN_OPTION1)));
                question.setmOption2(cursor.getString(cursor.getColumnIndex(QuestionsTable.COLUMN_OPTION2)));
                question.setmOption3(cursor.getString(cursor.getColumnIndex(QuestionsTable.COLUMN_OPTION3)));
                question.setmOption4(cursor.getString(cursor.getColumnIndex(QuestionsTable.COLUMN_OPTION4)));
                question.setmAnswer(cursor.getString(cursor.getColumnIndex(QuestionsTable.COLUMN_ANSWER)));
                questionList.add(question);
            } while (cursor.moveToNext());
        }
        cursor.close();
        return questionList;
    }
}