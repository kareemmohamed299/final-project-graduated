package com.example.project1.correction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.project1.R;

public class shownumatchAdapter extends RecyclerView.Adapter<shownumatchAdapter.ViewHolder> {

    class ViewHolder extends RecyclerView.ViewHolder{
        public TextView q;
        public TextView a;
        public ViewHolder(final View itemView) {
            super(itemView);
            q = (TextView)itemView.findViewById(R.id.qmatch_text_show);
            a = (TextView)itemView.findViewById(R.id.amatch_text_show);

        }
    }
    @NonNull
    @Override
    public shownumatchAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.show_match_answer, parent, false);
        shownumatchAdapter.ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull shownumatchAdapter.ViewHolder holder, int position) {
    }

    @Override
    public int getItemCount() {
        return 0;
    }


}
