package com.dinesh.android.java.app.nav_drawer;


import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.dinesh.android.R;
import com.dinesh.android.java.app.toolbar.ToolbarMain;
import com.google.android.material.navigation.NavigationView;

public class NavigationDrawer extends ToolbarMain implements NavigationView.OnNavigationItemSelectedListener {
    private final String TAG = "log_" + this.getClass().toString().split(this.getClass().getPackage().getName().split("\\.")[2] + ".")
            [this.getClass().toString().split(this.getClass().getPackage().getName().split("\\.")[2] + ".").length - 1];

    public DrawerLayout drawerLayout;
    public ActionBarDrawerToggle actionBarDrawerToggle;
    public NavigationView navigationView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.nav_drawer);
        setNavDrawer();

    }

    public void setNavDrawer() {
        setToolbar();
        drawerLayout = findViewById(R.id.drawerLayout);
        toolbar = findViewById(R.id.toolbar);
        navigationView = findViewById(R.id.navigationView);

        actionBarDrawerToggle = new ActionBarDrawerToggle(this,drawerLayout,toolbar,
                R.string.navigation_drawer_open,
                R.string.navigation_drawer_close);

        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();

        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_baseline_menu_24);

        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {

        Drawable optionDrawableIcon = menu.findItem(R.id.menuMain).getIcon();
        optionDrawableIcon = DrawableCompat.wrap(optionDrawableIcon);
        DrawableCompat.setTint(optionDrawableIcon, ContextCompat.getColor(this,R.color.white));
        menu.findItem(R.id.menuMain).setIcon(optionDrawableIcon);

//        toolbar.setNavigationIcon(R.drawable.ic_baseline_menu_24);
        Drawable navigationIcon = ContextCompat.getDrawable(this, R.drawable.ic_baseline_menu_24);
        navigationIcon.setTint(Color.WHITE);
        toolbar.setNavigationIcon(navigationIcon);

        tvToolbar = (TextView) findViewById(R.id.tvToolbar);
        tvToolbar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(NavigationDrawer.this, "Testing...NavigationDrawer", Toast.LENGTH_SHORT).show();
            }
        });

        return true;
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()){
            case android.R.id.home:
                Toast.makeText(this, "Back onNavigationItemSelected", Toast.LENGTH_LONG).show();
                return true;
            case R.id.menuHome:
                Log.i(TAG, "onNavigationItemSelected: "+item.getTitle());
                break;
            case R.id.menuJava:
                Log.i(TAG, "onNavigationItemSelected: "+item.getTitle());
                break;
            case R.id.menuKotlin:
                Log.i(TAG, "onNavigationItemSelected: "+item.getTitle());
                break;
            case R.id.menuShortcut:
                Log.i(TAG, "onNavigationItemSelected: "+item.getTitle());
                break;
            case R.id.menuLogout:
                Log.i(TAG, "onNavigationItemSelected: "+item.getTitle());
                break;
        }
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }
}



