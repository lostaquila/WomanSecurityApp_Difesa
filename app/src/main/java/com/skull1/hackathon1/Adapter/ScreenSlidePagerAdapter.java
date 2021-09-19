package com.skull1.hackathon1.Adapter;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.skull1.hackathon1.Front.DashboardFragment;
import com.skull1.hackathon1.Front.FourthFragment;
import com.skull1.hackathon1.Front.HomeFragment;
import com.skull1.hackathon1.Front.InfantFragment;
import com.skull1.hackathon1.Front.ProfileFragment;
import com.skull1.hackathon1.Medical.bcgActivity;
import com.skull1.hackathon1.News.NewsActivity;

public class ScreenSlidePagerAdapter extends FragmentStatePagerAdapter {

    public ScreenSlidePagerAdapter(FragmentManager fm) {
        super(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);


    }



    @Override
    public Fragment getItem(int pos) {
        switch(pos) {

            case 0: return new HomeFragment();
            case 1: return new DashboardFragment();
            case 2: return new ProfileFragment();
            case 3: return new FourthFragment();
            case 4: return new InfantFragment();
            case 5: return new NewsActivity();


            default: return new HomeFragment();
        }
    }

    @Override
    public int getCount() {
        return 6;
    }
}
