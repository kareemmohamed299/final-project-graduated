package com.example.project1.correction;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.project1.R;
import com.example.project1.connection.exam;

public class show_mcq_answer extends AppCompatActivity {
    exam examdata ;
    private SharedPreferences answer;
    private CardView card_view1,card_view2;
    public TextView q,stud_ans,true_ans;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.show_mcq_answer);
        answer=getSharedPreferences("answers", Context.MODE_PRIVATE);
        examdata=getIntent().getParcelableExtra("ex");
        card_view1 = (CardView)findViewById(R.id.cardview_cho1);
        card_view2 = (CardView)findViewById(R.id.cardview_cho2);
        q=(TextView)findViewById(R.id.question_txt);
        true_ans=(TextView)findViewById(R.id.choice_text);
        stud_ans=(TextView)findViewById(R.id.choice_text2);
        q.setText(examdata.getQ_text());
        if(examdata.getAnswer_text().equals(answer.getString(examdata.getId(),"NO choice"))) {
            true_ans.setText(answer.getString(examdata.getId(), "k"));
            card_view1.setCardBackgroundColor(Color.parseColor("#00D152"));
            card_view2.setVisibility(View.INVISIBLE);
        }
        else
        {
            true_ans.setText(examdata.getAnswer_text());
            stud_ans.setText(answer.getString(examdata.getId(), "NO choice"));
            card_view1.setCardBackgroundColor(Color.parseColor("#00D152"));
            card_view2.setCardBackgroundColor(Color.parseColor("#F83D33"));
        }
    }
}
