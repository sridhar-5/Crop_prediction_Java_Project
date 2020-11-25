package com.amrita;

import java.sql.*;

public class DatabaseOperations{
    public String username = "root";
    public String password = "root";
    public String Dburl = "jdbc:mysql://localhost:3306/crop_prediction_based_on_soil_nutrient_estimation";

    public void Insert(String query) throws SQLException {
        try{
            int rows_effected = 0;
            //creating the connection to the database
            Connection connect = DriverManager.getConnection(Dburl,username,password);

            //creating a statement && executing a query
            Statement statement = connect.createStatement();

            //excecuting a query
            rows_effected = statement.executeUpdate(query);
            //prinring the result
            System.out.println(rows_effected + " rows have been inserted.");
            //closing the connection
            connect.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    public void Update(String query) throws SQLException{
        try{
            int rows = 0;

            //creating the connection to the database
            Connection connection = DriverManager.getConnection(Dburl,username,password);

            // creating a statement && executing the query here
            Statement statement = connection.createStatement();
            //executing a query
            rows = statement.executeUpdate(query);
            //printing the rows affected
            System.out.println(rows + " rows have been updated.");
            //closing the connection
            connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    public void Delete(String query) throws SQLException{
        try{
            int rows_effected = 0;
            //creating a connection to the database
            Connection connection = DriverManager.getConnection(Dburl,username,password);
            //creating a statement
            Statement statement = connection.createStatement();
            //executing a query
            rows_effected = statement.executeUpdate(query);
            //printing the rows effected statement;
            System.out.println(rows_effected + " have been updated");
            connection.close();
        } catch (SQLException throwables){
            throwables.printStackTrace();
        }
    }
    public void Select(String query) throws SQLException{
        try{
            int count = 0;
            //creating a connection to the database
            Connection connection = DriverManager.getConnection(Dburl,username,password);
            //creating a statement
            Statement statement = connection.createStatement();
            //storing the result of executed query in a result set object
            ResultSet set = statement.executeQuery(query);
            while(set.next()){
                int id = set.getInt("State_id");
                String name = set.getString("State_Name");
                System.out.println(id + "    " + name);
                count++;
            }
            System.out.println(count + " rows are Selected");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    public void Drop(String query) throws SQLException{
        try{
            //creating a connection
            Connection connection = DriverManager.getConnection(Dburl,username,password);
            //creating a statement
            Statement statement = connection.createStatement();
            //executing the query
            statement.executeUpdate(query);
            System.out.println("TABLE DROPPED");

        }catch (SQLException throwables){
            throwables.printStackTrace();
        }
    }

}