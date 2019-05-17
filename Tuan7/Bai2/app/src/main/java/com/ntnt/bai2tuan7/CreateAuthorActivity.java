package com.ntnt.bai2tuan7;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class CreateAuthorActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_author);
        final Button btnInsert = (Button) findViewById(R.id.buttonInsert);
        final EditText txtFirstname = (EditText) findViewById(R.id.editTextFirstName);
        final EditText txtLastname = (EditText) findViewById(R.id.editTextLastName);
        final Intent intent = getIntent();
        btnInsert.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Intent intent = new Intent();
                Bundle bundle = new Bundle();
                bundle.putString("firstname", txtFirstname.getText().toString());
                bundle.putString("lastname", txtLastname.getText().toString());
                intent.putExtra("DATA_AUTHOR", bundle);
                setResult(MainActivity.SEND_DATA_FROM_AUTHOR_ACTIVITY, intent);
                CreateAuthorActivity.this.finish();
            }
        });
        final Button btnClear = (Button) findViewById(R.id.buttonClear);
        btnClear.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                txtFirstname.setText("");
                txtLastname.setText("");
                txtFirstname.requestFocus();
            }
        });

        Bundle bundle = intent.getBundleExtra("DATA");
        if (bundle != null && bundle.getInt("KEY") == 1) {
            String f2 = bundle.getString("getField2");
            String f3 = bundle.getString("getField3");
            txtFirstname.setText(f2);
            txtLastname.setText(f3);
            btnInsert.setText("Update");
            this.setTitle("View Detail");
			/*TableRow row=(TableRow) findViewById(R.id.tableRow3);
			row.removeViewAt(0);
			row.setGravity(Gravity.RIGHT);*/
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_create_author, menu);
        return true;
    }
}
