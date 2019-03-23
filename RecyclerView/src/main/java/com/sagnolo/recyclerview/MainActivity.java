package com.sagnolo.recyclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ArrayList<Dictionary> mArrayList;
    private CustomAdapter mAdapter;
    private RecyclerView mRecyclerView;
    private LinearLayoutManager mLinearLayoutManager;
    private int count = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerview_list);
        mLinearLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLinearLayoutManager);

        // MainActivity에서 RecyclerView의 데이터에 접근시 사용
        mArrayList = new ArrayList<>();

        mAdapter = new CustomAdapter( mArrayList);
        mRecyclerView.setAdapter(mAdapter);

        Button btnData= (Button)findViewById(R.id.btnData);
        btnData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                count++;

                // Dictionary 생성자를 사용하여 ArrayList에 삽입할 데이터를 만듭니다.
                Dictionary dict = new Dictionary(count+" ","Potato" + count);

                //mArrayList.add(0, dict); //RecyclerView의 첫 줄에 삽입
                mArrayList.add(dict); // RecyclerView의 마지막 줄에 삽입
                mAdapter.notifyDataSetChanged(); //변경된 데이터를 화면에 반영
            }
        });

    }
}
