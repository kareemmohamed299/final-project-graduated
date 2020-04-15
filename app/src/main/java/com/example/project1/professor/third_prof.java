package com.example.project1.professor;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.project1.R;
import com.example.project1.connection.doctor_course;
import com.example.project1.courses_demo;
import com.example.project1.profile;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import java.util.ArrayList;

public class third_prof extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    private static final String TAG = "third";
    BottomNavigationView bottomNavigationView;
    private ArrayList<doctor_course> course ;
    private ArrayList<String >doctor1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.third_prof);

        bottomNavigationView = findViewById(R.id.bottom_navigation_view);


        bottomNavigationView.setOnNavigationItemSelectedListener(this);
        bottomNavigationView.setSelectedItemId(R.id.navigation_profile_prof);
    }

    profile_prof profile = new profile_prof();
    courses_demo_prof courses_demo = new courses_demo_prof();
    about_prof about = new about_prof();



    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        FragmentManager manager = getSupportFragmentManager();
        final FragmentTransaction t = manager.beginTransaction();
        final profile_prof prof = new profile_prof();
        final courses_demo_prof courses_demo = new courses_demo_prof();
        doctor1 = new ArrayList<String>();
        course = new ArrayList<doctor_course>();
        course = getIntent().getParcelableArrayListExtra("course");
        doctor1 = getIntent().getStringArrayListExtra("doctor");
        Bundle bundle = new Bundle();
        bundle.putStringArrayList("doctor" , doctor1);
        bundle.putParcelableArrayList("course" , course);
        switch(item.getItemId())
        {
            case R.id.navigation_profile_prof:
                //getSupportFragmentManager().beginTransaction().setCustomAnimations(R.anim.fade_in,R.anim.fade_out).replace(R.id.container,profile).commit();
                prof.setArguments(bundle);
                t.replace(R.id.container ,prof).commit();
                return true;
            case R.id.navigation_courses_prof:
                //getSupportFragmentManager().beginTransaction().setCustomAnimations(R.anim.fade_in,R.anim.fade_out).replace(R.id.container, courses_demo).commit();
                courses_demo.setArguments(bundle);
                t.replace(R.id.container ,courses_demo).commit();
                return true;
            case R.id.navigation_about_prof:
                getSupportFragmentManager().beginTransaction().setCustomAnimations(R.anim.fade_in,R.anim.fade_out).replace(R.id.container,about).commit();
                return true;
        }
        return false;
    }
}

