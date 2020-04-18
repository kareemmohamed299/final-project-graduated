package com.example.project1.questions;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.project1.R;

public class itemcompleteAdapter extends RecyclerView.Adapter<itemcompleteAdapter.ViewHolder> {

    private String[] titles = {"(1)",
            "(2)",
            "(3)",
            "(4)",
            "(5)",
    };

    public class ViewHolder extends RecyclerView.ViewHolder{
        public EditText edit;
        public TextView txt;
        private CardView card_view;
        public ViewHolder(final View itemView) {
            super(itemView);
            edit = (EditText) itemView.findViewById(R.id.ans1);
            card_view = (CardView) itemView.findViewById(R.id.item1);
            txt = (TextView) itemView.findViewById(R.id.num1);
        }
    }


    @NonNull
    @Override
    public itemcompleteAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_complete_question, parent, false);
        itemcompleteAdapter.ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull itemcompleteAdapter.ViewHolder holder, int position) {

        holder.txt.setText(titles[position]);

    }

    @Override
    public int getItemCount() {
        return titles.length;
    }


}

