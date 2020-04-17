package com.example.project1.correction;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
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
    private int degree;
    private SharedPreferences q;
    public answerAdapter(ArrayList<exam> e, ArrayList<match> m, int d, Context c)
    {
        this.context=c;
        this.degree=d;
        this.mcqdata=e;
        this.matchdata=m;
    }
    class ViewHolder extends RecyclerView.ViewHolder{
        private TextView question_num;
        private CardView card_view;
        public ViewHolder(View itemView) {
            super(itemView);
            question_num = (TextView)itemView.findViewById(R.id.question);
            card_view = (CardView) itemView.findViewById(R.id.card_view_answer);
            q=context.getSharedPreferences("answers", Context.MODE_PRIVATE);
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
                /*

            if (position <= mcqdata.size()) {
                if (mcqdata.get(position).getAnswer_text().equals(q.getString(mcqdata.get(position).getId(), "k")))
                    holder.card_view.setCardBackgroundColor(Color.parseColor("#00D152"));
                else
                    holder.card_view.setCardBackgroundColor(Color.parseColor("#F83D33"));
            }
            else
                holder.card_view.setCardBackgroundColor(Color.parseColor("#F83D33"));
        holder.card_view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(position<=mcqdata.size()) {
                    Intent myIntent1 = new Intent(context, show_mcq_answer.class);
                    myIntent1.putExtra("ex", mcqdata.get(position));
                    context.startActivity(myIntent1);
                }
                else {
                    Intent myIntent1 = new Intent(context, show_match_answer.class);
                    context.startActivity(myIntent1);
                }
            }
        });*/
    }
    @Override
    public int getItemCount() {
        return (mcqdata.size()+matchdata.size());
    }
}
