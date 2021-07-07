package com.example.projectuas;

import android.content.Context;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RadioButton;
import android.widget.TableLayout;
import android.widget.TableRow;
import java.util.ArrayList;

public class ToggleButtonGroupTableLayout extends TableLayout {

    private RadioButton mActiveRadioButton; //dekalrasi variabel untuk RadioButton

    //membuat konstruktor ToggleButtonGroupTableLayout
    public ToggleButtonGroupTableLayout(Context context) {
        super(context);
    }

    //membuat konstruktor ToggleButtonGroupTableLayout
    public ToggleButtonGroupTableLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    //membuat kosntruktor ArrayList untuk RadioButton
    public ArrayList<RadioButton> getChildren() {
        ArrayList<RadioButton> radioButtons = new ArrayList<>();
        int childCount = this.getChildCount();
        for (int i = 0; i < childCount; i++) {
            TableRow tableRow = (TableRow) this.getChildAt(i);
            int rowChildCount = tableRow.getChildCount();
            for (int j = 0; j < rowChildCount; j++) {
                View v = tableRow.getChildAt(j);
                if (v instanceof RadioButton) {
                    radioButtons.add((RadioButton) v);
                }
            }
        }
        return radioButtons; //kembali ke nilai radioButtons
    }

    //method untuk mengecek jawaban
    public void checkAnswer(final RadioButton rb, String answer, Context mContext) {
        if (mActiveRadioButton != null) { //jika tidak sama dengan null
            mActiveRadioButton.setChecked(false);
        }
        int id = -1;
        rb.setChecked(true); //jika benar
        if (rb.getText().equals(answer)) {
            setRadioButtonBackgroundColor(rb, R.color.transparent_green); //set bg radio button
            ((QuestionActivity) mContext).updateScore(); //menambahkan score
        } else { //jika salah
            setRadioButtonBackgroundColor(rb, R.color.transparent_red); //set bg radio button
            for (RadioButton radioButton : getChildren()) {
                if (radioButton.getText().equals(answer)) { //jika benar
                    setRadioButtonBackgroundColor(radioButton, R.color.transparent_green); //set bg radio button
                    id = radioButton.getId();
                }
            }
        }

        ((QuestionActivity) mContext).displayScore(); //menampilkan score
        mActiveRadioButton = rb; //deklarasi rb
        for (RadioButton radioButton : getChildren()) {
            radioButton.setClickable(false);
            if (radioButton.getId() != rb.getId() && radioButton.getId() != id) {
                setRadioButtonBackgroundColor(radioButton, R.color.transparent_grey); //set bg radio button
                radioButton.setTextColor(getResources().getColor(R.color.transparent_black)); //set text color radio button
            }
        }
    }

    //method setRadioButtonBackgroundColor
    private void setRadioButtonBackgroundColor(RadioButton button, int colorId) {
        button.getBackground().setColorFilter(Color.parseColor(getContext().getString(colorId)), PorterDuff.Mode.MULTIPLY); //set radio button background color
    }
}
