package com.example.mymessenger;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity 
{

    @Override
    protected void onCreate(Bundle savedInstanceState) 
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void OnSendMessage(View view)
    {
        EditText edittextobj = findViewById(R.id.message);
        String text = edittextobj.getText().toString();//This was different for a Spinner
        Intent intent = new Intent(Intent.ACTION_SEND);//intent is the IntentObject
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_TEXT,text);
        String choosertitle = getString(R.string.chooser);//You recover your string values from string.xml. In the .xml file you use a @string thing
        Intent chosenintent = Intent.createChooser(intent,choosertitle);
        startActivity(chosenintent);
    }
}
