package com.example.lesson_15_0405.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.lesson_15_0405.Model.UserModel;
import com.example.lesson_15_0405.R;

import java.util.ArrayList;

public class AdapterExample extends RecyclerView.Adapter<AdapterExample.ViewHolderExample> {

    private ArrayList<UserModel> userModelArrayList;

    public AdapterExample(ArrayList<UserModel> list) {
        this.userModelArrayList = list;
    }

    public class ViewHolderExample extends RecyclerView.ViewHolder {

        protected TextView userEmail;
        protected TextView userName;

        public ViewHolderExample(View view) {
            super(view);
            this.userEmail = view.findViewById(R.id.tv_list_email);
            this.userName = view.findViewById(R.id.tv_list_name);
        }
    }

    @NonNull
    @Override
    public ViewHolderExample onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.main_list_item, viewGroup, false);

        return new ViewHolderExample(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderExample viewHolderExample, int position) {
        viewHolderExample.userEmail.setText(userModelArrayList.get(position).getUserEmail());
        viewHolderExample.userName.setText(userModelArrayList.get(position).getUserName());
    }

    @Override
    public int getItemCount() {
        return (null != userModelArrayList ? userModelArrayList.size() : 0);
    }


}
