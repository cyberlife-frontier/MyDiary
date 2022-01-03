package com.example.mydiary;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import java.text.SimpleDateFormat;
import java.util.Date;

import androidx.appcompat.app.AppCompatActivity;

public class AddActivity extends AppCompatActivity implements View.OnClickListener {
    private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    private Button btn_sure, btn_cancel;
    private EditText et_title, et_content,et_author;
    private SQLiteDatabase mDatabase;
    private int[] idlist;
    private int id;
    private String title,author, createtime, content, dateStr;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        mDatabase = new DBHelper(this).getWritableDatabase();
        initView();
        initEvent();
    }

    public void initView() {
        et_title = (EditText) findViewById(R.id.et_title);
        et_author=(EditText)findViewById(R.id.et_author);
        et_content = (EditText) findViewById(R.id.et_content);
        btn_sure = (Button) findViewById(R.id.btn_sure);
        btn_cancel = (Button) findViewById(R.id.btn_cancel);
    }

    public void initEvent() {
        btn_sure.setOnClickListener(AddActivity.this);
        btn_cancel.setOnClickListener(AddActivity.this);
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.btn_sure) {
            Toast toast = Toast.makeText(getApplicationContext(), "添加成功", Toast.LENGTH_LONG);
            toast.show();
            Date date = new Date();
            date.getTime();
            dateStr = sdf.format(date);
            title = et_title.getText().toString();
            author = et_author.getText().toString();
            content = et_content.getText().toString();
            insertData(title,author, dateStr, content);
            //跳转
            startActivity(new Intent(this, MainActivity.class));
            //跳转完以后关闭本界面
            finish();
        }
        if (view.getId() == R.id.btn_cancel) {
            startActivity(new Intent(this, MainActivity.class));
            finish();
        }
    }

    private void insertData(String title,String author ,String createtime, String content) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("title", title);
        contentValues.put("author",author);
        contentValues.put("createtime", createtime);
        contentValues.put("content", content);
        mDatabase.insertWithOnConflict(DBHelper.TABLE_NAME,null,contentValues,SQLiteDatabase.CONFLICT_IGNORE);
    }


}