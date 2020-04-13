package com.kt.std.quizeg1.activity;

import android.app.Activity;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.support.v7.widget.Toolbar;

import com.kt.std.quizeg1.R;

public class BaseActivity extends AppCompatActivity {
    private Context context;
    private Activity activity;

    private Toolbar toolbar;
    private LinearLayout loadingView, noDataView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);

        activity = BaseActivity.this;
        context = activity.getApplicationContext();

    }

    public void initToolBar(boolean isTitleEnabled){
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(isTitleEnabled);
    }

    public void setToolbarTitle(String title){
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle(title);
        }
    }

    public void enableUpButton() {
        if (getSupportActionBar() != null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);

        }
    }

    public void initLoader() {
        loadingView = findViewById(R.id.loadingView);
    }
}















