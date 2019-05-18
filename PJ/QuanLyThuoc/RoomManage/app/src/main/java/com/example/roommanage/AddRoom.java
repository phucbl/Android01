package com.example.roommanage;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class AddRoom extends AppCompatActivity {

    String urlinsert = "http://192.168.137.200:8080/qldp/public/api/addPhong";

    EditText edtMaPhong, edtLoaiPhong, edtTang, edtGia;
    Button btnThem, btnHuy;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_room);

        AnhXa();


        btnThem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String maphong = edtMaPhong.getText().toString().trim();
                String loaiphong = edtLoaiPhong.getText().toString().trim();
                String tang = edtTang.getText().toString().trim();
                String gia = edtGia.getText().toString().trim();
                if(maphong.isEmpty() || loaiphong.isEmpty() || tang.isEmpty() || gia.isEmpty()){
                    Toast.makeText(AddRoom.this, "Vui lòng nhập đủ thông tin!", Toast.LENGTH_SHORT).show();
                }else {
                    ThemRoom(urlinsert);
                    startActivity(new Intent(AddRoom.this, MainActivity.class));
                }
            }
        });

        btnHuy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    private void AnhXa() {
        btnThem         = (Button) findViewById(R.id.buttonOkAdd);
        btnHuy          = (Button) findViewById(R.id.buttonHuyAdd);
        edtMaPhong      = (EditText) findViewById(R.id.edittextMaPhongAdd);
        edtLoaiPhong    = (EditText) findViewById(R.id.edittextLoaiPhongAdd);
        edtTang         = (EditText) findViewById(R.id.edittextTangAdd);
        edtGia          = (EditText) findViewById(R.id.edittextGiaAdd);
    }

    private void ThemRoom(String url){
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        StringRequest stringRequest = new StringRequest(Request.Method.POST, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Toast.makeText(AddRoom.this, response.toString(), Toast.LENGTH_LONG).show();
//                        startActivity(new Intent(AddKhoa.this, MainActivity.class));
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {

                Map<String, String> params = new HashMap<>();
                params.put("addMaPhong",edtMaPhong.getText().toString().trim());
                params.put("addLoaiPhong",edtLoaiPhong.getText().toString().trim());
                params.put("addTang",edtTang.getText().toString().trim());
                params.put("addGiaPhong",edtGia.getText().toString().trim());

                return params;
            }
        };
        requestQueue.add(stringRequest);
    }

}
