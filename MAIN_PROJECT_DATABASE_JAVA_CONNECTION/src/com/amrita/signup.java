package com.amrita;

import java.sql.*;
import java.util.Scanner;

public class signup extends DatabaseOperations{

    String url = "jdbc:mysql://localhost:3306/crop_prediction_based_on_soil_nutrient_estimation";
    String pass = "root";
    String user = "root";

    public void signup() throws SQLException {
        try (
                //establishing connection with the database
                Connection connection = DriverManager.getConnection(url, user, pass);

                //Creating a statement
                Statement statement = connection.createStatement();
        ) {
            Scanner input = new Scanner(System.in);
            System.out.println("===========Welcome to the Signup Page==============");
            System.out.print("Username : ");
            String username = input.next();
            System.out.print("\nPassword : ");
            String password = input.next();
            System.out.print("\nConfirm Password : ");
            String Confirm_Password = input.next();

            //checking if the password and the confirm password is same else return
            if (password.equals(Confirm_Password)) {
                String query = "select username from credentials";

                //storing the result of the select query in a result set object
                ResultSet resultset = statement.executeQuery(query);

                //initialzing a count variable to count how many times the username is in the credentials relation
                int count = 0;

                //here we iterate through the object and check if the user name is already taken
                while(resultset.next()){
                    String username_db = resultset.getString("username");
                    if(username.equals(username_db)){
                        count = count + 1;
                    }
                }
                if(count == 0){
                    String exeQuery = "INSERT INTO credentials VALUES ('"+username+"','"+password+"')";
                    Insert(exeQuery);
                    System.out.println("SignUp Sucessfull!! You can now login");
                }


            } else {
                return;
            }
        }
    }
}
