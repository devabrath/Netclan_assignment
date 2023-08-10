package com.example.netclan_assignment;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;
import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.google.android.material.navigation.NavigationView;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {

    LinearLayout Refine;

    TabLayout tabLayoutBottom;
    ViewPager viewPager;
    private DrawerLayout drawerLayout;
    private ImageView drawer;

    private boolean isDrawerOpen = false;
    NavigationView navigationView;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Refine = findViewById(R.id.RefineLayout);
        tabLayoutBottom = findViewById(R.id.tabLayoutBottom);
        viewPager = findViewById(R.id.viewPager);
        drawerLayout = findViewById(R.id.drawerLayout);
        navigationView = findViewById(R.id.navigationView);
        //toolbar = findViewById(R.id.toolbar);
        drawer = findViewById(R.id.menu_icon);

        drawer.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Log.d("Drawer", "Image Clicked");
                if (isDrawerOpen) {
                    // Close the Navigation Drawer
                    drawerLayout.closeDrawer(GravityCompat.START);
                } else {
                    // Open the Navigation Drawer
                    drawerLayout.openDrawer(GravityCompat.START);
                }
            }
        });

        // Set a listener to detect drawer open/close events
        drawerLayout.addDrawerListener(new DrawerLayout.DrawerListener() {
            @Override
            public void onDrawerSlide(View drawerView, float slideOffset) {
            }

            @Override
            public void onDrawerOpened(View drawerView) {
                isDrawerOpen = true;
            }

            @Override
            public void onDrawerClosed(View drawerView) {
                isDrawerOpen = false;
            }

            @Override
            public void onDrawerStateChanged(int newState) {
            }
        });

        //ActionBarDrawerToggle abd = new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.navigation_open,R.string.navigation_close);

        //drawerLayout.addDrawerListener(abd);
        //abd.syncState();

        Refine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), Refine.class);
                startActivity(i);
            }
        });

        viewPager.setAdapter(new SectionsPagerAdapter(getSupportFragmentManager()));
        tabLayoutBottom.setupWithViewPager(viewPager);

        tabLayoutBottom.getTabAt(0).setIcon(R.drawable.eye);
        tabLayoutBottom.getTabAt(1).setIcon(R.drawable.connection);
        tabLayoutBottom.getTabAt(2).setIcon(R.drawable.chat);
        tabLayoutBottom.getTabAt(3).setIcon(R.drawable.contact_book);
        tabLayoutBottom.getTabAt(4).setIcon(R.drawable.hashtag);
    }

    private static class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0:
                    return new Fragment1();
                case 1:
                    return new Fragment2();
                case 2:
                    return new Fragment3();
                case 3:
                    return new Fragment4();
                case 4:
                    return new Fragment5();
                default:
                    return null;
            }
        }

        @Override
        public int getCount() {
            return 5;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return "Explore";
                case 1:
                    return "Network";
                case 2:
                    return "Chat";
                case 3:
                    return "Contact";
                case 4:
                    return "Group";
                default:
                    return null;
            }
        }
    }
}

