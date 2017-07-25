package com.bignerdranch.android.guesscolor;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class GuessActivity extends AppCompatActivity {
    private Button mChildrenButton;
    private Button mAdultButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guess);

        mChildrenButton = (Button) findViewById(R.id.children_button);
        mChildrenButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(GuessActivity.this, ChildrenActivity.class);
                startActivity(i);
            }
        });

        mAdultButton = (Button) findViewById(R.id.adult_button);
        mAdultButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(GuessActivity.this, AdultActivity.class);
                startActivity(i);
            }
        });
    }
}
