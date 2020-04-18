package com.example.project1.questions;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.project1.R;
import com.example.project1.connection.match;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;

public class numatchAdapter extends RecyclerView.Adapter<numatchAdapter.ViewHolder> {
    private Context context;
    private SharedPreferences student_answer;
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
        public EditText e;
        private int  index;
        private String an;
        public ViewHolder(final View itemView) {
            super(itemView);
            q = (TextView)itemView.findViewById(R.id.qmatch_text);
            a = (TextView)itemView.findViewById(R.id.amatch_text);
            student_answer=context.getSharedPreferences("match", Context.MODE_PRIVATE);
            e=(EditText)itemView.findViewById(R.id.text_stuans);
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
    public void onBindViewHolder(@NonNull final numatchAdapter.ViewHolder holder, final int position) {
        holder.q.setText(matchdata.getQuestions().get(position).getQuestion());
        holder.a.setText(matchansewr.get(position));
        holder.e.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }
            @Override
            public void afterTextChanged(Editable s) {
                try {
                    holder.index = Integer.parseInt(s.toString());
                    SharedPreferences.Editor editor = student_answer.edit();
                    if(holder.index==0||holder.index>matchdata.getQuestions().size()) {
                        holder.an="no_data";
                    }
                    else {
                        holder.an = matchansewr.get(holder.index - 1);
                        editor.putString(matchdata.getQuestions().get(position).getId_match(), holder.an);
                        editor.apply();
                        Toast.makeText(context.getApplicationContext(), student_answer.getString("3", "a7a"), Toast.LENGTH_SHORT).show();
                    }
                }
                catch (NumberFormatException e) {
                    Toast.makeText(context.getApplicationContext(),"دخل الرقم يا قلوط", Toast.LENGTH_SHORT).show();
                    return;
                }
            }
        });

    }
    @Override
    public int getItemCount() {
       return 5;
    }
}
