package com.example.project1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.project1.connection.cource;

import java.util.ArrayList;

public class welcome extends AppCompatActivity {

    private Button button ;
    private TextView name , prog_name;
    ArrayList<String>student1 ;
    cource cource = new cource();
    ArrayList<cource> course ;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.welcome);

        button = (Button)findViewById(R.id.button);
        name = (TextView)findViewById(R.id.name2);
        prog_name = (TextView)findViewById(R.id.prog_name2);
        student1 =  new ArrayList<String>();
        course = new ArrayList<cource>();
        course = getIntent().getParcelableArrayListExtra("course");
        student1 = getIntent().getStringArrayListExtra("student");
        name.setText( student1.get(0));
        prog_name.setText(student1.get(4));
        button.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                openthird();
            }
        });
    }

    public void openthird(){
        Intent myIntent1 = new Intent(this, third.class);
        myIntent1.putParcelableArrayListExtra("course",course);
        myIntent1.putStringArrayListExtra("student" , student1);
        startActivity(myIntent1);
    }
}
