package com.example.project1.professor;

import android.content.Context;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import android.widget.Filter;
import android.widget.Filterable;
import android.widget.SearchView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.project1.R;
import com.example.project1.connection.student_doctor;

import java.util.ArrayList;
import java.util.List;

public class studentsAdapter extends RecyclerView.Adapter<studentsAdapter.ViewHolder> implements Filterable {
    private Context mContext;
    public ArrayList<student_doctor> st_doctor = new ArrayList<>();
    public ArrayList<student_doctor> search1 ;
    public studentsAdapter(ArrayList<student_doctor> st_doctor1 , Context context) {
        this.mContext=context;
        this.st_doctor = st_doctor1;
        this.search1 = new ArrayList<>(st_doctor);
    }
    @Override
    public Filter getFilter()
    {
        return examplefilter;
    }
    private  Filter examplefilter = new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            ArrayList<student_doctor> filteredlist = new ArrayList<>() ;
            if(constraint == null || constraint.length() ==0  )
            {
                filteredlist.addAll(search1);
            }
            else
            {
                String filterpattern =  constraint.toString().toLowerCase().trim();
                for(student_doctor item :search1)
                {
                    if((item.getFname().toLowerCase().contains(filterpattern))||(item.getMname().toLowerCase().contains(filterpattern))
                    ||(item.getLname().toLowerCase().contains(filterpattern)))
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
            st_doctor.clear();
            st_doctor.addAll((List) results.values);
            notifyDataSetChanged();
        }
    };



    class ViewHolder extends RecyclerView.ViewHolder{

        public TextView name ,pro ,de;
      //  public SearchView search;


        public ViewHolder(View itemView) {
            super(itemView);
            name = (TextView)itemView.findViewById(R.id.txt_name);
             pro = (TextView)itemView.findViewById(R.id.txt_program);
            de = (TextView)itemView.findViewById(R.id.txt_degree);
           // search = (SearchView)itemView.findViewById(R.id.search_view);
        }
    }
    @Override
    public studentsAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.student_layout, viewGroup, false);
        studentsAdapter.ViewHolder viewHolder = new studentsAdapter.ViewHolder(v);
        return viewHolder;
    }
    @Override
    public void onBindViewHolder(studentsAdapter.ViewHolder viewHolder, int i) {
        student_doctor student_doctor1 = st_doctor.get(i);
        viewHolder.name.setText(student_doctor1.getFname()+" "+student_doctor1.getMname()+" "+student_doctor1.getLname());
        viewHolder.pro.setText(student_doctor1.getName());
        viewHolder.de.setText(student_doctor1.getDegree());
    }
    @Override
    public int getItemCount() {
        return st_doctor.size();
    }


}


