package com.example.project1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

import com.example.project1.connection.cource;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;

public class third extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    private static final String TAG = "third";
    BottomNavigationView bottomNavigationView;
    ArrayList<String>student1 ;
    ArrayList<cource> course ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.third);
        bottomNavigationView = findViewById(R.id.bottom_navigation_view);
        bottomNavigationView.setOnNavigationItemSelectedListener(this);
        bottomNavigationView.setSelectedItemId(R.id.navigation_profile);

    }

    profile profile = new profile();
    courses_demo courses_demo = new courses_demo();
    about about = new about();

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        FragmentManager manager = getSupportFragmentManager();
        final FragmentTransaction t = manager.beginTransaction();
        final profile prof = new profile();
        final courses_demo courses_demo = new courses_demo();
        student1 =  new ArrayList<String>();
        course = new ArrayList<cource>();
        course = getIntent().getParcelableArrayListExtra("course");
        student1 = getIntent().getStringArrayListExtra("student");
        Bundle bundle = new Bundle();
        bundle.putStringArrayList("student" , student1);
        bundle.putParcelableArrayList("course" , course);
        switch(item.getItemId())
        {
            case R.id.navigation_profile:
                prof.setArguments(bundle);
                t.replace(R.id.container ,prof).commit();
                return true;
            case R.id.navigation_courses:
                courses_demo.setArguments(bundle);
                t.replace(R.id.container ,courses_demo).commit();
                return true;
            case R.id.navigation_about:
                getSupportFragmentManager().beginTransaction().setCustomAnimations(R.anim.fade_in,R.anim.fade_out).replace(R.id.container,about).commit();
                return true;
        }
        return false;
    }

}
