package com.hp.johndeere.activity;

import android.content.Context;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.hp.johndeere.R;
import com.hp.johndeere.fragment.HomeFragment;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    public static TextView tvTitle;
    private Context context = this;
    private Toolbar toolbar;
    private RelativeLayout rlMainActivity;

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
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.fl_main_content, new HomeFragment()).commit();
    }
}
