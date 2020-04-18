package com.example.project1.professor;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.project1.R;
import com.example.project1.connection.questiondoctor;

import java.util.ArrayList;

public class type_questions extends AppCompatActivity {

    CardView cardView1 , cardView2 , cardView3;
    private ArrayList<questiondoctor> qes_doctor = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.type_questions);
        qes_doctor = getIntent().getParcelableArrayListExtra("question_doctor");
        cardView1 = (CardView)findViewById(R.id.card_mcq);
        cardView2 = (CardView)findViewById(R.id.card_match);
        cardView3 = (CardView)findViewById(R.id.card_complete);
        cardView1.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) {
                Intent myIntent = new Intent(type_questions.this, show_heads.class);
                myIntent.putParcelableArrayListExtra("question_doctor" , qes_doctor);
                startActivity(myIntent);
            }
        });
    }
}
