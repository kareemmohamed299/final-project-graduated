package com.example.project1.professor;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.project1.R;
import com.example.project1.connection.cource;
import com.example.project1.connection.questiondoctor;
import com.example.project1.connection.retrofit;
import com.example.project1.connection.student_doctor;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
public class course_info_prof extends AppCompatActivity {
    CardView cardView1 , cardView2 , cardView3;
    cource coursedata;
    private ArrayList<student_doctor>st_doctor=new ArrayList<student_doctor>();
    private ArrayList<String> doctordata;
    private ArrayList<questiondoctor> qes_doctor=new ArrayList<questiondoctor>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.course_info_prof);
        coursedata=new cource();
        coursedata = getIntent().getParcelableExtra("coursedata");
        doctordata=new ArrayList<String>();
        doctordata = getIntent().getStringArrayListExtra("doctordata");
        cardView1 = (CardView)findViewById(R.id.card1);
        cardView2 = (CardView)findViewById(R.id.card2);
        cardView1.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) {
                 retrofit.getINSTANCE().getApi().getstudent_doctor( coursedata.getCode(), doctordata.get(5)).
                         enqueue(new Callback<List<student_doctor>>() {
                             @Override
                             public void onResponse(Call<List<student_doctor>> call, Response<List<student_doctor>> response) {
                                     for (int i = 0; i < response.body().size(); i++)
                                     {
                                         st_doctor.add(i, response.body().get(i));
                                     }
                                     Intent myIntent = new Intent(course_info_prof.this, students_enrolled.class);
                                     myIntent.putParcelableArrayListExtra("student_doctor" , st_doctor);
                                     startActivity(myIntent);
                             }
                             @Override
                             public void onFailure(Call<List<student_doctor>> call, Throwable t) {
                                 Toast.makeText(getApplicationContext(),t.getMessage(),Toast.LENGTH_LONG).show();
                             }
                         });
            }
        });
        cardView2.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) {
                retrofit.getINSTANCE().getApi().getquestiondoctor(doctordata.get(5),coursedata.getCode()).
                        enqueue(new Callback<List<questiondoctor>>() {
                            @Override
                            public void onResponse(Call<List<questiondoctor>> call, Response<List<questiondoctor>> response) {
                                for (int i = 0; i < response.body().size(); i++)
                                {
                                    qes_doctor.add(i , response.body().get(i));
                                }
                                Intent myIntent2 = new Intent(course_info_prof.this, type_questions.class);
                                myIntent2.putParcelableArrayListExtra("question_doctor" , qes_doctor);
                                startActivity(myIntent2);
                            }
                            @Override
                            public void onFailure(Call<List<questiondoctor>> call, Throwable t) {

                            }
                        });
            }
        });
    }
}
