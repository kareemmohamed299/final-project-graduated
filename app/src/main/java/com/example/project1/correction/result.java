package com.example.project1.correction;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

import com.example.project1.R;
import com.example.project1.connection.exam;
import com.example.project1.connection.match;
import com.example.project1.course_info;
import com.example.project1.questions.question;

import java.util.ArrayList;

public class result extends AppCompatActivity {

    RecyclerView recyclerView;
    ArrayList<String> c;
    RecyclerView.LayoutManager layoutManager;
    RecyclerView.Adapter adapter;
    private ArrayList<exam> mcqdata ;
    private ArrayList<match> matchdata ;
    private double degree;
    private TextView n,k1,k2,k3,k4,k5;
    //private SharedPreferences match_question,mcq_question;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.result);
        mcqdata=new ArrayList<exam>();
        matchdata=new ArrayList<match>();
        mcqdata=getIntent().getParcelableArrayListExtra("mcq");
        matchdata=getIntent().getParcelableArrayListExtra("match");
        degree=getIntent().getDoubleExtra("degree",0);
        c = getIntent().getStringArrayListExtra("c");
        //aa=getSharedPreferences("match", Context.MODE_PRIVATE);
        n=(TextView)findViewById(R.id.score);
        /*k1=(TextView)findViewById(R.id.k1);
        k2=(TextView)findViewById(R.id.k2);
        k3=(TextView)findViewById(R.id.k3);
        k4=(TextView)findViewById(R.id.k4);
        k5=(TextView)findViewById(R.id.k5);
        k1.setText(aa.getString("3","a7a"));
        k2.setText(aa.getString("4","a7a"));
        k3.setText(aa.getString("5","a7a"));
        k4.setText(aa.getString("6","a7a"));
        k5.setText(aa.getString("7","a7a"));*/
        n.setText(String.valueOf(degree)+" / "+c.get(3));
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        layoutManager = new GridLayoutManager(result.this,3);
        recyclerView.setLayoutManager(layoutManager);
        adapter = new answerAdapter(mcqdata,matchdata,degree,result.this);
        recyclerView.setAdapter(adapter);
    }
    @Override
    public void onBackPressed() {
                        result.super.onBackPressed();
                        Intent myIntent = new Intent(result.this, course_info.class);
                        myIntent.putStringArrayListExtra("c",c);
                        startActivity(myIntent);
    }


}
