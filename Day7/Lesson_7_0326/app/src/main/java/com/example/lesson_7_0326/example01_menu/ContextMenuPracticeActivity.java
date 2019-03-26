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

public class ContextMenuPracticeActivity extends AppCompatActivity {

    ImageView ivViewImage;
    Button btnEventViewMoive;
    Button btnEventViewAnimation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_context_menu_practice);

        ivViewImage = (ImageView) findViewById(R.id.iv_image_practice);
        btnEventViewMoive = (Button) findViewById(R.id.btn_movie_practice);
        btnEventViewAnimation = (Button) findViewById(R.id.btn_animation_practice);

        // context menu register : when long click, event execute
        registerForContextMenu(btnEventViewMoive);
        registerForContextMenu(btnEventViewAnimation);

    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        MenuInflater menuInflater = getMenuInflater();

        if(v == btnEventViewMoive){
            menuInflater.inflate(R.menu.context_example_menu, menu);
        }
        if(v == btnEventViewAnimation){
            menuInflater.inflate(R.menu.context_animation_menu, menu);
        }


    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.item_movie1:
                ivViewImage.setImageResource(R.drawable.movie1);
                return true;
            case R.id.item_movie2:
                ivViewImage.setImageResource(R.drawable.movie2);
                return true;
            case R.id.item_movie3:
                ivViewImage.setImageResource(R.drawable.movie3);
                return true;
            case R.id.item_movie4:
                ivViewImage.setImageResource(R.drawable.movie4);
                return true;
            case R.id.item_animation1:
                ivViewImage.setImageResource(R.drawable.animation1);
                return true;
            case R.id.item_animation2:
                ivViewImage.setImageResource(R.drawable.animation2);
                return true;
            case R.id.item_animation3:
                ivViewImage.setImageResource(R.drawable.animation3);
                return true;
            case R.id.item_animation4:
                ivViewImage.setImageResource(R.drawable.animatioin4);
                return true;

        }
        return false;
    }
}
