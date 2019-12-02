package com.example.duniadinosaurus;

import android.content.Context;
import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.os.Bundle;
import android.util.AttributeSet;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.content.ContextCompat;

public class profile extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

    }


    public class GradientTextView extends AppCompatTextView {

        public GradientTextView(Context context) {
            super(context);
        }

        public GradientTextView(Context context, AttributeSet attrs) {
            super(context, attrs);
        }

        public GradientTextView(Context context, AttributeSet attrs, int defStyleAttr) {
            super(context, attrs, defStyleAttr);
        }

        @Override
        protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
            super.onLayout(changed, left, top, right, bottom);

            //Setting the gradient if layout is changed
            if (changed) {
                getPaint().setShader(new LinearGradient(0, 0, getWidth(), getHeight(),
                        ContextCompat.getColor(getContext(), R.color.colorPrimary),
                        ContextCompat.getColor(getContext(), R.color.colorAccent),
                        Shader.TileMode.CLAMP));
            }
        }
    }
}
