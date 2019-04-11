package com.example.final_project.fragment;


import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.final_project.Model.UserModel;
import com.example.final_project.R;
import com.example.final_project.adapter.friend.FriendFragmentAdapter;
import com.example.final_project.db.DBHelper;

import java.util.ArrayList;

public class FriendTabFragment extends Fragment {

    private ArrayList<UserModel> userModelArrayList;
    private FriendFragmentAdapter friendFragmentAdapter;
    private RecyclerView friendFragmentRecyclerView;

    private DBHelper dbHelper;
    private SQLiteDatabase sqLiteDatabase;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_friend_tab, container, false);

        dbHelper = new DBHelper(inflater.getContext());
        getFriendList();
        initView(view, inflater.getContext());

        return view;

    }

    private void getFriendList() {
        sqLiteDatabase = dbHelper.getReadableDatabase();
        Cursor cursor;
        cursor = sqLiteDatabase.rawQuery("SELECT * FROM friend_list;", null);

        while (cursor.moveToNext()) {
            UserModel userModel = new UserModel(cursor.getString(0),
                    cursor.getString(1));
            userModelArrayList.add(userModel);
        }

        cursor.close();
        sqLiteDatabase.close();
    }

    void initView(View view, Context context) {

        userModelArrayList = new ArrayList<>();

        // 초기화 때 , 추가하는 방법
        //userModelArrayList.add(new UserModel("test2", "test2@test.com"));
        //userModelArrayList.add(new UserModel("test2", "test2@test.com"));


        friendFragmentAdapter = new FriendFragmentAdapter(userModelArrayList, getContext());

        friendFragmentRecyclerView = view.findViewById(R.id.recycler_view_friend_list);
        friendFragmentRecyclerView.setLayoutManager(new LinearLayoutManager(context));
        friendFragmentRecyclerView.setAdapter(friendFragmentAdapter);

        friendFragmentAdapter.notifyDataSetChanged();

    }


}
