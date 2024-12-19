package Drinks;

import Ingredients.Coffee;
import Ingredients.Ingredient;
import Ingredients.Water;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Espresso extends Drink{
    public Espresso()
    {
        Ingredient water = new Water(1);
        Ingredient coffee = new Coffee(1);
        super(List.of(water, coffee), "Эспрессо");
    }
}
