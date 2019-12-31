package com.example.administrator.myapplication;


import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;


import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;
import com.example.administrator.myapplication.ui.IndexFragment;
import com.example.administrator.myapplication.ui.VideoFragment;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements BottomNavigationBar.OnTabSelectedListener {
    private BottomNavigationBar mBottomNavigationBar;
    private List<Fragment> mFragments;     //一.创建Fragments列表
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        init();
    }

    private void initView() {
        mBottomNavigationBar=(BottomNavigationBar)findViewById(R.id.bottom_nagivation_bar);
    }
    private void init(){
        mFragments= new ArrayList<>();
        mFragments.add(new IndexFragment());
        mFragments.add(new VideoFragment());

        //要点二 .添加底部导航栏
        mBottomNavigationBar.addItem(new BottomNavigationItem(R.drawable.index_list,"首页"))
                .addItem(new BottomNavigationItem(R.drawable.video_list,"视频"))
                .setMode(BottomNavigationBar.MODE_FIXED)  //设置进行切换的方式
                .initialise();  //进行启动

        //要点三. 切换时事件监听
        mBottomNavigationBar.setTabSelectedListener(this);
        selectTab(0);
    }

    @Override
    public void onTabSelected(int position) {
        selectTab(position);
    }

    @Override
    public void onTabUnselected(int position) {

    }

    @Override
    public void onTabReselected(int position) {

    }
    //要点四 .底部选项卡之间的切换
    public void selectTab(int position){
        FragmentManager fm=this.getSupportFragmentManager();  //获得相应的片段
        FragmentTransaction ft=fm.beginTransaction();  //将相应的片段加入到事物中
        ft.replace(R.id.main_container,mFragments.get(position)); //不同索引之间进行切换
        ft.commit();  //事物提交
    }
}
