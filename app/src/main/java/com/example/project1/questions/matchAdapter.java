package com.example.project1.questions;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.List;

public class matchAdapter extends FragmentPagerAdapter {

    List<match_question> fragmentList2;
    public matchAdapter(@NonNull FragmentManager fm , List<match_question> fragmentList2 ) {
        super(fm);
        this.fragmentList2=fragmentList2;
    }
    @NonNull
    @Override
    public Fragment getItem(int position) {
        return fragmentList2.get(position);
    }
    @Override
    public int getCount() {
        return fragmentList2.size();
    }
    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return new StringBuilder("Question ").append(position+1).toString();
    }
}
