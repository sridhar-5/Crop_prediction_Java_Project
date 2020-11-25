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
                    int Weather_id = user_input.nextInt();
                    String seed_name = user_input.next();
                    double price = user_input.nextDouble();

                    //match the synatx that is actually executing in my sql
                    query = "INSERT INTO "+table_name+" VALUES ('"+seed_id+"','"+Weather_id+"','"+seed_name+"','"+price+"')";
                    //Insert function is which actually executes the query it is present in class Database operations
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
                query = "";
                d.prediction(query);
            }
        }
        else{
            System.out.println("OOPS!Wrong Credentials Please enter the correct credentials");
        }
    }
}
