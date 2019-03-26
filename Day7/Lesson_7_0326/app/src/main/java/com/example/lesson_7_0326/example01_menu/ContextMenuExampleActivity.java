package com.example.lesson_7_0326.example01_menu;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.lesson_7_0326.R;

public class ContextMenuExampleActivity extends AppCompatActivity {

    ImageView ivViewMovie;
    Button btnEventViewMoive;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_context_menu_example);

        ivViewMovie = (ImageView) findViewById(R.id.iv_movie);
        btnEventViewMoive = (Button) findViewById(R.id.btn_movie);

        // context menu register : when long click, event execute
        registerForContextMenu(btnEventViewMoive);


    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.context_example_menu, menu);

    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.item_movie1:
                ivViewMovie.setImageResource(R.drawable.movie1);
                return true;
            case R.id.item_movie2:
                ivViewMovie.setImageResource(R.drawable.movie2);
                return true;
            case R.id.item_movie3:
                ivViewMovie.setImageResource(R.drawable.movie3);
                return true;
            case R.id.item_movie4:
                ivViewMovie.setImageResource(R.drawable.movie4);
                return true;

        }
        return false;
    }
}
