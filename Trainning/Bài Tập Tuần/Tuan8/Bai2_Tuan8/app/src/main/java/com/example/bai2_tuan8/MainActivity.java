package com.example.bai2_tuan8;

import android.graphics.Paint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {
    String TAG = "18K", TAG1="USD", TAG2="9999", TAG3="AUD";
    DatabaseReference msg, msg1, msg2, msg3 = null;
    Switch sw;
    EditText txt,txt1,txt2,txt3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setControl();
        setFirebase();
        setEvent();
    }
    public void setControl(){
        txt = findViewById(R.id.vangk);
        txt1 = findViewById(R.id.usd);
        txt2 = findViewById(R.id.vang4so);
        txt3 = findViewById(R.id.aud);
        sw = findViewById(R.id.sw);
    }
    public void setEvent(){
       sw.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               if(!sw.isChecked()){
                   CapNhat(v);
                   txt.setEnabled(false);
                   txt1.setEnabled(false);
                   txt2.setEnabled(false);
                   txt3.setEnabled(false);
               } else
               {
                   txt.setEnabled(true);
                   txt1.setEnabled(true);
                   txt2.setEnabled(true);
                   txt3.setEnabled(true);
               }
           }
       });
    }
    private void setFirebase(){
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        msg = database.getReference(TAG);
        msg1 = database.getReference(TAG1);
        msg2 = database.getReference(TAG2);
        msg3 = database.getReference(TAG3);
        msg.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String value = dataSnapshot.getValue(String.class);
                Toast.makeText(MainActivity.this,"Value 18k is: "+value,Toast.LENGTH_SHORT).show();
                txt.setText(value);
            }

            @Override
            public void onCancelled(DatabaseError error) {
                Log.w(TAG, "Failed to read value.", error.toException());
            }
        });
        msg1.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String value = dataSnapshot.getValue(String.class);
                Toast.makeText(MainActivity.this,"Value USD is: "+value,Toast.LENGTH_SHORT).show();

                txt1.setText(value);
            }

            @Override
            public void onCancelled(DatabaseError error) {
                Log.w(TAG1, "Failed to read value.", error.toException());
            }
        });
        msg2.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String value = dataSnapshot.getValue(String.class);
                Toast.makeText(MainActivity.this,"Value 9999 is: "+value,Toast.LENGTH_SHORT).show();

                txt2.setText(value);
            }

            @Override
            public void onCancelled(DatabaseError error) {
                Log.w(TAG2, "Failed to read value.", error.toException());
            }
        });
        msg3.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String value = dataSnapshot.getValue(String.class);
                Toast.makeText(MainActivity.this,"Value AUD is: "+value,Toast.LENGTH_SHORT).show();
                txt3.setText(value);
            }

            @Override
            public void onCancelled(DatabaseError error) {
                Log.w(TAG3, "Failed to read value.", error.toException());
            }
        });
    }
    public void CapNhat(View v){
        msg.setValue(txt.getText().toString());
        msg1.setValue(txt1.getText().toString());
        msg2.setValue(txt2.getText().toString());
        msg3.setValue(txt3.getText().toString());
    }
}
