package com.example.lesson_12_0402;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.lesson_12_0402.example01_fragment_life_cycle.ExampleFragmentLifeCycleActivity;
import com.example.lesson_12_0402.example02_fragment_data_change.ExampleFragmentDataChangeActivity;
import com.example.lesson_12_0402.example03_database.DatabaseExampleActivity;
import com.example.lesson_12_0402.example04_external_database.ExternalDatabaseLoginActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button doStartFragmentExampleButton;
    private Button doStartFragmentDataChangeButton;
    private Button doStartDatabaseExampleButton;
    private Button doStartExternalDatabaseLoginButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();

    }

    private void initView() {
        doStartFragmentExampleButton = findViewById(R.id.btn_do_start_fragment_life_cycle_example);
        doStartFragmentDataChangeButton = findViewById(R.id.btn_do_start_fragment_data_change);
        doStartDatabaseExampleButton = findViewById(R.id.btn_do_start_database_example);
        doStartExternalDatabaseLoginButton = findViewById(R.id.btn_do_start_external_database_login);

        doStartFragmentExampleButton.setOnClickListener(this);
        doStartFragmentDataChangeButton.setOnClickListener(this);
        doStartDatabaseExampleButton.setOnClickListener(this);
        doStartExternalDatabaseLoginButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_do_start_fragment_life_cycle_example:
                Intent startFragmentLifeCycleExampleIntent = new Intent(this, ExampleFragmentLifeCycleActivity.class);
                startActivity(startFragmentLifeCycleExampleIntent);
                break;
            case R.id.btn_do_start_fragment_data_change:
                Intent startFragmentDataChangeIntent = new Intent(this, ExampleFragmentDataChangeActivity.class);
                startActivity(startFragmentDataChangeIntent);
                break;
            case R.id.btn_do_start_database_example:
                Intent startDatabaseExampleIntent = new Intent(this, DatabaseExampleActivity.class);
                startActivity(startDatabaseExampleIntent);
                break;
            case R.id.btn_do_start_external_database_login:
                Intent startExternalDatabaseLoginIntent = new Intent(this, ExternalDatabaseLoginActivity.class);
                startActivity(startExternalDatabaseLoginIntent);
                break;
        }

    }
}
