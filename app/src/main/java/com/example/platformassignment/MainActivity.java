package com.example.platformassignment;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.EditText;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    BottomNavigationView botNavView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        botNavView = findViewById(R.id.bottomNavView);

        botNavView.setOnNavigationItemSelectedListener(navigationItemListener);
        // get the support for fragments
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new RegisterFragment()).commit();
    }

    private BottomNavigationView.OnNavigationItemSelectedListener navigationItemListener=new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment selectedFragment = null;

            switch (item.getItemId()) {
                case R.id.register:
                    selectedFragment = new RegisterFragment();
                    break;
                case R.id.login:
                    selectedFragment = new LoginFragment();
                    break;
                case R.id.profile:
                    selectedFragment = new ProfileFragment();
                    break;
                case R.id.followers:
                    selectedFragment = new FollowersFragment();
                    break;
            }

            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, selectedFragment).commit();
            return true;
        }
    };
}