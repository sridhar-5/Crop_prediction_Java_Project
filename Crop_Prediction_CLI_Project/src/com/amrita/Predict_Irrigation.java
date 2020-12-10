package com.amrita;
/*
Created with Intellij IDEA
Author : @Sridhar
Created on 2nd December
*/
import java.sql.*;
import java.util.Scanner;

public class Predict_Irrigation extends DatabaseOperations{
    public String query;
    public int ar_id;
    public void predict_irrigation() throws SQLException {
        try{
            //creating the database operations object
            DatabaseOperations d = new DatabaseOperations();
            //establishing the connection
            Connection connection = DriverManager.getConnection(d.Dburl,d.username,d.password);

            //preparing the statement
            Scanner user_input = new Scanner(System.in);
            Statement statement = connection.createStatement();
            //predicting the type of irrigation
            System.out.print("Please enter the Area_id : ");
            ar_id = user_input.nextInt();
            query = "select Rainfall_type from Area_Rainfall where Area_id="+ar_id;
            //executing the statement and storing the result in a result set
            ResultSet result = statement.executeQuery(query);

            //predicting the irrigation type based on rain dependencies
            String rainfall_type="";
            while(result.next()){
                rainfall_type = result.getString("Rainfall_type");
            }
            //executing the other query to get the rain dependency
            query = "select Rainfall_dependency from Rainfall where Rainfall_type = '"+rainfall_type+"'";
            //executing the query and storing the result set and printing type of irrigation is to be used
            result = statement.executeQuery(query);
            int rain_dependency = 0;
            while(result.next()){
                rain_dependency = result.getInt("Rainfall_dependency");
            }
            int irr_cost = 0;
            //rain dependency less irrigation efficiency should be high
            if(rain_dependency < 50){
                query = "select Irrigation_Name,Irr_cost from Irrigation where Irr_efficiency > 80";
                String irr_name = "";
                ResultSet result2 = statement.executeQuery(query);
                while(result2.next()) {
                    irr_name = result2.getString("Irrigation_Name");
                    irr_cost = result2.getInt("Irr_cost");
                }
                System.out.println("Suggested Irrigation : " +irr_name);
                System.out.println("Cost : " +irr_cost);
            }
            //rain dependency is to the okay level then irrigation efficiency should also be to the medium level
            else if(rain_dependency < 70 && rain_dependency > 50){
                query = "select Irrigation_Name,Irr_cost from Irrigation where Irr_efficiency > 50 and Irr_efficiency < 80";
                String irr_name = "";

                ResultSet result2 = statement.executeQuery(query);
                while(result2.next()) {
                    irr_name = result2.getString("Irrigation_Name");
                    irr_cost = result2.getInt("Irr_cost");
                    System.out.println("Suggested Irrigation : " +irr_name);
                    System.out.println("Cost : " +irr_cost);
                }
            }
            //if the rain dependency is high so the irrigation efficiency less
            else if(rain_dependency > 70){
                query = "select Irrigation_Name,Irr_cost from Irrigation where Irr_efficiency <= 60";
                String irr_name = "";
                ResultSet result2 = statement.executeQuery(query);
                while(result2.next()) {
                    irr_name = result2.getString("Irrigation_Name");
                    irr_cost = result2.getInt("Irr_cost");
                    System.out.println("Suggested Irrigation : " +irr_name);
                    System.out.println("Cost : "+irr_cost);
                }
            }
        }catch (SQLException throwables){
            throwables.printStackTrace();
        }
    }
}
