package com.example.bloom2;
//This activity serves as a timer to track the user's points
// import packages 
import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.ProgressBar;
import android.widget.Toast;

public class timer extends AppCompatActivity  {
    private Chronometer chronometer;
    private long pauseOffSet;
    private boolean running;
    public int progress = 0;
    //declare and initialize a variable that will be passed on to the cactus activity
    public int points = 0;
    public int dayCounts;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //declare and connect ids from objects
        setContentView(R.layout.activity_timer);

        //declare a chronometer for timer
        chronometer = findViewById(R.id.chronometer);

        //declare a button and match it with the i.d. fromm XML file
        Button btn = this.findViewById(R.id.next);

        //this method connects the transition button between the timer activity and the main screen
        btn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                //convert time elapsed to numeric value to calculate points
                long timeElapsed = SystemClock.elapsedRealtime() - chronometer.getBase();
                int hours = (int) (timeElapsed / 3600000);
                //increment progress bar with points
                progress += hours;
                ((ProgressBar) findViewById(R.id.progress_view)).setProgress(progress);
                Toast.makeText(getApplicationContext(),"You slept " + hours+ " hours!", Toast.LENGTH_SHORT).show();

                if (hours >= 8 & hours <= 10) {
                    Toast.makeText(getApplicationContext(),"Good job!", Toast.LENGTH_LONG).show();
                } else if (hours < 8 & hours > 3) {
                    Toast.makeText(getApplicationContext(),"Your cactus might die!!!", Toast.LENGTH_LONG).show();
                } else if (hours < 3) {

                }

                //Increment values accordingly
                points += hours;
                dayCounts++;
                Intent intent = new Intent(timer.this, navigation.class);
                intent.putExtra("PROGRESS", progress);
                intent.putExtra("POINTS", points);
                intent.putExtra("DAY", dayCounts);
                startActivity(intent);
            }
        });

    }

//Conditional logic to start and stop the chronometer
    public void startChronometer(View v) {
        if(!running) {
            //replace pause offset with 3600000 to show 1 hour has elapsed for demo purposes
            chronometer.setBase(SystemClock.elapsedRealtime()-pauseOffSet );
            chronometer.start();
            running = true;
        }
    }
    public void stopChronometer(View v) {
        if (running) {
            chronometer.stop();
            pauseOffSet = SystemClock.elapsedRealtime() - chronometer.getBase();
            running = false;
        }

    }
}


