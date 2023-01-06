package com.dinesh.android.java.activity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.dinesh.android.R;
import com.dinesh.android.java.app.nav_drawer.NavigationDrawer;
import com.google.android.material.navigation.NavigationView;

public class GoTo_Class extends NavigationDrawer {
    private final String TAG = "log_" + this.getClass().toString().split(this.getClass().getPackage().getName().split("\\.")[2] + ".")
            [this.getClass().toString().split(this.getClass().getPackage().getName().split("\\.")[2] + ".").length - 1];

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i("TAG_", "onCreate: " );

        setNavDrawer();

        /*

        Class<?> activityClass;

        try {
            SharedPreferences prefs = getSharedPreferences("X", MODE_PRIVATE);
            activityClass = Class.forName(prefs.getString("lastActivity", NewTest.class.getName()));
        } catch(ClassNotFoundException ex) {
            activityClass = NewTest.class;
        }

         */


        SharedPreferences prefs = getSharedPreferences("X", MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putString("lastActivity", getClass().getName());
        editor.commit();

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()) {
            case R.id.menuJava:
                Log.i(TAG, "menuJava: " + TAG);
                return true;
            default:
                return super.onNavigationItemSelected(item);
        }
    }

}
