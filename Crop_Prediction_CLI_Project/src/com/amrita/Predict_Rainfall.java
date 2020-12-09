package com.amrita;
/*
Created with Intellij IDEA
Author : @Sridhar
Created on 2nd December
*/
import java.sql.*;
import java.util.Scanner;

//adding abstract class
abstract class Predicting_Rainfall{
    public abstract void predict_rainfall() throws SQLException;
}
//inheriting from the abstract class
public class Predict_Rainfall extends Predicting_Rainfall{
    public String username = "root";
    public String password = "root";
    public String Dburl = "jdbc:mysql://localhost:3306/crop_prediction_based_on_soil_nutrient_estimation";

    public String query;
    public int area_id;
    //default constructor
    public Predict_Rainfall(){
        this.area_id = 0;
    }
    //parametrized constructor
    public Predict_Rainfall(int ar_id){
        this.area_id = ar_id;
    }
    public void predict_rainfall() throws SQLException {
        try{
            //establishing the connection
            Connection connection = DriverManager.getConnection(Dburl,username,password);

            //preparing the statement
            Scanner user_input = new Scanner(System.in);
            Statement statement = connection.createStatement();
            query = "select Rainfall_type from Area_Rainfall where Area_id="+area_id;
            //executing the statement and storing the result in a result set
            ResultSet result = statement.executeQuery(query);

            //predicting the rainfall type
            String rainfall_type="";
            while(result.next()){
                rainfall_type = result.getString("Rainfall_type");
            }
            //result of the rainfall
            System.out.print("The type of rainfall expected in your area is "+rainfall_type);
        }catch (SQLException throwables){
            throwables.printStackTrace();
        }
    }
}
