import Additives.*;
import DBA.DBAction;
import Drinks.*;
import Drinks.Espresso;

import java.sql.SQLException;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        DBAction dbAction = new DBAction();
        try{
            dbAction.loadCountFromDb();
            CoffeeMachine coffeeMachine = createCoffeeMachineLocal();
            coffeeMachine.showMenu();
            coffeeMachine.cookDrink();
            dbAction.updateDb();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        finally {
            dbAction.closConnection();
        }
    }
    private static CoffeeMachine createCoffeeMachineLocal(){
        Drink latte = new Latte();
        Drink americano = new Americano();
        Drink espresso = new Espresso();
        Drink flatWhite = new FlatWhite();
        Drink raf = new Raf();
        List<Drink> drinkList = List.of(latte, americano, espresso, flatWhite, raf);

        Additive sugar = new Sugar();
        Additive syrop = new Syrop();
        Additive cinnamon = new Cinnamon();
        List<Additive> additivesList = List.of(sugar, syrop,cinnamon);

        return new CoffeeMachine(drinkList, additivesList);
    }
}