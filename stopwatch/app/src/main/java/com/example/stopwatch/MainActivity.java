package com.example.stopwatch;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import java.util.Locale;
import android.os.Handler;

public class MainActivity extends AppCompatActivity
{
    private int seconds = 0;
    private boolean running;
    private boolean WasRunning;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (savedInstanceState != null)
        {
            seconds = savedInstanceState.getInt("seconds");
            running = savedInstanceState.getBoolean("running");
            WasRunning = savedInstanceState.getBoolean("WasRunning");
        }

        runTimer();
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState)
    {
        savedInstanceState.putInt("seconds",seconds);
        savedInstanceState.putBoolean("running",running);
        savedInstanceState.putBoolean("WasRunning",WasRunning);
    }

    @Override
    protected void onPause()
    {
        super.onPause();
        WasRunning = running;
        running = false;
    }

    @Override
    protected void onResume()
    {
        super.onResume();
        if(WasRunning)
        {
            running = true;
        }

    }


    public void OnClickStart(View view)
    {
        running = true;
    }
    public void OnClickStop(View view)
    {
        running = false;
    }
    public void OnClickReset(View view)
    {
        running = false;
        seconds = 0;
    }

    private void runTimer()
    {
        final TextView timeview = findViewById(R.id.time_view);
        final Handler handler = new Handler();
        handler.post(new Runnable()
        {
            @Override
            public void run()
            {
                int hours = seconds / 3600;
                int minutes = (seconds % 3600) / 60;
                int secs  = seconds % 60;
                String time = String.format(Locale.getDefault(), "%d:%02d:%02d", hours, minutes, secs);
                timeview.setText(time);
                if (running)
                {
                    seconds++;

                }
                handler.postDelayed(this, 1000);
            }
        });

    }

}
