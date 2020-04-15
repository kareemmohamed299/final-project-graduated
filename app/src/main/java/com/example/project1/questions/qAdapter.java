package com.example.project1.questions;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import java.util.List;

public class qAdapter extends FragmentStatePagerAdapter {

    private List<Fragment> fragmentList3;

    public qAdapter(FragmentManager fm, List<Fragment> fragmentList3)
    {
        super(fm);
        this.fragmentList3 = fragmentList3;
    }
    @Override
    public Fragment getItem(int position) {
        return fragmentList3.get(position);
    }

    @Override
    public int getCount() {
        return fragmentList3.size();
    }

    public CharSequence getPageTitle(int position) {
        return new StringBuilder("Question ").append(position+1).toString();
    }

}
