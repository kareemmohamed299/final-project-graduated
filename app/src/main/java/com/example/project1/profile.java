package com.example.project1;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class profile extends Fragment {
    private TextView name1 ,id1 ,prog_name ,prog_name1 , level , gpa , phone1 ,department1 ,name2;
    ArrayList<String> studentData;
    public profile() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v= inflater.inflate(R.layout.profile, container, false);
       Bundle b = getArguments();
        studentData =new ArrayList<String>();
        assert this.getArguments() != null;
        studentData = b.getStringArrayList("student");
       // fname = b.getString("fname");
        name1 = (TextView)v.findViewById(R.id.name2);
        id1 = (TextView)v.findViewById(R.id.id1);
        prog_name = (TextView)v.findViewById(R.id.prog_name2);
        prog_name1 = (TextView)v.findViewById(R.id.prog_name1);
        level = (TextView)v.findViewById(R.id.level);
        gpa = (TextView)v.findViewById(R.id.gpa);
        department1 = (TextView)v.findViewById(R.id.department1);
        phone1 = (TextView)v.findViewById(R.id.phone1);
        name2 = (TextView)v.findViewById(R.id.name1);
        //name1.setText(fname);
        name2.setText(studentData.get(0)+" "+studentData.get(1)+ " "+studentData.get(2));
        name1.setText( studentData.get(0)+" "+studentData.get(1));
        phone1.setText(studentData.get(6));
        level.setText(studentData.get(7));
        gpa.setText(studentData.get(8));
        department1.setText(studentData.get(3));
        prog_name.setText(studentData.get(4));
        prog_name1.setText(studentData.get(4));
        id1.setText(studentData.get(5));
        return v;
    }

}
