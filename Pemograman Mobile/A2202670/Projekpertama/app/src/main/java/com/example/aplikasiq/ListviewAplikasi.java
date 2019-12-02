package com.example.aplikasiq;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.lang.reflect.Array;

import javax.swing.text.html.ListView;

public class ListviewAplikasi extends AppCompatActivity {
    ListView listView;
    String bhsprogram[]={"Assembler", "Cobol", "Fortran", "Pascal", "Pearl", "C Plus", "Basic", "Turbo Basic", "Visual Basic",
            "Delphi", "Python", "Javascript", "Kotlin", "Java", "Mathlab", "PHP"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listview_aplikasi);

        listView=(ListView)findViewById(R.id.listView);

        ArrayAdapter adapter=new ArrayAdapter(  this, R.layout.support_simple_spinner_dropdown_item,bhsprogram);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(),bhsprogram[position],Toast.LENGTH_SHORT).show();
            }
        });
    }
}
