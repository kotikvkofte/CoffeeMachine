package Drinks;

import Ingredients.Coffee;
import Ingredients.Ingredient;
import Ingredients.Water;

import java.util.List;

public class Americano extends Drink{
    public Americano() {
        Ingredient water = new Water(1);
        Ingredient coffee = new Coffee(1);
        super(List.of(water, coffee), "Американо");
    }
}
