package com.example.jeevesh.myapplication3;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.view.ViewGroup;

import java.util.ArrayList;

public class CustomViewPageAdapter extends FragmentStatePagerAdapter {

    private ArrayList<String> arrayList;
    private ArrayList<VPFragment> vpFragments;

    public CustomViewPageAdapter(FragmentManager fm, ArrayList<String> arrayList, ArrayList<VPFragment> vpFragments) {
        super(fm);
        this.arrayList = arrayList;
        this.vpFragments = vpFragments;
    }

    @Override
    public Fragment getItem(int position) {
        return vpFragments.get(position);
    }

    @Override
    public int getCount() {
        return vpFragments.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return arrayList.get(position);
    }

    @Override
    public int getItemPosition(@NonNull Object object) {
        return POSITION_NONE;
    }

//    @Override
//    public void destroyItem(ViewGroup container, int position, Object object) {
//        super.destroyItem(container, position, object);
//    }

}
