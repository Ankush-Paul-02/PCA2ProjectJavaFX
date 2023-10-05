package com.devmare.pca2projectjavafx.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//! The DBConnection class provides a method to establish a connection to an Oracle database.
public class DBConnection {

    public Connection connection;

    public Connection getConnection() throws SQLException {
        String url = "jdbc:oracle:thin:@localhost:1521:xe";
        String username = "SYSTEM";
        String password = "root";

        try {
            /**
             * Loading the Oracle JDBC driver
             * Type 4 Driver (Thin Driver, Direct to Database Pure Java Driver)
             * This is a pure Java driver that directly communicates with the database using a
             * vendor-specific protocol. It doesn't require any native libraries and is
             * platform-independent.
             */
            Class.forName("oracle.jdbc.driver.OracleDriver");
            //! Establishing a connection to the database
            connection = DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException e) {
            //! Handle ClassNotFoundException (if the Oracle JDBC driver is not found)
            throw new SQLException("Oracle JDBC Driver not found", e);
        }
        return connection;
    }
}
