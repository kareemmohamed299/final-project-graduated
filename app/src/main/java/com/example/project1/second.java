package com.example.project1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.PagerAdapter;

import android.os.Bundle;

import com.example.project1.fragments.cpage1;
import com.example.project1.fragments.cpage2;

import java.util.ArrayList;
import java.util.List;

public class second extends AppCompatActivity {
    private VerticalViewPager viewPager ;
    private PagerAdapter pagerAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second);
        List<Fragment> list = new ArrayList<>();
        list.add(new cpage1());
        list.add(new cpage2());
        viewPager = findViewById(R.id.pager);
        pagerAdapter = new VPagerAdapter(getSupportFragmentManager(),list);
        viewPager.setAdapter(pagerAdapter);


    }
}
