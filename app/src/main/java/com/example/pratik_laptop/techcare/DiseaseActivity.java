package com.example.pratik_laptop.techcare;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.Arrays;

public class DiseaseActivity extends AppCompatActivity {
    String[] items;

    ArrayList<String> listItems;

    ArrayAdapter<String> adapter;

    ListView listView;

    EditText editText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_disease);
        listView=(ListView)findViewById(R.id.listview);

        editText=(EditText)findViewById(R.id.txtsearch);

        initList();
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View convertView, int position, long id) {

                if (position == 0){
                    Intent intent1 = new Intent(convertView.getContext(), D1Activity.class);
                    startActivityForResult(intent1,0);
                }
                if (position == 1){
                   Intent intent1 = new Intent(convertView.getContext(), D2Activity.class);
                    startActivityForResult(intent1,0);
                }
                if (position == 2){
                    Intent intent1 = new Intent(convertView.getContext(), D3Activity.class);
                    startActivityForResult(intent1,0);
                }
                if (position == 3){
                    Intent intent1 = new Intent(convertView.getContext(), D4Activity.class);
                    startActivityForResult(intent1,0);
                }
                if (position == 4){
                    Intent intent1 = new Intent(convertView.getContext(), D5Activity.class);
                    startActivityForResult(intent1,0);
                }
                if (position == 5){
                    Intent intent1 = new Intent(convertView.getContext(), D6Activity.class);
                    startActivityForResult(intent1,0);
                }
                if (position == 6){
                    Intent intent1 = new Intent(convertView.getContext(), D7Activity.class);
                    startActivityForResult(intent1,0);
                }
                if (position == 7){
                    Intent intent1 = new Intent(convertView.getContext(), D8Activity.class);
                    startActivityForResult(intent1,0);
                }
                if (position == 8){
                    Intent intent1 = new Intent(convertView.getContext(), D9Activity.class);
                    startActivityForResult(intent1,0);
                }
                if (position == 9){
                    Intent intent1 = new Intent(convertView.getContext(), D10Activity.class);
                    startActivityForResult(intent1,0);
                }
                if (position == 10){
                    Intent intent1 = new Intent(convertView.getContext(), D11Activity.class);
                    startActivityForResult(intent1,0);
                }

            }
        });
        editText.addTextChangedListener(new TextWatcher() {

            @Override

            public void beforeTextChanged(CharSequence s, int start, int count, int after) {



            }



            @Override

            public void onTextChanged(CharSequence s, int start, int before, int count) {

                if(s.toString().equals("")){

                    // reset listview

                    initList();

                }

                else{

                    // perform search

                    searchItem(s.toString());

                }

            }



            @Override

            public void afterTextChanged(Editable s) {



            }

        });

    }



    public void searchItem(String textToSearch){

        for(String item:items){

            if(!item.contains(textToSearch)){

                listItems.remove(item);

            }

        }

        adapter.notifyDataSetChanged();

    }

    public void initList(){

        items=new String[]{"Chicken pox","Measles","Poliomylitis","Rabies (also called hydrophobia)","Hepatitis","Dengue","Tuberculosis\n" +
                "Pathogen","Typhoid","Cholera","Diphtheria"};

        listItems=new ArrayList<>(Arrays.asList(items));

        adapter=new ArrayAdapter<String>(this,
                R.layout.list_item, R.id.txtitem, listItems);

        listView.setAdapter(adapter);

    }

}
