package com.example.project1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.basgeekball.awesomevalidation.AwesomeValidation;
import com.basgeekball.awesomevalidation.ValidationStyle;
import com.example.project1.connection.Api;
import com.example.project1.connection.cource;
import com.example.project1.connection.student;
import com.example.project1.welcome;

import java.util.ArrayList;
import java.util.HashMap;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class login_student extends AppCompatActivity {
    private ImageButton imageButton;
    private Button button ;
    private EditText tv1,tv2;
    private ArrayList<cource> course ;
    private ArrayList<String >student1;
    String t1,t2;
    HashMap<Object,Object> map=new HashMap<>();
    public void openwelcome(){
        t1=tv1.getText().toString().trim();
        t2=tv2.getText().toString().trim();
        map.put("email",t1);
        map.put("password",t2);
        Retrofit r = new Retrofit.Builder()
                .baseUrl("http://kmmmm.000webhostapp.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        Api a = r.create(Api.class);
        Call<student> call=a.getdata(map);
        call.enqueue(new Callback<student>() {
            @Override
            public void onResponse(Call<student> call, Response<student> response) {
                if(response.isSuccessful())
                {
                    student student = response.body();
                    student1 = new ArrayList<String>();
                    assert student != null;
                    course = student.getCourse();
                    student1.add(student.getFname());
                    student1.add(student.getMname());
                    student1.add(student.getLname());
                    student1.add(student.getDepartment_name());
                    student1.add(student.getProgram_name());
                    student1.add(student.getId());
                    student1.add( student.getPhone());
                    student1.add(student.getLevel());
                    student1.add(student.getGPA());
                    student1.add( student.getEmail());
                    welcome();
                }
                else
                {
                    Toast.makeText(getApplicationContext(), "email or password is wrong", Toast.LENGTH_SHORT).show();
                }
            }
            @Override
            public void onFailure(Call<student> call, Throwable t) {
                Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
    AwesomeValidation awesomeValidation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_student);
        tv1=findViewById(R.id.email);
        tv2=findViewById(R.id.pass);
        awesomeValidation = new AwesomeValidation(ValidationStyle.BASIC);
        //validation of email
        awesomeValidation.addValidation(this, R.id.email, Patterns.EMAIL_ADDRESS, R.string.invalid_email);
        //validation of password
        awesomeValidation.addValidation(this, R.id.pass, ".{6,}", R.string.invalid_password);
        button = (Button)findViewById(R.id.button);
        imageButton = (ImageButton)findViewById(R.id.imageButton);
        imageButton.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                openpage1();
            }
        });
        button.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {

                if (awesomeValidation.validate()) {
                                       openwelcome();
                }
                else
                    {
                    Toast.makeText(getApplicationContext(), "Validation error", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    public void openpage1(){
        Intent myIntent = new Intent(this, second.class);
        startActivity(myIntent);
    }
    public void welcome()
    {
        Intent myIntent1 = new Intent(this , welcome.class);
        myIntent1.putParcelableArrayListExtra("course",course);
        myIntent1.putStringArrayListExtra("student" , student1);
        startActivity(myIntent1);
    }
}
