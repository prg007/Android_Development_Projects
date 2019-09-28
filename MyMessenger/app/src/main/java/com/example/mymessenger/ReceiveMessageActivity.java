package com.example.mymessenger;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.content.Intent;
import android.widget.TextView;


public class ReceiveMessageActivity extends AppCompatActivity
{
    public static final String EXTRA_MESSAGE = "message";
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_receive_message);
        Intent intent = getIntent();
        String text = intent.getStringExtra(EXTRA_MESSAGE);
        TextView obj = findViewById(R.id.message);
        obj.setText(text);
    }
}
