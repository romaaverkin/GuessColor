package com.bignerdranch.android.guesscolor;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class ChildrenActivity extends AppCompatActivity {
    private static final String TAG = "ChildrenActivity";
    private static final String KEY_INDEX = "index";
    private Button mNewGameButton;
    private Button mMFirstAnswerButton;
    private Button mMSecondAnswerButton;
    private Button mThreeAnswerButton;
    private Button mFourthAnswerButton;
    private Button mPreviousButton;
    private Button mNextButton;
    private TextView mColorTextView;

    private static Question[] mQuestionBank = new Question[]{
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

    private static List<Question> mQuestionBankShuffle = Arrays.asList(mQuestionBank);

    static {
        //Перемешиваем массив
        Collections.shuffle(mQuestionBankShuffle);
        mQuestionBank = mQuestionBankShuffle.toArray(mQuestionBank);
    }

    private int mCurrentIndex = 0;

    private void updateQuestion() {
        int question = mQuestionBank[mCurrentIndex].getColorResId();
        mColorTextView.setBackgroundColor(getResources().getColor(question));
    }

    private void shuffleButtons() {
        HashSet<Integer> answerHashSet = new HashSet<>();
        int answerWhatColor = mQuestionBank[mCurrentIndex].getTextResId();
        answerHashSet.add(answerWhatColor);
        while (answerHashSet.size() <= 3) {
            int rand = (int) Math.floor(Math.random() * mQuestionBank.length);
            int answerWhatColorRandom = mQuestionBank[rand].getTextResId();
            answerHashSet.add(answerWhatColorRandom);
        }
        Integer[] myArrayColorsForButton = {};
        myArrayColorsForButton = answerHashSet.toArray(new Integer[answerHashSet.size()]);

        //Перемешиваем кнопки
        List<Integer> mArrayShuffle = Arrays.asList(myArrayColorsForButton);
        Collections.shuffle(mArrayShuffle);
        myArrayColorsForButton = mArrayShuffle.toArray(myArrayColorsForButton);

        mMFirstAnswerButton = (Button) findViewById(R.id.first_answer_button);
        mMFirstAnswerButton.setText(myArrayColorsForButton[0]);
        mMSecondAnswerButton = (Button) findViewById(R.id.second_answer_button);
        mMSecondAnswerButton.setText(myArrayColorsForButton[1]);
        mThreeAnswerButton = (Button) findViewById(R.id.three_answer_button);
        mThreeAnswerButton.setText(myArrayColorsForButton[2]);
        mFourthAnswerButton = (Button) findViewById(R.id.fourth_answer_button);
        mFourthAnswerButton.setText(myArrayColorsForButton[3]);
    }

    private void checkAnswer(String userSelectColor) {
        int answerWhatColor = mQuestionBank[mCurrentIndex].getTextResId();
        int messageResId = 0;
        if (userSelectColor == getResources().getText(answerWhatColor)) {
            messageResId = R.string.correct_toast;
        } else {
            messageResId = R.string.incorrect_toast;
        }
        Toast.makeText(this, messageResId, Toast.LENGTH_SHORT)
                .show();
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.d(TAG, "onStart() called");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.d(TAG, "onPause() called");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.d(TAG, "onResume() called");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.d(TAG, "onStop() called");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy() called");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_children);
//        //Перемешиваем массив
//        Collections.shuffle(mQuestionBankShuffle);
//        mQuestionBank = mQuestionBankShuffle.toArray(mQuestionBank);

        mColorTextView = (TextView) findViewById(R.id.color_text_view);
        mMFirstAnswerButton = (Button) findViewById(R.id.first_answer_button);
        mMFirstAnswerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkAnswer(((Button) view).getText().toString());
            }
        });

        mNewGameButton = (Button) findViewById(R.id.new_game_button);
        mNewGameButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Collections.shuffle(mQuestionBankShuffle);
                mQuestionBank = mQuestionBankShuffle.toArray(mQuestionBank);
                onDestroy();
                onCreate(null);
            }
        });

        mMSecondAnswerButton = (Button) findViewById(R.id.second_answer_button);
        mMSecondAnswerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkAnswer(((Button) view).getText().toString());
            }
        });

        mThreeAnswerButton = (Button) findViewById(R.id.three_answer_button);
        mThreeAnswerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkAnswer(((Button) view).getText().toString());
            }
        });

        mFourthAnswerButton = (Button) findViewById(R.id.fourth_answer_button);
        mFourthAnswerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkAnswer(((Button) view).getText().toString());
            }
        });

        mNextButton = (Button) findViewById(R.id.next_button);
        mNextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mCurrentIndex = (mCurrentIndex + 1) % mQuestionBank.length;
                updateQuestion();
                shuffleButtons();
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
                updateQuestion();
                shuffleButtons();
            }
        });
        if (savedInstanceState != null) {
            mCurrentIndex = savedInstanceState.getInt(KEY_INDEX, 0);
        }

        updateQuestion();
        shuffleButtons();
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        Log.i(TAG, "onSaveInstanceState");
        savedInstanceState.putInt(KEY_INDEX, mCurrentIndex);
    }
}
