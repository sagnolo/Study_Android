package com.sagnolo.realm_example;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import io.realm.Realm;
import io.realm.RealmResults;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();
    private Realm mRealm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
    }

    // 데이터 초기화
    private void init(){
        mRealm = Realm.getInstance(this);
        RealmResults<UserVO> userList = getUserList();
        Log.i(TAG, ">>>>>   userList.size :  " + userList.size()); // :0

        insert_user();
        Log.i(TAG, ">>>>>   userList.size :  " + userList.size()); // :1

        delete_user();
        Log.i(TAG, ">>>>>   userList.size :  " + userList.size()); // :0
    }

    // 유저 정보 데이터 반환
    private RealmResults<UserVO> getUserList(){
        return mRealm.where(UserVO.class).findAll();
    }

    // 데이터 저장
    private void insert_user(){
        mRealm.beginTransaction();
        UserVO user = mRealm.createObject(UserVO.class);
        user.setName("Sagnol");
        user.setAge(28);
        mRealm.commitTransaction();
    }

    // 데이터 삭제
    private void delete_user(){
        mRealm.beginTransaction();
        RealmResults<UserVO> userList = mRealm.where(UserVO.class).findAll();
        userList.remove(0);
        mRealm.commitTransaction();
    }
}
