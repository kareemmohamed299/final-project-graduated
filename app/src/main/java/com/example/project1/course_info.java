package com.example.project1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import android.widget.TextView;
import android.view.View;
import android.widget.Button;

import com.example.project1.questions.question;

import java.util.ArrayList;

public class course_info extends AppCompatActivity {
    ArrayList<String> c;
    private TextView course,professor,Duration,Exam_Start,Exam_End,Degree;
    private Button button ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.course_info);
        c = getIntent().getStringArrayListExtra("c");
        course=(TextView)findViewById(R.id.t1);
        professor=(TextView)findViewById(R.id.t2);
        Duration=(TextView)findViewById(R.id.t3);
        Exam_Start=(TextView)findViewById(R.id.t4);
        Exam_End=(TextView)findViewById(R.id.t5);
        Degree=(TextView)findViewById(R.id.t6);
        course.setText(c.get(4));
        professor.setText(c.get(5));
        Duration.setText(c.get(0));
        Exam_Start.setText(c.get(1));
        Exam_End.setText(c.get(2));
        Degree.setText(c.get(3));

        button = (Button)findViewById(R.id.button2);
        button.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(course_info.this, question.class);
                startActivity(myIntent);
            }
        });
    }
}