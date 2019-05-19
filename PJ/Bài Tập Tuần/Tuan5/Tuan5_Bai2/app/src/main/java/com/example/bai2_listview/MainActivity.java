package com.example.bai2_listview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView lvTraiCay;
    ArrayList<TraiCay> arrayTraiCay;
    TraiCayAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AnhXa();

        adapter = new TraiCayAdapter(this, R.layout.dong_trai_cay, arrayTraiCay);
        lvTraiCay.setAdapter(adapter);
    }

    private void AnhXa() {
        lvTraiCay =(ListView) findViewById(R.id.listviewTraiCay);
        arrayTraiCay = new ArrayList<>();

        arrayTraiCay.add(new TraiCay("Strawberyy", "It is an aggrerate accesory fruit", R.drawable.straw));
        arrayTraiCay.add(new TraiCay("Banana", "It is the largest harbaceous flowering plant", R.drawable.banana));
        arrayTraiCay.add(new TraiCay("Organe", "Citrus Fruit", R.drawable.organe));
        arrayTraiCay.add(new TraiCay("Mixed", "Mixed Fruits", R.drawable.mixed));
    }

}
