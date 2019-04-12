package com.example.lesson_12_0402.example03_database;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.lesson_12_0402.R;

import org.w3c.dom.Text;

public class DatabaseExampleActivity extends AppCompatActivity implements View.OnClickListener {

    private DBHelper Helper;
    private EditText InputNameEditText;
    private EditText InputAgeEditText;
    private TextView InPutNameResultTextView;
    private TextView InputAgeResultTextView;
    private Button InitDataBaseButton;
    private Button InsertDataBaseButton;
    private Button SelectDataBaseButton;
    private Button UpdateDataBaseButton;
    private Button DeleteDataBaseButton;

    private SQLiteDatabase sqlDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_database_example);

        initView();
    }

    private void initView() {

        setTitle(getString(R.string.database_example_subject));

        Helper = new DBHelper(this);

        InputNameEditText = findViewById(R.id.et_input_name);
        InputAgeEditText = findViewById(R.id.et_input_age);
        InPutNameResultTextView = findViewById(R.id.tv_name_result);
        InputAgeResultTextView = findViewById(R.id.tv_number_result);
        InitDataBaseButton = findViewById(R.id.btn_db_init);
        InsertDataBaseButton = findViewById(R.id.btn_db_insert);
        SelectDataBaseButton = findViewById(R.id.btn_db_select);
        UpdateDataBaseButton = findViewById(R.id.btn_db_update);
        DeleteDataBaseButton = findViewById(R.id.btn_db_delete);

        InitDataBaseButton.setOnClickListener(this);
        InsertDataBaseButton.setOnClickListener(this);
        SelectDataBaseButton.setOnClickListener(this);
        UpdateDataBaseButton.setOnClickListener(this);
        DeleteDataBaseButton.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_db_init:
                sqlDB = Helper.getWritableDatabase();
                Helper.onUpgrade(sqlDB, 1, 2);
                sqlDB.close();
                break;
            case R.id.btn_db_insert:
                sqlDB = Helper.getWritableDatabase();
                sqlDB.execSQL("INSERT INTO student VALUES ('"
                        + InputNameEditText.getText().toString() + "',"
                        + InputAgeEditText.getText().toString() + ");");
                sqlDB.close();
                Toast.makeText(getApplicationContext(), getString(R.string.input_success), Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn_db_select:
                sqlDB = Helper.getWritableDatabase();
                Cursor cursor;
                cursor = sqlDB.rawQuery("SELECT * FROM student;", null);

                String strName = "이름 " + "\r\n" + "-------" + "\r\n";
                String strAge = "나이 " + "\r\n" + "-------" + "\r\n";

                while (cursor.moveToNext()) {
                    strName += cursor.getString(0) + "\r\n";
                    strAge += cursor.getString(1) + "\r\n";
                }

                InPutNameResultTextView.setText(strName);
                InputAgeResultTextView.setText(strAge);
                cursor.close();
                sqlDB.close();

                break;
            // 업데이트의 경우
            case R.id.btn_db_update:
                sqlDB = Helper.getWritableDatabase();
                sqlDB.execSQL("UPDATE student SET age="
                        + InputAgeEditText.getText().toString()
                        + " WHERE name='" + InputNameEditText.getText().toString() + "';");
                sqlDB.close();
                break;

            case R.id.btn_db_delete:
                // 삭제의 경우
                sqlDB = Helper.getWritableDatabase();
                sqlDB.execSQL("DELETE FROM student WHERE name='"
                        + InputNameEditText.getText().toString() + "';");
                sqlDB.close();
                break;

        }
    }

    public class DBHelper extends SQLiteOpenHelper {

        public DBHelper(Context context) {
            super(context, context.getString(R.string.database_helper_name), null, 1);

        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            db.execSQL("CREATE TABLE student (name CHAR(20) PRIMARY KEY, age INTEGER);");
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            db.execSQL("DROP TABLE IF EXISTS student");
            onCreate(db);
        }


    }
}
