package MachineElements;

import Ingredients.Water;
import Interfaces.IBoiler;

public class Boiler implements IBoiler {
    @Override
    public void Boil(Water water) {
        requiredTime = water.Boil(100);
        System.out.println(STR."Нагрев воды: \{requiredTime} секунд");
    }

    @Override
    public double getRequiredTime()
    {
        return requiredTime;
    }
    private double requiredTime;
}
