package MachineElements;

import Additives.Additive;
import Drinks.Drink;
import Interfaces.IDisplay;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Display implements IDisplay {
    private final Scanner scanner;
    private Drink chosenDrink;
    private final List<Additive> chosenAdditives;
    public Display()
    {
        scanner = new Scanner(System.in);
        chosenAdditives = new ArrayList<>();
    }

    @Override
    public void showDrinkMenu(List<Drink> listDrinks) {
        System.out.println("Выберите напиток:");
        for (int i = 0; i < listDrinks.size(); i++) {
            System.out.println(STR."\{i + 1}. \{listDrinks.get(i).getName()}");
        }

        int drinkId = scanner.nextInt() - 1;

        while(drinkId < 0 || drinkId >= listDrinks.size()){
            System.out.println("Неверное значение. Попробуйте снова");
            drinkId = scanner.nextInt() - 1;
        }
        chosenDrink = listDrinks.get(drinkId);
    }

    @Override
    public void showAdditiveMenu(List<Additive> listAdditive) {
        System.out.println("Желаете что то добавить в напиток?");
        System.out.println("1. Да");
        System.out.println("2. Нет");
        if (scanner.nextInt() == 2){
            return;
        }

         do {
             System.out.println("Выберите добавку:");
             for (int i = 0; i < listAdditive.size(); i++) {
                 System.out.println(STR."\{i + 1}. \{listAdditive.get(i).getName()}");
             }
             int additiveId = scanner.nextInt() - 1;
             while (additiveId < 0 || additiveId >= listAdditive.size()) {
                 System.out.println("Неверное значение. Попробуйте снова");
                 additiveId = scanner.nextInt() - 1;
             }
             chosenAdditives.add(listAdditive.get(additiveId));

             System.out.println("Желаете добавить что то еще?:");
             System.out.println("1. Да");
             System.out.println("2. Нет");
         }
        while (scanner.nextInt() != 2);
    }

    @Override
    public Drink getChosenDrink()
    {
        return chosenDrink;
    }

    @Override
    public List<Additive> getChosenAdditives()
    {
        return chosenAdditives;
    }

    @Override
    public void showMessage(String message) {
        System.out.println(message);
    }

    @Override
    public  void getResult(double cookTime)
    {
        String outText = "";

        outText += STR."Ваш напиток - \{chosenDrink.getName()},";
        if (!chosenAdditives.isEmpty())
        {
            outText += STR." с добавками ";
            for(int i = 0; i < chosenAdditives.size(); i++){
                outText += STR."\{chosenAdditives.get(i).getName()}";
                if (i != chosenAdditives.size()-1){
                    outText += ", ";
                }
            }
        }
        outText += STR." готов. Это заняло \{cookTime} секунд";

        System.out.println(outText);
    }
}
