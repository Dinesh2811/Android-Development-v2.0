package com.dinesh.android.java.app.tab_layout;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import com.dinesh.android.R;
import com.dinesh.android.java.app.nav_drawer.NavigationDrawer;
import com.dinesh.android.java.fragment.FirstFragment;
import com.dinesh.android.java.fragment.SecondFragment;
import com.dinesh.android.java.fragment.ThirdFragment;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class TabLayoutMain extends NavigationDrawer {

    TabLayout tabLayout;
    ViewPager2 viewPager;
    ViewPagerFragmentAdapter viewPagerFragmentAdapter;
    String[] tabTitle = {"Tab 1", "Tab 2", "Tab 3"};

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tab_layout);
        setNavDrawer();

        tabLayout = findViewById(R.id.tabLayout);
        viewPager = findViewById(R.id.viewPager);
        viewPagerFragmentAdapter = new ViewPagerFragmentAdapter(this);

        viewPager.setAdapter(viewPagerFragmentAdapter);

        new TabLayoutMediator(tabLayout, viewPager, new TabLayoutMediator.TabConfigurationStrategy() {
            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                tab.setText(tabTitle[position]);
            }
        }).attach();

    }


    public class ViewPagerFragmentAdapter extends FragmentStateAdapter {

        public ViewPagerFragmentAdapter(@NonNull FragmentActivity fragmentActivity) {
            super(fragmentActivity);
        }

        @NonNull
        @Override
        public Fragment createFragment(int position) {
            switch (position) {
                case 0:
                default:
                    return new FirstFragment();
                case 1:
                    return new SecondFragment();
                case 2:
                    return new ThirdFragment();
            }
        }

        @Override
        public int getItemCount() {
            return tabTitle.length;
        }
    }


}



