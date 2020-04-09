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
import com.example.project1.connection.exam;

import java.util.ArrayList;


public class mcq_question extends Fragment {

    TextView question_txt ;

    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    RecyclerView.Adapter adapter2;
    exam examdata ;
    public mcq_question() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View itemView = inflater.inflate(R.layout.mcq_question, container, false);
        examdata=new exam();
        assert this.getArguments() != null;
        examdata = this.getArguments().getParcelable("ex");
        question_txt = itemView.findViewById(R.id.question_txt);
        question_txt.setText(examdata.getQ_text());
        recyclerView = (RecyclerView) itemView.findViewById(R.id.recycler_view);
        layoutManager = new GridLayoutManager(mcq_question.this.getActivity(),1);
        recyclerView.setLayoutManager(layoutManager);
        adapter2 = new choiceAdapter(examdata);
        recyclerView.setAdapter(adapter2);

        return itemView;
    }}

