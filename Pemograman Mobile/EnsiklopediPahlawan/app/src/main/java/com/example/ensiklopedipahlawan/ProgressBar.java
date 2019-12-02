package com.example.ensiklopedipahlawan;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.WindowManager;
import android.widget.TextView;

public class ProgressBar extends AppCompatActivity {

    android.widget.ProgressBar progressBar;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progress_bar2);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        progressBar = findViewById(R.id.progress_bar);
        textView = findViewById(R.id.text_view);

        progressBar.setMax(100);
        progressBar.setScaleY(3f);

        progressAnimation();

    }

    private void progressAnimation() {

        ProgressBarAnimation anim = new ProgressBarAnimation(this, progressBar,textView, 0f, 100f);
        anim.setDuration(8000);
        progressBar.setAnimation(anim);
    }

}
