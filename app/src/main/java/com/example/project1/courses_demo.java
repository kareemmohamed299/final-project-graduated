package com.example.project1;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.project1.connection.cource;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class courses_demo extends Fragment {
    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    RecyclerView.Adapter adapter;
   ArrayList<cource>coursedata;
    public courses_demo() {
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.courses_demo, container, false);
coursedata = new ArrayList<>();
        assert this.getArguments() != null;
        coursedata = this.getArguments().getParcelableArrayList("course");
        recyclerView = (RecyclerView) rootView.findViewById(R.id.recycler_view);
        layoutManager = new GridLayoutManager(courses_demo.this.getActivity(),2);
        recyclerView.setLayoutManager(layoutManager);
        adapter = new RecyclerAdapter(coursedata,courses_demo.this.getActivity());
        recyclerView.setAdapter(adapter);
        return rootView;
    }
}
