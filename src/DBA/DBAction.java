package DBA;

import Ingredients.*;

import java.sql.SQLException;
import java.util.List;

public class DBAction {
    private static ConnectDB db;

    public DBAction()
    {
        db = new ConnectDB();
    }

    public void closConnection()
    {
        db.closeConnection();
    }

    public void updateDb() throws SQLException {
        String coffeeUpdate = STR."UPDATE Ingredients SET Count = \{Coffee.getStaticCount()} WHERE Name = 'Coffee'";
        String waterUpdate = STR."UPDATE Ingredients SET Count = \{Water.getStaticCount()} WHERE Name = 'Water'";
        String milkUpdate = STR."UPDATE Ingredients SET Count = \{Milk.getStaticCount()} WHERE Name = 'Milk'";
        String creamUpdate = STR."UPDATE Ingredients SET Count = \{Cream.getStaticCount()} WHERE Name = 'Cream'";
        String vanillaSugarUpdate = STR."UPDATE Ingredients SET Count = \{VanillaSugar.getStaticCount()} WHERE Name = 'VanillaSugar'";

        List<String> queries = List.of(coffeeUpdate, waterUpdate, milkUpdate, creamUpdate, vanillaSugarUpdate);

        queries.stream().forEach(q -> db.executeUpdate(q));
    }

    public void loadCountFromDb() throws SQLException {
        int waterCount = db.getIngridentCount("SELECT Count FROM Ingredients WHERE Name='Water'");
        int coffeeCount = db.getIngridentCount("SELECT Count FROM Ingredients WHERE Name='Coffee'");
        int milkCount = db.getIngridentCount("SELECT Count FROM Ingredients WHERE Name='Milk'");
        int creamCount = db.getIngridentCount("SELECT Count FROM Ingredients WHERE Name='Cream'");
        int vanillaSugarCount = db.getIngridentCount("SELECT Count FROM Ingredients WHERE Name='VanillaSugar'");

        Water.setStaticCount(waterCount);
        Coffee.setStaticCount(coffeeCount);
        Milk.setStaticCount(milkCount);
        Cream.setStaticCount(creamCount);
        VanillaSugar.setStaticCount(vanillaSugarCount);
    }
}
