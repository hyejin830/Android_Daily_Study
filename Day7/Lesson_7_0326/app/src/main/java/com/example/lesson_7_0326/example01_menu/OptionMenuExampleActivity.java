package com.example.lesson_7_0326.example01_menu;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.LinearLayout;

import com.example.lesson_7_0326.R;

public class OptionMenuExampleActivity extends AppCompatActivity {

    LinearLayout baseLinearLayout;
    Button btnEventMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_option_menu_example);

        baseLinearLayout = (LinearLayout)findViewById(R.id.base_layout);
        btnEventMenu = (Button)findViewById(R.id.btn_menu_event);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.example_menu, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){
            case R.id.item_red:
                baseLinearLayout.setBackgroundColor(Color.RED);
                return true;
            case R.id.item_green:
                baseLinearLayout.setBackgroundColor(Color.GREEN);
                return true;
            case R.id.item_blue:
                baseLinearLayout.setBackgroundColor(Color.BLUE);
                return true;
        }

        return false;
    }
}
