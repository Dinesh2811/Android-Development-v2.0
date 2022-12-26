package com.dinesh.android.java.activity;


import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.dinesh.android.R;

public class LayoutInflater_Class extends AppCompatActivity {
    private final String TAG = "log_" + getClass().getName().split(getClass().getName().split("\\.")[2] + ".")[1];

    ConstraintLayout parentConstraintLayout;
    TextView textView;
    TextView textViewChild;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        parentConstraintLayout = findViewById(R.id.constraintLayout);
        textView = findViewById(R.id.ActivityMain_TextView);
        View childView = android.view.LayoutInflater.from(getApplicationContext()).inflate(R.layout.progress_bar, parentConstraintLayout, false);

        parentConstraintLayout.addView(childView);
        textViewChild = childView.findViewById(R.id.textView);

        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.e(TAG, "onClick: ActivityMain_TextView");
            }
        });

        textViewChild.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i(TAG, "onClick: textViewChild");
            }
        });
    }
}
