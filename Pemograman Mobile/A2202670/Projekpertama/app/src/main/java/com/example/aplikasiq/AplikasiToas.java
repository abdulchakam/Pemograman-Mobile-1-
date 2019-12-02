package com.example.aplikasiq;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class AplikasiToas extends AppCompatActivity {
    Button button1,button2;
    TextView textView;

    int count=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aplikasi_toas);

        button1=(Button) findViewById(R.id.button);
        button2=(Button) findViewById(R.id.button2);

        textView=(TextView) findViewById(R.id.textView5);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"Halloo Saya Toast",Toast.LENGTH_LONG).show();
            }
        });


        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count++;
                textView.setText(Integer.toString(count));
            }
        });
    }
}
