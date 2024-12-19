package MachineElements;

import Additives.Additive;
import Ingredients.Cream;
import Ingredients.Ingredient;
import Ingredients.Milk;
import Ingredients.MixedMilk;
import Interfaces.INozzle;

public class Nozzle implements INozzle {

    @Override
    public void milkBoil(Milk milk) {

        requiredTime = milk.Boil(65);
        System.out.println(STR."Нагрев молока: \{requiredTime} секунд");
        mixedMilk = new MixedMilk(milk);
    }

    @Override
    public void milkBoil(Cream cream) {

        requiredTime = cream.Boil(65);
        System.out.println(STR."Нагрев сливок: \{requiredTime} секунд");
        mixedMilk = new MixedMilk(cream);
    }

    @Override
    public void addAdditives(Additive additive) {
        mixedMilk.addAddivity(additive);
        requiredTime += mixedMilk.getRequiredTime();
        System.out.println(STR."Смешивание молока(сливок) с \{additive.getName()}:  \{additive.getDissolutionTime()} секунд");
    }

    @Override
    public double getRequiredTime()
    {
        return requiredTime;
    }
    private double requiredTime;
    private MixedMilk mixedMilk;
}
