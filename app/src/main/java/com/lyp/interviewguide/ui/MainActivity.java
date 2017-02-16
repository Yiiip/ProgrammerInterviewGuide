package com.lyp.interviewguide.ui;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.lyp.interviewguide.R;
import com.lyp.interviewguide.adapter.TabViewPagerAdapter;

import cn.hugeterry.coordinatortablayout.CoordinatorTabLayout;

public class MainActivity extends AppCompatActivity {

    private int[] mImageArray = {
            R.mipmap.bg_01,
            R.mipmap.bg_02,
            R.mipmap.bg_03};

    private int[] mColorArray = {
            android.R.color.holo_blue_light,
            android.R.color.holo_red_light,
            android.R.color.holo_green_light};

    private CoordinatorTabLayout mCoordinatorTabLayout;
    private ViewPager mViewPager;

    private TabViewPagerAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        mAdapter = new TabViewPagerAdapter(getSupportFragmentManager());
        mAdapter.addFragments(new KnowledgeFragment(), "基础知识BAT");
        mAdapter.addFragments(new AlgorithmFragment(), "算法面试题");
        mAdapter.addFragments(new AboutFragment(), "关于");

        mViewPager = (ViewPager) findViewById(R.id.main_view_pager);
        mViewPager.setOffscreenPageLimit(3);
        mViewPager.setAdapter(mAdapter);

        mCoordinatorTabLayout = (CoordinatorTabLayout) findViewById(R.id.main_coordinator_tab_layout);
        mCoordinatorTabLayout.setTitle(getResources().getString(R.string.app_name))
                .setImageArray(mImageArray, mColorArray)
                .setupWithViewPager(mViewPager);
    }
}
