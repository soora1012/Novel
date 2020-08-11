package com.gmail.soora1012.Novel.activity;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

import com.gmail.soora1012.Novel.R;
import com.gmail.soora1012.Novel.fragment.MenuFragment1;
import com.gmail.soora1012.Novel.fragment.MenuFragment2;
import com.gmail.soora1012.Novel.fragment.MenuFragment3;

public class MainActivity extends AppCompatActivity {


    private FragmentManager fragmentManager = getSupportFragmentManager();
    private MenuFragment1 menuFragment1 = new MenuFragment1();
    private MenuFragment2 menuFragment2 = new MenuFragment2();
    private MenuFragment3 menuFragment3 = new MenuFragment3();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        BottomNavigationView bottomNavigationView = findViewById(R.id.nv_bottom);
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.frame_layout, menuFragment1).commitAllowingStateLoss();

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                FragmentTransaction transaction = fragmentManager.beginTransaction();
                switch (item.getItemId()) {
                    case R.id.navigation_menu1: {
                        transaction.replace(R.id.frame_layout, menuFragment1).commitAllowingStateLoss();
                        break;
                    }
                    case R.id.navigation_menu2: {
                        transaction.replace(R.id.frame_layout, menuFragment2).commitAllowingStateLoss();
                        break;
                    }
//                    case R.id.navigation_menu3: {
//                        transaction.replace(R.id.frame_layout, menuFragment3).commitAllowingStateLoss();
//                        break;
//                    }
                }
                return true;
            }
        });

    }

}
