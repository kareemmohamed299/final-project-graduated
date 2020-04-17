package com.example.project1.questions;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import com.example.project1.R;
import com.example.project1.connection.exam;
import com.example.project1.connection.match;
import com.example.project1.correction.result;

import android.os.CountDownTimer;
import android.view.MenuItem;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
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
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
public class question extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    RecyclerView answer_sheet_view;
    TextView txt_right_answer;
    TextView txt_timer;
    public static final int Total_Time = 2*60*1000;
    int time_play = Total_Time;
    RecyclerView.Adapter adapter;
    public static CountDownTimer countDownTimer;
    ArrayList<exam> mcqdata ;
    ArrayList<match> matchdata;
    ArrayList<String> c;
    ArrayList<Fragment> fragmentList3 = new ArrayList<>();
    ViewPager viewPager;
    TabLayout tabLayout;
    private SharedPreferences s_a_mcq,s_a_match;
    private String student_answermcq;
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
        mcqdata=new ArrayList<exam>();
        mcqdata=getIntent().getParcelableArrayListExtra("mcq");
        matchdata=new ArrayList<match>();
        matchdata=getIntent().getParcelableArrayListExtra("match");
        c = getIntent().getStringArrayListExtra("c");
        txt_right_answer = (TextView)findViewById(R.id.txt_question_right);
        txt_right_answer.setText("0 / "+(mcqdata.size()+matchdata.size()));
        txt_timer = (TextView)findViewById(R.id.txt_timer);
        txt_timer.setVisibility(View.VISIBLE);
        txt_right_answer.setVisibility(View.VISIBLE);
        countTimer();
        answer_sheet_view = (RecyclerView)findViewById(R.id.grid_answer);
        answer_sheet_view.setHasFixedSize(true);
        answer_sheet_view.setLayoutManager(new GridLayoutManager(this,4));
        //not work class AnswerSheetAdapter
        //adapter = new AnswerSheetAdapter(examdata,question.this);
        answer_sheet_view.setAdapter(adapter);
        viewPager= (ViewPager)findViewById(R.id.viewpager);
        tabLayout = (TabLayout) findViewById(R.id.sliding_tabs);
        genFragmentList1();
        genFragmentList2();
        qAdapter qAdapter  = new qAdapter(getSupportFragmentManager(),fragmentList3);
        viewPager.setAdapter(qAdapter);
        tabLayout.setupWithViewPager(viewPager);
        s_a_mcq=getSharedPreferences("mcq", Context.MODE_PRIVATE);
        s_a_match=getSharedPreferences("match", Context.MODE_PRIVATE);
        //Toast.makeText(getApplicationContext(),String.valueOf(getdegree_of_match(matchdata.get(0))),Toast.LENGTH_SHORT).show();

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
                    translatdata();
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
                    translatdata();
                    finish();
                }
            }.start();
        }
    }
    private void genFragmentList1() {
        for (int i = 0; i <mcqdata.size(); i++) {
            mcq_question frag = new mcq_question();
            Bundle bundle = new Bundle();
            bundle.putParcelable("mcq", mcqdata.get(i));
            frag.setArguments(bundle);
            fragmentList3.add(frag);
        }
    }
        private void genFragmentList2(){
            for(int i=0;i<matchdata.size();i++) {
                    match_question frag = new match_question();
                    Bundle bundle1 = new Bundle();
                    bundle1.putParcelable("match", matchdata.get(i));
                    frag.setArguments(bundle1);
                    fragmentList3.add(frag);
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
                       translatdata();
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
    private double correction_prosses_of_mcq()
    {
        double degree=0;
        for(int i=0;i<mcqdata.size();i++)
        {
            student_answermcq=s_a_mcq.getString(mcqdata.get(i).getId(),"No_answer");
            if(mcqdata.get(i).getAnswer_text().equals(student_answermcq))
            {
                degree+=Double.parseDouble(mcqdata.get(i).getDegree());
            }
        }
        return degree;
    }
    private double getdegree_of_match(match m)
    {
        double d=Integer.parseInt(m.getDegree())/m.getQuestions().size();
        return d;
    }
    private double correction_prosses_of_match()
    {
        double degree=correction_prosses_of_mcq();
        if(matchdata.size()==0)
        {
            return degree;
        }
        else
        for(int i=0;i<matchdata.size();i++)
        {
            for(int j=0;j<matchdata.get(i).getQuestions().size();j++) {

                if (matchdata.get(i).getQuestions().get(j).getAnswer().equals(s_a_match.getString(matchdata.get(i).getQuestions().get(j).getId_match(), "0")))
                {
                    degree += getdegree_of_match(matchdata.get(i));
                }
            }
        }
        return degree;
    }
    private void translatdata()
    {
        Intent myIntent = new Intent(question.this, result.class);
        myIntent.putParcelableArrayListExtra("mcq",mcqdata);
        myIntent.putParcelableArrayListExtra("match",matchdata);
        myIntent.putExtra("degree",correction_prosses_of_match());
        myIntent.putStringArrayListExtra("c",c);
        startActivity(myIntent);
    }
}
