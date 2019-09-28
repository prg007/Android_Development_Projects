package com.example.pets;
import java.util.List;
import java.util.ArrayList;

public class Breeds
{
    List<String> generatebreeds(String abc)
    {
        List<String> breeds = new ArrayList<>();
        if (abc.equals("cats"))
        {
            breeds.add("Persian Cats");
            breeds.add("British Short Hair");
            breeds.add("Maine Coon");
            breeds.add("Siamese Cat");
        }
        else if (abc.equals("dogs"))
        {
            breeds.add("BullDog");
            breeds.add("Paddle");
            breeds.add("Pug");
            breeds.add("Lavrador");
            breeds.add("German Shepherd");
        }
        else if(abc.equals("rabbit"))
        {
            breeds.add("Netherland Dwarf Rabbit");
            breeds.add("LionHead Rabbit");
        }
        else
        {
            breeds.add("Chinese Hamster");
        }
        return breeds;

    }
}
