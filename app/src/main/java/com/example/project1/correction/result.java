package com.example.project1.correction;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.example.project1.R;
import com.example.project1.connection.exam;
import com.example.project1.course_info;
import com.example.project1.questions.question;

import java.util.ArrayList;

public class result extends AppCompatActivity {

    RecyclerView recyclerView;
    ArrayList<String> c;
    RecyclerView.LayoutManager layoutManager;
    RecyclerView.Adapter adapter;
    private ArrayList<exam> examdata ;
    private int degree;
    private TextView n;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.result);
        examdata=new ArrayList<exam>();
        examdata=getIntent().getParcelableArrayListExtra("exam");
        degree=getIntent().getIntExtra("degree",0);
        c = getIntent().getStringArrayListExtra("c");
        n=(TextView)findViewById(R.id.score);
        n.setText(String.valueOf(degree)+" / "+c.get(3));
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        layoutManager = new GridLayoutManager(result.this,3);
        recyclerView.setLayoutManager(layoutManager);
        adapter = new answerAdapter(examdata,degree,result.this);
        recyclerView.setAdapter(adapter);
    }

   /* @Override
    public void onBackPressed() {
                        result.super.onBackPressed();
                        Intent myIntent = new Intent(result.this, course_info.class);
                        myIntent.putStringArrayListExtra("c",c);
                        startActivity(myIntent);
    }*/


}
