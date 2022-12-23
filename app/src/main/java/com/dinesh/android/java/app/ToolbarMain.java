package com.dinesh.android.java.app;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
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
    public Toolbar toolbar;
    public TextView tvToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.toolbar_layout);
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // Enable the back button on the Toolbar
//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
//        getSupportActionBar().setDisplayShowHomeEnabled(true);

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

//        toolbar.setNavigationIcon(R.drawable.ic_baseline_arrow_back_24);
//        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(ToolbarMain.this, "This is last activity", Toast.LENGTH_SHORT).show();
//            }
//        });

        tvToolbar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(ToolbarMain.this, "Hello World", Toast.LENGTH_SHORT).show();
            }
        });
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