package com.example.sqdb;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button bt1,bt2,bt3,bt4;
    TextView tv1;
    EditText r,n,d;

    DBHelper db ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        db = new DBHelper(MainActivity.this);

        bt1=findViewById(R.id.b1);
        bt2=findViewById(R.id.b2);
        bt3=findViewById(R.id.b3);
        bt4=findViewById(R.id.b4);
        r=findViewById(R.id.et1);
        n=findViewById(R.id.et2);
        d=findViewById(R.id.et3);
    }
    public void onInsert(View view){
        String rollno = r.getText().toString();
        String name = n.getText().toString();
        String dept = d.getText().toString();
        if(rollno.equals("") || name.equals("") || dept.equals("")){
            Toast.makeText(this,"Please Enter value",Toast.LENGTH_SHORT).show();
            return;
        }else{
            ContentValues value = new ContentValues();
            value.put("rollno",rollno);
            value.put("name",name);
            value.put("dept",dept);
            db.insertData("student",value);
            Toast.makeText(this,"Inserted ",Toast.LENGTH_SHORT).show();
        }
    }
    public void onUpdate(View view){
        String rollno = r.getText().toString();
        String name = n.getText().toString();
        String dept = d.getText().toString();
        if(rollno.isEmpty() || name.isEmpty() || dept.isEmpty()){
            Toast.makeText(this,"Please Enter value",Toast.LENGTH_SHORT).show();
            return;
        }else{
            ContentValues values=new ContentValues();
            values.put("rollno",rollno);
            values.put("name",name);
            values.put("dept",dept);
            db.updateData("student",values,rollno);
            Toast.makeText(this,"Update :",Toast.LENGTH_SHORT).show();

        }

    }
    public void onRead(View view) {
        StringBuffer buffer = new StringBuffer();
        Cursor c = db.rawQuery("select * from student", null);
        if (c.getCount() == 0) {
            Toast.makeText(this, "No data found", Toast.LENGTH_SHORT).show();
        } else {
            while (c.moveToNext()) {
                buffer.append("\n Roll no :" + c.getString(0));
                buffer.append("\n Name ;" + c.getString(1));
                buffer.append("\n Dept :" + c.getString(2));
            }
            Toast.makeText(this, buffer.toString(), Toast.LENGTH_SHORT).show();
        }
    }
    public void onDelete(View view){
        String rollno = r.getText().toString();
        String name = n.getText().toString();
        String dept = d.getText().toString();
        if(rollno.equals("")){
            Toast.makeText(this,"Please enter the roll no",Toast.LENGTH_SHORT).show();
            return;
        }
        db.deleteData("student",rollno);
        Toast.makeText(this,"Deleted",Toast.LENGTH_SHORT).show();

    }
    }
