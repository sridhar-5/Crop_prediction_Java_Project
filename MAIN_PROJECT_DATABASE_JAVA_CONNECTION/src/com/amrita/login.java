package com.amrita;

import java.sql.*;
import java.util.Scanner;

public class login extends signup{

    public static boolean login_bool;

    public boolean login() throws SQLException{

        //step-1 : creating a database connection - in the project
        try (
                Connection connection = DriverManager.getConnection(url, user, pass);

                //creating a statement and executing a query
                Statement statement = connection.createStatement();

        ) {
            System.out.println("===========Menu===================");
            System.out.println("1. Login");
            System.out.println("2. Sign Up");
            System.out.println("============END====================");
            //creating a scanner object to take the inputs
            Scanner input = new Scanner(System.in);
            int option = input.nextInt();
            if(option == 1){
                   // generating the query
                    String query = "select * from credentials";

                    //creating a result set of the object
                    ResultSet resultset = statement.executeQuery(query);

                    //using the information that is stored in result set to validate the login
                    String username_input;
                    String password_input;

                    System.out.print("Username : ");
                    username_input = input.next();
                    System.out.print("\n");
                    System.out.print("Password : ");
                    password_input = input.next();
                    //checking for the user int the database;
                    while(resultset.next()) {
                        String Username = resultset.getString("username");
                        String Password = resultset.getString("password");

                        if(Username.equals(username_input)){
                            if(Password.equals(password_input)){
                                login_bool = true;
                                return login_bool;
                            }
                            else{
                                login_bool = false;
                            }
                        }
                    }
                }
            else if(option == 2){
                signup();
                login();
            }
        }
        return login_bool;
    }
}
