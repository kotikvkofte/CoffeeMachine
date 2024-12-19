package Ingredients;

public class LiquidIngredient extends Ingredient {
    public LiquidIngredient(int count, double speed)
    {
        this.temperature = 24;
        this.count = count;
        this.requiredTimePerSec = speed;
    }

    public LiquidIngredient(int count, double speed, double temperature)
    {
        this.temperature = temperature;
        this.count = count;
        this.requiredTimePerSec = speed;
    }

    public double Boil(double needTemp)
    {
        double wastedTime = (needTemp - temperature) / requiredTimePerSec;
        temperature = needTemp;
        return wastedTime;
    }
}
