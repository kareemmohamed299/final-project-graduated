package com.example.project1.questions;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.project1.R;
import com.example.project1.connection.match;

import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class match_question extends Fragment {
    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    RecyclerView.Adapter adapter2;
    match matchdata;
    public match_question() {

    }
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View itemView = inflater.inflate(R.layout.match_question, container, false);
        matchdata=new match();
        assert this.getArguments() != null;
        matchdata=this.getArguments().getParcelable("match");
        recyclerView = (RecyclerView) itemView.findViewById(R.id.recycler_view1);
        layoutManager = new GridLayoutManager(match_question.this.getActivity(),1);
        recyclerView.setLayoutManager(layoutManager);
        adapter2 = new numatchAdapter(matchdata,randowansers(),match_question.this.getActivity());
        recyclerView.setAdapter(adapter2);
        return itemView;
    }
    private ArrayList<String>randowansers()
    {
        ArrayList<String>array=new ArrayList<String>();
        Random rand = new Random();
        for(int i=0;i<matchdata.getQuestions().size();i++)
        {
            array.add(matchdata.getQuestions().get(i).getAnswer());
        }
        for (int i =0;i<array.size();i++)
        {
            int index = rand.nextInt(array.size());
            String a = array.get(index);
            array.set(index,array.get(i));
            array.set(i,a);
        }
        return array;
    }
}