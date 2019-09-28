package com.example.pets;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Spinner;
import java.lang.String;
import java.util.List;



public class MainActivity extends AppCompatActivity {

    private Breeds breed = new Breeds();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void FindPets(View view)
    {
        TextView obj = findViewById(R.id.nothingtoshowyet);
        Spinner objspi = findViewById(R.id.color);
        String str = String.valueOf(objspi.getSelectedItem());
        List<String> breeds = breed.generatebreeds(str);

        StringBuilder empty = new StringBuilder();

        for (String temp : breeds)
        {
            empty.append(temp).append("\n");
        }
        obj.setText(empty);
    }
}
