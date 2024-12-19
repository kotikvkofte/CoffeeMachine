package Ingredients;

public class Espresso extends LiquidIngredient{
    public Espresso(GroundCoffe groundCoffe, Water water) {
        super(groundCoffe.count + water.count, water.requiredTimePerSec, water.temperature);
    }

    @Override
    public String toString()
    {
        return "Эспрессо";
    }
}
