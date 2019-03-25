package com.example.lesson_5_0322;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Chronometer;
import android.widget.DatePicker;
import android.widget.MultiAutoCompleteTextView;
import android.widget.RadioButton;
import android.widget.RatingBar;
import android.widget.TimePicker;

public class MainActivity extends AppCompatActivity {


    AutoCompleteTextView auto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

/*
        // 자동완성텍스트뷰, 멀티자동완성텍스트뷰 예제
        String[] items = {"Avengers1","Avengers2","iron man","iron man2"};
        auto = (AutoCompleteTextView)findViewById(R.id.autoCompleteTextView1);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line, items);
        auto.setAdapter(adapter);

        MultiAutoCompleteTextView multi = (MultiAutoCompleteTextView)findViewById(R.id.multiautoCompleteTextView);
        MultiAutoCompleteTextView.CommaTokenizer token = new MultiAutoCompleteTextView.CommaTokenizer();
        multi.setTokenizer(token);
        multi.setAdapter(adapter);
*/

/*
        RatingBar ratingBar = (RatingBar)findViewById(R.id.ratingbar);
        float numStars = ratingBar.getRating();
*/

    }
}
