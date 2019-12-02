package com.example.duniadinosaurus;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.ArrayList;

public class Dashboard extends AppCompatActivity {

    private RecyclerView rvDino;
    private ArrayList<Dino> list =new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        rvDino = findViewById(R.id.rv_dino);
        rvDino.setHasFixedSize(true);

        list.addAll(DinoData.getListData());
        showRecyclerList();

    }

    private void showRecyclerList() {
        rvDino.setLayoutManager(new LinearLayoutManager(this));
        ListDinoAdapter listDinoAdapter = new ListDinoAdapter(list);
        rvDino.setAdapter(listDinoAdapter);

        listDinoAdapter.setOnItemClickCallback(new ListDinoAdapter.OnItemClickCallback() {
            @Override
            public void onItemClicked(Dino data) {
                showSelectedHero(data);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.action_profile:
                Intent intent =  new Intent(Dashboard.this,profile.class);
                startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }


    private void showSelectedHero(Dino dino) {
        Toast.makeText(this, "Detail " + dino.getName(), Toast.LENGTH_SHORT).show();
    }

}
