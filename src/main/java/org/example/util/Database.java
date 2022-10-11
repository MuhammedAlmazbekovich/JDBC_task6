package org.example.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {
    private static  String url = "jdbc:postgresql://localhost:5432/homework";
    private static  String userName = "postgres";
    private static  String password = "Muha0017";

    public static Connection connection(){
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(url,userName,password);
            System.out.println("Successfully connected to Database");

        }catch (SQLException e){
            e.printStackTrace();
        }
        return connection;
    }

}
