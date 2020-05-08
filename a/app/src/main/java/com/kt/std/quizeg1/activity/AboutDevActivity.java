package com.kt.std.quizeg1.activity;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.kt.std.quizeg1.R;
import com.kt.std.quizeg1.utilities.ActivityUtilities;

public class AboutDevActivity extends BaseActivity {

    private ImageView imageView;
    private TextView tvDevTitle, tvDevSubTitle, tvDevText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_dev);

        imageView = findViewById(R.id.imgDev);
        tvDevTitle = findViewById(R.id.tvDevTitle);
        tvDevSubTitle = findViewById(R.id.tvDevSubtitle);
        tvDevText = findViewById(R.id.tvDevText);


        initToolbar(true);
        setToolbarTitle(getString(R.string.about_dev));
        enableUpButton();
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void clickView(View view) {
        ActivityUtilities.getInstance().invokeCustomUrlActivity(AboutDevActivity.this, CustomUrlActivity.class,
                getResources().getString(R.string.site), getResources().getString(R.string.site_url), false);
    }
}



























