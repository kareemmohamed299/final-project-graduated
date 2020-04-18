package com.example.project1.professor;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.project1.R;
import com.example.project1.connection.questiondoctor;
import com.example.project1.connection.student_doctor;

import java.util.ArrayList;

public class course_info_prof extends AppCompatActivity {

    CardView cardView1 , cardView2 , cardView3;
    public ArrayList<student_doctor> st_doctor = new ArrayList<>();
    private ArrayList<questiondoctor>qes_doctor = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.course_info_prof);
        st_doctor = getIntent().getParcelableArrayListExtra("student_doctor");
        qes_doctor = getIntent().getParcelableArrayListExtra("question_doctor");
        cardView1 = (CardView)findViewById(R.id.card1);
        cardView2 = (CardView)findViewById(R.id.card2);
        cardView1.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) {
                Intent myIntent = new Intent(course_info_prof.this, students_enrolled.class);
                myIntent.putParcelableArrayListExtra("student_doctor" , st_doctor);

                startActivity(myIntent);
            }
        });
        cardView2.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) {

                goquestion();
            }
        });
    }
    public  void goquestion()
    {
        Intent myIntent2 = new Intent(course_info_prof.this, type_questions.class);
        myIntent2.putParcelableArrayListExtra("question_doctor" , qes_doctor);
        startActivity(myIntent2);
    }
}
