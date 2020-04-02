package com.example.project1.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.project1.R;
import com.example.project1.login_student;

public class cpage1 extends Fragment {

    private Button button ;
    public void openlogin_student(){
        Intent myIntent = new Intent(cpage1.this.getActivity(), login_student.class);
        startActivity(myIntent);
    }

    @Nullable
    @Override
    public View onCreateView(@Nullable LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.page1,container,false);

        button = (Button)rootView.findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                openlogin_student();
            }
        });
        return rootView;
    }

}
