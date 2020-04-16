package com.example.project1.professor;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.project1.R;

public class course_info_prof extends AppCompatActivity {

    CardView cardView1 , cardView2 , cardView3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.course_info_prof);

        cardView1 = (CardView)findViewById(R.id.card1);
        cardView1.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) {
                Intent myIntent = new Intent(course_info_prof.this, students_enrolled.class);
                startActivity(myIntent);
            }
        });
    }
}
