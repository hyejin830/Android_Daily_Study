package com.example.lesson_7_0326.practice01_menu;

import android.graphics.Color;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.lesson_7_0326.R;

public class OptionAndContextMenuActivity extends AppCompatActivity {

    LinearLayout baseLinearLayout;
    ImageView ivShowImage;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_option_and_context_menu);

        baseLinearLayout = (LinearLayout)findViewById(R.id.option_and_context_base_layout);
        ivShowImage = (ImageView)findViewById(R.id.iv_show_image);

        registerForContextMenu(ivShowImage);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.practice_option_menu, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){
            case R.id.item_movie:
                ivShowImage.setImageResource(R.drawable.movie1);
                return true;
            case R.id.item_animation:
                ivShowImage.setImageResource(R.drawable.animation1);
                return true;
        }

        return false;
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        MenuInflater menuInflater = getMenuInflater();
        // TODO : 이미지별 컨텍스트 메뉴

    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.item_movie1:
                ivShowImage.setImageResource(R.drawable.movie1);
                return true;
            case R.id.item_movie2:
                ivShowImage.setImageResource(R.drawable.movie2);
                return true;
            case R.id.item_movie3:
                ivShowImage.setImageResource(R.drawable.movie3);
                return true;
            case R.id.item_movie4:
                ivShowImage.setImageResource(R.drawable.movie4);
                return true;
            case R.id.item_animation1:
                ivShowImage.setImageResource(R.drawable.animation1);
                return true;
            case R.id.item_animation2:
                ivShowImage.setImageResource(R.drawable.animation2);
                return true;
            case R.id.item_animation3:
                ivShowImage.setImageResource(R.drawable.animation3);
                return true;
            case R.id.item_animation4:
                ivShowImage.setImageResource(R.drawable.animatioin4);
                return true;

        }
        return false;
    }
}
