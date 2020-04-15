package com.example.project1.professor;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.project1.R;

import com.example.project1.connection.doctor_course;

import java.util.ArrayList;


public class courses_demo_prof extends Fragment {


    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    RecyclerView.Adapter adapter;
    public ArrayList<doctor_course> course;
    public courses_demo_prof() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.courses_demo_prof, container, false);
        course = new ArrayList<doctor_course>();
        assert this.getArguments() != null;
        course = this.getArguments().getParcelableArrayList("course");
        recyclerView =
                (RecyclerView) rootView.findViewById(R.id.recycler_view);

        layoutManager = new GridLayoutManager(courses_demo_prof.this.getActivity(),2);
        recyclerView.setLayoutManager(layoutManager);

        adapter = new coursesAdapter(course , courses_demo_prof.this.getActivity());
        recyclerView.setAdapter(adapter);

        return rootView;

    }



}

