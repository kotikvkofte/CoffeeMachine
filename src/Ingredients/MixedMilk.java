package Ingredients;

import Additives.Additive;
import Interfaces.IRequireTime;

import java.util.ArrayList;

public class MixedMilk extends Milk implements IRequireTime {
    public MixedMilk(Milk milk)
    {
        super(milk.count, milk.temperature);
        addivites = new ArrayList<Additive>();
    }
    public MixedMilk(Cream cream)
    {
        super(cream.count, cream.temperature);
        addivites = new ArrayList<Additive>();
    }
    public void addAddivity(Additive additive)
    {
        addivites.add(additive);
        requiredTime += additive.getDissolutionTime();
    }
    @Override
    public double getRequiredTime() {
        return requiredTime;
    }
    private ArrayList<Additive> addivites;
    private double requiredTime;
    @Override
    public String toString()
    {
        return "Молоко с добавками";
    }
}
