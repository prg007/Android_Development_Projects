package com.example.workout;

import android.os.Bundle;
import android.os.Handler;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import java.util.Locale;
import android.widget.Button;


public class StopwatchFragment extends Fragment implements View.OnClickListener
{

    private int seconds = 0;
    private boolean running;
    private boolean wasRunning;


    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        if(savedInstanceState != null)
        {
            seconds = savedInstanceState.getInt("seconds");
            running = savedInstanceState.getBoolean("running");
            wasRunning = savedInstanceState.getBoolean("wasRunning");
        }
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        // Inflate the layout for this fragment
        View layout =  inflater.inflate(R.layout.fragment_stopwatch, container, false);
        runTimer(layout);

        Button startbutton = layout.findViewById(R.id.start_button);
        startbutton.setOnClickListener(this);

        Button stopbutton = layout.findViewById(R.id.stop_button);
        stopbutton.setOnClickListener(this);

        Button resetbutton = layout.findViewById(R.id.reset_button);
        resetbutton.setOnClickListener(this);

        return layout;
    }
    @Override
    public void onClick(View view)
    {
        switch (view.getId())
        {


            case R.id.start_button:
                OnClickStart();
                break;
            case R.id.stop_button:
                OnClickStop();
                break;
            case R.id.reset_button:
                OnClickReset();
                break;

        }
    }
    @Override
    public void onPause()
    {
        super.onPause();
        wasRunning = running;
        running = false;
    }

    @Override
    public void onResume()
    {
        super.onResume();
        if(wasRunning)
        {
            running = true;
        }
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState)
    {
        savedInstanceState.putInt("seconds",seconds);
        savedInstanceState.putBoolean("running",running);
        savedInstanceState.putBoolean("wasRunning",wasRunning);
    }

    private void OnClickStart()
    {
        running = true;
    }
    private void OnClickStop()
    {
        running = false;
    }
    private void OnClickReset()
    {
        running = false;
        seconds = 0;
    }
    private void runTimer(View view)
    {
        final TextView timeView = view.findViewById(R.id.time_view);
        final Handler handler = new Handler();
        handler.post(new Runnable() {
            @Override
            public void run()
            {
                int hours = seconds/3600;
                int minutes = (seconds%3600)/60;
                int secs = seconds%60;
                String time = String.format(Locale.getDefault(),"%d:%02d:%02d",hours,minutes,secs);
                timeView.setText(time);
                if(running)
                {
                    seconds++;
                }
                handler.postDelayed(this,1000);
            }
        });
    }
}
