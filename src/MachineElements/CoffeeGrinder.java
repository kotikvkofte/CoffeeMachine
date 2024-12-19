package MachineElements;

import Ingredients.Coffee;
import Ingredients.GroundCoffe;
import Interfaces.ICoffeeGrinder;

public class CoffeeGrinder implements ICoffeeGrinder {
    @Override
    public GroundCoffe Grind(Coffee coffee) {
        requiredTime = Math.ceil(14+Math.random()*6);
        System.out.println(STR."Молка кофе: \{requiredTime} секунд");
        return new GroundCoffe(coffee);
    }

    @Override
    public double getRequiredTime()
    {
        return requiredTime;
    }
    private double requiredTime;
}
