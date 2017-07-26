package com.bignerdranch.android.guesscolor;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class ChildrenActivity extends AppCompatActivity {
    private Button mFirst_answer_button;
    private Button mSecond_answer_button;
    private Button mThree_answer_button;
    private Button mFourth_answer_button;
    private TextView mColorTextView;

    private Question[] mQuestionBank = new Question[]{
            new Question(R.string.question_colorWhite, "Белый"),
            new Question(R.string.question_colorBlack, "Черный"),
            new Question(R.string.question_colorBlue, "Синий"),
            new Question(R.string.question_colorBrown, "Коричневый"),
            new Question(R.string.question_colorGreen, "Зеленый"),
            new Question(R.string.question_colorOrange, "Оранжевый"),
            new Question(R.string.question_colorRed, "Красный"),
            new Question(R.string.question_colorYellow, "Желтый"),
            new Question(R.string.question_colorRed, "Красный"),
    };

    private int mCurrentIndex = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_children);

        mColorTextView = (TextView) findViewById(R.id.color_text_view);
        int question = mQuestionBank[mCurrentIndex].getTextResId();
//        mColorTextView.setText(question);
        mColorTextView.setBackgroundColor(getResources().getColor(R.color.colorWhite));

        mFirst_answer_button = (Button) findViewById(R.id.first_answer_button);
        mFirst_answer_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(ChildrenActivity.this,
                        R.string.correct_toast,
                        Toast.LENGTH_SHORT).show();
            }
        });

        mSecond_answer_button = (Button) findViewById(R.id.second_answer_button);
        mSecond_answer_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(ChildrenActivity.this,
                        R.string.correct_toast,
                        Toast.LENGTH_SHORT).show();
            }
        });

        mThree_answer_button = (Button) findViewById(R.id.three_answer_button);
        mThree_answer_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(ChildrenActivity.this,
                        R.string.correct_toast,
                        Toast.LENGTH_SHORT).show();
            }
        });

        mFourth_answer_button = (Button) findViewById(R.id.fourth_answer_button);
        mFourth_answer_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(ChildrenActivity.this,
                        R.string.correct_toast,
                        Toast.LENGTH_SHORT).show();
            }
        });
    }
}
