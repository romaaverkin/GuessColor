package com.bignerdranch.android.guesscolor;

/**
 * Created by admin on 26.07.2017.
 */

public class Question {
    private int mTextResId;
    private String mAnswerToQuestion;

    public Question(int textResId, String answerToQuestion) {
        mTextResId = textResId;
        mAnswerToQuestion = answerToQuestion;
    }

    public int getTextResId() {
        return mTextResId;
    }

    public void setTextResId(int textResId) {
        mTextResId = textResId;
    }

    public String getAnswerToQuestion() {
        return mAnswerToQuestion;
    }

    public void setAnswerToQuestion(String answerToQuestion) {
        mAnswerToQuestion = answerToQuestion;
    }
}
