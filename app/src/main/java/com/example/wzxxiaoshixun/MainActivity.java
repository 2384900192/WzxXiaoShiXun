package com.example.wzxxiaoshixun;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.wzxxiaoshixun.activity.FenActivity;
import com.example.wzxxiaoshixun.adapter.MainAdapter;
import com.example.wzxxiaoshixun.fragment.FlirFragment;
import com.example.wzxxiaoshixun.fragment.OneFragment;
import com.example.wzxxiaoshixun.fragment.TwoFragment;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.annotations.NonNull;

public class MainActivity extends AppCompatActivity {

    private Toolbar mToolbar;
    private ViewPager mViewpager;
    private TabLayout mTablayout;
    private LinearLayout mLinear;
    private NavigationView mNavig;
    private DrawerLayout mDrawer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();



    }

    private void initView() {
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        mViewpager = (ViewPager) findViewById(R.id.viewpager);
        mTablayout = (TabLayout) findViewById(R.id.tablayout);
        mLinear = (LinearLayout) findViewById(R.id.linear);
        mNavig = (NavigationView) findViewById(R.id.navig);
        mDrawer = (DrawerLayout) findViewById(R.id.drawer);
        mToolbar.setLogo(R.mipmap.ic_launcher);
//        mToolbar.setTitle(getResources().getString(R.string.conversation));
        mToolbar.setTitleTextColor(Color.WHITE);
        setSupportActionBar(mToolbar);
        ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(this, mDrawer, mToolbar, R.string.hoop, R.string.coller);
        mDrawer.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();
        //侧滑头部处理
        View headerView = mNavig.getHeaderView(0);
        ImageView iv_dl_header = headerView.findViewById(R.id.iv_dl_header);
        RequestOptions requestOptions = new RequestOptions();
        requestOptions.circleCrop();
        Glide.with(this).load(R.drawable.adc).apply(requestOptions).into(iv_dl_header);
        iv_dl_header.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, FenActivity.class);
                startActivity(intent);
                Toast.makeText(MainActivity.this, "点击头部", Toast.LENGTH_SHORT).show();
            }
        });
        //主界面跟随侧滑在x轴方向移动
        mDrawer.addDrawerListener(new DrawerLayout.DrawerListener() {
            @Override
            public void onDrawerSlide(@NonNull View drawerView, float slideOffset) {
                int right = drawerView.getRight();
                mLinear.setX(right);
            }

            @Override
            public void onDrawerOpened(@NonNull View drawerView) {

            }

            @Override
            public void onDrawerClosed(@NonNull View drawerView) {

            }

            @Override
            public void onDrawerStateChanged(int newState) {

            }
        });

        List<Fragment> list=new ArrayList<>();
        list.add(new OneFragment());
        list.add(new TwoFragment());
        list.add(new FlirFragment());
        MainAdapter mainAdapter = new MainAdapter(getSupportFragmentManager(), list);
        mViewpager.setAdapter(mainAdapter);
        mTablayout.setupWithViewPager(mViewpager);
        mTablayout.getTabAt(0).setText("1");
        mTablayout.getTabAt(1).setText("2");
        mTablayout.getTabAt(2).setText("3");
    }
}
