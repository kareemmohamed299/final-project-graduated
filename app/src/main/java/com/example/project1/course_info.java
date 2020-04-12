package com.example.project1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import android.widget.TextView;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.project1.connection.cource;
import com.example.project1.connection.exam;
import com.example.project1.connection.retrofit;
import com.example.project1.questions.question;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class course_info extends AppCompatActivity {
    ArrayList<String> c;
    private TextView course,professor,Duration,Exam_Start,Exam_End,Degree;
    private Button button ;
    private ArrayList<exam> examdata=new ArrayList<exam>();
    private SharedPreferences k;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.course_info);
        c = getIntent().getStringArrayListExtra("c");
        course = (TextView) findViewById(R.id.t1);
        professor = (TextView) findViewById(R.id.t2);
        Duration = (TextView) findViewById(R.id.t3);
        Exam_Start = (TextView) findViewById(R.id.t4);
        Exam_End = (TextView) findViewById(R.id.t5);
        Degree = (TextView) findViewById(R.id.t6);
        course.setText(c.get(4));
        professor.setText(c.get(5));
        Duration.setText(c.get(0));
        Exam_Start.setText(c.get(1));
        Exam_End.setText(c.get(2));
        Degree.setText(c.get(3));
        button = (Button) findViewById(R.id.button2);
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    SharedPreferences.Editor editor= k.edit();
                    editor.putInt("data",Integer.parseInt(c.get(8)));
                    editor.apply();
                        retrofit.getINSTANCE().getApi().examdata(c.get(8)).enqueue(new Callback<List<exam>>() {
                            @Override
                            public void onResponse(Call<List<exam>> call, Response<List<exam>> response) {
                                if (response.isSuccessful()) {
                                    for (int i = 0; i < response.body().size(); i++) {
                                        examdata.add(i, response.body().get(i));
                                    }
                                    examdata1();
                                }
                            }
                            @Override
                            public void onFailure(Call<List<exam>> call, Throwable t) {
                                Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_LONG).show();
                            }
                        });
                    }

            });
        k=getSharedPreferences("kareem", Context.MODE_PRIVATE);
    }
    @Override
    protected void onStart() {
        int x=k.getInt("data",0);
            if(x== Integer.parseInt(c.get(8)))
            {
                button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(getApplicationContext(),"مش هتخش تاني يا شرمط",Toast.LENGTH_LONG).show();
                    }
                });
            }

        super.onStart();
    }
    public void examdata1()
    {
        Intent myIntent = new Intent(this, question.class);
        myIntent.putParcelableArrayListExtra("exam",examdata);
        myIntent.putStringArrayListExtra("c",c);
        startActivity(myIntent);
    }
}
