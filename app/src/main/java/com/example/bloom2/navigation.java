package com.example.bloom2;

import android.content.Intent;
import android.os.Bundle;

import androidx.core.view.GravityCompat;
import androidx.appcompat.app.ActionBarDrawerToggle;

import android.view.MenuItem;

import com.google.android.material.navigation.NavigationView;

import androidx.drawerlayout.widget.DrawerLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.Menu;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

public class navigation extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    private int days;
    private TextView displayCount;
    private TextView tDisplayPoints;
    private ImageView cactus;
    private ProgressBar progressBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
       getSupportActionBar().setDisplayShowTitleEnabled(false);

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);

        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);

        //match objects with declarations from xml files
        progressBar = findViewById(R.id.progress_view2);
        displayCount = findViewById(R.id.day);
        cactus = findViewById(R.id.cactus);
        tDisplayPoints = (TextView) findViewById(R.id.points);

        Intent intent = getIntent();
        int dPoints = intent.getIntExtra("POINTS", 0);
        tDisplayPoints.setText("Points: " + dPoints);

        int dProgress = intent.getIntExtra("PROGRESS", 0);
        ((ProgressBar) findViewById(R.id.progress_view2)).setProgress(dProgress);

        int dDayCount = intent.getIntExtra("DAY", 0);
        displayCount.setText("Day: " + dDayCount);

        //Make a nested conditional statement for setting the image views based on day and points earned
        if(dDayCount ==1 ) {
            if (dPoints < 4) {
                //set cactus to dying cactus asset for day one
                cactus.setImageResource(R.drawable.cday1_dead);
            } else if (dPoints >= 5 && dPoints <= 12) {
                cactus.setImageResource(R.drawable.cday1);
            }
        } else if (dDayCount == 2) {
            if (dPoints < 13) {
                cactus.setImageResource(R.drawable.cday2_dead);
            } else if (dPoints >= 14 && dPoints <= 24) {
                cactus.setImageResource(R.drawable.cday2);
            }

        } else if (dDayCount == 3) {
            if (dPoints < 29) {
                cactus.setImageResource(R.drawable.cday3_dead);
            } else if (dPoints >= 30 && dPoints <= 36) {
                cactus.setImageResource(R.drawable.cday3);
            }
        } else if (dDayCount == 4) {

            if (dPoints < 41) {
                cactus.setImageResource(R.drawable.cday4_dead);
            } else if (dPoints >= 42 && dPoints <= 48) {
                cactus.setImageResource(R.drawable.cday4);
            }
        } else if (dDayCount == 5) {

            if (dPoints < 52) {
                cactus.setImageResource(R.drawable.cday5_dead);
            } else if (dPoints >= 54 && dPoints <= 60) {
                cactus.setImageResource(R.drawable.cday5);
            }
        } else if (dDayCount == 6) {

            if (dPoints < 65) {
                cactus.setImageResource(R.drawable.cday6_dead);
            } else if (dPoints >= 66 && dPoints <= 72) {
                cactus.setImageResource(R.drawable.cday6);
            }
        } else if (dDayCount == 7) {

            if (dPoints < 77) {
                cactus.setImageResource(R.drawable.cday6_dead);
            } else if (dPoints >= 78 && dPoints <= 84) {
                cactus.setImageResource(R.drawable.cday6);
            }
        }

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.navigation, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here.
        int id = item.getItemId();


        return super.onOptionsItemSelected(item);
    }

    //add control flow for activity directory
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_home) {
            Intent i = new Intent(this, navigation.class);
            startActivity(i);
        }  else if (id == R.id.nav_timer) {
        Intent j = new Intent(this, timer.class);
        startActivity(j);
        } else if (id == R.id.nav_statistics) {
        Intent k = new Intent(this, statistics.class);
        startActivity(k);
        } else if (id == R.id.nav_garden) {
        Intent l = new Intent(this, Garden.class);
        startActivity(l);
        } else if (id == R.id.nav_tips) {
            Intent m = new Intent(this, tips.class);
            startActivity(m);
        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

}
