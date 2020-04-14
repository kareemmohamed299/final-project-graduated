package com.example.project1.questions;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.project1.R;

public class numatchAdapter extends RecyclerView.Adapter<numatchAdapter.ViewHolder> {


    private String[] qa = {"Q1",
            "Q2",
            "Q3",
            "Q4",
            "A1",
            "A2","A3",
            "A4"
    };



    class ViewHolder extends RecyclerView.ViewHolder{
        public TextView q;
        public TextView a;
        public ViewHolder(final View itemView) {
            super(itemView);
            q = (TextView)itemView.findViewById(R.id.qmatch_text);
            a = (TextView)itemView.findViewById(R.id.amatch_text);

        }
    }

    @NonNull
    @Override
    public numatchAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_match, parent, false);
        numatchAdapter.ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull numatchAdapter.ViewHolder holder, int position) {

        if(position<(qa.length/2))
            holder.q.setText(qa[position]);
        else
            holder.a.setText(qa[position]);

    }

    @Override
    public int getItemCount() {
        return (qa.length/2);
    }


}
