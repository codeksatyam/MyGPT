package com.example.mygpt;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MessageAdapter extends RecyclerView.Adapter<MessageAdapter.MyViewHolder> {

     List<Message> messageList;
    private ViewGroup root;

    public MessageAdapter(List<Message>messageList) {
        this.messageList=messageList;
    }

    @NonNull
    @Override
    public MessageAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View chatView = LayoutInflater.from(parent.getContext()).inflate(R.layout.chat_item, null);

        MyViewHolder myViewHolder= new MyViewHolder(chatView);
        return myViewHolder;

    }

    @Override
    public void onBindViewHolder(@NonNull MessageAdapter.MyViewHolder holder, int position) {
        Message message =messageList.get(position);
        if (message.getSentBy().equals(Message.SENT_BY_ME)){
            holder.leftChatViewe.setVisibility(View.GONE);
            holder.rightChatView.setVisibility(View.VISIBLE);
            holder.rightTextView.setText(message.getMessage());

        }else {
            holder.rightChatView.setVisibility(View.GONE);
            holder.leftChatViewe.setVisibility(View.VISIBLE);
            holder.leftTextView.setText(message.getMessage());

        }



    }

    @Override
    public int getItemCount() {
        return messageList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        LinearLayout leftChatViewe,rightChatView;
        TextView leftTextView,rightTextView;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            leftChatViewe=itemView.findViewById(R.id.Left_chat_view);
            rightChatView=itemView.findViewById(R.id.right_chat_view);
            leftTextView=itemView.findViewById(R.id.Left_chat_text_view);
            rightTextView=itemView.findViewById(R.id.right_chat_text_view);
        }



}
}
