package com.dinesh.android.java.dialog.rv.recycler_view.basic;

import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.dinesh.android.R;

public class NewLayout extends AppCompatActivity {
    TextView textView5, textView6, textView7, textView8;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.rv1_new_layout);
        textView5 = findViewById(R.id.test_textView5);
        textView6 = findViewById(R.id.test_textView6);
        textView7 = findViewById(R.id.test_textView7);
        textView8 = findViewById(R.id.test_textView8);


        String ID = getIntent().getStringExtra("ID");
        String movieName = getIntent().getStringExtra("NAME");
        String Email = getIntent().getStringExtra("Email");
        String Mobile = getIntent().getStringExtra("Mobile");
        textView5.setText(ID);
        textView6.setText(movieName);
        textView7.setText(Email);
        textView8.setText(Mobile);
    }
}
