package com.example.pratik_laptop.techcare;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        Button m1 = findViewById(R.id.menu_button);
        Button m2 = findViewById(R.id.menu_button8);
        Button m3 = findViewById(R.id.menu_button9);
        Button m4 = findViewById(R.id.menu_button3);
        Button m5 = findViewById(R.id.menu_button7);
        Button m6 = findViewById(R.id.menu_button6);
        Button m7 = findViewById(R.id.menu_button2);
        m7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i1 = new Intent(MenuActivity.this,PulseMeasuring.class);
                startActivity(i1);
            }
        });
       m6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i1 = new Intent(MenuActivity.this,HeartRateMonitor.class);
                startActivity(i1);
            }
        });
        m5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i1 = new Intent(MenuActivity.this,SymptomsActivity.class);
                startActivity(i1);
            }
        });
        m1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i1 = new Intent(MenuActivity.this,LocateActivity.class);
                startActivity(i1);
            }
        });
        m2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i1 = new Intent(MenuActivity.this,BmiActivity.class);
                startActivity(i1);
            }
        });
        m3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i1 = new Intent(MenuActivity.this,HelpActivity.class);
                startActivity(i1);
            }
        });
        m4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i1 = new Intent(MenuActivity.this,ProfileActivity.class);
                startActivity(i1);
            }
        });
    }
}
