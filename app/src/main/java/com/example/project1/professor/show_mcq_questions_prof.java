package com.example.project1.professor;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.project1.R;
import com.example.project1.connection.questiondoctor;

import java.util.ArrayList;

public class show_mcq_questions_prof extends AppCompatActivity {
    //private ArrayList<questiondoctor> qes_doctor = new ArrayList<>();
    Bundle questiondoctor;
    TextView question_text , choice , choice2 , choice3 , choice4 , choice5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.show_mcq_questions_prof);

        question_text=(TextView)findViewById(R.id.question_txt);
        choice = (TextView)findViewById(R.id.choice_text);
        choice2 =(TextView)findViewById(R.id.choice_text2);
        choice3 =(TextView)findViewById(R.id.choice_text3);
        choice4=(TextView)findViewById(R.id.choice_text4);
        choice5=(TextView)findViewById(R.id.choice_text5);

            //question_text.setText("qes_doctor.get(0).getQ_text()");
           // choice.setText(qes_doctor.get(i).getChoices().get(i));



    }
}
