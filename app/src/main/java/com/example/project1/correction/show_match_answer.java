package com.example.project1.correction;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.project1.R;

public class show_match_answer extends AppCompatActivity {

    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    shownumatchAdapter shownumatchAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.show_match_answer);

        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        layoutManager = new GridLayoutManager(show_match_answer.this,1);
        recyclerView.setLayoutManager(layoutManager);
        shownumatchAdapter =new shownumatchAdapter();
        recyclerView.setAdapter(shownumatchAdapter);
    }
}
