package com.sagnolo.sqlite_example;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.File;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<Dictionary> mArrayList;
    private CustomAdapter mAdapter;
    private RecyclerView mRecyclerView;
    private LinearLayoutManager mLinearLayoutManager;
    private int count = -1;

    private MySQLiteHelper helper;
    private SQLiteDatabase db;
    String dbname = "tests.db";
    String sql;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText txtName = (EditText) findViewById (R.id.editTextName);
        Button btnSave = (Button) findViewById (R.id.btnSave);
        Button btnClear = (Button) findViewById (R.id.btnClear);
        Button btnSelect = (Button) findViewById (R.id.btnSelect);

        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerview_list);
        mLinearLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLinearLayoutManager);

        // MainActivity에서 RecyclerView의 데이터에 접근시 사용
        mArrayList = new ArrayList<>();

        mAdapter = new CustomAdapter( mArrayList);
        mRecyclerView.setAdapter(mAdapter);

        helper = new MySQLiteHelper(
                this,
                dbname,
                null,
                1
        );

        try {
            db = helper.getWritableDatabase();
        } catch (SQLiteException e) {
            e.printStackTrace();
            finish();
        }

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sql = "INSERT INTO TEST (  name ) VALUES ( '" + txtName.getText().toString() + "');";
                db.execSQL(sql);
            }
        });

        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sql = "DELETE FROM TEST";
                db.execSQL(sql);
            }
        });

        btnSelect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cursor c = db.rawQuery("SELECT * from TEST ORDER BY name ASC;", null);
                mArrayList.clear();
                while(c.moveToNext()) {
                    String name = c.getString(0);
                    Dictionary dict = new Dictionary(name);
                    mArrayList.add(dict); // RecyclerView의 마지막 줄에 삽입
                }
                mAdapter.notifyDataSetChanged(); //변경된 데이터를 화면에 반영
            }
        });
    }
}
