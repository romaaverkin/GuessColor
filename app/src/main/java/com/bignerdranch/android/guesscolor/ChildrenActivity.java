package com.bignerdranch.android.guesscolor;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class ChildrenActivity extends AppCompatActivity {
    private Button mFirst_answer_button;
    private Button mSecond_answer_button;
    private Button mThree_answer_button;
    private Button mFourth_answer_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_children);

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
