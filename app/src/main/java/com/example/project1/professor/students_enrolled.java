package com.example.project1.professor;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.SearchView;

import com.example.project1.R;
import com.example.project1.connection.student_doctor;

import java.util.ArrayList;

public class students_enrolled extends AppCompatActivity {
    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    studentsAdapter studentsAdapter;
    public ArrayList<student_doctor> student_doctor ;
SearchView searchView;
    public students_enrolled() {
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.students_enrolled);
        student_doctor=getIntent().getParcelableArrayListExtra("student_doctor");
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        layoutManager = new GridLayoutManager(students_enrolled.this,1);
        recyclerView.setLayoutManager(layoutManager);
        searchView = (SearchView) findViewById(R.id.search_view);
        studentsAdapter = new studentsAdapter(student_doctor, students_enrolled.this);
        recyclerView.setAdapter(studentsAdapter );
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                studentsAdapter.getFilter().filter(newText);
                return false;
            }
        });

    }


}
