package com.example.project1.questions;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

import com.example.project1.R;
import com.example.project1.connection.exam;
import com.example.project1.result;

import android.os.CountDownTimer;
import android.view.MenuItem;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
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
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
public class question extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private AppBarConfiguration mAppBarConfiguration;
    RecyclerView answer_sheet_view;
    TextView txt_right_answer;
    TextView txt_timer;
    public static final int Total_Time = 1*60*1000;
    int time_play = Total_Time;
    RecyclerView.Adapter adapter;
    boolean isAnswerModeView = false;
    public static CountDownTimer countDownTimer;
    ArrayList<exam> examdata ;
    public  static ArrayList<mcq_question> fragmentList = new ArrayList<>();
    ViewPager viewPager;
    TabLayout tabLayout;
    //for choices
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
        NavigationView navigationView = findViewById(R.id.nav_view);
        examdata=new ArrayList<exam>();
        examdata=getIntent().getParcelableArrayListExtra("exam");
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
       /* mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home, R.id.nav_gallery, R.id.nav_slideshow,
                R.id.nav_tools, R.id.nav_share, R.id.nav_send)
                .setDrawerLayout(drawer)
                .build();*/
     /*   NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);*/
        txt_right_answer = (TextView)findViewById(R.id.txt_question_right);
        txt_right_answer.setText("0 / "+examdata.size());
        txt_timer = (TextView)findViewById(R.id.txt_timer);
        txt_timer.setVisibility(View.VISIBLE);
        txt_right_answer.setVisibility(View.VISIBLE);
        countTimer();
        navigationView.setNavigationItemSelectedListener(this);
        answer_sheet_view = (RecyclerView)findViewById(R.id.grid_answer);
        answer_sheet_view.setHasFixedSize(true);
        answer_sheet_view.setLayoutManager(new GridLayoutManager(this,4));
        adapter = new AnswerSheetAdapter(examdata);
        answer_sheet_view.setAdapter(adapter);
        viewPager = (ViewPager)findViewById(R.id.viewpager);
        tabLayout = (TabLayout) findViewById(R.id.sliding_tabs);
        genFragmentList();
        mcqAdapter mcqAdapter  = new mcqAdapter(getSupportFragmentManager(),fragmentList);
        //for choices
        viewPager.setAdapter(mcqAdapter);
        tabLayout.setupWithViewPager(viewPager);
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
                    startActivity(myIntent);
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
                    startActivity(myIntent);
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
        // Inflate the menu; this adds items to the action bar if it is present.
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
            if(!isAnswerModeView)
            {
                AlertDialog dialog =new AlertDialog.Builder(this)
                        .setMessage("Do you want to finish?").setNegativeButton("No",null)
                        .setPositiveButton("Yes",null).show();
                Button positive = dialog.getButton(AlertDialog.BUTTON_POSITIVE);
                positive.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent myIntent = new Intent(question.this, result.class);
                        startActivity(myIntent);
                    }
                });

            }
            return true;
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
    //@Override
  /*  public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }*/
}
