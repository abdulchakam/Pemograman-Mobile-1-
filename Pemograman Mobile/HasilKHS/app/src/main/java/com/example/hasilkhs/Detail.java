package com.example.hasilkhs;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.TestLooperManager;
import android.view.MenuItem;
import android.widget.TextView;

public class Detail extends AppCompatActivity {

    TextView Nama_Natkul,Nilai_Angka,Nilai_Huruf, SKS;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Nama_Natkul = findViewById(R.id.nama_matkul);
        Nilai_Angka = findViewById(R.id.nilai_angka);
        Nilai_Huruf = findViewById(R.id.nilai_huruf);
        SKS = findViewById(R.id.detail_sks);


        Intent intent = getIntent();
        String receivedName = intent.getStringExtra("nama_matkul");
        int receivedNilaiAngka = intent.getIntExtra("nilai_angka",0);
        String receivedNilaiHuruf = intent.getStringExtra("nilai_huruf");
        int receivedSKS = intent.getIntExtra("sks",0);

        Nama_Natkul.setText(receivedName);
        Nilai_Angka.setText(String.valueOf(receivedNilaiAngka));
        Nilai_Huruf.setText(receivedNilaiHuruf);
        SKS.setText(String.valueOf(receivedSKS));
//
//
//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

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
