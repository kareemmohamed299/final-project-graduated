package com.example.project1.questions;

import android.content.Context;
import android.content.SharedPreferences;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.project1.R;
import com.example.project1.connection.match;

import java.util.ArrayList;

public class numatchAdapter extends RecyclerView.Adapter<numatchAdapter.ViewHolder> {
    private Context context;
    private SharedPreferences answer;
    match matchdata;
    ArrayList<String>matchansewr;
    public numatchAdapter(match m,ArrayList<String>ma, Context c)
    {
        this.matchdata=m;
        this.matchansewr=ma;
        this.context=c;
    }
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

            holder.q.setText(matchdata.getQuestions().get(position).getQuestion());
            holder.a.setText(matchansewr.get(position));
    }
    @Override
    public int getItemCount() {
        return matchdata.getQuestions().size();
    }
}
