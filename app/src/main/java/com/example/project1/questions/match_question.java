package com.example.project1.questions;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.project1.R;

public class match_question extends Fragment {

    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    RecyclerView.Adapter adapter2;

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View itemView = inflater.inflate(R.layout.match_question, container, false);

        recyclerView = (RecyclerView) itemView.findViewById(R.id.recycler_view1);
        layoutManager = new GridLayoutManager(match_question.this.getActivity(),1);
        recyclerView.setLayoutManager(layoutManager);
        adapter2 = new numatchAdapter();
        recyclerView.setAdapter(adapter2);
        return itemView;
    }
}