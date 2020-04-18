package com.example.project1.correction;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.project1.R;
import com.example.project1.questions.complete_question;
import com.example.project1.questions.itemcompleteAdapter;

public class show_complete_answer extends AppCompatActivity {

    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    RecyclerView.Adapter adapter2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.show_complete_answer);

        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        layoutManager = new GridLayoutManager(show_complete_answer.this,1);
        recyclerView.setLayoutManager(layoutManager);
        adapter2 = new showitemcompleteAdapter();
        recyclerView.setAdapter(adapter2);
    }
}
