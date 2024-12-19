package Drinks;

import Ingredients.*;

import java.util.List;

public class Raf extends Drink{
    public Raf()
    {
        Ingredient cream = new Cream(1);
        Ingredient water = new Water(1);
        Ingredient coffee = new Coffee(1);
        Ingredient vanillaSugar = new VanillaSugar(1);
        super(List.of(cream, water, coffee, vanillaSugar), "Раф");
    }
}

