package com.example.project1.questions;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import com.example.project1.R;
import com.example.project1.connection.exam;
import com.example.project1.correction.result;

import android.os.CountDownTimer;
import android.view.MenuItem;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.navigation.ui.AppBarConfiguration;

import com.google.android.material.navigation.NavigationView;
import com.google.android.material.tabs.TabLayout;

import androidx.drawerlayout.widget.DrawerLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.view.Menu;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
public class question extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    RecyclerView answer_sheet_view;
    TextView txt_right_answer;
    TextView txt_timer;
    public static final int Total_Time = 1*20*1000;
    int time_play = Total_Time;
    RecyclerView.Adapter adapter;
    public static CountDownTimer countDownTimer;
    ArrayList<exam> examdata ;
    ArrayList<String> c;
    public ArrayList<mcq_question> fragmentList = new ArrayList<>();
    ViewPager viewPager;
    TabLayout tabLayout;
    private String student_answer;
    private SharedPreferences sa;
    @Override
    protected void onDestroy() {
        if(countDownTimer !=null)
            countDownTimer.cancel();
        super.onDestroy();
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        examdata=new ArrayList<exam>();
        examdata=getIntent().getParcelableArrayListExtra("exam");
        c = getIntent().getStringArrayListExtra("c");
        txt_right_answer = (TextView)findViewById(R.id.txt_question_right);
        txt_right_answer.setText("0 / "+examdata.size());
        txt_timer = (TextView)findViewById(R.id.txt_timer);
        txt_timer.setVisibility(View.VISIBLE);
        txt_right_answer.setVisibility(View.VISIBLE);
        countTimer();
        answer_sheet_view = (RecyclerView)findViewById(R.id.grid_answer);
        answer_sheet_view.setHasFixedSize(true);
        answer_sheet_view.setLayoutManager(new GridLayoutManager(this,4));
        adapter = new AnswerSheetAdapter(examdata,question.this);
        answer_sheet_view.setAdapter(adapter);
        viewPager = (ViewPager)findViewById(R.id.viewpager);
        tabLayout = (TabLayout) findViewById(R.id.sliding_tabs);
        genFragmentList();
        mcqAdapter mcqAdapter  = new mcqAdapter(getSupportFragmentManager(),fragmentList);
        viewPager.setAdapter(mcqAdapter);
        tabLayout.setupWithViewPager(viewPager);
        sa=getSharedPreferences("answers", Context.MODE_PRIVATE);
    }
    private void countTimer() {
        if(countDownTimer == null) {
            countDownTimer = new CountDownTimer(Total_Time, 1000) {
                @Override
                public void onTick(long l) {
                    txt_timer.setText(String.format("%02d:%02d",
                            TimeUnit.MILLISECONDS.toMinutes(l),
                            TimeUnit.MILLISECONDS.toSeconds(l) -
                                    TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(l))));
                    time_play -= 1000;
                }
                @Override
                public void onFinish() {
                    Intent myIntent = new Intent(question.this, result.class);
                    myIntent.putParcelableArrayListExtra("exam",examdata);
                    myIntent.putExtra("degree",correction_prosses());
                    myIntent.putStringArrayListExtra("c",c);
                    startActivity(myIntent);
                    finish();
                }
            }.start();
        }
        else
        {
            countDownTimer.cancel();
            countDownTimer = new CountDownTimer(Total_Time, 1000) {
                @Override
                public void onTick(long l) {
                    txt_timer.setText(String.format("%02d:%02d",
                            TimeUnit.MILLISECONDS.toMinutes(l),
                            TimeUnit.MILLISECONDS.toSeconds(l) -
                                    TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(l))));
                    time_play -= 1000;
                }
                @Override
                public void onFinish() {
                    Intent myIntent = new Intent(question.this, result.class);
                    myIntent.putParcelableArrayListExtra("exam",examdata);
                    myIntent.putExtra("degree",correction_prosses());
                    myIntent.putStringArrayListExtra("c",c);
                    startActivity(myIntent);
                    finish();
                }
            }.start();
        }
    }
    private void genFragmentList(){

        if(fragmentList.isEmpty())
        {
            for(int i=0;i<examdata.size();i++)
            {
                mcq_question frag = new mcq_question();
                Bundle bundle = new Bundle();
                bundle.putParcelable("ex",examdata.get(i));
                frag.setArguments(bundle);
                fragmentList.add(frag);
            }
        }
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.question, menu);
        return true;
    }
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        return false;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        int id = item.getItemId();
        if(id ==R.id.finish_exam)
        {
           onBackPressed();
        }
        return super.onOptionsItemSelected(item);
    }
    @Override
    public void onBackPressed() {
       AlertDialog.Builder builder=new AlertDialog.Builder(this);
       builder.setMessage("Do you want to finish?")
               .setCancelable(false)
               .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                   @Override
                   public void onClick(DialogInterface dialog, int which) {
                       question.super.onBackPressed();
                       Intent myIntent = new Intent(question.this, result.class);
                       myIntent.putParcelableArrayListExtra("exam",examdata);
                       myIntent.putExtra("degree",correction_prosses());
                       myIntent.putStringArrayListExtra("c",c);
                       startActivity(myIntent);
                   }
               })
               .setNegativeButton("NO", new DialogInterface.OnClickListener() {
                   @Override
                   public void onClick(DialogInterface dialog, int which) {
                       dialog.cancel();
                   }
               });
       AlertDialog alertDialog=builder.create();
       alertDialog.show();
    }
    private int correction_prosses()
    {
        int degree=0;
        for(int i=0;i<examdata.size();i++)
        {
            student_answer=sa.getString(examdata.get(i).getId(),"No_answer");
            if(examdata.get(i).getAnswer_text().equals(student_answer))
            {
                degree+=Integer.parseInt(examdata.get(i).getDegree());
            }
        }
        return degree;
    }
}
