package com.example.duniadinosaurus;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailDino extends AppCompatActivity {

    TextView namaDino, deskripsi;
    ImageView imageDino;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_dino);

        imageDino = findViewById(R.id.detail_image);
        namaDino = findViewById(R.id.nama_dino);
        deskripsi = findViewById(R.id.detail_deskripsi);

        Intent intent = getIntent();
        int image = intent.getIntExtra("dino_image",0);
        String nama = intent.getStringExtra("dino_name");
        String detail = intent.getStringExtra("dino_deskripsi");

        imageDino.setImageResource(image);
        namaDino.setText(nama);
        deskripsi.setText(detail);

    }
}
