package com.amrita;

import java.sql.*;
import java.util.Scanner;

public class Predict_Crop extends Predict_Irrigation{
    String query;

    public String username = "root";
    public String password = "root";
    public String Dburl = "jdbc:mysql://localhost:3306/crop_prediction_based_on_soil_nutrient_estimation";

    public void predict_crop() throws SQLException{

        Connection connection = DriverManager.getConnection(Dburl,username,password);
        //Now the Prediction of the crop starts
        //since the predicted data is already entered and stored into the table
        //generate a query that displays the crop name
        Scanner user_input = new Scanner(System.in);
        System.out.print("please enter the area_id: ");
        ar_id = user_input.nextInt();
        query = "select Seed_id from Area_Seed where Area_id="+ar_id;

        Statement statement = connection.createStatement();
        //storing the result of select query in result set object
        ResultSet result = statement.executeQuery(query);
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
