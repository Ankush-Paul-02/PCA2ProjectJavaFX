package com.devmare.pca2projectjavafx.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

    public Connection connection;

    public Connection getConnection() throws SQLException {
        String url = "jdbc:oracle:thin:@localhost:1521:xe";
        String username = "SYSTEM";
        String password = "root";

        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            connection = DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException e) {
            // Handle ClassNotFoundException
            throw new SQLException("Oracle JDBC Driver not found", e);
        }
        return connection;
    }
}
