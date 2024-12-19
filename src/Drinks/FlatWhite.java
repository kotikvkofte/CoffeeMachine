package Drinks;

import Ingredients.Coffee;
import Ingredients.Ingredient;
import Ingredients.Milk;
import Ingredients.Water;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FlatWhite extends Drink{
    public FlatWhite()
    {
        Ingredient milk = new Milk(1);
        Ingredient coffee = new Coffee(2);
        Ingredient water = new Water(1);
        super(List.of(milk, water, coffee), "Флэт-уайт");
    }
}
