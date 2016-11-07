package com.hp.johndeere.activity;

import android.content.Context;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.hp.johndeere.R;
import com.hp.johndeere.fragment.HomeFragment;
import com.hp.johndeere.util.ApplicationConstants;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    public static TextView tvTitle;
    private Context context = this;
    private Toolbar toolbar;
    private RelativeLayout rlMainActivity;
    public static boolean isScrolling = true;
    private DrawerLayout drawer;
    private ActionBarDrawerToggle toggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViews();
    }

    private void findViews() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        tvTitle = (TextView) findViewById(R.id.tvTitle);
        rlMainActivity = (RelativeLayout) findViewById(R.id.rlMainActivity);
        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.fl_main_content, new HomeFragment()).commit();

        toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.app_name, R.string.appbar_scrolling_view_behavior) {
            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
                ApplicationConstants.hideKeyboard(MainActivity.this, drawerView);
                drawer.setClipChildren(false);
            }

            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
                ApplicationConstants.hideKeyboard(MainActivity.this, drawerView);
                drawer.setClipChildren(true);
            }
        };
        drawer.setDrawerListener(toggle);
        toggle.syncState();
        hamburgerIcon();
    }


    /****************
     * Method to manage hun burger icon
     ***********************/
    void hamburgerIcon() {
        if (toolbar != null) {
            ApplicationConstants.hideKeyboard(MainActivity.this, rlMainActivity);
            getSupportFragmentManager().addOnBackStackChangedListener(new FragmentManager.OnBackStackChangedListener() {
                @Override
                public void onBackStackChanged() {
                    if (getSupportFragmentManager().getBackStackEntryCount() > 0) {
                        getSupportActionBar().setDisplayHomeAsUpEnabled(true); // show back button
                        //    getSupportActionBar().setHomeAsUpIndicator(getResources().getDrawable(R.drawable.icon_back_white));
                        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                onBackPressed();
                            }
                        });
                    } else {
                        //show hamburger
                        getSupportActionBar().setDisplayHomeAsUpEnabled(false);
                        toggle.syncState();
                        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                drawer.openDrawer(GravityCompat.START);
                                closeNavDrawer();
                            }
                        });
                    }
                }
            });
        }
    }

    /****************
     * Method to close navigation drawer
     ***********************/
    private void closeNavDrawer() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        }
    }
}
