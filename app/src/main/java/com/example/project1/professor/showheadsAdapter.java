package com.example.project1.professor;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.project1.R;
import com.example.project1.connection.questiondoctor;
import com.example.project1.connection.student_doctor;

import java.util.ArrayList;
import java.util.List;

public class showheadsAdapter  extends RecyclerView.Adapter<showheadsAdapter.ViewHolder> implements Filterable {

    Context mcontext;

    private ArrayList<questiondoctor> qes_doctor = new ArrayList<>();
    private ArrayList<questiondoctor> search1 ;
    questiondoctor questiondoctor;
    show_heads show_heads;
    public  showheadsAdapter( ArrayList<questiondoctor>qes_doctor1 ,show_heads show_heads1)
    {
        this.qes_doctor = qes_doctor1;
        this.show_heads = show_heads1;
        this.search1 = new ArrayList<>(qes_doctor);
    }
    @Override
    public Filter getFilter()
    {
        return examplefilter;
    }
    private  Filter examplefilter = new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            ArrayList<questiondoctor> filteredlist = new ArrayList<>() ;
            if(constraint == null || constraint.length() ==0  )
            {
                filteredlist.addAll(search1);
            }
            else
            {
                String filterpattern =  constraint.toString().toLowerCase().trim();
                for(questiondoctor item :search1)
                {
                    if(item.getQ_text().toLowerCase().contains(filterpattern))
                    {
                        filteredlist.add(item);
                    }

                }
            }
            FilterResults results = new FilterResults();
            results.values = filteredlist;
            return  results;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            qes_doctor.clear();
            qes_doctor.addAll((List) results.values);
            notifyDataSetChanged();
        }
    };

    public void remove(ArrayList<questiondoctor> selection_qes_doctor) {
        for(int i=0;i<selection_qes_doctor.size() ; i++)
        {
            qes_doctor.remove(selection_qes_doctor.get(i));
            notifyDataSetChanged();
        }

    }


    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
            TextView head ;
            CheckBox checkBox;
            CardView cardView;
        View view;
        int x=getAdapterPosition();
        public ViewHolder(View itemView , show_heads show_heads) {
            super(itemView);
            head = (TextView)itemView.findViewById(R.id.head_txt);
            checkBox = (CheckBox)itemView.findViewById(R.id.check_box);
            cardView  = (CardView) itemView.findViewById(R.id.card_view_item);
            view=itemView;
            view.setOnLongClickListener(show_heads);
            checkBox.setOnClickListener(this);

        }
        @Override
        public void onClick(View v) {
            show_heads.MakeSelection(v,getAdapterPosition());
        }
    }


    @NonNull
    @Override
    public showheadsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.head_item, parent, false);
        showheadsAdapter.ViewHolder viewHolder = new ViewHolder(v , show_heads);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull showheadsAdapter.ViewHolder holder, int position) {

        holder.head.setText(qes_doctor.get(position).getQ_text());


        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) {
                Intent myIntent = new Intent(mcontext, show_mcq_questions_prof.class);
                //myIntent.putParcelableArrayListExtra("question_doctor" , qes_doctor);
                myIntent.putExtra("question_doctor" , questiondoctor);
                mcontext.startActivity(myIntent);
            }
        });
        if(show_heads.iscontexualmodeenable)
        {
            holder.checkBox.setVisibility(View.GONE);
        }
        else
        {
            holder.checkBox.setVisibility(View.VISIBLE);
            holder.checkBox.setChecked(false);
        }

    }

    @Override
    public int getItemCount() {
        return qes_doctor.size();
    }


}
