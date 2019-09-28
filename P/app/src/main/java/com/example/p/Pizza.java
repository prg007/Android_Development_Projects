package com.example.p;

public class Pizza
{
    private String name;
    private int imageResourceID;

    public static final Pizza[] pizzas =
    {
            new Pizza("Diavalo",R.drawable.diavolo),
            new Pizza("Funghi",R.drawable.funghi)
    };

    private Pizza(String name,int imageResourceID)
    {
        this.name = name;
        this.imageResourceID = imageResourceID;
    }

    public String getName()
    {
        return name;
    }

    public int getImageResourceID()
    {
        return imageResourceID;
    }
}
