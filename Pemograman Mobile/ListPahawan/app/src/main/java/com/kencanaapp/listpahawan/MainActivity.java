package com.kencanaapp.listpahawan;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
  ListView listView;

  String[] pahlawanNames = {"Ir Soekarno"," Mohammad Hatta","Ki Hajar Dewantara"," Fatmawati","Pangeran Diponegoro"};
  int[] pahlawanImage = { R.drawable.soekarno, R.drawable.hatta, R.drawable.ki, R.drawable.fatma, R.drawable.dipo               };
  String[] pahlawanDeskripsi = {
          "Ia memainkan peranan penting dalam memerdekakan bangsa Indonesia dari penjajahan Belanda. Ia adalah Proklamator Kemerdekaan Indonesia (bersama dengan Mohammad Hatta) yang terjadi pada tanggal 17 Agustus 1945. Soekarno adalah yang pertama kali mencetuskan konsep mengenai Pancasila sebagai dasar negara Indonesia dan ia sendiri yang menamainya.",

          "lahir dengan nama Mohammad Athar di Fort de Kock, Hindia Belanda, 12 Agustus 1902 – meninggal di Jakarta, 14 Maret 1980 pada umur 77 tahun) adalah negarawan dan ekonom Indonesia yang menjabat sebagai Wakil Presiden Indonesia pertama. Ia bersama Soekarno memainkan peranan sentral dalam perjuangan kemerdekaan Indonesia dari penjajahan Belanda sekaligus memproklamirkannya pada 17 Agustus 1945. Ia pernah menjabat sebagai Perdana Menteri dalam Kabinet Hatta I, Hatta II, dan RIS. Pada 1956, ia mundur dari jabatan wakil presiden karena berselisih dengan Presiden Soekarno.",

          "Raden Mas Soewardi Soerjaningrat (EBI: Suwardi Suryaningrat, sejak 1922 menjadi Ki Hadjar Dewantara, EBI: Ki Hajar Dewantara, beberapa menuliskan bunyi bahasa Jawanya dengan Ki Hajar Dewantoro; lahir di Pakualaman, 2 Mei 1889 – meninggal di Yogyakarta, 26 April 1959 pada umur 69 tahun;[1] selanjutnya disingkat sebagai 'Soewardi' atau 'KHD') adalah aktivis pergerakan kemerdekaan Indonesia, kolumnis, politisi, dan pelopor pendidikan bagi kaum pribumi Indonesia dari zaman penjajahan Belanda. Ia adalah pendiri Perguruan Taman Siswa, suatu lembaga pendidikan yang memberikan kesempatan bagi para pribumi untuk bisa memperoleh hak pendidikan seperti halnya para priyayi maupun orang-orang Belanda.",

          "Fatmawati yang bernama asli Fatimah (lahir di Bengkulu, 5 Februari 1923 – meninggal di Kuala Lumpur, Malaysia, 14 Mei 1980 pada umur 57 tahun) adalah istri dari Presiden Indonesia pertama Soekarno. Ia menjadi Ibu Negara Indonesia pertama dari tahun 1945 hingga tahun 1967 dan merupakan istri ke-3 dari Presiden Pertama Indonesia, Soekarno. Ia juga dikenal akan jasanya dalam menjahit Bendera Pusaka Sang Saka Merah Putih yang turut dikibarkan pada upacara Proklamasi Kemerdekaan Indonesia di Jakarta pada tanggal 17 Agustus 1945.",

          "Bendara Pangeran Harya Dipanegara (lebih dikenal dengan nama Diponegoro, lahir di Ngayogyakarta Hadiningrat, 11 November 1785 – meninggal di Makassar, Hindia Belanda, 8 Januari 1855 pada umur 69 tahun) adalah salah seorang pahlawan nasional Republik Indonesia. Pangeran Diponegoro terkenal karena memimpin Perang Diponegoro/Perang Jawa (1825-1830) melawan pemerintah Hindia Belanda. Perang tersebut tercatat sebagai perang dengan korban paling besar dalam sejarah Indonesia.",
  };
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

      //finding listview
    listView = findViewById(R.id.listview);

    CustomAdapter customAdapter = new CustomAdapter();
    listView.setAdapter(customAdapter);
    listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
      @Override
      public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//        Toast.makeText(getApplicationContext(),pahlawanNames[i],Toast.LENGTH_LONG).show();
        Intent intent = new Intent(getApplicationContext(),Listdata.class);
        intent.putExtra("name",pahlawanNames[i]);
        intent.putExtra("image",pahlawanImage[i]);
        intent.putExtra("deskripsi",pahlawanDeskripsi[i]);
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
      View view1 = getLayoutInflater().inflate(R.layout.row_data,null);
      //getting view in row_data
      TextView name = view1.findViewById(R.id.pahlawan);
      ImageView image = view1.findViewById(R.id.images);

      name.setText(pahlawanNames[i]);
      image.setImageResource(pahlawanImage[i]);
      return view1;
    }



  }
}
