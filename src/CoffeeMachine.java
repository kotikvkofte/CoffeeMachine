import Additives.Additive;
import Drinks.Drink;
import Ingredients.*;
import Interfaces.*;
import MachineElements.*;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CoffeeMachine {
    private final IBoiler boiler;
    private final IGroup group;
    private final INozzle nozzle;
    private final ICoffeeGrinder coffeeGrinder;
    private final IDisplay display;

    private final List<Drink> drinks;
    private List<Additive> additives;

    public CoffeeMachine(List<Drink> drinks, List<Additive> additives)
    {
        boiler = new Boiler();
        group = new Group();
        nozzle = new Nozzle();
        coffeeGrinder = new CoffeeGrinder();
        this.drinks = drinks;
        this.additives = additives;
        this.display = new Display();
    }

    public CoffeeMachine(IBoiler boiler, IGroup group, INozzle nozzle, ICoffeeGrinder coffeeGrinder, IDisplay display, ArrayList<Drink> drinks)
    {
        this.boiler = boiler;
        this.group = group;
        this.nozzle = nozzle;
        this.coffeeGrinder = coffeeGrinder;
        this.drinks = drinks;
        this.display = display;
    }

    public void showMenu()
    {
        display.showDrinkMenu(drinks);
        display.showAdditiveMenu(additives);
    }


    public void cookDrink()
    {
        Drink chosenDrink = display.getChosenDrink();
        List<Additive> chosenAdditives = display.getChosenAdditives();
        List<Ingredient> ingredientList = chosenDrink.getIngredients();
        double cookTime = 0;

        try
        {
            for (Ingredient ingredient: ingredientList)
            {
                if (ingredient instanceof Water water)
                {

                    this.boiler.Boil(water);
                    cookTime += this.boiler.getRequiredTime();
                    this.group.setBoilWater(water);
                    water.decCount();
                }
                else if (ingredient instanceof Coffee coffee)
                {
                    GroundCoffe groundCoffee = this.coffeeGrinder.Grind(coffee);
                    cookTime += this.coffeeGrinder.getRequiredTime();
                    this.group.setGroundCoffee(groundCoffee);
                    coffee.decCount();
                }
                else if (ingredient instanceof Milk milk)
                {
                    this.nozzle.milkBoil(milk);
                    milk.decCount();
                }
                else if (ingredient instanceof Cream cream)
                {
                    this.nozzle.milkBoil(cream);
                    cream.decCount();
                }
                else if (ingredient instanceof VanillaSugar vanillaSugar)
                {
                    vanillaSugar.decCount();
                    display.showMessage(STR."Добавление \{ingredient.toString()}");
                }
                else
                {
                    display.showMessage(STR."Добавление \{ingredient.toString()}");
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return;
        }


        Espresso espresso = this.group.BrewCoffee();

        for (Additive ad : chosenAdditives){
            nozzle.addAdditives(ad);
        }
        cookTime += this.nozzle.getRequiredTime();
       display.getResult(cookTime);
    }
}
