package com.example.stopwtuto;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private  int seconds;
    private boolean running;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (savedInstanceState!=null){
            seconds=savedInstanceState.getInt("second");
            running=savedInstanceState.getBoolean("running");
        }

        runTimer();
    }

    @Override
    protected void onSaveInstanceState( Bundle savedInstanceState) {

        super.onSaveInstanceState(savedInstanceState);
        savedInstanceState.putInt("second", seconds);
        savedInstanceState.putBoolean("running", running);
    }

    public void btnStart(View view){
        running=true;
    }

    public void btnStop(View view){
        running=false;
    }

    public void btnReset(View view){
        running=false;
        seconds=0;
    }

    public void runTimer(){

        final TextView timeView=(TextView) findViewById(R.id.tv_time);
        final Handler handler= new Handler();
        handler.post(new Runnable() {
            @Override
            public void run() {
                int hour= seconds/3600;
                int minute=(seconds%3600)/60;
                int sec=seconds%60;

                String time=String.format("%d:%02d:%02d",hour,minute,sec);
                timeView.setText(time);

                if(running){
                    seconds++;
                }
            handler.postDelayed(this,1000);

            }

        });

    }
}