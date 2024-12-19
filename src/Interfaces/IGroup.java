package Interfaces;

import Ingredients.Espresso;
import Ingredients.GroundCoffe;
import Ingredients.Water;

public interface IGroup extends IRequireTime{
    void setGroundCoffee(GroundCoffe groundCoffee);
    void setBoilWater(Water boilWater);
    Espresso BrewCoffee();
}
