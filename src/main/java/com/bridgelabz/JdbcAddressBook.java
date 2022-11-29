package com.bridgelabz;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcAddressBook {

    public static void main(String[] args) {
        System.out.println("Welcome to the Address Book Program with the MySQL DataBase wit the Connector JDBC");

        String url = "jdbc:mysql://localhost:3306/addressbook";
        String username = "root";
        String password = "Avinash@015";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection connection = DriverManager.getConnection(url, username, password);
            System.out.println("Connection Established Successfully");


            connection.close();
            System.out.println("Connection Closed");
        }catch(SQLException | ClassNotFoundException e){
            System.out.println(e);
        }
    }
}
