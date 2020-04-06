package com.example.project1.questions;

import android.content.Intent;
import android.os.Bundle;

import com.example.project1.R;
import com.example.project1.result;

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
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class question extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private AppBarConfiguration mAppBarConfiguration;
    RecyclerView answer_sheet_view;
    TextView txt_right_answer;
    TextView txt_timer;
    RecyclerView.Adapter adapter;
    boolean isAnswerModeView = false;

    public  static ArrayList<mcq_question> fragmentList = new ArrayList<>();
    public  String[] questionList = {"question 1","question 2","question 3","question 4","question 5","question 6"
    };

    ViewPager viewPager;
    TabLayout tabLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
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
        txt_timer = (TextView)findViewById(R.id.txt_timer);
        txt_timer.setVisibility(View.VISIBLE);
        txt_right_answer.setVisibility(View.VISIBLE);

        navigationView.setNavigationItemSelectedListener(this);
        answer_sheet_view = (RecyclerView)findViewById(R.id.grid_answer);
        answer_sheet_view.setHasFixedSize(true);
        answer_sheet_view.setLayoutManager(new GridLayoutManager(this,4));

        adapter = new AnswerSheetAdapter(questionList);
        answer_sheet_view.setAdapter(adapter);

        viewPager = (ViewPager)findViewById(R.id.viewpager);
        tabLayout = (TabLayout) findViewById(R.id.sliding_tabs);

        genFragmentList();
        mcqAdapter mcqAdapter  = new mcqAdapter(getSupportFragmentManager(),fragmentList);


        viewPager.setAdapter(mcqAdapter);
        tabLayout.setupWithViewPager(viewPager);

    }


    private void genFragmentList(){
        for(int i=0;i<questionList.length;i++)
        {
            mcq_question frag = new mcq_question();
            fragmentList.add(frag);
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
    //@Override
  /*  public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }*/
}
