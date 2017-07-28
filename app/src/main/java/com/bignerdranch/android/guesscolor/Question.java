package com.bignerdranch.android.guesscolor;

/**
 * Created by admin on 26.07.2017.
 */

public class Question {
    private int mTextResId;
    private int mColorResId;

    public Question(int textResId, int colorResId) {
        mTextResId = textResId;
        mColorResId = colorResId;
    }

    public int getTextResId() {
        return mTextResId;
    }

    public void setTextResId(int textResId) {
        mTextResId = textResId;
    }

    public int getColorResId() {
        return mColorResId;
    }

    public void setColorResId(int colorResId) {
        mColorResId = colorResId;
    }
}
