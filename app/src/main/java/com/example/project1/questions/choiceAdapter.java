package com.example.project1.questions;

import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.project1.R;
import com.example.project1.connection.exam;
import com.google.android.material.snackbar.Snackbar;


public class choiceAdapter extends RecyclerView.Adapter<choiceAdapter.ViewHolder> {

    private exam examdata;
    private Context context;
    private SharedPreferences answer;
    private int position=-1 ;
     public choiceAdapter(exam e,Context c)
     {
         this.examdata=e;
         this.context=c;
     }
    class ViewHolder extends RecyclerView.ViewHolder{
        public TextView choice;
        private CardView card_view;
        public ViewHolder(final View itemView) {
            super(itemView);
            choice = (TextView)itemView.findViewById(R.id.choice_text);
            card_view = (CardView) itemView.findViewById(R.id.card_view);
            answer=context.getSharedPreferences("answers", Context.MODE_PRIVATE);
        }
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.choice_layout, viewGroup, false);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final ViewHolder viewHolder, final int i) {
        viewHolder.choice.setText(examdata.getChoices().get(i));


        viewHolder.card_view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                position = viewHolder.getAdapterPosition();
                String ch=examdata.getChoices().get(position);
                SharedPreferences.Editor editor= answer.edit();
                editor.putString(examdata.getId(),ch);
                editor.apply();
                Snackbar.make(v, answer.getString(examdata.getId(),"no_anwser"),
                        Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
                notifyDataSetChanged();
            }
        });
        if(position == i) {
            viewHolder.card_view.setCardBackgroundColor(Color.parseColor("#00D152"));
        }
        else
        {
            viewHolder.card_view.setCardBackgroundColor(Color.WHITE);
        }
    }
    @Override
    public int getItemCount() {
        return examdata.getChoices().size();
    }



}
