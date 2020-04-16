package com.kt.std.quizeg1.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.kt.std.quizeg1.R;

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

        initToolBar(true);
        setToolbarTitle(getString(R.string.about_dev));
        enableUpButton();
    }
}
