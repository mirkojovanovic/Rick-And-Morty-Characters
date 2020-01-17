package com.example.android.mj_rickandmorty.ui;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;

import com.example.android.mj_rickandmorty.CharacterAdapter;
import com.example.android.mj_rickandmorty.R;
import com.example.android.mj_rickandmorty.models.Character;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<Character> characterList;
    public CharacterAdapter characterAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        NavController
                navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation_view);
        NavigationUI.setupWithNavController(bottomNavigationView, navController);
    }

}
