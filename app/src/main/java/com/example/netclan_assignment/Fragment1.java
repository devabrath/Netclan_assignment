package com.example.netclan_assignment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.tabs.TabLayout;

public class Fragment1 extends Fragment {
    TabLayout tabLayout;
    ViewPager viewPager;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_1, container, false);

        tabLayout = rootView.findViewById(R.id.tabLayout);
        viewPager = rootView.findViewById(R.id.viewPager);

        viewPager.setAdapter(new NestedSectionsPagerAdapter(getChildFragmentManager()));
        tabLayout.setupWithViewPager(viewPager);

        return rootView;
    }

    private static class NestedSectionsPagerAdapter extends FragmentPagerAdapter {

        public NestedSectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0:
                    return new PersonalFragment();
                case 1:
                    return new BusinessFragment();
                case 2:
                    return new MerchantFragment();
                default:
                    return null;
            }
        }

        @Override
        public int getCount() {
            return 3;
        }

        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return "Personal";
                case 1:
                    return "Business";
                case 2:
                    return "Merchant";
                default:
                    return null;
            }
        }
    }
}