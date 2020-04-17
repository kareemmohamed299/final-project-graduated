package com.example.project1.correction;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;

import com.example.project1.R;
import com.example.project1.connection.match;

public class show_match_answer extends AppCompatActivity {
    match matchdata;
    private SharedPreferences answer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.show_match_answer);
        matchdata=getIntent().getParcelableExtra("match");
    }
}
