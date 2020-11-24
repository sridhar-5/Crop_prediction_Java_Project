package com.amrita;

import java.sql.SQLException;
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
            System.out.println("==================Please Select an option=======================");

            int option = user_input.nextInt();
            if(option == 1){
                String table_name;
                System.out.println("Please enter the table name : ");
                user_input.nextLine();
                table_name = user_input.nextLine();

                int State_id = user_input.nextInt();
                user_input.nextLine();
                String State_name = user_input.nextLine();

                query = "INSERT INTO "+table_name+" VALUES ('"+State_id+"','"+State_name+"')";
                d.Insert(query);
            }
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
            else if(option == 4){
                String table_name;
                System.out.println("Please enter a table name : ");
                user_input.nextLine();
                table_name = user_input.nextLine();
                query = "SELECT * FROM "+table_name;
                d.Select(query);
            }
            else if(option == 5){
                String table_name;
                System.out.println("Please enter a table name : ");
                user_input.nextLine();
                table_name = user_input.nextLine();
                query = "DROP TABLE "+table_name;
                d.Drop(query);
            }
        }
        else{
            System.out.println("OOPS!Wrong Credentials Please enter the correct credentials");
        }
    }
}
