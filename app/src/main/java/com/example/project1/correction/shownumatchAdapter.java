package com.example.project1.correction;

import android.content.Context;
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
import com.example.project1.connection.match;

public class shownumatchAdapter extends RecyclerView.Adapter<shownumatchAdapter.ViewHolder> {

    match matchdata;
    Context context;
    private SharedPreferences student_answer;

    public shownumatchAdapter(match m, Context c) {
        this.matchdata=m;
        this.context=c;
    }
    class ViewHolder extends RecyclerView.ViewHolder{
        public TextView q;
        public TextView a;
        public CardView card_view;
        public ViewHolder(final View itemView) {
            super(itemView);
            q = (TextView)itemView.findViewById(R.id.qmatch_text_show);
            a = (TextView)itemView.findViewById(R.id.amatch_text_show);
            card_view=(CardView) itemView.findViewById(R.id.correction);
            student_answer=context.getSharedPreferences("match", Context.MODE_PRIVATE);
        }
    }
    @NonNull
    @Override
    public shownumatchAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_match_answer, parent, false);
        shownumatchAdapter.ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }
    @Override
    public void onBindViewHolder(@NonNull shownumatchAdapter.ViewHolder holder, int position) {
        holder.q.setText(matchdata.getQuestions().get(position).getQuestion());
        holder.a.setText(matchdata.getQuestions().get(position).getAnswer());
                if(matchdata.getQuestions().get(position).getAnswer().equals(student_answer.getString(matchdata.getQuestions().get(position).getId_match(),"NO Data")))
                {
                    holder.card_view.setCardBackgroundColor(Color.parseColor("#00D152"));

                }
            else
                holder.card_view.setCardBackgroundColor(Color.parseColor("#F83D33"));
    }
    @Override
    public int getItemCount() {
        return matchdata.getQuestions().size();
    }


}
