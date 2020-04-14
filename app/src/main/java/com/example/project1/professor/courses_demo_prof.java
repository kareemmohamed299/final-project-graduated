package com.example.project1.professor;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.project1.R;


public class courses_demo_prof extends Fragment {


    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    RecyclerView.Adapter adapter;

    public courses_demo_prof() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.courses_demo_prof, container, false);
        recyclerView =
                (RecyclerView) rootView.findViewById(R.id.recycler_view);

        layoutManager = new GridLayoutManager(courses_demo_prof.this.getActivity(),2);
        recyclerView.setLayoutManager(layoutManager);

        adapter = new coursesAdapter();
        recyclerView.setAdapter(adapter);

        return rootView;

    }



}

