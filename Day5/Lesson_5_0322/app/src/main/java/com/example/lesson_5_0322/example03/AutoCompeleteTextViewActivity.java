package com.example.lesson_5_0322.example03;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.MultiAutoCompleteTextView;

import com.example.lesson_5_0322.R;

public class AutoCompeleteTextViewActivity extends AppCompatActivity {

    AutoCompleteTextView autoCompleteTextView; // 자동완성텍스트뷰
    MultiAutoCompleteTextView multiAutoCompleteTextView; // 멀티자동완성텍스트뷰

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auto_compelete_text_view);

        // 자동완성텍스트뷰, 멀티자동완성텍스트뷰 예제
        String[] items = {"Avengers1","Avengers2","iron man","iron man2"};
        autoCompleteTextView = (AutoCompleteTextView)findViewById(R.id.tv_auto_complete);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line, items);
        autoCompleteTextView.setAdapter(adapter);

        multiAutoCompleteTextView = (MultiAutoCompleteTextView)findViewById(R.id.tv_multi_auto_complete);
        MultiAutoCompleteTextView.CommaTokenizer token = new MultiAutoCompleteTextView.CommaTokenizer();
        multiAutoCompleteTextView.setTokenizer(token);
        multiAutoCompleteTextView.setAdapter(adapter);
    }
}
