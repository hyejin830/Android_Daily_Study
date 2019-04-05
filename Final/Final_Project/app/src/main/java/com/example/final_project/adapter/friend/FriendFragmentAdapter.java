package com.example.final_project.adapter.friend;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.final_project.Model.UserModel;
import com.example.final_project.R;

import java.util.ArrayList;

public class FriendFragmentAdapter extends RecyclerView.Adapter<FriendFragmentAdapter.FriendFragmentViewHolder> {

    private ArrayList<UserModel> userModelArrayList;

    public FriendFragmentAdapter(ArrayList<UserModel> list) {
        this.userModelArrayList = list;
    }

    public class FriendFragmentViewHolder extends RecyclerView.ViewHolder {

        protected TextView userEmail;
        protected TextView userName;

        public FriendFragmentViewHolder(View view) {
            super(view);
            this.userEmail = view.findViewById(R.id.tv_friend_list_email);
            this.userName = view.findViewById(R.id.tv_friend_list_name);
        }
    }

    @NonNull
    @Override
    public FriendFragmentViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.fragment_item_friend, viewGroup, false);

        FriendFragmentViewHolder friendFragmentViewHolder = new FriendFragmentViewHolder(view);

        return friendFragmentViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull FriendFragmentViewHolder friendFragmentViewHolder, int position) {
        friendFragmentViewHolder.userEmail.setText(userModelArrayList.get(position).getUserEmail());
        friendFragmentViewHolder.userName.setText(userModelArrayList.get(position).getUserName());
    }

    @Override
    public int getItemCount() {
        return (null != userModelArrayList ? userModelArrayList.size() : 0);
    }
}
