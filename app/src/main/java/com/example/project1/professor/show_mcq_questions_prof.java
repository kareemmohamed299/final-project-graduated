package com.example.project1.professor;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.project1.R;
import com.example.project1.connection.questiondoctor;

import java.util.ArrayList;

public class show_mcq_questions_prof extends AppCompatActivity {
    questiondoctor questiondata;
    TextView question_text , choice , choice2 , choice3 , choice4 , choice5;
    CardView c1,c2,c3,c4,c5;
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
        c1=(CardView)findViewById(R.id.cardview_cho1);
        c2=(CardView)findViewById(R.id.cardview_cho2);
        c3=(CardView)findViewById(R.id.cardview_cho3);
        c4=(CardView)findViewById(R.id.cardview_cho4);
        c5=(CardView)findViewById(R.id.cardview_cho5);
        questiondata=new questiondoctor();
        questiondata=getIntent().getParcelableExtra("question_doctor");
        question_text.setText(questiondata.getQ_text());
        if(questiondata.getChoices().size()==5)
        {
            choice.setText(questiondata.getChoices().get(0));
            choice2.setText(questiondata.getChoices().get(1));
            choice2.setText(questiondata.getChoices().get(2));
            choice2.setText(questiondata.getChoices().get(3));
            choice2.setText(questiondata.getChoices().get(4));
            if(questiondata.getChoices().get(0).equals(questiondata.getAnswer_text())) {
                c1.setCardBackgroundColor(Color.parseColor("#00D152"));
            }
            else if(questiondata.getChoices().get(1).equals(questiondata.getAnswer_text())) {
                c2.setCardBackgroundColor(Color.parseColor("#00D152"));
            }
            else if(questiondata.getChoices().get(2).equals(questiondata.getAnswer_text())) {
                c3.setCardBackgroundColor(Color.parseColor("#00D152"));
            }
            else if(questiondata.getChoices().get(3).equals(questiondata.getAnswer_text())) {
                c4.setCardBackgroundColor(Color.parseColor("#00D152"));
            }
            else if(questiondata.getChoices().get(4).equals(questiondata.getAnswer_text())) {
                c5.setCardBackgroundColor(Color.parseColor("#00D152"));
            }
        }
        else if(questiondata.getChoices().size()==4)
        {
            choice.setText(questiondata.getChoices().get(0));
            choice2.setText(questiondata.getChoices().get(1));
            choice3.setText(questiondata.getChoices().get(2));
            choice4.setText(questiondata.getChoices().get(3));
            if(questiondata.getChoices().get(0).equals(questiondata.getAnswer_text())) {
                c1.setCardBackgroundColor(Color.parseColor("#00D152"));
            }
            else if(questiondata.getChoices().get(1).equals(questiondata.getAnswer_text())) {
                c2.setCardBackgroundColor(Color.parseColor("#00D152"));
            }
            else if(questiondata.getChoices().get(2).equals(questiondata.getAnswer_text())) {
                c3.setCardBackgroundColor(Color.parseColor("#00D152"));
            }
            else if(questiondata.getChoices().get(3).equals(questiondata.getAnswer_text())) {
                c4.setCardBackgroundColor(Color.parseColor("#00D152"));
            }
            else if(questiondata.getChoices().get(4).equals(questiondata.getAnswer_text())) {
                c5.setCardBackgroundColor(Color.parseColor("#00D152"));
            }
            c5.setVisibility(View.INVISIBLE);

        }
        else if(questiondata.getChoices().size()==3)
        {
            choice.setText(questiondata.getChoices().get(0));
            choice2.setText(questiondata.getChoices().get(1));
            choice3.setText(questiondata.getChoices().get(2));
            if(questiondata.getChoices().get(0).equals(questiondata.getAnswer_text())) {
                c1.setCardBackgroundColor(Color.parseColor("#00D152"));
            }
            else if(questiondata.getChoices().get(1).equals(questiondata.getAnswer_text())) {
                c2.setCardBackgroundColor(Color.parseColor("#00D152"));
            }
            else if(questiondata.getChoices().get(2).equals(questiondata.getAnswer_text())) {
                c3.setCardBackgroundColor(Color.parseColor("#00D152"));
            }
            c4.setVisibility(View.INVISIBLE);
            c5.setVisibility(View.INVISIBLE);
        }
        else
        {
            choice.setText(questiondata.getChoices().get(0));
            choice2.setText(questiondata.getChoices().get(1));
            if(questiondata.getChoices().get(0).equals(questiondata.getAnswer_text())) {
                c1.setCardBackgroundColor(Color.parseColor("#00D152"));
            }
            else if(questiondata.getChoices().get(1).equals(questiondata.getAnswer_text())) {
                c2.setCardBackgroundColor(Color.parseColor("#00D152"));
            }
            c3.setVisibility(View.INVISIBLE);
            c4.setVisibility(View.INVISIBLE);
            c5.setVisibility(View.INVISIBLE);
        }
    }
}
