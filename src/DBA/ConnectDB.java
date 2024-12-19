package DBA;

import java.sql.*;

public class ConnectDB {
    private Connection connection;
    private Statement statement;
    public ConnectDB()
    {
        try
        {
            connection = DriverManager.getConnection("jdbc:sqlite:CoffeeMachine");

            System.out.println("Подключение к базе данных успешно выполнено");

            statement = connection.createStatement();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public int getIngridentCount(String query) throws SQLException {
        ResultSet resultSet = statement.executeQuery(query);
        int count = resultSet.getInt("Count");
        return count;
    }

    public void executeUpdate(String query)
    {
        try {
            statement.executeUpdate(query);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void closeConnection(){

        try {
            if (connection != null)
            {
                connection.close();
                System.out.println("Connection closed");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
