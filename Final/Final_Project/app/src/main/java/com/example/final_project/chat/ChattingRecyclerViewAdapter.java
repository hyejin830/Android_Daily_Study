package com.example.final_project.chat;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.final_project.Model.MessageModel;
import com.example.final_project.R;

import java.util.ArrayList;

public class ChattingRecyclerViewAdapter extends RecyclerView.Adapter<ChattingRecyclerViewAdapter.ChattingViewHolder> {

    private ArrayList<MessageModel> messageModels;
    private String email_account;


    public ChattingRecyclerViewAdapter(ArrayList<MessageModel> messageModels, String email_account) {
        this.messageModels = messageModels;
        this.email_account = email_account;
    }

    public class ChattingViewHolder extends RecyclerView.ViewHolder {

        TextView fromNameTextView;
        TextView messageTextView;
        LinearLayout messageItemDestinationLinearLayout;

        public ChattingViewHolder(@NonNull View view) {
            super(view);

            this.fromNameTextView = view.findViewById(R.id.tv_message_item_name);
            this.messageTextView = view.findViewById(R.id.tv_message_item_message);
            this.messageItemDestinationLinearLayout = view.findViewById(R.id.linear_layout_message_item_destination);
        }
    }

    @NonNull
    @Override
    public ChattingViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {

        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.item_chat, viewGroup, false);
        ChattingViewHolder messageViewHolder = new ChattingViewHolder(view);

        return messageViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ChattingViewHolder messageViewHolder, int position) {
        if (messageModels.get(position).getUserName().equals(email_account)) {
            messageViewHolder.messageTextView.setBackgroundResource(R.drawable.rightbubble);
            messageViewHolder.fromNameTextView.setText(messageModels.get(position).getUserName());
            messageViewHolder.messageTextView.setText(messageModels.get(position).getMessage());
            LinearLayout.LayoutParams layoutParams =
                    new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
            layoutParams.gravity = Gravity.RIGHT;
            messageViewHolder.messageItemDestinationLinearLayout.setLayoutParams(layoutParams);
        } else {
            messageViewHolder.messageTextView.setBackgroundResource(R.drawable.leftbubble);
            messageViewHolder.fromNameTextView.setText(messageModels.get(position).getUserName());
            messageViewHolder.messageTextView.setText(messageModels.get(position).getMessage());
            LinearLayout.LayoutParams layoutParams =
                    new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
            layoutParams.gravity = Gravity.LEFT;
            messageViewHolder.messageItemDestinationLinearLayout.setLayoutParams(layoutParams);
        }
    }

    @Override
    public int getItemCount() {
        return (null != messageModels ? messageModels.size() : 0);
    }

}
