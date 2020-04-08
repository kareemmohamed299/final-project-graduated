package com.example.project1.questions;



import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import com.example.project1.R;


public class mcq_question extends Fragment {

    TextView question_txt ;

    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    RecyclerView.Adapter adapter2;



    public mcq_question() {

    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View itemView = inflater.inflate(R.layout.mcq_question, container, false);


        question_txt = itemView.findViewById(R.id.question_txt);

        recyclerView = (RecyclerView) itemView.findViewById(R.id.recycler_view);
        layoutManager = new GridLayoutManager(mcq_question.this.getActivity(),1);
        recyclerView.setLayoutManager(layoutManager);
        adapter2 = new choiceAdapter();
        recyclerView.setAdapter(adapter2);

        return itemView;
    }}

