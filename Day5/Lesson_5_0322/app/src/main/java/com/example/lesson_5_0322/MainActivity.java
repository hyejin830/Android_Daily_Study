package com.example.lesson_5_0322;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Button;

import com.example.lesson_5_0322.example01.WidgetExampleActivity;
import com.example.lesson_5_0322.example02.ReservationTimeActivity;
import com.example.lesson_5_0322.example03.AutoCompeleteTextViewActivity;
import com.example.lesson_5_0322.example04.MovieRatingActivity;
import com.example.lesson_5_0322.example04.PracticeBarActivity;
import com.example.lesson_5_0322.example05.ScrollViewActivity;
import com.example.lesson_5_0322.example06.SlidingDrawerActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button goWidgetExample;
    Button goReservationTime;
    Button goAutoCompleteTextView;
    Button goPracticeBar;
    Button goMovieRating;
    Button goScrollView;
    Button goSlidingDrawer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        goWidgetExample = (Button)findViewById(R.id.btn_widget);
        goReservationTime = (Button)findViewById(R.id.btn_time_resevation);
        goAutoCompleteTextView = (Button)findViewById(R.id.btn_auto_textview);
        goPracticeBar = (Button)findViewById(R.id.btn_bar);
        goMovieRating = (Button)findViewById(R.id.btn_rating_movie);
        goScrollView = (Button)findViewById(R.id.btn_scrollview);
        goSlidingDrawer = (Button)findViewById(R.id.btn_sliding_drawer);

        goWidgetExample.setOnClickListener(this);
        goReservationTime.setOnClickListener(this);
        goAutoCompleteTextView.setOnClickListener(this);
        goPracticeBar.setOnClickListener(this);
        goMovieRating.setOnClickListener(this);
        goScrollView.setOnClickListener(this);
        goSlidingDrawer.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_widget:
                Intent intentWidget = new Intent(MainActivity.this, WidgetExampleActivity.class);
                startActivity(intentWidget);
                break;
            case R.id.btn_time_resevation:
                Intent intentTimeReservation = new Intent(MainActivity.this, ReservationTimeActivity.class);
                startActivity(intentTimeReservation);
                break;
            case R.id.btn_auto_textview:
                Intent intentAutoTextView = new Intent(MainActivity.this, AutoCompeleteTextViewActivity.class);
                startActivity(intentAutoTextView);
                break;
            case R.id.btn_bar:
                Intent intentPracticeBar = new Intent(MainActivity.this, PracticeBarActivity.class);
                startActivity(intentPracticeBar);
                break;
            case R.id.btn_rating_movie:
                Intent intentRatingMovie = new Intent(MainActivity.this, MovieRatingActivity.class);
                startActivity(intentRatingMovie);
                break;
            case R.id.btn_scrollview:
                Intent intentScrollView= new Intent(MainActivity.this, ScrollViewActivity.class);
                startActivity(intentScrollView);
                break;
            case R.id.btn_sliding_drawer:
                Intent intentSlidingDrawer = new Intent(MainActivity.this, SlidingDrawerActivity.class);
                startActivity(intentSlidingDrawer);
                break;
        }
    }
}
