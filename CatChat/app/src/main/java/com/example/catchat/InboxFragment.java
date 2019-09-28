package com.example.catchat;

import android.view.View;
import android.view.ViewGroup;
import android.os.Bundle;
import android.view.LayoutInflater;
import androidx.fragment.app.Fragment;

public class InboxFragment extends Fragment
{
    @Override
    public View onCreateView(LayoutInflater inflater,ViewGroup container, Bundle savedInstanceState)
    {
        return inflater.inflate(R.layout.fragment_inbox,container,false);
    }
}
