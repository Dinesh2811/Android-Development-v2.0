package com.dinesh.android.java.app;

import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.dinesh.android.R;

public class MainActivity extends ToolbarMain {
    private final String TAG = "log_" + MainActivity.class.getName().split(MainActivity.class.getName().split("\\.")[2] + ".")[1];

    TextView textView;
    long pressedTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setCollapseIcon(R.drawable.ic_baseline_arrow_back_24);

//        // Enable the back button on the toolbar
//        getSupportActionBar().setHomeButtonEnabled(true);
//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
//        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_baseline_menu_24);


        textView = findViewById(R.id.ActivityMain_TextView);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "ActivityMain_TextView", Toast.LENGTH_SHORT).show();
            }
        });


    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (pressedTime + 2000 > System.currentTimeMillis()) {
//                    super.onBackPressed();
                    finish();
                    finishAndRemoveTask();
                    finishAffinity();
                    System.exit(0);
                } else {
                    Toast.makeText(getBaseContext(), "Press back again to exit", Toast.LENGTH_SHORT).show();
                }
                pressedTime = System.currentTimeMillis();
            }
        });

        tvToolbar = (TextView) findViewById(R.id.tvToolbar);
        tvToolbar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Testing...", Toast.LENGTH_SHORT).show();
            }
        });

        return true;
    }


    @Override
    public boolean onMenuOpened(int featureId, Menu menu) {
//        menu.findItem(R.id.menuAdmin).setVisible(false);
        menu.findItem(R.id.menuAdmin).setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                Toast.makeText(MainActivity.this, "Admin Testing", Toast.LENGTH_SHORT).show();
                return true;
            }
        });

        return true;
    }
}
