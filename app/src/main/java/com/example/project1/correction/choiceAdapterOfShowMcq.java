package com.example.project1.correction;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.project1.R;
import com.example.project1.questions.choiceAdapter;

public class choiceAdapterOfShowMcq extends RecyclerView.Adapter<choiceAdapterOfShowMcq.ViewHolder> {

    private String[] choice = {"Answer A",
            "Answer B"
    };

    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView choice;
        private CardView card_view;



        public ViewHolder(final View itemView) {
            super(itemView);
            choice = (TextView)itemView.findViewById(R.id.choice_text);
            card_view = (CardView) itemView.findViewById(R.id.card_view);
        }
    }


    @NonNull
    @Override
    public choiceAdapterOfShowMcq.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.choice_layout, parent, false);
        choiceAdapterOfShowMcq.ViewHolder viewHolder = new ViewHolder(v);


        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull choiceAdapterOfShowMcq.ViewHolder holder, int position) {
        holder.choice.setText(choice[position]);
        if(choice[position]== "Answer A")
            holder.card_view.setCardBackgroundColor(Color.parseColor("#00D152"));
        else
            holder.card_view.setCardBackgroundColor(Color.parseColor("#F83D33"));
    }


    @Override
    public int getItemCount() {
        return choice.length;
    }


}
