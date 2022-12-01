package com.indira_yulianti_f55121023.aplikasi_uts;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private String[] dataName;
    private String[] datadescription;
    private TypedArray dataPhoto;
    private DoktorAdapter adapter;
    private ArrayList<Doktor> doktors;


    private String[] dataname = {"Indira Yulianti", "Cut Nyak Dien", "Ki Hajar Dewantara", "Moh Yamin", "Pattimura", "R A Kartini", "Sukarno"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        adapter = new DoktorAdapter(this);
        ListView listView = findViewById(R.id.lv_list);
        listView.setAdapter(adapter);
        prepare();
        addItem();
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long id) {
                if (i==0){
                    startActivity(new Intent(MainActivity.this, itemlist.class));
                }}
        });
    }
    private void prepare() {
        dataName =
                getResources().getStringArray(R.array.data_name);
        datadescription =
                getResources().getStringArray(R.array.data_description);
        dataPhoto =
                getResources().obtainTypedArray(R.array.data_photo);
    }
    private void addItem() {
        doktors = new ArrayList<>();
        for (int i = 0; i < dataName.length; i++) {
            Doktor doktor = new Doktor ();
            doktor.setPhoto(dataPhoto.getResourceId(i, -1));
            doktor.setName(dataName[i]);
            doktor.setDescription(datadescription[i]);
            doktors.add(doktor);
        }
        adapter.setDoktors(doktors);
    }
}