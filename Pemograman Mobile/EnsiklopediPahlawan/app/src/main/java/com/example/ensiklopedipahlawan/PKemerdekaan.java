package com.example.ensiklopedipahlawan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class PKemerdekaan extends AppCompatActivity {


    ListView listView;

    String[] pahlawanNames = {"Ir. Soekarno", "Jendral Sudirman", "Hasyim Asyari", "Pangeran Diponegoro",
            "Ki Hadjar Dewantara", "Bung Tomo", "Imam Bonjol", "R.A. Kartini", "Kapitan Pattimura",
            "Cut Nyak Dien", "Raden Dewi Sartika", "Sultan Hasanuddin", "Tan Malaka",
            "Martha Christina Tiahahu", "Mohammad Hatta"};
    int[] pahlawanImage = {R.drawable.sukarno, R.drawable.sudirman, R.drawable.hasyim, R.drawable.diponogoro, R.drawable.dewantoro,
            R.drawable.bungtomo, R.drawable.imanbonjol, R.drawable.kartini, R.drawable.pattimura, R.drawable.cutnyakdien,
            R.drawable.dewi, R.drawable.hasanudin, R.drawable.tanmalaka, R.drawable.martha, R.drawable.hatta};


   String[] pahlawanDeskripsi= {"Dr. Ir. H. Soekarno adalah Presiden pertama Republik Indonesia yang menjabat pada periode 1945–1967. Ia memainkan peranan penting dalam memerdekakan bangsa Indonesia dari penjajahan Belanda. Ia adalah Proklamator Kemerdekaan Indonesia yang terjadi pada tanggal 17 Agustus 1945."};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pkemerdekaan);

        //finding listview
        listView = findViewById(R.id.listview);

        CustomAdapter customAdapter = new CustomAdapter();
        listView.setAdapter(customAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        Toast.makeText(getApplicationContext(),pahlawanNames[i],Toast.LENGTH_LONG).show();
                Intent intent = new Intent(getApplicationContext(),listdata.class);
                intent.putExtra("name",pahlawanNames[i]);
                //intent.putExtra("image",pahlawanImage[i]);
                //intent.putExtra("deskripsi",pahlawanDeskripsi[i]);
                startActivity(intent);

            }
        });


    }


    private class CustomAdapter extends BaseAdapter{
        @Override
        public int getCount() {
            return pahlawanImage.length;
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
            View view1 = getLayoutInflater().inflate(R.layout.activity_row_data,null);
            //getting view in row_data
            TextView name = view1.findViewById(R.id.pahlawan);
            ImageView image = view1.findViewById(R.id.images);

            name.setText(pahlawanNames[i]);
            image.setImageResource(pahlawanImage[i]);
            return view1;
        }

    }
}