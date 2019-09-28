package com.example.workout;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.FragmentTransaction;

public class MainActivity extends AppCompatActivity implements WorkoutListFragment.Listener
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void itemClicked(long id)
    {
        View fragmentContainer = findViewById(R.id.fragment_container);
                if(fragmentContainer!=null)
                {
                    WorkoutDetailActivity frag = new WorkoutDetailActivity();
                    FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
                    frag.setWorkout(id);
                    ft.replace(R.id.fragment_container,frag);
                    ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
                    ft.addToBackStack(null);
                    ft.commit();
                }
                else {
                    Intent intent = new Intent(this, DetailActivity.class);
                    intent.putExtra(DetailActivity.EXTRA_WORKOUT_ID, (int) id);
                    startActivity(intent);
                }
    }
}
