package Interfaces;

import Ingredients.Water;

public interface IBoiler extends IRequireTime {
    void Boil(Water water);
}
