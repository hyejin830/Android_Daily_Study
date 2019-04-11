package com.example.final_project.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.final_project.R;

public class DBHelper extends SQLiteOpenHelper {

    private static final String TAG = "DBHelper";
    public DBHelper(Context context) {
        super(context, context.getString(R.string.db_helper_name), null, 1);
        Log.d(TAG,"database");
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        Log.d(TAG,"Table 생성");
        db.execSQL("CREATE TABLE friend_list (email varchar(50) not null,name	varchar(10) not null, primary key(email));");
        db.execSQL("CREATE TABLE messages (fromUser varchar(50) not null,toUser varchar(50) not null,message varchar(100) not null);");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS friend_list");
        db.execSQL("DROP TABLE IF EXISTS messages");
        onCreate(db);
    }
}
