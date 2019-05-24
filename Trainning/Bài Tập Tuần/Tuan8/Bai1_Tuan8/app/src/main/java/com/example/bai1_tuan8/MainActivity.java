package com.example.bai1_tuan8;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {
String TAG = "Message";
DatabaseReference msg = null;
Button btn;
@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setFirebase();
        setEvent();
    }
    public void setEvent(){
        btn = findViewById(R.id.bttb);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CapNhat(v);
            }
        });
    }
    private void setFirebase(){
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        msg = database.getReference(TAG);
        msg.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String value = dataSnapshot.getValue(String.class);
                Toast.makeText(MainActivity.this,"Value is: "+value,Toast.LENGTH_SHORT).show();
                EditText txt = findViewById(R.id.edit);
                txt.setText(value);
            }

            @Override
            public void onCancelled(DatabaseError error) {
                Log.w(TAG, "Failed to read value.", error.toException());
            }
        });
    }
    public void CapNhat(View v){
        EditText txt = findViewById(R.id.edit);
        msg.setValue(txt.getText().toString());
    }
}
