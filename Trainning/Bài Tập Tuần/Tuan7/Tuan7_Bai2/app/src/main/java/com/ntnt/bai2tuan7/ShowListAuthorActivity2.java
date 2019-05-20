package com.ntnt.bai2tuan7;

import java.util.ArrayList;
import java.util.List;
import android.app.ListActivity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

public class ShowListAuthorActivity2 extends ListActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_show_data2);
        updateUI();
        Button btn=(Button) findViewById(R.id.buttonBack);
        btn.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                ShowListAuthorActivity2.this.finish();
            }
        });
    }
    List<InforData>list=new ArrayList<InforData>();
    public void updateUI()
    {
        SQLiteDatabase database=openOrCreateDatabase("mydata.db", SQLiteDatabase.CREATE_IF_NECESSARY, null);
        if(database!=null)
        {
            Cursor cursor=database.query("tblAuthors", null, null, null, null, null, null);
            startManagingCursor(cursor);
            InforData header=new InforData();
            header.setField1(cursor.getColumnName(0));
            header.setField2(cursor.getColumnName(1));
            header.setField3(cursor.getColumnName(2));
            list.add(header);
            cursor.moveToFirst();
            while(!cursor.isAfterLast())
            {
                InforData data=new InforData();
                data.setField1(cursor.getInt(0));
                data.setField2(cursor.getString(1));
                data.setField3(cursor.getString(2));
                list.add(data);
                cursor.moveToNext();
            }
            cursor.close();
            MySimpleArrayAdapter adapter=new MySimpleArrayAdapter(ShowListAuthorActivity2.this, R.layout.my_layout_for_show_list_data, list);
            setListAdapter(adapter);
        }
    }
    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        // TODO Auto-generated method stub
        super.onListItemClick(l, v, position, id);
        Toast.makeText(ShowListAuthorActivity2.this,"View->"+ list.get(position).toString(), Toast.LENGTH_LONG).show();
    }

}

