package com.example.lesson_15_0405.adapter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import com.example.lesson_15_0405.Model.UserModel;
import com.example.lesson_15_0405.R;

import java.util.ArrayList;

public class AdapterExampleActivity extends AppCompatActivity implements View.OnClickListener {

    private ArrayList<UserModel> userModelArrayList;
    private AdapterExample exampleAdapter;
    private RecyclerView exampleRecyclerView;
    private LinearLayoutManager linearLayoutManager;
    private Button userInsertButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adapter_example);

        initView();
    }

    void initView() {

        userModelArrayList = new ArrayList<>();
        exampleAdapter = new AdapterExample(userModelArrayList);
        linearLayoutManager = new LinearLayoutManager(this);


        exampleRecyclerView = findViewById(R.id.recycler_view_main_list);

        exampleRecyclerView.setLayoutManager(linearLayoutManager);
        exampleRecyclerView.setAdapter(exampleAdapter);


        userInsertButton = findViewById(R.id.btn_main_list);
        userInsertButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_main_list:
                UserModel userModel = new UserModel("test", "test");
                userModelArrayList.add(userModel);

                exampleAdapter.notifyDataSetChanged();
                break;
        }
    }
}
