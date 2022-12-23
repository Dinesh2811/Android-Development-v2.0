package com.dinesh.android.java.app.toolbar;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;

import com.dinesh.android.R;

public class ToolbarMain extends AppCompatActivity {
    private final String TAG = "log_" + ToolbarMain.class.getName().split(ToolbarMain.class.getName().split("\\.")[2] + ".")[1];
    public Toolbar toolbar;
    public TextView tvToolbar;
    long pressedTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.toolbar_layout);
        setToolbar();

        toolbar.setNavigationOnClickListener(v -> {
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
        });

    }

    public void setToolbar() {
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

//        // Enable the back button on the toolbar
//        getSupportActionBar().setDisplayShowHomeEnabled(true);
//        getSupportActionBar().setHomeButtonEnabled(true);
//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
//        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_baseline_menu_24);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        tvToolbar = findViewById(R.id.tvToolbar);

//        toolbar.setNavigationIcon(R.drawable.ic_baseline_arrow_back_24);
        Drawable navigationIcon = ContextCompat.getDrawable(this, R.drawable.ic_baseline_arrow_back_24);
        navigationIcon.setTint(Color.WHITE);
        toolbar.setNavigationIcon(navigationIcon);

//        toolbar.setCollapseIcon(R.drawable.ic_baseline_arrow_back_24);
        Drawable backCollapseIcon = ContextCompat.getDrawable(this, R.drawable.ic_baseline_arrow_back_24);
        backCollapseIcon.setTint(Color.WHITE);
        toolbar.setCollapseIcon(backCollapseIcon);

        Drawable optionDrawableIcon = menu.findItem(R.id.menuMain).getIcon();
        optionDrawableIcon = DrawableCompat.wrap(optionDrawableIcon);
        DrawableCompat.setTint(optionDrawableIcon, ContextCompat.getColor(this,R.color.white));
        menu.findItem(R.id.menuMain).setIcon(optionDrawableIcon);

        Drawable searchDrawableIcon = menu.findItem(R.id.action_search).getIcon();
        searchDrawableIcon = DrawableCompat.wrap(searchDrawableIcon);
        DrawableCompat.setTint(searchDrawableIcon, ContextCompat.getColor(this,R.color.white));
        menu.findItem(R.id.action_search).setIcon(searchDrawableIcon);

        MenuItem searchItem = menu.findItem(R.id.action_search);
        SearchView searchView = (SearchView) searchItem.getActionView();
        searchView.setBackgroundColor(ContextCompat.getColor(this,R.color.white));
        searchView.setQueryHint("Search Here");
        searchView.setMaxWidth(Integer.MAX_VALUE);
        searchView.setIconified(false);

        ImageView searchClose = (ImageView) searchView.findViewById(androidx.appcompat.R.id.search_close_btn);

        Drawable collapseIcon = ContextCompat.getDrawable(this, R.drawable.ic_baseline_close_24);
        collapseIcon.setTint(Color.BLUE);
        searchClose.setBackground(collapseIcon);

        searchClose.setImageResource(R.drawable.ic_baseline_close_24);
        searchClose.setBackgroundColor(ContextCompat.getColor(this,R.color.teal_200));

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case android.R.id.home:
                Toast.makeText(this, "Back Menu", Toast.LENGTH_LONG).show();
                return true;
            case R.id.menuAdmin:
                Toast.makeText(this, "Item 1 Selected", Toast.LENGTH_LONG).show();
                return true;
            case R.id.menuUser:
                Toast.makeText(this, "Item 2 Selected", Toast.LENGTH_LONG).show();
                return true;
            case R.id.logout:
                Toast.makeText(this, "Log Out", Toast.LENGTH_SHORT).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}

/*
 <item name="windowActionBar">false</item>
 <item name="windowNoTitle">true</item>
 */