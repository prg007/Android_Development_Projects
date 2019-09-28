package com.example.beeradviser;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Spinner;
import android.widget.TextView;
import java.util.List;
import java.lang.String;


public class MainActivity extends AppCompatActivity
{
    private BeerExpert expert = new BeerExpert();
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void onClickFindBeer(View view)
    {
        TextView brands =  findViewById(R.id.brands);
        Spinner color =  findViewById(R.id.color);
        String BeerType = String.valueOf(color.getSelectedItem());
        List<String> brandslist = expert.getBrands(BeerType);
        StringBuilder empty = new StringBuilder();

        for (String temp : brandslist)
        {
           empty.append(temp).append("\n");
        }
        brands.setText(empty);

    }
}
