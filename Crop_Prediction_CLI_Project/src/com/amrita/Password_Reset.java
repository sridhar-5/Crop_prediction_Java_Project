package com.amrita;
/*
Created with Intellij IDEA
Author : @Sridhar
Created on 2nd December
*/
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

abstract class reset{
    abstract void password_reset() throws SQLException;
}
public class Password_Reset extends reset{
    public String username = "root";
    public String password = "root";
    public String Dburl = "jdbc:mysql://localhost:3306/crop_prediction_based_on_soil_nutrient_estimation";
    String query;

    public void password_reset() throws SQLException {
        try{
            Scanner user_input = new Scanner(System.in);
            System.out.print("Please enter your username : ");
            String user = user_input.next();

            //establishing the connection with the database
            Connection connection = DriverManager.getConnection(Dburl,username,password);

            //creating a statement
            Statement statement = connection.createStatement();

            System.out.print("Please enter the new_password : ");
            String new_password = user_input.next();
            query = "UPDATE credentials SET  username ='" + new_password + "' WHERE username = '"+user+"'";
            int row = statement.executeUpdate(query);
            System.out.println(row + " rows have been updated");
            System.out.println("Your password has been changed successfully");
            System.out.println("please login Now");
        }catch (SQLException throwables){
            throwables.printStackTrace();
        }
    }
}
