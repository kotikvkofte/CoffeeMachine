package MachineElements;

import Ingredients.Espresso;
import Ingredients.GroundCoffe;
import Ingredients.Water;
import Interfaces.IGroup;

public class Group implements IGroup {
    private  GroundCoffe groundCoffe;
    private Water boilWater;

    @Override
    public void setGroundCoffee(GroundCoffe groundCoffe)
    {
        this.groundCoffe = groundCoffe;
    }

    @Override
    public void setBoilWater(Water boilWater)
    {
        this.boilWater = boilWater;
    }

    @Override
    public Espresso BrewCoffee() {
        requiredTime = Math.ceil(19+Math.random()*6);
        System.out.println(STR."Варка кофе: \{requiredTime} секунд");
        return new Espresso(this.groundCoffe, this.boilWater);
    }

    @Override
    public double getRequiredTime()
    {
        return requiredTime;
    }
    private double requiredTime;
}
