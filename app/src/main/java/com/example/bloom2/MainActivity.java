package com.example.bloom2;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
Button launch;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        launch = findViewById(R.id.getStarted);
//this method changes the activity to the main one from a click of a button
        launch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //transition from start screen to home screen of app
                Intent i = new Intent(MainActivity.this, navigation.class);
                startActivity(i);
            }
        });
    }
}
