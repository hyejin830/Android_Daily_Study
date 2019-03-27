package com.example.lessson_8_0327.example03_resource;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.lessson_8_0327.R;

public class ResourceExampleActivity extends AppCompatActivity {

    TextView tvResouceExample;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resource_example);

        tvResouceExample = (TextView)findViewById(R.id.tv_res_java);
        // string
        String resStr = getString(R.string.res_string_test);
        tvResouceExample.setText(resStr);

        // string array
        String[] fruitStringArray = getResources().getStringArray(R.array.fruits);
        // 나중에
    }
}
