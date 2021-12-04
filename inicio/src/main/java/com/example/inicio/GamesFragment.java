package com.example.inicio;

import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;

public class GamesFragment extends Fragment {

    private TabLayout tabLayout;
    private ViewPager viewPager;
    private VPAdapter vpAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_games, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
//        view = inflater.inflate(R.layout.fragment_games, container);

        tabLayout = (TabLayout) view.findViewById(R.id.tabGames);
        viewPager = (ViewPager) view.findViewById(R.id.viewPager);

        tabLayout.setupWithViewPager(viewPager);
        vpAdapter = new VPAdapter(getChildFragmentManager(), FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        vpAdapter.addFragment(new PuzzleFragment(), "ROMPECABEZAS");
        vpAdapter.addFragment(new SideLineFragment(), "BANDA");
        viewPager.setAdapter(vpAdapter);


    }
}