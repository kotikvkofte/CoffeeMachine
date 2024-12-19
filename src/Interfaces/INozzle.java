package Interfaces;

import Additives.Additive;
import Ingredients.Cream;
import Ingredients.Ingredient;
import Ingredients.Milk;
import Ingredients.MixedMilk;

public interface INozzle extends IRequireTime {
    void milkBoil(Milk milk);
    void addAdditives(Additive additive);
    void milkBoil(Cream cream);
}
