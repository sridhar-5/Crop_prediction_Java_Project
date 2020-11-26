package com.amrita;

/*
Created with Intellij IDEA
Author : @Sridhar
Created on 16th November
*/

import java.sql.*;
import java.util.Scanner;

public class Main extends login{
    public static void main(String[] args) throws SQLException {
        login x = new login();
        x.login();
        if(login_bool){
            Scanner user_input = new Scanner(System.in);
            DatabaseOperations d = new DatabaseOperations();

            String query;

            System.out.println("=============Welcome to the Crop Prediction Console===============");
            System.out.println("Please select an option to operate a database ");
            System.out.println("1. Insert");
            System.out.println("2. Update");
            System.out.println("3. Delete");
            System.out.println("4. Select everything from a table");
            System.out.println("5. Drop Table");
            System.out.println("6. Predict crop for your Area ( Complete Insertion First )");
            System.out.println("==================Please Select an option=========================");

            int option = user_input.nextInt();
            //if option 1 is selected then we can start insertions into the table.
            if(option == 1){
                String table_name;
                System.out.println("Please enter the table name : ");
                user_input.nextLine();
                table_name = user_input.nextLine();

                if(table_name.equals("State") || table_name.equals("STATE")||table_name.equals("state")){
                    int State_id = user_input.nextInt();
                    user_input.nextLine();
                    String State_name = user_input.nextLine();

                    //match the synatx that is actually executing in my sql
                    query = "INSERT INTO "+table_name+" VALUES ('"+State_id+"','"+State_name+"')";
                    //Insert function is which actually executes the query it is present in class Database operations
                    d.Insert(query);
                }
                else if(table_name.equals("District") || table_name.equals("DISTRICT")||table_name.equals("district")){
                    int District_id = user_input.nextInt();
                    user_input.nextLine();
                    String District_name = user_input.nextLine();
                    int no_of_districts = user_input.nextInt();
                    int State_id = user_input.nextInt();

                    //match the synatx that is actually executing in my sql
                    query = "INSERT INTO "+table_name+" VALUES ('"+District_id+"','"+District_name+"','"+no_of_districts+"','"+State_id+"')";

                    //Insert function is which actually executes the query it is present in class Database operations
                    d.Insert(query);
                }
                else if(table_name.equals("Mandal") || table_name.equals("MANDAL") || table_name.equals("mandal")){
                    int Mandal_id = user_input.nextInt();
                    user_input.nextLine();
                    String Mandal_name = user_input.next();
                    int no_of_farming_areas = user_input.nextInt();
                    String Representative = user_input.next();
                    int District_id = user_input.nextInt();

                    //match the synatx that is actually executing in my sql
                    query = "INSERT INTO "+table_name+" VALUES ('"+Mandal_id+"','"+District_id+"','"+Mandal_name+"','"+no_of_farming_areas+"','"+Representative+"')";
                    //Insert function is which actually executes the query it is present in class Database operations
                    d.Insert(query);
                }
                else if(table_name.equals("Area") || table_name.equals("AREA") ||table_name.equals("area")){
                    int Area_id = user_input.nextInt();
                    user_input.nextLine();
                    String Area_name = user_input.nextLine();

                    //match the synatx that is actually executing in my sql
                    query = "INSERT INTO "+table_name+" VALUES ('"+Area_id+"','"+Area_name+"')";
                    //Insert function is which actually executes the query it is present in class Database operations
                    d.Insert(query);
                }
                else if(table_name.equals("Seed") || table_name.equals("SEED") ||table_name.equals("seed")){
                    int seed_id = user_input.nextInt();
                    String seed_name = user_input.next();
                    double price = user_input.nextDouble();

                    //match the synatx that is actually executing in my sql
                    query = "INSERT INTO "+table_name+" VALUES ('"+seed_id+"','"+seed_name+"','"+price+"')";
                    //Insert function is which actually executes the query it is present in class Database operations
                    d.Insert(query);
                }
                else if(table_name.equals("Weather")||table_name.equals("WEATHER") || table_name.equals("weather")){
                    int Weather_id = user_input.nextInt();
                    String Weather_name = user_input.next();
                    String prevail = user_input.next();
                    int chances = user_input.nextInt();

                    //match the syntax that is actually executing in my sql
                    query = "INSERT INTO "+table_name+" VALUES ('"+Weather_id+"','"+Weather_name+"','"+prevail+"','"+chances+"')";

                    //insert function is which is actually executing the query it is present in class Database operations
                    d.Insert(query);
                }
                else if(table_name.equals("WaterRes")||table_name.equals("WATERRES") || table_name.equals("waterres")){
                    String WaterRes_Name = user_input.next();
                    int Resource_dependency = user_input.nextInt();

                    //match the synatx that is actually executing in my sql
                    query = "INSERT INTO "+table_name+" VALUES ('"+WaterRes_Name+"','"+Resource_dependency+"')";
                    //Insert function is which actually executes the query it is present in class Database operations
                    d.Insert(query);
                }
                else if(table_name.equals("Rainfall") || table_name.equals("RAINFALL") || table_name.equals("rainfall")){
                    String Rainfall_type = user_input.next();
                    int Intensity = user_input.nextInt();
                    int Rainfall_dependency = user_input.nextInt();

                    query = "INSERT INTO "+table_name+" VALUES ('"+Rainfall_type+"','"+Intensity+"','"+Rainfall_dependency+"')";
                    d.Insert(query);
                }
                else if(table_name.equals("Soil_Nutrients") || table_name.equals("SOIL_NUTRIENT") || table_name.equals("soil_nutirents")){
                    int Area_id = user_input.nextInt();
                    int Nutrient_id = user_input.nextInt();
                    int Act_Req_percent = user_input.nextInt();
                    int Avail_Percent = user_input.nextInt();
                    int Req_Percent = Act_Req_percent - Avail_Percent;

                    query = "INSERT INTO "+table_name+" VALUES ('"+Area_id+"','"+Nutrient_id+"','"+Act_Req_percent+"','"+Avail_Percent+"','"+Req_Percent+"')";
                    d.Insert(query);
                }
            }
            //if option 2 is selected we can update rows in the table
            else if (option == 2){
                String table_name;
                System.out.println("Please enter the table name : ");
                user_input.nextLine();
                table_name = user_input.nextLine();
                System.out.println("Please enter the column you want to make changes in : ");
                String UpdateCol = user_input.nextLine();
                System.out.println("Please enter the value you want to change : ");
                String Value = user_input.nextLine();
                System.out.println("Please enter the State_id to change the corresponding row: ");
                int changes = user_input.nextInt();
                query = "UPDATE "+table_name+" SET " + UpdateCol + "='" + Value + "' WHERE State_id = " +changes;
                d.Update(query);
            }
            //if option is 3 then we can delete rows from the table
            else if(option == 3){
                String table_name;
                System.out.println("Please enter the table name : ");
                user_input.nextLine();
                table_name = user_input.nextLine();
                System.out.println("Please enter the id of the entry to delete : ");
                int DeleteEntry = user_input.nextInt();
                query = "DELETE FROM " +table_name+ " WHERE State_id ="+DeleteEntry;
                d.Delete(query);
            }
            //if option is 4 then we can select something from the table
            else if(option == 4){
                String table_name;
                System.out.println("Please enter a table name : ");
                user_input.nextLine();
                table_name = user_input.nextLine();
                query = "SELECT * FROM "+table_name;
                d.Select(query);
            }
            //if option is 5 then enter the table that is to be dropped
            else if(option == 5){
                String table_name;
                System.out.println("Please enter a table name : ");
                user_input.nextLine();
                table_name = user_input.nextLine();
                query = "DROP TABLE "+table_name;
                d.Drop(query);
            }
            //if option is 6 then the prediction actually starts
            else if(option == 6){
                //establishing the connection
                Connection connection = DriverManager.getConnection(d.Dburl,d.username,d.password);

                //preparing the statement
                Statement statement = connection.createStatement();
                //predicting the type of irrigation
                System.out.println("Please enter the Area_id : ");
                int ar_id = user_input.nextInt();
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
                //Now the Prediction of the crop starts
                //since the predicted data is already entered and stored into the table
                //generate a query that displays the crop name
                query = "select Seed_id from Area_Seed where Area_id="+ar_id;

                //storing the result of select query in result set object

                result = statement.executeQuery(query);
                //iterating through the object
                int seed_id = 0;
                while(result.next()){
                    seed_id = result.getInt("Seed_id");
                }
                query = "select Seed_Name,Seed_cost from Seeds where Seed_id="+seed_id;
                result = statement.executeQuery(query);
                String seed_name = "";
                int seed_cost = 0;
                while(result.next()){
                     seed_name = result.getString("Seed_Name");
                     seed_cost = result.getInt("Seed_cost");
                }
                System.out.println("Suggested Crop to be grown : " +seed_name);
                System.out.println("Cost : "+seed_cost);
            }
        }
        else{
            System.out.println("OOPS!Wrong Credentials Please enter the correct credentials");
        }
    }
}
