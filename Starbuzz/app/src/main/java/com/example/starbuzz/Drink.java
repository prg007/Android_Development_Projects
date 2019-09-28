package com.example.starbuzz;
import java.lang.String;


public class Drink
{
    private String name;
    private String description;
    private int imageResourcedId;
    public static final Drink drinks[] = {
            new Drink("Latte","A couple of espresso shots with steamed milk",R.drawable.latte),
            new Drink("Cappucinno","Espresso,hot milk and steamed milk foam",R.drawable.cappuccino),
            new Drink("Filter","Highest quality beans roasted and brewed fresh",R.drawable.filter)
    };
    private Drink(String name,String description,int imageResourcedId)
    {
        this.name = name;
        this.description = description;
        this.imageResourcedId = imageResourcedId;
    }
    public String getName()
    {
        return name;
    }
    public String getDescription()
    {
        return description;
    }
    public int getImageResourcedId()
    {
        return imageResourcedId;
    }
    public String toString()
    {
        return this.name;
    }
}
