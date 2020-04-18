package com.example.project1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;


import com.example.project1.connection.cource;
import com.example.project1.connection.doctor;
import com.example.project1.connection.doctor_course;
import com.example.project1.connection.retrofit;
import com.example.project1.connection.student;
import com.example.project1.professor.third_prof;
import com.example.project1.welcome;

import java.util.ArrayList;
import java.util.HashMap;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class login_professor extends AppCompatActivity {

    private ImageButton imageButton;
    private Button button ;
    private ArrayList<cource> coursedata ;
    private ArrayList<String >doctor1;
    String t1,t2;
    HashMap<Object,Object> map=new HashMap<>();
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
        map.put("email","aos@cs");
        map.put("password","123456789");
        retrofit.getINSTANCE().getApi().getdoctordata(map).enqueue(new Callback<doctor>() {
            @Override
            public void onResponse(Call<doctor> call, Response<doctor> response) {
                if(response.isSuccessful())
                {
                    doctor doctor = response.body();
                    doctor1 = new ArrayList<String>();
                    assert doctor != null;
                    coursedata = doctor.getCourse();
                    doctor1.add(doctor.getFname());
                    doctor1.add(doctor.getMname());
                    doctor1.add(doctor.getLname());
                    doctor1.add(doctor.getDepartment_name());
                    doctor1.add(doctor.getProgram_name());
                    doctor1.add(doctor.getId());
                    doctor1.add( doctor.getPhone());
                    doctor1.add(doctor.getPicture());
                    doctor1.add( doctor.getEmail());
                   // Toast.makeText(getApplicationContext(), doctor1.get(0), Toast.LENGTH_SHORT).show();

                    open();

                }
                else
                {
                    Toast.makeText(getApplicationContext(), "email or password is wrong", Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void onFailure(Call<doctor> call, Throwable t) {
                Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_SHORT).show();

            }

        });
    }
public void open()
        {
            Intent myIntent1 = new Intent(this, third_prof.class);
            myIntent1.putParcelableArrayListExtra("course",coursedata);
            myIntent1.putStringArrayListExtra("doctor" , doctor1);
            startActivity(myIntent1);
        }
    public void openpage2(){
        Intent myIntent = new Intent(this, second.class);
        startActivity(myIntent);
    }

}
