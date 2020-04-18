package com.example.project1.correction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.project1.R;

public class showitemcompleteAdapter extends RecyclerView.Adapter<showitemcompleteAdapter.ViewHolder> {

    private String[] titles = {"(1)",
            "(2)",
            "(3)",
            "(4)",
            "(5)",
    };

    public class ViewHolder extends RecyclerView.ViewHolder{
        public TextView txt1,txt2,txt3;
        private CardView card_view;
        private View v1,v2,v3,v4;
        public ViewHolder(final View itemView) {
            super(itemView);
            card_view = (CardView) itemView.findViewById(R.id.item1);
            txt1 = (TextView) itemView.findViewById(R.id.show_num1);
            txt2 = (TextView) itemView.findViewById(R.id.show_ans1);
            txt3 = (TextView) itemView.findViewById(R.id.show_correct_ans1);
            v1 = (View) itemView.findViewById(R.id.check_right1);
            v2 = (View) itemView.findViewById(R.id.mark_right1);
            v3 = (View) itemView.findViewById(R.id.check_wrong1);
            v4 = (View) itemView.findViewById(R.id.mark_wrong1);
        }
    }


    @NonNull
    @Override
    public showitemcompleteAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_complete_answer, parent, false);
        showitemcompleteAdapter.ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull showitemcompleteAdapter.ViewHolder holder, int position) {

        holder.txt1.setText(titles[position]);

    }

    @Override
    public int getItemCount() {
        return titles.length;
    }


}
