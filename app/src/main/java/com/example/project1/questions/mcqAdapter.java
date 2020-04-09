package com.example.project1.questions;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.List;

public class mcqAdapter extends FragmentPagerAdapter {
    List<mcq_question> fragmentList;
    public mcqAdapter(@NonNull FragmentManager fm , List<mcq_question> fragmentList ) {
        super(fm);
        this.fragmentList=fragmentList;
    }
    @NonNull
    @Override
    public Fragment getItem(int position) {
        return fragmentList.get(position);
    }
    @Override
    public int getCount() {
        return fragmentList.size();
    }
    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return new StringBuilder("Question ").append(position+1).toString();
    }
}
