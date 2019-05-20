package com.example.roommanage;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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

public class UpdateRoom extends AppCompatActivity {

    String   urlUpdate = "http://192.168.137.200:8080/qldp/public/api/updatePhong";
    EditText edtMaPhong, edtLoaiPhong, edtTang, edtGia;
    Button   btnOk, btnHuy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_room);

        Intent intent = getIntent();
        Room room = (Room) intent.getSerializableExtra("dataRoom");
//        Toast.makeText(this, khoa.getTenKhoa(), Toast.LENGTH_SHORT).show();

        AnhXa();

        edtMaPhong.setText(room.getMaPhong());
        edtLoaiPhong.setText(room.getLoaiPhong());
        edtTang.setText(room.getTang());
        edtGia.setText(room.getGiaPhong());

        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String maphong = edtMaPhong.getText().toString().trim();
                String loaiphong = edtLoaiPhong.getText().toString().trim();
                String tang = edtTang.getText().toString().trim();
                String gia = edtGia.getText().toString().trim();
                if(maphong.isEmpty() || loaiphong.isEmpty() || tang.isEmpty() || gia.isEmpty()){
                    Toast.makeText(UpdateRoom.this, "Vui lòng nhập đủ thông tin!", Toast.LENGTH_SHORT).show();
                }else {
                    CapNhatRoom(urlUpdate);

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
        btnOk           = (Button) findViewById(R.id.buttonOk);
        btnHuy          = (Button) findViewById(R.id.buttonHuy);
        edtMaPhong      = (EditText) findViewById(R.id.edittextMaPhong);
        edtLoaiPhong    = (EditText) findViewById(R.id.edittextLoaiPhong);
        edtTang         = (EditText) findViewById(R.id.edittextTang);
        edtGia          = (EditText) findViewById(R.id.edittextGia);
    }

    private void CapNhatRoom(String url){
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        StringRequest stringRequest = new StringRequest(Request.Method.POST, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Toast.makeText(UpdateRoom.this, response.toString(), Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(UpdateRoom.this, MainActivity.class));
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(UpdateRoom.this, "Lỗi cập nhật", Toast.LENGTH_SHORT).show();
                    }
                }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {

                Map<String, String> params = new HashMap<>();
                params.put("updateMaPhong", edtMaPhong.getText().toString().trim());
                params.put("updateLoaiPhong", edtLoaiPhong.getText().toString().trim());
                params.put("updateTang", edtTang.getText().toString().trim());
                params.put("updateGiaPhong", edtGia.getText().toString().trim());

                return params;
            }
        };
        requestQueue.add(stringRequest);
    }
}
