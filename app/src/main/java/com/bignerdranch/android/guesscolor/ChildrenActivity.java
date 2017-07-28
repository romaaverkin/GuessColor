package com.bignerdranch.android.guesscolor;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ChildrenActivity extends AppCompatActivity {
    private Button mMFirstAnswerButton;
    private Button mMSecondAnswerButton;
    private Button mThreeAnswerButton;
    private Button mFourthAnswerButton;
    private Button mPreviousButton;
    private Button mNextButton;
    private TextView mColorTextView;

    private Question[] mQuestionBank = new Question[]{
            new Question(R.string.question_colorRed, R.color.colorRed),
            new Question(R.string.question_colorGreen, R.color.colorGreen),
            new Question(R.string.question_colorBlue, R.color.colorBlue),
            new Question(R.string.question_colorYellow, R.color.colorYellow),
            new Question(R.string.question_colorWhite, R.color.colorWhite),
            new Question(R.string.question_colorBlack, R.color.colorBlack),
            new Question(R.string.question_colorBrown, R.color.colorBrown),
            new Question(R.string.question_colorOrange, R.color.colorOrange),
            new Question(R.string.question_colorPink, R.color.colorPink),
    };

    private List<Question> mQuestionBankShuffle = Arrays.asList(mQuestionBank);

    private int mCurrentIndex = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_children);
        //Перемешиваем массив
        Collections.shuffle(mQuestionBankShuffle);
        mQuestionBank = mQuestionBankShuffle.toArray(mQuestionBank);


        mColorTextView = (TextView) findViewById(R.id.color_text_view);
        int question = mQuestionBank[mCurrentIndex].getColorResId();
//        mColorTextView.setText(question);
        mColorTextView.setBackgroundColor(getResources().getColor(question));

        mMFirstAnswerButton = (Button) findViewById(R.id.first_answer_button);
        mMFirstAnswerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(ChildrenActivity.this,
                        R.string.correct_toast,
                        Toast.LENGTH_SHORT).show();
            }
        });

        mMSecondAnswerButton = (Button) findViewById(R.id.second_answer_button);
        mMSecondAnswerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(ChildrenActivity.this,
                        R.string.correct_toast,
                        Toast.LENGTH_SHORT).show();
            }
        });

        mThreeAnswerButton = (Button) findViewById(R.id.three_answer_button);
        mThreeAnswerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(ChildrenActivity.this,
                        R.string.correct_toast,
                        Toast.LENGTH_SHORT).show();
            }
        });

        mFourthAnswerButton = (Button) findViewById(R.id.fourth_answer_button);
        mFourthAnswerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(ChildrenActivity.this,
                        R.string.correct_toast,
                        Toast.LENGTH_SHORT).show();
            }
        });

        mNextButton = (Button) findViewById(R.id.next_button);
        mNextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mCurrentIndex = (mCurrentIndex + 1) % mQuestionBank.length;
                int question = mQuestionBank[mCurrentIndex].getColorResId();
                mColorTextView.setBackgroundColor(getResources().getColor(question));
            }
        });

        mPreviousButton = (Button) findViewById(R.id.previous_button);
        mPreviousButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mCurrentIndex == 0) {
                    mCurrentIndex = mQuestionBank.length - 1;
                } else {
                    mCurrentIndex--;
                }
                int question = mQuestionBank[mCurrentIndex].getColorResId();
                mColorTextView.setBackgroundColor(getResources().getColor(question));
            }
        });
    }
}
