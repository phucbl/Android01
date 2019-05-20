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

public class Book_Room extends AppCompatActivity {

    String urladd = "http://192.168.137.200:8080/qldp/public/api/addThongTinPhong";
    EditText edtHoTen, edtQuocTich, edtNgayDat, edtSoNgayO, edtMaPhong;
    Button btnXong, btnHuy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book__room);


        Intent intent = getIntent();
        Room room = (Room) intent.getSerializableExtra("dataRoom");

        AnhXa();

        // đưa mã phòng vừa chọn vào phiếu thông tin
        edtMaPhong.setText(room.getMaPhong());

        btnXong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String hoten    = edtHoTen.getText().toString().trim();
                String quoctich = edtQuocTich.getText().toString().trim();
                String ngaydat  = edtNgayDat.getText().toString().trim();
                String songayo  = edtSoNgayO.getText().toString().trim();
                String maphong  = edtMaPhong.getText().toString().trim();
                if(hoten.isEmpty() || quoctich.isEmpty() || ngaydat.isEmpty() || songayo.isEmpty() || maphong.isEmpty()){
                    Toast.makeText(Book_Room.this, "Vui lòng nhập đủ thông tin!", Toast.LENGTH_SHORT).show();
                }else {
                    BookRoom(urladd);
                    startActivity(new Intent(Book_Room.this, ShowPhieu.class));
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
        btnXong             = (Button) findViewById(R.id.buttonOkBook);
        btnHuy              = (Button) findViewById(R.id.buttonHuyBook);
        edtHoTen            = (EditText) findViewById(R.id.edittextHoTen);
        edtQuocTich         = (EditText) findViewById(R.id.edittextQuocTich);
        edtNgayDat          = (EditText) findViewById(R.id.edittextNgayDat);
        edtSoNgayO          = (EditText) findViewById(R.id.edittextSoNgayO);
        edtMaPhong          = (EditText) findViewById(R.id.edittextChonPhong);
    }

    private void BookRoom(String url){
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        StringRequest stringRequest = new StringRequest(Request.Method.POST, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Toast.makeText(Book_Room.this, response.toString(), Toast.LENGTH_LONG).show();
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
                params.put("addTenKH",edtHoTen.getText().toString().trim());
                params.put("addQuocTich",edtQuocTich.getText().toString().trim());
                params.put("addNgayDat",edtNgayDat.getText().toString().trim());
                params.put("addPhong",edtMaPhong.getText().toString().trim());
                params.put("addNgayO",edtSoNgayO.getText().toString().trim());


                return params;
            }
        };
        requestQueue.add(stringRequest);
    }
}
