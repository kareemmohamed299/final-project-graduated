package com.example.project1.professor;

import android.content.Context;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.project1.R;

import java.util.ArrayList;

public class studentsAdapter extends RecyclerView.Adapter<studentsAdapter.ViewHolder> {




    private String[] names= { "Mohamed Ashraf Mohamed","Kareem Mohamed Mostafa","Mahmoud Essam Mohamed","Youssef Mohamed Fawzy","Mohamed Ibrahim Ahmed"
    ,"Hussam Abd Elfatah Mohamed","Toni Mohamed Mostafa","Khaled Essam Mohamed","Abanob Mohamed Fawzy","Mohamed Ibrahim Ahmed"};

    private String[] prog= { "Computer Science","Math/CS","Stat/CS","Math/CS","Stat/CS"
            ,"Computer Science","Computer Science","Math/CS","Stat/CS","Stat/CS"};
    private String[] deg= { "10/10","5/10","0/10","3/10","1/10"
            ,"8/10","6/10","4/10","2/10","5/10"};

    class ViewHolder extends RecyclerView.ViewHolder{

        public TextView name ,pro ,de;


        public ViewHolder(View itemView) {
            super(itemView);
            name = (TextView)itemView.findViewById(R.id.txt_name);
             pro = (TextView)itemView.findViewById(R.id.txt_program);
            de = (TextView)itemView.findViewById(R.id.txt_degree);
        }
    }

    @Override
    public studentsAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.student_layout, viewGroup, false);
        studentsAdapter.ViewHolder viewHolder = new studentsAdapter.ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(studentsAdapter.ViewHolder viewHolder, int i) {

        viewHolder.name.setText(names[i]);
        viewHolder.pro.setText(prog[i]);
        viewHolder.de.setText(deg[i]);

    }

    @Override
    public int getItemCount() {
        return names.length;
    }
}

