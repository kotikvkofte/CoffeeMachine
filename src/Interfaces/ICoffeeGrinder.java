package Interfaces;

import Ingredients.Coffee;
import Ingredients.GroundCoffe;

public interface ICoffeeGrinder extends IRequireTime{
    GroundCoffe Grind(Coffee coffee);
}
