package com.example.project1.professor;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.project1.R;

public class showheadsAdapter  extends RecyclerView.Adapter<showheadsAdapter.ViewHolder> {

    Context mcontext;

    public  showheadsAdapter(Context context)
    {
        this.mcontext = context ;
    }

    private String[] heads ={ "Question1","Question2","Question 3 ","Question4","Question5",
            "Question6","Question7","Question8","Question9","Question10"
    };

    public class ViewHolder extends RecyclerView.ViewHolder {
            TextView head ;
            CheckBox checkBox;
            CardView cardView;
        public ViewHolder(View itemView) {
            super(itemView);
            head = (TextView)itemView.findViewById(R.id.head_txt);
            checkBox = (CheckBox)itemView.findViewById(R.id.check_box);
            cardView  = (CardView) itemView.findViewById(R.id.card_view_item);
        }
    }


    @NonNull
    @Override
    public showheadsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.head_item, parent, false);
        showheadsAdapter.ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull showheadsAdapter.ViewHolder holder, int position) {

        holder.head.setText(heads[position]);
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) {
                Intent myIntent = new Intent(mcontext, show_mcq_questions_prof.class);
                mcontext.startActivity(myIntent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return heads.length;
    }


}
