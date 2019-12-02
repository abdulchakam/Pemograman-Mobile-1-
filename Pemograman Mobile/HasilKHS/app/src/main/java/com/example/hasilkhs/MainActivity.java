package com.example.hasilkhs;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    TextView ipk,totalsks,jumlahnilai;

    int[] Arrnomer = {1, 2, 3, 4, 5, 6, 7, 8, 9};
    String[] Arrkode = {"A22.53113", "A22.53203", "A22.53205", "A22.53207", "A22.53209",
            "A22.53313", "A22.53401", "A22.53509", "N201701"};
    String[] Arrmatkul = {"Multimedia", "Basis Data", "Jarkom", "IMK", "Audio",
            "Pengantar Gis", "WEB 2", "RPL", "B.Inggris"};
    int[] Arrsks = {2, 4, 4, 2, 2, 2, 4, 2, 2};
    String[] Arrhuruf = {"A", "A", "A", "A", "A", "A", "A", "BC", "AB"};
    int[] Arrnilai = {86, 85, 100, 85, 88, 86, 88, 69, 81};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView=findViewById(R.id.listview);
        ipk = findViewById(R.id.IPK);
        totalsks = findViewById(R.id.jumlahsks);
        jumlahnilai = findViewById(R.id.jumlahnilai);

        CustomAdapter customAdapter = new CustomAdapter();
        listView.setAdapter(customAdapter);
        listView.setOnItemClickListener((adapterView, view, i, l) -> {
            Toast.makeText(getApplicationContext(),Arrmatkul[i],Toast.LENGTH_SHORT).show();;
            Intent intent = new Intent(getApplicationContext(),Detail.class);
            intent.putExtra("nama_matkul",Arrmatkul[i]);
            intent.putExtra("nilai_angka",Arrnilai[i]);
            intent.putExtra("nilai_huruf", Arrhuruf[i]);
            intent.putExtra("sks",Arrsks[i]);
            startActivity(intent);
        });


        int jmlSks = 0, jmlNilai=0;
        double bobot,
                bobotsks=0,
                bobottotal=0,
                AkhirIpk= 0;
        for(int i=0; i<Arrnomer.length; i++){
//            //Hitung Jumlah SKS
            int sks = Integer.parseInt(String.valueOf(Arrsks[i]));
            jmlSks += sks;

            int sumnilai = Integer.parseInt(String.valueOf(Arrnilai[i]));
            jmlNilai += sumnilai;
//
//            //Bobot Nilai
            int nilai = Integer.parseInt(String.valueOf(Arrnilai[i]));
            if(nilai>=85){
                bobot = 4.0;
            } else if(nilai>=80){
                bobot = 3.5;
            } else if(nilai>=70){
                bobot = 3.0;
            } else if(nilai>=65){
                bobot = 2.5;
            } else if(nilai>=60){
                bobot = 2.0;
            } else if(nilai>=50){
                bobot = 1.5;
            }else{
                bobot = 1.0;
            }
            bobotsks = bobot * Double.parseDouble(String.valueOf(Arrsks[i]));
            bobottotal = bobottotal + bobotsks;
        }
        AkhirIpk = bobottotal/jmlSks;
        DecimalFormat decimalFormat = new DecimalFormat("#.#");

        ipk.setText(String.valueOf("IPK = "+decimalFormat.format(AkhirIpk)));
        totalsks.setText(String.valueOf("Jumlah SKS = "+jmlSks));
        jumlahnilai.setText(String.valueOf("Jumlah Nilai = "+jmlNilai));



    }

    private class CustomAdapter extends BaseAdapter {
        @Override
        public int getCount() {
            return Arrkode.length;
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {

            View view1=getLayoutInflater().inflate(R.layout.activity_list_data,null);


            TextView no = view1.findViewById(R.id.listno);
            TextView kdMatkul = view1.findViewById(R.id.listkode);
            TextView nmMatkul = view1.findViewById(R.id.listnama);
            TextView sks= view1.findViewById(R.id.listsks);
            TextView nilai_huruf= view1.findViewById(R.id.listhuruf);
            TextView nilai_angka= view1.findViewById(R.id.listangka);


            no.setText(String.valueOf(Arrnomer[i]));
            kdMatkul.setText(Arrkode[i]);
            nmMatkul.setText(Arrmatkul[i]);
            sks.setText(String.valueOf(Arrsks[i]));
            nilai_huruf.setText(Arrhuruf[i]);
            nilai_angka.setText(String.valueOf(Arrnilai[i]));


            return view1;

        }
    }
}
