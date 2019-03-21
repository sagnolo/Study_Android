package com.sagnolo.activity_data_transfer;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class SubActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);

        TextView textView = (TextView) findViewById(R.id.TextView);

        Intent intent = getIntent();
        String editData = intent.getStringExtra("editData"); // 값 전달받기

        textView.setText(editData);

    }
}
