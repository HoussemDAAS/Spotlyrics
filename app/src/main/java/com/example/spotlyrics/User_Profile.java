package com.example.spotlyrics;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.PopupMenu;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;

public class User_Profile extends AppCompatActivity {
    DrawerLayout drawerLayout;
    NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile);

        drawerLayout = findViewById(R.id.nav_user);
        navigationView = findViewById(R.id.nav);

        // Initialize menu button
        ImageButton menuButton = findViewById(R.id.menuButton);
        menuButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                drawerLayout.openDrawer(navigationView);
            }
        });

        // Set up the navigation drawer
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.favorite:
                        Toast.makeText(User_Profile.this, "Favorite is Selected", Toast.LENGTH_SHORT).show();
                        Intent likedIntent = new Intent(User_Profile.this, Liked.class);
                        startActivity(likedIntent);
                        break;
                    case R.id.search:
                        Intent searchIntent = new Intent(User_Profile.this, Search.class);
                        startActivity(searchIntent);
                        break;
                    case R.id.settings:
                        Toast.makeText(User_Profile.this, "Settings is Selected", Toast.LENGTH_SHORT).show();
                        Intent settingsIntent = new Intent(User_Profile.this, Settings.class);
                        startActivity(settingsIntent);
                        break;
                    case R.id.exit:
                        Intent exitIntent = new Intent(User_Profile.this, MainActivity.class);
                        startActivity(exitIntent);
                        break;
                }
                drawerLayout.closeDrawers();
                return true;
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.search:
                Intent searchIntent = new Intent(User_Profile.this, Search.class);
                startActivity(searchIntent);
                return true;
            case R.id.favorite:
                Intent likedIntent = new Intent(User_Profile.this, Liked.class);
                startActivity(likedIntent);
                return true;
            case R.id.settings:
                Intent settingsIntent = new Intent(User_Profile.this, Settings.class);
                startActivity(settingsIntent);
                return true;
            case R.id.exit:
                Intent exitIntent = new Intent(User_Profile.this, MainActivity.class);
                startActivity(exitIntent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(navigationView)) {
            drawerLayout.closeDrawer(navigationView);
        } else {
            super.onBackPressed();
        }
    }
}
