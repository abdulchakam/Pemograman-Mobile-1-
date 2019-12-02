package com.example.aplikasiq;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class DashboardMenu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard_menu);
    }
    public  void detailmenu(View view)
    {
        Intent intent=new Intent(DashboardMenu.this, Detailmenu.class);
        startActivity(intent);
    }
}
