package Ingredients;

import java.sql.SQLException;

public class Milk extends  LiquidIngredient{
    private static int countInDB;
    public static void setStaticCount(int count)
    {
        countInDB = count;
    }
    public static int getStaticCount()
    {
        return countInDB;
    }
    public final void decCount() throws SQLException {
        countInDB -= this.count;
        if(countInDB < 0)
        {
            throw new SQLException("Не хватает воды");
        }
    }
    public Milk(int count) {
        super(count, 0.5);
    }
    public Milk(int count, double temp) {
        super(count, 0.5, temp);
    }

    @Override
    public String toString()
    {
        return "Молоко";
    }
}
