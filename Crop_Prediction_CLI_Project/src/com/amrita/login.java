package com.amrita;

/*
Created with Intellij IDEA
Author : @Sridhar
Created on 16th November
*/
import java.sql.*;
import java.util.Scanner;
public class login extends signup{

    public static boolean login_bool;

    //Default Constructors
    public login(){ }

    public boolean login() throws SQLException{

        //step-1 : creating a database connection - in the project
        try (
                Connection connection = DriverManager.getConnection(url, user, pass);

                //creating a statement and executing a query
                Statement statement = connection.createStatement();
        ) {
            //user selects an option here to sign  up or login
            System.out.println("===========Menu===================");
            System.out.println("1. Login");
            System.out.println("2. Sign Up");
            System.out.println("============END====================");
            //creating a scanner object to take the inputs
            System.out.print("Please select an option:");
            Scanner input = new Scanner(System.in);
            int option = input.nextInt();
            if(option == 1){
                   // generating the select query
                    String query = "select * from credentials";

                    //executing the query and storing the result set in an object
                    ResultSet resultset = statement.executeQuery(query);

                    //using the information that is stored in result set to validate the login
                    String username_input;
                    String password_input;
                    //input username
                    System.out.print("Username : ");
                    username_input = input.next();
                    //input password
                    System.out.print("Password : ");
                    password_input = input.next();
                    //checking for the user int the database;
                    while(resultset.next()) {
                        String Username = resultset.getString("username");
                        String Password = resultset.getString("password");

                        if(Username.equals(username_input)){
                            if(Password.equals(password_input)){
                                //if username and password both are found in the database then login_bool i set to true
                                login_bool = true;
                                return login_bool;
                            }
                            else{
                                //else set to false
                                login_bool = false;
                            }
                        }
                    }
                }
            else if(option == 2){
                //call for the sign up and the sign up here
                signup();
                //since he is a user now prompt him to login again
                login();
            }
        }
        return login_bool;
    }
}
