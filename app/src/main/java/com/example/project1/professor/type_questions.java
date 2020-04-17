package com.example.project1.professor;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.project1.R;

public class type_questions extends AppCompatActivity {

    CardView cardView1 , cardView2 , cardView3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.type_questions);

        cardView1 = (CardView)findViewById(R.id.card_mcq);
        cardView2 = (CardView)findViewById(R.id.card_match);
        cardView3 = (CardView)findViewById(R.id.card_complete);
        cardView1.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) {
                Intent myIntent = new Intent(type_questions.this, show_heads.class);
                startActivity(myIntent);
            }
        });
    }
}
