package com.example.project1.questions;

import android.content.DialogInterface;
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

    exam examdata;

    private int position ;

     public choiceAdapter(exam e)
     {
         this.examdata=e;
     }
    class ViewHolder extends RecyclerView.ViewHolder{

        public TextView choice;
        private CardView card_view;



        public ViewHolder(final View itemView) {
            super(itemView);
            choice = (TextView)itemView.findViewById(R.id.choice_text);
            card_view = (CardView) itemView.findViewById(R.id.card_view);
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
                //Position1 = i;
                position = viewHolder.getAdapterPosition();
                String ch=examdata.getChoices().get(position);

                Snackbar.make(v, ch,
                        Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();

                notifyDataSetChanged();

            }
        });
        if(position == i) {
            viewHolder.card_view.setCardBackgroundColor(Color.parseColor("#b70505"));
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
