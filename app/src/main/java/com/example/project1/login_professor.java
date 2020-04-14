package com.example.project1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.example.project1.professor.third_prof;
import com.example.project1.welcome;


public class login_professor extends AppCompatActivity {

    private ImageButton imageButton;
    private Button button ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_professor);
        button = (Button)findViewById(R.id.button);
        imageButton = (ImageButton)findViewById(R.id.imageButton);
        imageButton.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                openpage2();
            }
        });
        button.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                openprof();
            }
        });
    }



    public void openprof(){
        Intent myIntent1 = new Intent(this, third_prof.class);
        startActivity(myIntent1);
    }


    public void openpage2(){
        Intent myIntent = new Intent(this, second.class);
        startActivity(myIntent);
    }
}
