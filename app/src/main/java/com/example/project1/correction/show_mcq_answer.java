package com.example.project1.correction;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.project1.R;

public class show_mcq_answer extends AppCompatActivity {


    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    RecyclerView.Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.show_mcq_answer);

        recyclerView =
                (RecyclerView) findViewById(R.id.recycler_view);

        layoutManager = new GridLayoutManager(this,1);
        recyclerView.setLayoutManager(layoutManager);

        adapter = new choiceAdapterOfShowMcq();
        recyclerView.setAdapter(adapter);
    }
}
