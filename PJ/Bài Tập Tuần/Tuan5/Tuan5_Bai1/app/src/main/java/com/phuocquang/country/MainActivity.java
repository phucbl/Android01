package com.phuocquang.country;

import android.annotation.SuppressLint;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.phuocquang.country.Adapter.CustomAdapter;
import com.phuocquang.country.model.Country;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ListView lvCountry;
    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lvCountry = (ListView) findViewById(R.id.lv_country);

        ArrayList<Country> arrCountry = new ArrayList<>();

        Country country1 = new Country(R.drawable.vn, "Việt Nam", "Population: 97,194,391");
        arrCountry.add(country1);
        Country country2 = new Country(R.drawable.korea, "Hàn Quốc", "Population: 82,000,000");
        arrCountry.add(country2);
        Country country3 = new Country(R.drawable.canada, "Canada", "Population: 68,000,000");
        arrCountry.add(country3);
        Country country4 = new Country(R.drawable.thailand, "Thái Lan", "Population: 52,000,000");
        arrCountry.add(country4);
        Country country5 = new Country(R.drawable.cambodia, "Campuchia", "Population: 85,000,000");
        arrCountry.add(country5);

        CustomAdapter customAdapter = new CustomAdapter(this, R.layout.row_item, arrCountry);
        lvCountry.setAdapter(customAdapter);
    }
}
