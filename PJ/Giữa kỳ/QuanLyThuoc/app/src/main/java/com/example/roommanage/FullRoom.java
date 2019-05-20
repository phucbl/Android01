package com.example.roommanage;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class FullRoom extends AppCompatActivity {

    String urlGetPhongDaDat = "http://192.168.137.177/qldp/public/api/getPhongDaDat";
    String urlGetData = "http://192.168.137.177/qldp/public/api/getPhong";
    String urlDelete = "http://192.168.137.177/qldp/public/api/deletePhong";

    ListView lvRoom;
    ArrayList<Room> arrayRoom;
    ArrayList<String> arrayString;
    FullRoomAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_full_room);

        GetPhongDaDat(urlGetPhongDaDat);

        lvRoom = (ListView) findViewById(R.id.listvFullRoom);
        arrayString = new ArrayList<>();
        arrayRoom = new ArrayList<>();
        adapter = new FullRoomAdapter(this, R.layout.item_room, arrayRoom);
        lvRoom.setAdapter(adapter);



        GetData(urlGetData);
    }

    private void GetData(String url) {
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
//                        Toast.makeText(MainActivity.this, response.toString(), Toast.LENGTH_SHORT).show();
                        arrayRoom.clear();
                        for(int i = 0; i < response.length(); i++){
                            try {
                                JSONObject object = response.getJSONObject(i);
                                for (int j = 0; j < arrayString.size(); j++) {
                                    if(object.getString("MAPHONG").equals(arrayString.get(j))){
                                        arrayRoom.add(new Room(
                                                object.getString("MAPHONG"),
                                                object.getString("LOAIPHONG"),
                                                object.getString("TANG"),
                                                object.getString("GIAPHONG")
                                        ));
                                    }
                                }

                            } catch (JSONException e){
                                e.printStackTrace();
                            }
                        }
                        adapter.notifyDataSetChanged();
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(FullRoom.this, "Lỗi show phòng!", Toast.LENGTH_SHORT).show();
            }
        }
        );
        requestQueue.add(jsonArrayRequest);
    }

    public void GetPhongDaDat(String url) {
        RequestQueue requestQueuea = Volley.newRequestQueue(this);
        JsonArrayRequest jsonArrayRequests = new JsonArrayRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        arrayRoom.clear();
                        for(int i = 0; i < response.length(); i++){
                            try {
                                JSONObject object = response.getJSONObject(i);
                                arrayString.add(new String(object.getString("MAPHONG")));
                            } catch (JSONException e){
                                e.printStackTrace();
                            }
                        }

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(FullRoom.this, "Lỗi show phòng456789!", Toast.LENGTH_SHORT).show();
            }
        }
        );
        requestQueuea.add(jsonArrayRequests);
    }

    public void DeleteKhoa(final String maphong){
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        StringRequest stringRequest = new StringRequest(Request.Method.POST, urlDelete,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Toast.makeText(FullRoom.this, response.toString(), Toast.LENGTH_SHORT).show();
                        GetData(urlGetData);
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(FullRoom.this, "Lỗi rồi đó!", Toast.LENGTH_SHORT).show();
                    }
                }
        ){
            @Override
            protected Map<String , String > getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                params.put("deleteMaPhong", maphong);

                return params;
            }
        };
        requestQueue.add(stringRequest);
    }
}
