package Ingredients;

import java.sql.SQLException;

public class Cream extends LiquidIngredient {
    private static int countInDB;
    public static void setStaticCount(int count)
    {
        countInDB = count;
    }
    public static int getStaticCount()
    {
        return countInDB;
    }
    public void decCount() throws SQLException {
        countInDB -= this.count;
        if(countInDB < 0)
        {
            throw new SQLException("Не хватает воды");
        }
    }
    public Cream(int count) {
        super(count, 2);
    }

    @Override
    public String toString()
    {
        return "Сливки";
    }
}
