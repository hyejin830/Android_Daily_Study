package com.example.final_project.adapter.friend;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.final_project.Model.UserModel;
import com.example.final_project.R;
import com.example.final_project.chat.ChattingActivity;

import java.util.ArrayList;

public class FriendFragmentAdapter extends RecyclerView.Adapter<FriendFragmentAdapter.FriendFragmentViewHolder> {

    private ArrayList<UserModel> userModelArrayList;
    private Context context;

    private ArrayList<String> toEmailArrayList = new ArrayList<>();

    public FriendFragmentAdapter(ArrayList<UserModel> list, Context context) {
        this.userModelArrayList = list;
        this.context = context;
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
    public void onBindViewHolder(@NonNull FriendFragmentViewHolder friendFragmentViewHolder, final int position) {

        toEmailArrayList.add(userModelArrayList.get(position).getUserEmail());

        friendFragmentViewHolder.userEmail.setText(userModelArrayList.get(position).getUserEmail());
        friendFragmentViewHolder.userName.setText(userModelArrayList.get(position).getUserName());
        friendFragmentViewHolder.getAdapterPosition();

        friendFragmentViewHolder.itemView.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent startChattingActivityIntent = new Intent(context, ChattingActivity.class);
                startChattingActivityIntent.putExtra(context.getString(R.string.select_to_email), toEmailArrayList.get(position));
                context.startActivity(startChattingActivityIntent);
            }
        });

    }


    @Override
    public int getItemCount() {
        return (null != userModelArrayList ? userModelArrayList.size() : 0);
    }
}
