package com.example.project1.questions;



import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import com.example.project1.R;


public class mcq_question extends Fragment {

    TextView question_txt ;
    CheckBox ckbA,ckbB,ckbC,ckbD;


    public mcq_question() {

    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View itemView = inflater.inflate(R.layout.mcq_question, container, false);


        question_txt = itemView.findViewById(R.id.question_txt);
        ckbA = itemView.findViewById(R.id.ckbA);
        ckbB = itemView.findViewById(R.id.ckbB);
        ckbC = itemView.findViewById(R.id.ckbC);
        ckbD = itemView.findViewById(R.id.ckbD);



        return itemView;
    }}

