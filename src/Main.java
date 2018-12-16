

import java.sql.*;




public class Main {



    public static void main(String[] args) throws SQLException
    {

        System.out.println("JDBC database eksempel");



        // 1) Load the JDBC driver

        try
        {

            Class.forName("com.mysql.jdbc.Driver");

        } catch (ClassNotFoundException e) {

            System.out.println("Der er fejl med din database driver JDBC");

            e.printStackTrace();

        }

        System.out.println("Driver loaded");



        // 2) Connect to a database

        Connection connection = DriverManager.getConnection

                ("jdbc:mysql://localhost/world" , "root", "");

        System.out.println("Database connected");



        // 3) Create a statement
        //HEJ
        Statement statement = connection.createStatement();



        // 4) Execute a statementr

        String sql = "select * from city where name like 'rotterdam'";

        ResultSet resultSet = statement.executeQuery(sql);








        // 5) Iterate through the result and print the student names

        while (resultSet.next())

            System.out.println(

                    resultSet.getString(2) + "\t" + resultSet.getString(3));



        // Adding new values to databases table with this insert into sql statement
        String sqlAddToDatabaseNewCity="insert into city(Name,CountryCode,District,Population)"+" values('Roskilde','AGO','Sjaelland',10000)";
        statement.executeUpdate(sqlAddToDatabaseNewCity);

        String sqlDeleteFromDatabaseCountry="DELETE from country where Population=8000";
        statement.executeUpdate(sqlDeleteFromDatabaseCountry);
        // 6) Close the connection
        connection.close();



    }

}