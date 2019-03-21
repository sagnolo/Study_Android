package com.sagnolo.tutorial;

import android.nfc.Tag;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i("onCreate", "액티비티 생성될 때 호출");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i("onCreate", "활동이 다시 시작되기 전에");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i("onStart", "Activity가 사용자에게 표시될 때");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("onResume", "Activity가 사용자와 상호작용하기 시작할 때 호출");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("onPause", "화면 갱신 처리 정지 또는 일시정지");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("onStop", "Activity가 사용자에게 더 이상 보이지 않을 때");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("onDestroy", "Activity 종료");
    }

}
