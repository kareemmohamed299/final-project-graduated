package com.example.project1.professor;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.example.project1.R;

import java.util.ArrayList;

public class profile_prof extends Fragment {

    private TextView name1 ,id1 ,prog_name ,prog_name1 ,department1 ,name2;
    ArrayList<String> doctor;
    public profile_prof() {
        // Required empty public constructor
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View v=inflater.inflate(R.layout.profile_prof, container, false);
        Bundle b = getArguments();
        doctor =new ArrayList<String>();
        assert this.getArguments() != null;
        doctor = b.getStringArrayList("doctor");
        name1 = (TextView)v.findViewById(R.id.name1);
        id1 = (TextView)v.findViewById(R.id.id);
        prog_name = (TextView)v.findViewById(R.id.prog_name1);
        prog_name1 = (TextView)v.findViewById(R.id.prog_name2);
        department1 = (TextView)v.findViewById(R.id.department);
        name2 = (TextView)v.findViewById(R.id.name2);
        name2.setText(doctor.get(0)+" "+doctor.get(1)+ " "+doctor.get(2));
        name1.setText( doctor.get(0)+" "+doctor.get(1));
        department1.setText(doctor.get(3));
        prog_name.setText(doctor.get(4));
        prog_name1.setText(doctor.get(4));
        id1.setText(doctor.get(5));
        return v;
    }

}
