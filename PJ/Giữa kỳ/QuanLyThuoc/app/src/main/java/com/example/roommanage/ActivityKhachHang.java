package com.example.roommanage;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
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

public class ActivityKhachHang extends AppCompatActivity {

    String urlGetData = "http://192.168.137.177/qldp/public/api/getKhachHang";

    ListView lvKhachHang;
    ArrayList<KhachHang> arrayKhachHang;
    KhachHangAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_khach_hang);

        lvKhachHang = (ListView) findViewById(R.id.listvKhachHang);
        arrayKhachHang = new ArrayList<>();
        adapter = new KhachHangAdapter(this, R.layout.item_khachhang, arrayKhachHang);
        lvKhachHang.setAdapter(adapter);



        GetData(urlGetData);

    }

    private void GetData(String url) {
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
//                        Toast.makeText(MainActivity.this, response.toString(), Toast.LENGTH_SHORT).show();
                        arrayKhachHang.clear();
                        for(int i = 0; i < response.length(); i++){
                            try {
                                JSONObject object = response.getJSONObject(i);
                                arrayKhachHang.add(new KhachHang(
                                        object.getString("MAKH"),
                                        object.getString("TENKH"),
                                        object.getString("QUOCTICH")
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
                Toast.makeText(ActivityKhachHang.this, "Lỗi show khách hàng!", Toast.LENGTH_SHORT).show();
            }
        }
        );
        requestQueue.add(jsonArrayRequest);
    }
}
