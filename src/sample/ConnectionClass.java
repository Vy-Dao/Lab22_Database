package sample;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionClass {
    public static Connection connection;
    public  Connection getConnection(){
    String myUrl = "jdbc:mysql://puff:3306/daovy_addressbook?useLegacyDatetimeCode=false&serverTimezone=America/Chicago&useSSL=FALSE";
    String username="daovy";
    String password="98Thongnhat)";
    System.out.println("Loading Driver ....");
    try{
        Class.forName("com.mysql.cj.jdbc.Driver");
    } catch (ClassNotFoundException e) {
        throw new RuntimeException("Can't find driver", e);
    }
    System.out.println("Driver Loaded");
    connection = null;
    System.out.println("Trying to connect to database ....");
    try {
        connection = DriverManager.getConnection(myUrl,username,password);
    } catch (SQLException e) {
        e.printStackTrace();
    }
    System.out.println("Connected to the database");
    return  connection;
    }

    public static void closeConnection() throws  SQLException{
        try {
            if (connection != null && !connection.isClosed()){
                connection.close();;
            }
        }catch (Exception e){
            throw e;
        }
    }
}
