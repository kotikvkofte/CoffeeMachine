package Ingredients;


import java.sql.SQLException;

public class Coffee extends DryIngredient{
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
    public Coffee(int count){
        super(count);
    }

    @Override
    public String toString()
    {
        return "Кофе";
    }
}
