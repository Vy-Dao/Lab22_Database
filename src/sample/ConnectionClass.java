package sample;

import java.sql.Connection;

public class ConnectionClass {
    public static Connection connection;
    public Connection getConnection(){
        String url="jdbc:mysql://puff.mnstate.edu:3306/";
    }
}
