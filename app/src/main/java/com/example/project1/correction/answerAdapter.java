package com.example.project1.correction;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import com.example.project1.R;
import com.example.project1.connection.exam;
import com.example.project1.connection.match;

import java.util.ArrayList;
public class answerAdapter extends RecyclerView.Adapter<answerAdapter.ViewHolder>  {
    private Context context;
    ArrayList<exam> mcqdata ;
    ArrayList<match>matchdata  ;
    private double degree;
    private SharedPreferences match_question,mcq_question;
    public answerAdapter(ArrayList<exam> e, ArrayList<match> m, double d, Context c)
    {
        this.context=c;
        this.degree=d;
        this.mcqdata=e;
        this.matchdata=m;
    }
    class ViewHolder extends RecyclerView.ViewHolder{
        private TextView question_num;
        private CardView card_view;
        private int i;
        public ViewHolder(View itemView) {
            super(itemView);
            question_num = (TextView)itemView.findViewById(R.id.question);
            card_view = (CardView) itemView.findViewById(R.id.card_view_answer);
            mcq_question=context.getSharedPreferences("mcq", Context.MODE_PRIVATE);
            match_question=context.getSharedPreferences("match", Context.MODE_PRIVATE);
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
    public void onBindViewHolder(@NonNull answerAdapter.ViewHolder holder, final int position) {
        holder.question_num.setText("Question"+(position+1));
        if (position<mcqdata.size()) {
            if (mcqdata.get(position).getAnswer_text().equals(mcq_question.getString(mcqdata.get(position).getId(), "k")))
                holder.card_view.setCardBackgroundColor(Color.parseColor("#00D152"));
            else
                holder.card_view.setCardBackgroundColor(Color.parseColor("#F83D33"));
        }
        if(position>=mcqdata.size()&&position<(matchdata.size()+mcqdata.size())) {
           /* int c=0;
            for(holder.i=0 ;holder.i<matchdata.get(position).getQuestions().size();holder.i++)
            {
                if(matchdata.get(position).getQuestions().get(holder.i).getAnswer().equals(match_question.getString(matchdata.get(position).getQuestions().get(holder.i).getId_match(),"NO Data")))
                {
                    c+=1;
                }
            }
            if(c==matchdata.get(position).getQuestions().size()) {
                holder.card_view.setCardBackgroundColor(Color.parseColor("#00D152"));
            }
            else*/
                holder.card_view.setCardBackgroundColor(Color.parseColor("#D68C09"));
        }
        //for cpmplete question
       /* if(position>=(mcqdata.size()+matchdata.size())&&position<(qa.length+mcqdata.size()+matchdata.size()))
        {
            holder.card_view.setCardBackgroundColor(Color.parseColor("#D81B60"));
        }*/
        holder.card_view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (position < mcqdata.size()) {
                    Intent myIntent1 = new Intent(context, show_mcq_answer.class);
                    myIntent1.putExtra("mcq", mcqdata.get(position));
                    context.startActivity(myIntent1);
                }
                if (position >= mcqdata.size() && position < (matchdata.size() + mcqdata.size())) {
                    Intent myIntent = new Intent(context, show_match_answer.class);
                    myIntent.putExtra(",match", matchdata.get(position-mcqdata.size()));
                    Log.d("kkkkkkkk",matchdata.get(position-mcqdata.size()).getId_component());
                    context.startActivity(myIntent);
                }
            }

        });
    }
    @Override
    public int getItemCount() {
        return (mcqdata.size()+matchdata.size());
    }
}
