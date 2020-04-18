package com.example.project1.correction;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.example.project1.R;
import com.example.project1.connection.match;

public class show_match_answer extends AppCompatActivity {

    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    shownumatchAdapter shownumatchAdapter;
    match matchdata;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.show_match_answer);
        matchdata=getIntent().getParcelableExtra("match");
        Log.d("kkkkkkkk",String.valueOf(matchdata.getQuestions().size()));
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        layoutManager = new GridLayoutManager(show_match_answer.this,1);
        recyclerView.setLayoutManager(layoutManager);
        shownumatchAdapter =new shownumatchAdapter(matchdata,show_match_answer.this);
        recyclerView.setAdapter(shownumatchAdapter);
    }
}
