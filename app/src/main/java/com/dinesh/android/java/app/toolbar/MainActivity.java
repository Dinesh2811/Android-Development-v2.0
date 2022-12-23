package com.dinesh.android.java.app.toolbar;

import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.dinesh.android.R;

public class MainActivity extends ToolbarMain {
    private final String TAG = "log_" + MainActivity.class.getName().split(MainActivity.class.getName().split("\\.")[2] + ".")[1];

    TextView textView;
    long pressedTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setToolbar();

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
//        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if (pressedTime + 2000 > System.currentTimeMillis()) {
////                    super.onBackPressed();
//                    finish();
//                    finishAndRemoveTask();
//                    finishAffinity();
//                    System.exit(0);
//                } else {
//                    Toast.makeText(getBaseContext(), "Press back again to exit", Toast.LENGTH_SHORT).show();
//                }
//                pressedTime = System.currentTimeMillis();
//            }
//        });

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
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case android.R.id.home:
                Toast.makeText(this, TAG, Toast.LENGTH_LONG).show();
                return true;
            case R.id.menuAdmin:
                Toast.makeText(this, "Admin Testing", Toast.LENGTH_LONG).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);

        }

    }
}
