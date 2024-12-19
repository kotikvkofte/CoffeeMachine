package Interfaces;

import Additives.Additive;
import Drinks.Drink;

import java.util.List;


public interface IDisplay {
    void showDrinkMenu(List<Drink> listDrinks);
    void showAdditiveMenu(List<Additive> listAdditive);
    Drink getChosenDrink();
    void showMessage(String message);
    List<Additive> getChosenAdditives();
    void getResult(double cookTime);
}
