package Ingredients;

import java.sql.SQLException;

public class Water extends LiquidIngredient {
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
    public Water()
    {
        super(1, 1);
    }
    public Water(int count)
    {
        super(count, 1);
    }

    @Override
    public String toString()
    {
        return "Вода";
    }
}
