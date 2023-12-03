package com.company.tables;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.company.connection.JDBC;

public class CreateTables {

    public static void main(String[] args) throws SQLException {

        Statement statement = null;

        try {

            System.out.println("This will DELETE all data, do you want to continue? (y/n) ");
            Scanner scanner = new Scanner(System.in);
            String input = scanner.nextLine();
            if (input.equals("y") || input.equals("Y")) {
                JDBC.connect();
                statement = JDBC.connection.createStatement();
                String drop1 = "DROP TABLE IF EXISTS Authors";
                statement.executeUpdate(drop1);

                String drop2 = "DROP TABLE IF EXISTS Titles";
                statement.executeUpdate(drop2);

                String drop3 = "DROP TABLE IF EXISTS Publishers";
                statement.executeUpdate(drop3);
                String drop4 = "DROP TABLE IF EXISTS authorISBN";
                statement.executeUpdate(drop4);
                String authorsTable = "CREATE TABLE Authors " +
                        "(authorID INTEGER NOT NULL AUTO_INCREMENT, " +
                        " firstName CHAR(20), " +
                        " lastName CHAR(20), " +
                        " PRIMARY KEY (authorID))";

                statement.executeUpdate(authorsTable);
                System.out.println("Created Authors table");

                String titlesTable = "CREATE TABLE Titles " +
                        "(isbn CHAR(13) not NULL, " +
                        " title VARCHAR(255), " +
                        " editionNumber INTEGER, " +
                        " year CHAR(4), " +
                        " publisherID INTEGER REFERENCES Publishers(publisherID), " +
                        " price DECIMAL(8,2), " +
                        " PRIMARY KEY (isbn))";

                statement.executeUpdate(titlesTable);
                System.out.println("Created Titles table");

                String publishersTable = "CREATE TABLE Publishers " +
                        "(publisherID INTEGER NOT NULL AUTO_INCREMENT, " +
                        " publisherName CHAR(100), " +
                        " PRIMARY KEY (publisherID))";

                statement.executeUpdate(publishersTable);
                System.out.println("Created Publishers table");

                String authorISBNTable = "CREATE TABLE authorISBN " +
                        "(authorID INTEGER REFERENCES Authors(authorID), " +
                        " isbn CHAR(10) REFERENCES Titles(isbn))";

                statement.executeUpdate(authorISBNTable);
                System.out.println("Created authorISBN table");

                InsertTestData.updateTables();
            }
        } catch (SQLException se) {
            se.printStackTrace();
        } finally {
            if (statement != null) {
                JDBC.close();
            }
        }
    }
}
