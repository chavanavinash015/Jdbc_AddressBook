package com.bridgelabz;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
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

            PreparedStatement ps = connection.prepareStatement("insert into contacts values(?,?,?,?)");
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            while(true){
                System.out.println("Enter id");
                int id=Integer.parseInt(br.readLine());

                System.out.println("Enter Name :");
                String name=br.readLine();

                System.out.println("Enter Age :");
                int age=Integer.parseInt(br.readLine()); ;

                System.out.println("Enter Gender :");
                String gender=br.readLine();

                ps.setInt(1,id);
                ps.setString(2,name);
                ps.setInt(3,age);
                ps.setString(4,gender);

                int count=ps.executeUpdate();
                if (count>0)
                    System.out.println(count+" Record inserted");
                else
                    System.out.println("Record Not inserted");

                System.out.println("Do you want to insert more records-[yes/No]");
                String ch=br.readLine();
                if (ch.equalsIgnoreCase("no"))
                    break;
            }
            connection.close();
            System.out.println("Connection Closed");
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Catch block ");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
