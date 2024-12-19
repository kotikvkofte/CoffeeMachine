package Drinks;

import Ingredients.Ingredient;

import java.util.List;

public abstract class Drink {
    private List<Ingredient> ingredientList;
    private String name;
    public Drink(List<Ingredient> ingredients, String name)
    {
        this.ingredientList = ingredients;
        this.name = name;
    }

    public List<Ingredient> getIngredients()
    {
        return this.ingredientList;
    }

    public String getName()
    {
        return this.name;
    }
}
