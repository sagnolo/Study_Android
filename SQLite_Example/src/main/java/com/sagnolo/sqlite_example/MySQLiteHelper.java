package com.sagnolo.sqlite_example;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class MySQLiteHelper extends SQLiteOpenHelper {

    public MySQLiteHelper(Context context, String name,
                          SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // 테이블 생성
        String sql = "CREATE TABLE TEST (name text );";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // DB버전 변경 시 테이블 새로 생성
        String sql = "DROP TABLE TEST";
        db.execSQL(sql);
        onCreate(db);
    }
}
