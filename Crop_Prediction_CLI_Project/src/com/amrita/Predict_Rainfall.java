package com.amrita;

import java.sql.*;
import java.util.Scanner;

public class Predict_Rainfall extends DatabaseOperations{
    public String query;
    public int area_id;
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
            System.out.print("The type of rainfall expected in your area is "+rainfall_type);
        }catch (SQLException throwables){
            throwables.printStackTrace();
        }
    }
}
