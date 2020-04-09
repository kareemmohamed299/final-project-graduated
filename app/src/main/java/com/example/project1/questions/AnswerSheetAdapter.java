package com.example.project1.questions;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.project1.R;
import com.example.project1.connection.exam;

import java.util.ArrayList;

public class AnswerSheetAdapter extends RecyclerView.Adapter<AnswerSheetAdapter.MyViewHolder> {
    ArrayList<exam> examdatas ;
    public AnswerSheetAdapter(ArrayList<exam> questionList)
    {
        this.examdatas= questionList;
    }


    public class MyViewHolder extends RecyclerView.ViewHolder{

        View question_item;
        public MyViewHolder(@NonNull View itemView){
            super(itemView);
            question_item = itemView.findViewById(R.id.question_item);
        }
    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.answer_sheet_item,parent,false);
        return new MyViewHolder(itemView);
    }
    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

            holder.question_item.setBackgroundResource(R.color.white);
    }
    @Override
    public int getItemCount() {
        return examdatas.size();
    }






}
