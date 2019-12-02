package com.example.ensiklopedipahlawan;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

public class listdata extends AppCompatActivity {


    TextView listdata,deskripsi;
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listdata);

        listdata = findViewById(R.id.listdata);
        imageView = findViewById(R.id.imageView);
        deskripsi = findViewById(R.id.deskripsi);
//
        Intent intent = getIntent();
        String receivedName = intent.getStringExtra("name");
        int receivedImage = intent.getIntExtra("image",0);
        String receivedDeskripsi = intent.getStringExtra("deskripsi");

        listdata.setText(receivedName);
        imageView.setImageResource(receivedImage);
        deskripsi.setText(receivedDeskripsi);

        // enable back button
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == android.R.id.home){
            onBackPressed();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}