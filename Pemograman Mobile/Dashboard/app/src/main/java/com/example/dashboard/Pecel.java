package com.example.dashboard;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.text.NumberFormat;
import java.util.Locale;

public class Pecel extends AppCompatActivity {

    Button button1, button2;
    TextView textView, total1;
    int count=0, harga;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pecel);

        button1=(Button) findViewById(R.id.btnPlus);
        button2=(Button) findViewById(R.id.btnMin);
        textView=(TextView) findViewById(R.id.count);
        total1 = (TextView) findViewById(R.id.total);
        harga=15000;
        Locale localeID = new Locale("in", "ID");
        final NumberFormat formatRupiah = NumberFormat.getCurrencyInstance(localeID);

        button1.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {

                count++;
                textView.setText(Integer.toString(count));
                total1.setText(formatRupiah.format( count*harga));
                if (count == 0){
                    button2.setEnabled(false);
                }else{
                    button2.setEnabled(true);
                }
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                count--;
                textView.setText(Integer.toString(count));
                total1.setText(formatRupiah.format(count*harga));
                if (count <= 0){
                    button2.setEnabled(false);
                }else{
                    button2.setEnabled(true);
                }
            }
        });

        Button btnmenu = (Button) findViewById(R.id.btnmenu);
        btnmenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Pecel.this,MainActivity.class);
                startActivity(i);
            }
        });

    }
}
