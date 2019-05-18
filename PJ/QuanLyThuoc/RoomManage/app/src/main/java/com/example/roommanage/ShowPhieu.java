package com.example.roommanage;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class ShowPhieu extends AppCompatActivity {

    String urlGetData = "http://192.168.137.200:8080/qldp/public/api/getPhieuDatPhong";

    ListView lvPhieu;
    ArrayList<Phieu> arrayPhieu;
    PhieuAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_phieu);

        GetData(urlGetData);

        lvPhieu = (ListView) findViewById(R.id.listvPhieu);
        arrayPhieu = new ArrayList<>();
        adapter = new PhieuAdapter(ShowPhieu.this, R.layout.item_phieu, arrayPhieu);
        lvPhieu.setAdapter(adapter);
//        btnChapNhan.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                startActivity(new Intent(ShowPhieu.this, MainActivity.class));
//            }
//        });

    }


    private void GetData(String url) {
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
//                        Toast.makeText(MainActivity.this, response.toString(), Toast.LENGTH_SHORT).show();
                        arrayPhieu.clear();
                        for(int i = 0; i < response.length(); i++){
                            try {
                                JSONObject object = response.getJSONObject(i);
                                arrayPhieu.add(new Phieu(
                                        object.getString("TENKH"),
                                        object.getString("NGAYDAT"),
                                        object.getString("SONGAYO"),
                                        object.getString("MAPHONG"),
                                        object.getString("LOAIPHONG"),
                                        object.getString("TANG"),
                                        object.getString("GIAPHONG")
                                ));
                            } catch (JSONException e){
                                e.printStackTrace();
                            }
                        }
                        adapter.notifyDataSetChanged();
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(ShowPhieu.this, "Lỗi show phiếu!", Toast.LENGTH_SHORT).show();
            }
        }
        );
        requestQueue.add(jsonArrayRequest);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.done_add_room, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if(item.getItemId() == R.id.menuDone){
            startActivity(new Intent(ShowPhieu.this, MainActivity.class));
        }
        return super.onOptionsItemSelected(item);
    }
}
