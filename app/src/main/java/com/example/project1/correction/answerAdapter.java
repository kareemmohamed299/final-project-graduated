package com.example.project1.correction;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.project1.R;
import com.google.android.material.snackbar.Snackbar;


public class answerAdapter extends RecyclerView.Adapter<answerAdapter.ViewHolder>  {



    private String[] questions = {"Question 1",
            "Question 2",
            "Question 3",
            "Question 4",
            "Question 5", "Question 6","Question 7","Question 8","Question 9","Question 10"
    };

    private String[] ans = {"right",
            "right",
            "right",
            "right",
            "wrong", "right","right","right","wrong","right"
    };

    private Context aContext;
    answerAdapter(Context context)
    {
        aContext=context;
    }


    class ViewHolder extends RecyclerView.ViewHolder{
        private TextView question_num;
        private CardView card_view;

        public ViewHolder(View itemView) {
            super(itemView);
            question_num = (TextView)itemView.findViewById(R.id.question);
            card_view = (CardView) itemView.findViewById(R.id.card_view_answer);

        }
    }




    @NonNull
    @Override
    public answerAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.answer_item,parent, false);
        ViewHolder viewHolder = new ViewHolder(v);


        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull answerAdapter.ViewHolder holder, int position) {

        holder.question_num.setText(questions[position]);

        if(ans[position]=="right")
            holder.card_view.setCardBackgroundColor(Color.parseColor("#00D152"));
        else
            holder.card_view.setCardBackgroundColor(Color.parseColor("#F83D33"));


        holder.card_view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent1 = new Intent(aContext,show_mcq_answer.class);
                aContext.startActivity(myIntent1);
            }
        });

    }

    @Override
    public int getItemCount() {
        return questions.length;
    }
}
