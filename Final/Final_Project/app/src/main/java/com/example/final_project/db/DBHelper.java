package com.example.final_project.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.final_project.R;

public class DBHelper extends SQLiteOpenHelper {
    public DBHelper(Context context) {
        super(context, context.getString(R.string.db_helper_name), null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE friend_list (email varchar(50) not null,name	varchar(10) not null, primary key(email));");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS friend_list");
        onCreate(db);
    }
}