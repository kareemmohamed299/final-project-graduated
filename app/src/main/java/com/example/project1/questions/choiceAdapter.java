package com.example.project1.questions;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.project1.R;
import com.example.project1.connection.exam;
import com.google.android.material.snackbar.Snackbar;


public class choiceAdapter extends RecyclerView.Adapter<choiceAdapter.ViewHolder> {

    exam examdata;
     public choiceAdapter(exam e)
     {
         this.examdata=e;
     }
    class ViewHolder extends RecyclerView.ViewHolder{

        public TextView choice;



        public ViewHolder(View itemView) {
            super(itemView);
            choice = (TextView)itemView.findViewById(R.id.choice_text);



            itemView.setOnClickListener(new View.OnClickListener() {
                @Override public void onClick(View v) {
                    int position = getAdapterPosition();

                    Snackbar.make(v, "Click detected on item " + position,
                            Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();

                }
            });
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
    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        viewHolder.choice.setText(examdata.getChoices().get(i));
    }

    @Override
    public int getItemCount() {
        return examdata.getChoices().size();
    }


}
