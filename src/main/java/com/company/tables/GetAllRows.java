package com.company.tables;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.company.connection.JDBC;

public class GetAllRows {

    public static void main(String[] args) {

        try{

            JDBC.connect();

            Statement statement = JDBC.connection.createStatement();

            String exampleQuery1 = "SELECT * FROM Authors";
            System.out.println("Authors:");
            ResultSet resultSet = statement.executeQuery(exampleQuery1);

            while (resultSet.next()) {
                int id = resultSet.getInt("authorID");
                String firstName = resultSet.getString("firstName");
                String lastName = resultSet.getString("lastName");
                System.out.println(id + "\t" + firstName + "\t" + lastName);
            }

            String exampleQuery2 = "SELECT * FROM titles";
            System.out.println("Titles:");
            ResultSet resultSet2 = statement.executeQuery(exampleQuery2);

            while (resultSet2.next()) {
                String isbn = resultSet2.getString("isbn");
                String title = resultSet2.getString("title");
                System.out.println(isbn + "\t" + title);
            }
        } catch(SQLException se) {
            se.printStackTrace();
        } finally {
            JDBC.close();
        }
    }
}
