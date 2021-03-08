package com.example.elghazaly_midt1;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class showBig extends AppCompatActivity {
    TextView txt;
    MediaPlayer song;
    int x;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_big);
        song=new MediaPlayer();
        song=MediaPlayer.create(this,R.raw.track1);
        x=1;

        txt=(TextView)findViewById(R.id.textView5);



        txt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                x++;
                if(x%2==0)
                    song.start();
                else
                    song.pause();

            }
        });
    }
}