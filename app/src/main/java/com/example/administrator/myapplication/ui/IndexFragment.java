package com.example.administrator.myapplication.ui;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;

import com.example.administrator.myapplication.R;
import com.example.administrator.myapplication.fragment.LifeFragment;
import com.example.administrator.myapplication.fragment.TechFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class IndexFragment extends Fragment {
    private View mView;
    private TabLayout mTabLayout;
    private ViewPager mViewPager;
    private List<Fragment> mFragments;
    public IndexFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mView=inflater.inflate(R.layout.fragment_index, container, false);
        initView();
        init();
        return mView;
    }

    private void initView() {
        mTabLayout=(TabLayout)mView.findViewById(R.id.tab_layout);
        mViewPager=(ViewPager)mView.findViewById(R.id.view_pager);
    }
    //要点一
    private void init(){
     mFragments=new ArrayList<>();
     mFragments.add(new LifeFragment());
     mFragments.add(new TechFragment());

     //要点二.创建适配器
        MyPagerAdapter adapter= new MyPagerAdapter(getChildFragmentManager());
        mViewPager.setAdapter(adapter);

     //要点三.将选项卡和滑动绑定到一起
        mTabLayout.setupWithViewPager(mViewPager);
     //要点四 将文字信息添加到选项卡
        mTabLayout.getTabAt(0).setText("生活");
        mTabLayout.getTabAt(1).setText("科学");

    }

    private class MyPagerAdapter extends FragmentPagerAdapter {
        public MyPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragments.get(position);
        }

        @Override
        public int getCount() {
            return mFragments.size();
        }
    }
}
