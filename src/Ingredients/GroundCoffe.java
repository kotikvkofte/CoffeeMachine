package Ingredients;

public class GroundCoffe  extends DryIngredient{
    public GroundCoffe(Coffee coffee)
    {
        super(coffee.count);
    }

    @Override
    public String toString()
    {
        return "Молотый кофе";
    }
}
