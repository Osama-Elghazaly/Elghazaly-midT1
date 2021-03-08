package com.example.elghazaly_midt1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;

public class Splash extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        TextView times=(TextView)findViewById(R.id.textView);


        TimerTask task=new TimerTask() {
            @Override
            public void run() {
                // do something here
                finish();
                startActivity(new Intent(Splash.this,MainActivity.class));

            }
        };

        //time.setText(String.valueOf(timer));

        Timer timer=new Timer();
        timer.schedule(task,6000);

        int time=30;



    }
}