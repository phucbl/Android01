package com.example.bai5_qldb;

import java.util.ArrayList;
import android.os.Bundle;
import android.app.Activity;
import android.view.ContextMenu;
import android.view.View;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.view.MenuItem;

public class MainActivity extends Activity {

    EditText editName,editPhone;
    Button btnSave;
    ListView lvContact;

    ArrayList<MyContact>arrContact=new ArrayList<MyContact>();
    ArrayAdapter<MyContact>adapter=null;
    MyContact selectedContact=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        doGetFormWidgets();
        doAddEvents();
    }
    public void doGetFormWidgets()
    {
        btnSave=(Button) findViewById(R.id.btnSaveContact);
        editName=(EditText) findViewById(R.id.editName);
        editPhone=(EditText) findViewById(R.id.editPhone);
        lvContact=(ListView) findViewById(R.id.lvContact);

        adapter=new ArrayAdapter<MyContact>
                (this, android.R.layout.simple_list_item_1,arrContact);

        lvContact.setAdapter(adapter);

        registerForContextMenu(lvContact);
    }
    public void doAddEvents()
    {
        btnSave.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View arg0) {
                doSaveContact();
            }
        });

        lvContact.setOnItemLongClickListener(new OnItemLongClickListener() {

            @Override
            public boolean onItemLongClick(AdapterView<?> arg0, View arg1,
                                           int arg2, long arg3) {
                selectedContact=arrContact.get(arg2);
                return false;
            }
        });
    }

    public void doSaveContact()
    {
        MyContact ct=new MyContact();
        ct.setName(editName.getText()+"");
        ct.setPhone(editPhone.getText()+"");
        arrContact.add(ct);
        adapter.notifyDataSetChanged();
    }
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenuInfo menuInfo) {

        super.onCreateContextMenu(menu, v, menuInfo);

        getMenuInflater().inflate(R.menu.phonecontextmenu, menu);
        menu.setHeaderTitle("Call- Sms");
        menu.getItem(0).setTitle("Call to "+selectedContact.getPhone());
        menu.getItem(1).setTitle("Send sms to "+selectedContact.getPhone());
    }
    @Override
    public boolean onContextItemSelected(MenuItem item) {
        switch(item.getItemId())
        {
            case R.id.mnuRemove:
                arrContact.remove(selectedContact);
                adapter.notifyDataSetChanged();
                break;
        }
        return super.onContextItemSelected(item);
    }
}

