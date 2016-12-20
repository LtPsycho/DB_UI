package com.mycompany.app.controllers;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.lang.*;

/**
 * Created by Dovydas on 11/6/2016.
 */
public class DatabaseConnection {
    // load the sqlite-JDBC driver using the current class loader

    public Connection getDatabaseConnection() throws ClassNotFoundException {
        Class.forName("org.sqlite.JDBC");
        String filePath = new File("").getAbsolutePath();

        Connection connection = null;
        try {
            // create a database connection
            connection = DriverManager.getConnection("jdbc:sqlite:" + filePath + "/pdb/db.sqlite3");
            if (connection != null) {
                System.out.println("Connected to the database");
            }
        } catch (SQLException e) {
            // if the error message is "out of memory",
            // it probably means no database file is found
            System.err.println("DB DID NOT Connect");
        }
        return connection;
    }
}
