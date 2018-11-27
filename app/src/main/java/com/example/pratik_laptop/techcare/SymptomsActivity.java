package com.example.pratik_laptop.techcare;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

public class SymptomsActivity extends AppCompatActivity {

    CheckBox c1,c2,c3,c4,c5,c6,c7,c8,c9,c10;
    Button submit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_symptoms);
        c1=findViewById(R.id.checkBox);
        c2=findViewById(R.id.checkBox2);
        c3=findViewById(R.id.checkBox3);
        c4=findViewById(R.id.checkBox4);
        c5=findViewById(R.id.checkBox5);
        c6=findViewById(R.id.checkBox6);
        c7=findViewById(R.id.checkBox7);
        c8=findViewById(R.id.checkBox8);
        c9=findViewById(R.id.checkBox9);
        c10=findViewById(R.id.checkBox10);
        submit=findViewById(R.id.button);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (c1.isChecked()&&c3.isChecked())
                {
                    Intent i1 = new Intent(SymptomsActivity.this,D1Activity.class);
                    startActivity(i1);
                    c1.setChecked(Boolean.parseBoolean(null));
                    c3.setChecked(Boolean.parseBoolean(null));
                }
                if (c2.isChecked()&&c4.isChecked()&&c5.isChecked()&&c6.isChecked())
                {
                    Intent i1 = new Intent(SymptomsActivity.this,D6Activity.class);
                    startActivity(i1);
                    c2.setChecked(Boolean.parseBoolean(null));
                    c4.setChecked(Boolean.parseBoolean(null));
                    c5.setChecked(Boolean.parseBoolean(null));
                    c6.setChecked(Boolean.parseBoolean(null));
                }
                if (c7.isChecked()&&c9.isChecked())
                {
                    Intent i1 = new Intent(SymptomsActivity.this,D8Activity.class);
                    startActivity(i1);
                    c7.setChecked(Boolean.parseBoolean(null));
                    c9.setChecked(Boolean.parseBoolean(null));
                }
                if (c8.isChecked()&&c10.isChecked())
                {
                    Intent i1 = new Intent(SymptomsActivity.this,D9Activity.class);
                    startActivity(i1);
                    c8.setChecked(Boolean.parseBoolean(null));
                    c10.setChecked(Boolean.parseBoolean(null));
                }
            }
        });
    }
}
