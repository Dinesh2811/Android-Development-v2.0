package com.dinesh.android.java.app.nav_drawer;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;

import com.dinesh.android.R;
import com.dinesh.android.java.app.toolbar.ToolbarMain;
import com.google.android.material.navigation.NavigationView;

public class NavMain extends NavigationDrawer {
    private final String TAG = "log_" + NavMain.class.getName().split(NavMain.class.getName().split("\\.")[2] + ".")[1];

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setNavDrawer();

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()) {
            case R.id.menuHome:
                Log.i(TAG, "menuHome: " + TAG);
                return true;
            default:
                return super.onNavigationItemSelected(item);
        }
    }

}
